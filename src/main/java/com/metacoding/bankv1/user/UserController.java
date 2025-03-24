package com.metacoding.bankv1.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/login-form")
    public String loginform(){
        return "/user/login-form";
    }

    @GetMapping("/join-form")
    public String joinform(){
        return "/user/join-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO){

//        //유효성 검사
//        if(joinDTO.getUsername().length() >12){
//            throw new RuntimeException("Username too long");
//        }
        userService.회원가입(joinDTO);
        return "redirect:/login-form";
    }

}
