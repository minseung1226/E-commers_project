package kms.project.controller;

import kms.project.service.ProductService;
import kms.project.vo.DivisionVO;
import kms.project.vo.ProductVO;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/","user/home"})
    public String home(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("divisionList")==null){
            List<DivisionVO> divisionList = productService.divisionList();
            session.setAttribute("divisionList",divisionList);
        }

        List<ProductVO> list = productService.home_select();

        model.addAttribute("list",list);

        return "home";
    }
}
