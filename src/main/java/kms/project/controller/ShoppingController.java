package kms.project.controller;

import kms.project.service.DetailService;
import kms.project.service.ProductService;
import kms.project.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ShoppingController {
    private final ProductService productService;
    private final DetailService detailService;

    public ShoppingController(ProductService productService, DetailService detailService) {
        this.productService = productService;
        this.detailService = detailService;
    }

    @GetMapping("shopping/product_info")
    public String product_info(int product_code,Model model){
        ProductVO product = productService.select_product(product_code);
        Map<String, List<String>> sizeColor = detailService.getSizeColor(product_code);
        model.addAttribute("product",product);
        model.addAttribute("size",sizeColor.get("size"));
        model.addAttribute("color",sizeColor.get("color"));
        log.info("size ={}",sizeColor.get("size"));
        log.info("color={}",sizeColor.get("color"));
        return "shopping/product_info";
    }

    @GetMapping("shopping/product_search")
    public String product_search(String division_lType,String division_mType,String search){
        return "asd";
    }
}
