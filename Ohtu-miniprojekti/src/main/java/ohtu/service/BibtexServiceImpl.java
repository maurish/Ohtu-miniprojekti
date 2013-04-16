package ohtu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ohtu.domain.Reference;
import org.springframework.stereotype.Service;

@Service
public class BibtexServiceImpl implements BibtexService {

    @Override
    public String generate(Reference reference) {
        String rakennettava = "@" + reference.getClass().getSimpleName() + "{";
        Map<String, Object> attributes = reference.attributes();
        for (String string : attributes.keySet()) {
            if(attributes.get(string)!=null) {
                rakennettava+=string+" = \""+attributes.get(string)+"\", \n";
            }
        }
        rakennettava+="}";
        System.out.println(rakennettava);
        return rakennettava;
    }

    @Override
    public List<String> generate(List<Reference> references) {


        List<String> bibtexList = new ArrayList<String>();
        for (Reference ref : references) {
            bibtexList.add(generate(ref));
        }
        return bibtexList;
    }
}
