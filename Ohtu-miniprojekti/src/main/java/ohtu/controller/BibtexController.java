/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.controller;

import ohtu.service.BibtexService;
import ohtu.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author annisall
 */
@Controller
public class BibtexController {

    @Autowired
    BibtexService bibtex;
    @Autowired
    ReferenceService references;

    @RequestMapping(value = "listBibtex")
    public String listAllAsBibtex(Model model) {
        model.addAttribute("bibtexs", bibtex.generate(references.listAll()));
        return "bibtex";
    }

    @RequestMapping(value = "bibtex")
    public String pureBibtex(Model model) {
        model.addAttribute("bibtexs", bibtex.generate(references.listAll()));
        return "purebibtex";
    }

    @RequestMapping(value = "listIds/{ids}")
    public String listSelected(Model model, @PathVariable(value = "ids") Long... ids) {
        model.addAttribute("bibtexs", bibtex.generate(references.findByIds(ids)));
        return "bibtex";
    }

    @RequestMapping("listIds/{ids}/bibtex")
    public String listSelectedPureBibtex(Model model, @PathVariable("ids")Long... ids){
        model.addAttribute("bibtexs",bibtex.generate(references.findByIds(ids)));
        return "purebibtex";
    }
}
