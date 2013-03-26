package ohtu.controller;

import ohtu.service.ReferenceService;
import ohtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OhtuController {

    @Autowired
    UserService users;
    @Autowired
    ReferenceService references;

    @RequestMapping("*")                
    public String login() {             
        return "login";                 //Palauttaa WEB-INF/jsp/login.jsp:n 
    }
}
