package ohtu.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import ohtu.domain.Reference;
import ohtu.service.BibtexService;
import ohtu.service.BibtexServiceImpl;
import ohtu.service.ReferenceService;
import ohtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OhtuController {

    @PostConstruct
    public void init() {
//        references.add(new Reference("Pauli", "Paulin kirja"));
//        references.add(new Reference("anniina", "coding for masters"));
    }
    
    @Autowired
    BibtexService bibtex;
    @Autowired
    UserService users;
    @Autowired
    ReferenceService references;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String login() {
        return "login";                 //Palauttaa WEB-INF/jsp/login.jsp:n 
    }

    @RequestMapping(value = "addRef", method = RequestMethod.POST)
    public String createRef(@ModelAttribute(value = "reference") @Valid Reference ref, BindingResult bindingresult, Model model) {
        if (bindingresult.hasErrors()){
            model.addAttribute("reference", ref);
            return "addRef"; 
        }
        references.add(ref);
        return "redirect:list";
    }
    
    @RequestMapping(value="listBibtex") 
    public String createBibtex(Model model) {
        model.addAttribute("bibtexs", bibtex.generate(references.listAll()));
        return "bibtex";
}

    @RequestMapping(value = "addRef", method = RequestMethod.GET)
    public String addRef(Model model) {
        model.addAttribute("reference", new Reference());
        return "addRef";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("references", references.listAll());
        return "listAll";
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Reference> listAll() {
        return references.listAll();
    }
}
