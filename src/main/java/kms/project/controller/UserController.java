package kms.project.controller;

import kms.project.aop.Trace;
import kms.project.controller.validation.UserValidator;
import kms.project.service.BasketService;
import kms.project.service.OrderService;
import kms.project.service.UserService;
import kms.project.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@Controller

@Trace
public class UserController {

    private final UserService userService;
    private final Validator userValidator;

    private final BasketService basketService;

    private final OrderService orderService;

    public UserController(UserService userService, Validator userValidator, BasketService basketService, OrderService orderService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.basketService = basketService;
        this.orderService = orderService;
    }

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(userValidator);


    }

    @PostMapping("/user/userCheck")
    @ResponseBody
    @Trace
    public String userCheck(String user_id, String user_pw, HttpServletRequest request) {
        UserVO findUserVO = userService.findUser(user_id);

        String result = "";
        if (findUserVO == null) {
            result = "잘못된 아이디 입니다";
        } else if (!findUserVO.getUser_pw().equals(user_pw)) {
            result = "잘못된 비밀번호 입니다";
        } else {
            userService.updateCon_date(findUserVO.getUser_code());
            HttpSession session = request.getSession();
            session.setAttribute("user", findUserVO);
            result = "ok";
        }
        return result;

    }

    @GetMapping("/user/logout")
    @Trace
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/";
    }



    @PostMapping("user/idCheck")
    @ResponseBody
    @Trace
    public String idCheck(String user_id) {
        UserVO findUser = userService.findUser(user_id);
        if (findUser == null) {
            return "ok";
        }
        return "x";
    }

    @PostMapping("user/joinForm")
    @Trace
    public String joinForm(@ModelAttribute("user") UserVO user) {
        return "user/joinForm";
    }

    @PostMapping("/user/join")
    @Trace
    public String join(@Validated @ModelAttribute("user") UserVO user, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "user/joinForm";
        }

        int seq = userService.userInsert(user);
        user.setUser_code(seq);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "redirect:/";
    }

    @GetMapping("user/certification")
    @Trace
    public String certification() {
        return "user/certification";
    }

    @GetMapping("user/sendMessage")
    @ResponseBody
    @Trace
    public String sendMessage(@ModelAttribute("user") UserVO user) {
        if (user.getUser_id()!=null) {
            user = userService.findUser(user.getUser_id());
            if (user == null) {
                return "x";
            }
        }
        Random random = new Random();
        String cer_num = "";
        for (int i = 0; i < 4; i++) {
            cer_num += Integer.toString(random.nextInt(10));
        }
        String user_phone = user.getUser_phone();
        userService.sendMessage(user.getUser_phone().replace("-", ""), cer_num);
        return cer_num;



    }

    @GetMapping("user/login")
    @Trace
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("user/find")
    @Trace
    public String findForm() {
        return "user/findForm";
    }

    @PostMapping("user/passwordForm")
    @Trace
    public String passwordForm(String user_id, Model model) {
        model.addAttribute("user_id", user_id);
        return "user/passwordForm";

    }

    @PostMapping("user/password")
    @Trace
    public String password(@ModelAttribute UserVO user) {
        userService.updatePw(user);
            return "user/login";
    }

    @PostMapping("user/basket_insert")
    @Trace
    public String basket_insert(BasketVO basket, DetailVO detail,HttpServletRequest request){
        HttpSession session = request.getSession();
        UserVO user =(UserVO) session.getAttribute("user");
        basket.setUser_code(user.getUser_code());

        basketService.add_basket(basket,detail);
        return "redirect:/shopping/product_info?product_code="+detail.getProduct_code();
    }

    @PostMapping("user/order")
    @Trace
    public String one_order(BasketVO basket, DetailVO detail, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        basket.setUser_code(user.getUser_code());
        List<BasketViewVO> list = basketService.add_basket_order(basket, detail);
        model.addAttribute("list",list);
        model.addAttribute("order_payment",list.get(0).getProduct_price());
        return "user/orderForm";


    }

    @PostMapping("user/orderForm")
    @Trace
    public String orderForm(String basket_check,int order_payment,HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        UserVO user = (UserVO)session.getAttribute("user");

        List<BasketViewVO> list = basketService.select_choiceBasket_view( basket_check);

        model.addAttribute("list",list);
        model.addAttribute("order_payment",order_payment);


        return "user/orderForm";
    }


    @PostMapping("user/product_order")
    @Trace
    public String orderInsert(@ModelAttribute OrderVO order,String detail_codeList){
       orderService.insert_order(order,detail_codeList);

        return "redirect:/mypage/orderList";
    }



}
