package kms.project.controller;

import kms.project.dto.UserUpdateDto;
import kms.project.service.BasketService;
import kms.project.service.EnquiryService;
import kms.project.service.UserService;
import kms.project.vo.EnquiryVO;
import kms.project.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MypageController {
    private final BasketService basketService;
    private final UserService userService;

    private final EnquiryService enquiryService;

    public MypageController(BasketService basketService, UserService userService, EnquiryService enquiryService) {
        this.basketService = basketService;
        this.userService = userService;
        this.enquiryService = enquiryService;
    }

    @PostMapping("mypage/accountPassword")
    @ResponseBody
    public String password2(@ModelAttribute UserVO user) {
        userService.updatePw(user);
        return "ok";
    }
    @GetMapping("mypage/account")
    public String account() {
        return "mypage/account";
    }

    @PostMapping("user/updateUser")
    public String updateUser(@ModelAttribute("user") UserUpdateDto user, HttpServletRequest request) {
        userService.updateUser(user);

        HttpSession preSession = request.getSession();
        preSession.invalidate();

        HttpSession session = request.getSession();
        UserVO updateUser = userService.findUser(user.getUser_id());
        session.setAttribute("user",updateUser);

        return "mypage/account";
    }

    @GetMapping("mypage/basket")
    public String basket(){
        return "mypage/basket";
    }

    @GetMapping("/mypage/enquiryList")
    public String enquiryList(Model model,HttpSession session){
        UserVO user =(UserVO) session.getAttribute("user");
        List<EnquiryVO> list = enquiryService.selectAll(user.getUser_code());

        model.addAttribute("list",list);

        return "mypage/enquiryList";
    }

    @GetMapping("mypage/enquiryForm")
    public String enquiryForm(){
        return "mypage/enquiryForm";
    }
    @PostMapping("mypage/enquiryForm")
    public String enquiry(EnquiryVO enquiry,HttpSession session){
        UserVO user =(UserVO) session.getAttribute("user");
        enquiry.setUser_code(user.getUser_code());
        enquiryService.enquiryInsert(enquiry);
        return "redirect:/mypage/enquiryList";
    }

    @GetMapping("mypage/detailEnquiry")
    public String detailEnquiry(int enquiry_code,Model model){
        EnquiryVO enquiry = enquiryService.enquiryselectOne(enquiry_code);
        model.addAttribute("enquiry",enquiry);
        return "mypage/detailEnquiry";
    }
}