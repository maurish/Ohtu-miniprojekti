package ohtu.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import ohtu.domain.Article;
import ohtu.domain.Book;
import ohtu.domain.Inproceedings;
import ohtu.domain.Reference;
import ohtu.service.BibtexService;
import ohtu.service.BibtexServiceImpl;
import ohtu.service.ReferenceService;
import ohtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OhtuController {

    // @PostConstruct
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

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";                 //Palauttaa WEB-INF/jsp/login.jsp:n 
    }
    
    @RequestMapping(value="*")
    public String redir(){
        return "redirect:list";
    }
    
    @RequestMapping(value="bibtex")
    public String pureBibtex(Model model){
        model.addAttribute("bibtexs", bibtex.generate(references.listAll()));
        return "purebibtex";
    }

    @RequestMapping(value = "addArticle", method = RequestMethod.POST)
    public String createArticle(@ModelAttribute @Valid Article article, BindingResult bindingresult, Model model) {
        if (bindingresult.hasErrors()) {
            model.addAttribute("article", article);
            addAll(model);
            return "addRef";
        }
        references.add(article);
        return "redirect:list";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute @Valid Book book, BindingResult bindingresult, Model model) {
        if (bindingresult.hasErrors()) {
            model.addAttribute("book", book);
            addAll(model);
            return "addRef";
        }
        references.add(book);
        return "redirect:list";
    }

    @RequestMapping(value = "addInproc", method = RequestMethod.POST)
    public String createInproc(@ModelAttribute @Valid Inproceedings inproc, BindingResult bindingresult, Model model) {
        if (bindingresult.hasErrors()) {
            model.addAttribute("inproc", inproc);
            addAll(model);
            return "addRef";
        }
        references.add(inproc);
        return "redirect:list";
    }

    @RequestMapping(value = "listBibtex")
    public String createBibtex(Model model) {
        model.addAttribute("bibtexs", bibtex.generate(references.listAll()));
        return "bibtex";
    }

    @RequestMapping(value = "addRef", method = RequestMethod.GET)
    public String addRef(Model model) {
        addAll(model);
        return "addRef";
    }

    private void addAll(Model model) {
        if (!model.containsAttribute("book")) {
            model.addAttribute("book", new Book());
        }
        if (!model.containsAttribute("article")) {
            model.addAttribute("article", new Article());
        }
        if (!model.containsAttribute("inproc")) {
            model.addAttribute("inproc", new Inproceedings());
        }
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("references", references.listAll());
        return "listAll";
    }
    
    @RequestMapping(value = "downloadBibtex", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadAttachment() {
        String ret = "";
        for (String string : bibtex.generate(references.listAll())) {
            ret+=string;
        }
        byte[] content =ret.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(content.length);
        headers.set("Content-Disposition", "attachment; filename=\"list"+System.currentTimeMillis()+".BIBTEX\"");
        headers.setContentType(MediaType.parseMediaType("text/plain"));
        return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Reference> listAll() {
        return references.listAll();
    }
}
