package ohtu.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import ohtu.domain.Article;
import ohtu.domain.Book;
import ohtu.domain.Inproceedings;
import ohtu.domain.Reference;
import ohtu.service.BibtexService;
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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OhtuController {

    @Autowired
    BibtexService bibtex;
    @Autowired
    UserService users;
    @Autowired
    ReferenceService references;

    @PostConstruct
    public void init() {
        references.add(new Book("WSOY", "PauliP", "Koodivinkit", 2012, "koodivPP"));
        references.add(new Book("omakustanne", "Anttiina", "Kokkauksen taito, osa1", 2013, "kokkitaito"));
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";                 //Palauttaa WEB-INF/jsp/login.jsp:n 
    }

    @RequestMapping(value = "/")
    public String redir() {
        return "redirect:/list";
    }

    @RequestMapping(value = "bibtex")
    public String pureBibtex(Model model) {
        model.addAttribute("bibtexs", bibtex.generate(references.listAll()));
        return "purebibtex";
    }

    @RequestMapping(value = "listIds/{id}")
    public String listSelected(Model model, @PathVariable(value = "id") Long... id) {
        model.addAttribute("bibtexs", bibtex.generate(references.findByIds(id)));
        return "bibtex";
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
    public String createInproc(@ModelAttribute("inproc") @Valid Inproceedings inproc, BindingResult bindingresult, Model model) {
        return add("inproc", inproc, bindingresult, model);
    }

    @RequestMapping(value = "listBibtex")
    public String listAllAsBibtex(Model model) {
        model.addAttribute("bibtexs", bibtex.generate(references.listAll()));
        return "bibtex";
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
    public String updateInproc(@ModelAttribute("inproc") @Valid Inproceedings inproc, BindingResult bindingresult, Model model) {
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

    @RequestMapping(value = "downloadIds/{id}")
    public ResponseEntity<byte[]> downloadAttachmentByIds(@PathVariable("id") Long... ids) {
        String content = bibtex.generateString(references.findByIds(ids));
        return fileDownload(content);
    }

    @RequestMapping(value = "downloadBibtex", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadAttachment() {
        String content = bibtex.generateString(references.listAll());
        return fileDownload(content);
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Reference> listAll() {
        return references.listAll();
    }

    private void addAll(Model model) {
        addOne(model, "book", new Book());
        addOne(model, "article", new Article());
        addOne(model, "inproc", new Inproceedings());
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

    private ResponseEntity<byte[]> fileDownload(String content) {
        byte[] bytes = content.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(bytes.length);
        headers.set("Content-Disposition", "attachment; filename=\"list" + System.currentTimeMillis() + ".BIB\"");
        headers.setContentType(MediaType.parseMediaType("text/plain"));
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }
}
