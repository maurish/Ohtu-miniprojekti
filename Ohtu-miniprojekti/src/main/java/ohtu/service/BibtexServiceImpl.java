/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.domain.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibtexServiceImpl implements BibtexService{
    
    
    Reference reference;
    
    @Override
    public String generate(Reference reference) {
        System.out.println(reference.toBibtex());
        return reference.toBibtex();
    }

    @Override
    public List<String> generate(List<Reference> references) {
        List<String> bibtexList = new ArrayList<String>();
        for (Reference ref : references) {
            String bibtex=ref.toBibtex();
            System.out.println(bibtex);
      //      System.out.println(ref.toBibtex());
            bibtexList.add(bibtex);
        }
        return bibtexList;
    }
    
}
