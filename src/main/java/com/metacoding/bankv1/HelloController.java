package com.metacoding.bankv1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("t1")
    public String t1(){
        return "account/detail-form";
    }
    @GetMapping("t2")
    public String t2(){
        return "account/list-form";
    }
    @GetMapping("t3")
    public String t3(){
        return "account/save-form";
    }
    @GetMapping("t4")
    public String t4(){
        return "account/transfer-form";
    }
    @GetMapping("t5")
    public String t5(){
        return "user/join";
    }
    @GetMapping("t6")
    public String t6(){
        return "user/login";
    }
    @GetMapping("t7")
    public String t7(){
        return "home";
    }

}
