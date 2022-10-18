package kms.project.controller;

import kms.project.service.DetailService;
import kms.project.service.ProductService;
import kms.project.service.ReviewService;
import kms.project.vo.ProductVO;
import kms.project.vo.ReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ShoppingController {
    private final ProductService productService;
    private final DetailService detailService;
    private final ReviewService reviewService;


    public ShoppingController(ProductService productService, DetailService detailService, ReviewService reviewService) {
        this.productService = productService;
        this.detailService = detailService;
        this.reviewService = reviewService;
    }

    @GetMapping("shopping/product_info")
    public String product_info(int product_code,Model model){
        ProductVO product = productService.select_product(product_code);
        Map<String, List<String>> sizeColor = detailService.getSizeColor(product_code);
        List<ReviewVO> reviewList = reviewService.selectList(product_code);


        model.addAttribute("product",product);
        model.addAttribute("size",sizeColor.get("size"));
        model.addAttribute("color",sizeColor.get("color"));
        model.addAttribute("reviewList",reviewList);
        return "shopping/product_info";
    }

    @GetMapping("shopping/product_search")
    public String product_search(String division_lType,String division_mType,String search,Model model){
        List<ProductVO> productList = productService.select_search(division_mType, division_lType, search);
        model.addAttribute("list",productList);

        return "shopping/product_search";

    }
}
