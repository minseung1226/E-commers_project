package kms.project.controller;

import kms.project.aop.Trace;
import kms.project.service.*;
import kms.project.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Trace
public class MypageController {
    private final BasketService basketService;
    private final UserService userService;
    private final EnquiryService enquiryService;
    private final OrderService orderService;
    private final ReviewService reviewService;

    public MypageController(BasketService basketService, UserService userService,
                            EnquiryService enquiryService, OrderService orderService,
                            ReviewService reviewService) {
        this.basketService = basketService;
        this.userService = userService;
        this.enquiryService = enquiryService;
        this.orderService = orderService;
        this.reviewService = reviewService;
    }

    @PostMapping("mypage/accountPassword")
    @ResponseBody
    @Trace
    public String password2(@ModelAttribute UserVO user) {
        userService.updatePw(user);
        return "ok";
    }
    @GetMapping("mypage/account")
    @Trace
    public String account() {
        return "mypage/account";
    }

    @PostMapping("user/updateUser")
    @Trace
    public String updateUser(@ModelAttribute("user") UserVO user, HttpServletRequest request) {
        userService.updateUser(user);

        HttpSession preSession = request.getSession();
        preSession.invalidate();

        HttpSession session = request.getSession();
        UserVO updateUser = userService.findUser(user.getUser_id());
        session.setAttribute("user",updateUser);

        return "mypage/account";
    }

    @GetMapping("mypage/basket")
    @Trace
    public String basket(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        UserVO user =(UserVO) session.getAttribute("user");
        List<BasketViewVO> viewList = basketService.select_basketView(user.getUser_code());
        model.addAttribute("list",viewList);

        return "mypage/basket";
    }

    @GetMapping("/mypage/enquiryList")
    @Trace
    public String enquiryList(Model model,HttpSession session){
        UserVO user =(UserVO) session.getAttribute("user");
        List<EnquiryVO> list = enquiryService.selectUser(user.getUser_id());

        model.addAttribute("list",list);

        return "mypage/enquiryList";
    }

    @GetMapping("mypage/enquiryForm")
    @Trace
    public String enquiryForm(){
        return "mypage/enquiryForm";
    }
    @PostMapping("mypage/enquiryForm")
    @Trace
    public String enquiry(EnquiryVO enquiry,HttpSession session){
        UserVO user =(UserVO) session.getAttribute("user");
        enquiry.setUser_id(user.getUser_id());
        enquiryService.enquiryInsert(enquiry);
        return "redirect:/mypage/enquiryList";
    }

    @GetMapping("mypage/detailEnquiry")
    @Trace
    public String detailEnquiry(int enquiry_code,Model model){
        EnquiryVO enquiry = enquiryService.enquiryselectOne(enquiry_code);
        model.addAttribute("enquiry",enquiry);
        return "mypage/detailEnquiry";
    }

    @PostMapping("mypage/basket_delete")
    @Trace
    public String basket_delete(String basket_check){

        basketService.delete_basket(basket_check);

        return "redirect:/mypage/basket";
    }

    @GetMapping("mypage/orderList")
    @Trace
    public String orderList(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        UserVO user =(UserVO) session.getAttribute("user");

        List<OrderViewVO> list = orderService.select_order_view(user.getUser_code());

        model.addAttribute("list",list);

        return "mypage/orderList";

    }

    @GetMapping("mypage/order_detail")
    @Trace
    public String order_detail(int order_code,Model model){
        OrderViewVO order_view = orderService.findOrderView(order_code);
        model.addAttribute("order_view",order_view);
        return "mypage/order_detail";
    }

    @GetMapping("/mypage/reviewList")
    @Trace
    public String reviewList(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        UserVO user =(UserVO) session.getAttribute("user");
        List<OrderViewVO> orderList = orderService.select_order_view(user.getUser_code());
        model.addAttribute("list",orderList);

        return "mypage/reviewList"  ;
    }

    @GetMapping("mypage/reviewForm")
    @Trace
    public String reviewForm(int order_code,Model model){
        OrderViewVO orderView = orderService.findOrderView(order_code);
        model.addAttribute("orderView",orderView);
        model.addAttribute("review",new ReviewVO());

        return "mypage/reviewForm";
    }

    @PostMapping("mypage/reviewForm")
    @Trace
    public String review_insert(@ModelAttribute ReviewVO review){
            reviewService.insert_review(review);
        return "redirect:/mypage/reviewList";
    }

    @GetMapping("mypage/review_modify")
    @Trace
    public String review_modifyForm(int order_code,Model model){
        ReviewViewVO review = reviewService.find_review_view(order_code);
        model.addAttribute("review_view",review);

        return "mypage/review_modify";
    }

    @PostMapping("mypage/review_modify")
    @Trace
    public String review_modify(ReviewVO review){
        reviewService.update_review(review);

        return"redirect:/mypage/reviewList";
    }

}
