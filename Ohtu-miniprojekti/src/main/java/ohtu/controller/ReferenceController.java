package ohtu.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import ohtu.domain.Article;
import ohtu.domain.Book;
import ohtu.domain.Inproc;
import ohtu.domain.Reference;
import ohtu.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReferenceController {

    
    @Autowired
    ReferenceService references;

    @PostConstruct
    public void init() {
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";                 //Palauttaa WEB-INF/jsp/login.jsp:n 
    }

    @RequestMapping(value = "/")
    public String redir() {
        return "redirect:/list";
    }



    @RequestMapping(value = "addArticle", method = RequestMethod.POST)
    public String createArticle(@ModelAttribute("article") @Valid Article article, BindingResult bindingresult, Model model) {
        return add("article", article, bindingresult, model);
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingresult, Model model) {
        return add("book", book, bindingresult, model);
    }

    @RequestMapping(value = "addInproc", method = RequestMethod.POST)
    public String createInproc(@ModelAttribute("inproc") @Valid Inproc inproc, BindingResult bindingresult, Model model) {
        return add("inproc", inproc, bindingresult, model);
    }

  

    @RequestMapping(value = "removeRef/{Ids}")
    public String removeReference(Model model, @PathVariable("Ids") Long... ids) {
        references.deleteMany(ids);
        return "redirect:/app/list";
    }

    @RequestMapping(value = "updateRef/{id}")
    public String updateReference(Model model, @PathVariable("id") Long id) {
        Reference found = references.findById(id);
        String nimi = found.getClass().getSimpleName().toLowerCase();
        model.addAttribute(nimi, found);
        return "update";
    }

    @RequestMapping(value = "updateRef/addBook", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingresult, Model model) {
        return update("book", book, bindingresult, model);
    }

    @RequestMapping(value = "updateRef/addArticle", method = RequestMethod.POST)
    public String updateArticle(@ModelAttribute("article") @Valid Article article, BindingResult bindingresult, Model model) {
        return update("article", article, bindingresult, model);
    }

    @RequestMapping(value = "updateRef/addInproc", method = RequestMethod.POST)
    public String updateInproc(@ModelAttribute("inproc") @Valid Inproc inproc, BindingResult bindingresult, Model model) {
        return update("inproc", inproc, bindingresult, model);
    }

    @RequestMapping(value = "addRef", method = RequestMethod.GET)
    public String addRef(Model model) {
        addAll(model);
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

    private void addAll(Model model) {
        addOne(model, "book", new Book());
        addOne(model, "article", new Article());
        addOne(model, "inproc", new Inproc());
    }

    private void addOne(Model model, String key, Reference reference) {
        if (!model.containsAttribute(key)) {
            model.addAttribute(key, reference);
        }
    }

    private String add(String name, Reference reference, BindingResult result, Model model) {
        if (references.containsRefId(reference.getRefId())) {
            result.addError(new FieldError(name, "refId", reference.getRefId(), true, new String[]{}, new Object[]{}, "ID must Be Unique!"));
        }
        if (result.hasErrors()) {
            model.addAttribute(name, reference);
            addAll(model);
            return "addRef";
        }
        references.add(reference);
        return "redirect:list";
    }

    private String update(String name, Reference reference, BindingResult result, Model model) {
        if (references.breaksReferenceConstraint(reference)) {
            result.addError(new FieldError(name, "refId", reference.getRefId(), true, new String[]{}, new Object[]{}, "ID must Be Unique!"));
        }
        if (result.hasErrors()) {
            model.addAttribute(name, reference);
            return "update";
        }
        references.update(reference);
        return "redirect:/app/list";
    }

 
}
