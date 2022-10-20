package kms.project.controller;

import kms.project.controller.validation.AdminValidator;
import kms.project.controller.validation.ProductValidator;
import kms.project.repository.ProductRepository;
import kms.project.service.AdminService;
import kms.project.service.DetailService;
import kms.project.service.EnquiryService;
import kms.project.service.ProductService;
import kms.project.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class AdminController {
    private final AdminService adminService;
    private final EnquiryService enquiryService;
    private final ProductService productService;
    private final DetailService detailService;
    private final AdminValidator adminValidator;
    private final ProductValidator productValidator;

    public AdminController(AdminService adminService, EnquiryService enquiryService,
                           ProductService productService, DetailService detailService,
                           AdminValidator adminValidator, ProductValidator productValidator) {
        this.adminService = adminService;
        this.enquiryService = enquiryService;
        this.productService = productService;
        this.detailService = detailService;
        this.adminValidator = adminValidator;
        this.productValidator = productValidator;
    }

    @GetMapping("/admin")
    public String adminForm(Model model,HttpServletRequest request) {
        request.getSession().invalidate();
        model.addAttribute("admin", new AdminVO());
        return "/admin/loginForm";
    }


    @PostMapping("/admin/Login")
    public String adminLogin(@ModelAttribute("admin") AdminVO admin, BindingResult result, HttpServletRequest request) {
        adminValidator.validate(admin, result);
        if (result.hasErrors()) {
            return "/admin/loginForm";
        }
        AdminVO findAdmin = adminService.adminLogin(admin.getAdmin_id());
        if (findAdmin == null || !findAdmin.getAdmin_pw().equals(admin.getAdmin_pw())) {
            result.rejectValue("admin_id", "idPwMismatch");
            return "/admin/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("admin", findAdmin);
        return "redirect:/";
    }

    @GetMapping("admin/enquiryList")
    public String enquiryList(Model model) {
        List<EnquiryVO> list = enquiryService.selectAll();
        model.addAttribute("list", list);

        return "admin/enquiryList";
    }

    @GetMapping("admin/answer")
    public String enquiryAnswer(int enquiry_code, Model model) {
        EnquiryVO enquiry = enquiryService.enquiryselectOne(enquiry_code);
        model.addAttribute("enquiry", enquiry);

        return "admin/answer";
    }

    @PostMapping("admin/answer")
    public String enquiryUpdate(@ModelAttribute("enquiry") EnquiryVO enquiry) {
        enquiryService.enquiryAnswer(enquiry);

        return "redirect:/admin/enquiryList";
    }

    @GetMapping("admin/product/add")
    public String productForm(Model model) {
        List<DivisionVO> list = productService.divisionList();
        model.addAttribute("list",list);
        model.addAttribute("product", new ProductVO());
        return "admin/productForm";
    }

    @PostMapping("admin/product/add")
    @Transactional
    public String productAdd(@Validated @ModelAttribute("product") ProductVO product,BindingResult result,String size,String color,Model model){
        productValidator.validate(product,result);
        if (result.hasErrors()){
            List<DivisionVO> list = productService.divisionList();
            model.addAttribute("list",list);
            return "admin/productForm";
        }

        productService.productInsert(product);
        detailService.detailInsert(size,color,product.getProduct_code());
        log.info("product_code={}",product.getProduct_code());

        return "redirect:/admin/recent_register";
    }


    @GetMapping("/admin/recent_register")
    public String recent_register(Model model){
        List<ProductVO> product = productService.recent_register();
        model.addAttribute("list",product);

        return "admin/recent_register";

    }

    // 리턴을 상품 검색칸으로 옮기기
    @GetMapping("admin/delete_product")
    public String delete(int product_code){
        productService.delete_productAndDetail(product_code);

        return "redirect:/admin/recent_register";
    }

    @PostMapping("admin/product/modify")
    public String product_modify(int product_code,Model model){
        log.info("product_modify.product_code={}",product_code);
        model.addAttribute("product_code",product_code);
        return "/admin/product_infoAndDetail";
    }


    @GetMapping("admin/product/info_modify")
    public String info_modifyForm(int product_code,Model model){
        log.info("form.product_code={}",product_code);
        ProductVO productVO = productService.select_product(product_code);
        List<DivisionVO> list = productService.divisionList();
        model.addAttribute("product",productVO);
        model.addAttribute("list",list);

        return "admin/info_modifyForm";
    }

    @PostMapping("admin/product/info_modify")
    public String info_modify(@ModelAttribute("product") ProductVO product,BindingResult result,Model model){
        productValidator.validate(product,result);
        if (result.hasErrors()){
            List<DivisionVO> list = productService.divisionList();
            model.addAttribute("list",list);
            return "admin/info_modifyForm";
        }
        productService.update_product(product);
        return "redirect:/admin/recent_register";
    }

    @GetMapping("admin/product/detail_modify")
    public String detail_modifyForm(int product_code,Model model){
        Map<String, String> detail = detailService.select_detail(product_code);
        model.addAttribute("detail",detail);

        return "admin/detail_modifyForm";

    }

    @PostMapping("admin/product/detail_modify")
    public String detail_modify(int product_code,String size,String color,Model model){
        detailService.updateDetail(product_code,size,color);

        return "redirect:/admin/recent_register";
    }

    @GetMapping("admin/sales_status")
    public String salesStatus(Model model){
        List<ProductVO> list = new ArrayList<>();
        model.addAttribute("list",list);

        return "admin/sales_status";
    }

    @PostMapping("admin_sales_status/search")
    public String sales_status_search(String search,String start_date,String end_date,Model model){
        Map<String,String> map = new HashMap<>();
        map.put("search",search);
        map.put("start_date",start_date);
        map.put("end_date",end_date);
        List<SalesStatusVO> list = productService.sale_status(map);

        int all_quantity=0;
        int all_payment=0;
        for(int i = 0 ; i < list.size();i++){
            all_payment+=list.get(i).getOrder_payment();
            all_quantity+=list.get(i).getOrder_quantity();
        }

        model.addAttribute("list",list);
        model.addAttribute("all_quantity",all_quantity);
        model.addAttribute("all_payment",all_payment);
        return "template/sales_statusList";

    }

}