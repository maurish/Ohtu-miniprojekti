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
        String rakennettava = "@" + reference.getClass().getSimpleName().toLowerCase();
        rakennettava+="{"+reference.getRefId();

        Map<String, Object> attributes = reference.getAttributes();

        for (String key : attributes.keySet()) {
            Object value = attributes.get(key);
            if(!blank(value)) {
                rakennettava+=",\n"+" "+key+" = \""+value+"\"";
            }
        }
        rakennettava+="\n}\n";
        
        rakennettava = fixAeaekkoset(rakennettava);
        rakennettava+="\n";
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

    private String fixAeaekkoset(String rakennettava) {
        rakennettava = rakennettava.replaceAll("ä", "{\"a}");
        rakennettava = rakennettava.replaceAll("ö", "{\"o}");
        return rakennettava;
    }

    private boolean blank(Object value) {
        return value == null || value.equals("");
    }

    @Override
    public String generateString(List<Reference> listAll) {
        StringBuilder builder = new StringBuilder();
        for (String string : generate(listAll)) {
            builder.append(string);
        }
        return builder.toString();
    }
}
