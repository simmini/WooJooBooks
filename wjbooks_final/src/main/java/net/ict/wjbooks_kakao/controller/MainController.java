package net.ict.wjbooks_kakao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping(value = "/")
//@RequiredArgsConstructor
public class MainController {

    @GetMapping(value="/")//회원가입 후
    public String main(){
        return "/sellboard/main";//main.html로 이동
    }
}
