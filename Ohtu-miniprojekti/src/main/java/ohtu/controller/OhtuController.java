package ohtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OhtuController {
//    @RequestMapping("/asd/*")
//    public String redirect(){
//        return "redirect:login";
//    }

    @RequestMapping("*")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }
}
