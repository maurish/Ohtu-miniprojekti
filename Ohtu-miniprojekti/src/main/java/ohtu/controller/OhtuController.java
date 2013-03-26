package ohtu.controller;

import java.util.List;
import ohtu.domain.Reference;
import ohtu.service.ReferenceService;
import ohtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OhtuController {

    @Autowired
    UserService users;
    @Autowired
    ReferenceService references;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String login() {
        return "login";                 //Palauttaa WEB-INF/jsp/login.jsp:n 
    }

    @RequestMapping(value = "addRef", method = RequestMethod.POST)
    public String addRef(Reference ref) {
        references.add(ref);
        return "addRef";
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<Reference> listAll() {
        return references.listAll();
    }
}
