package com.metacoding.bankv1.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    //로그인은 원래 Get요청인데 보안때문에 예외적으로 Post 한다.(조회시에도 같다)
    public String login(UserRequest.LoginDTO loginDTO) {
        User sessionuser = userService.로그인(loginDTO);
        session.setAttribute("sessionUser", sessionuser); //서버의 상태를 저장하는 Stateful
        return "redirect:/";
    }

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
