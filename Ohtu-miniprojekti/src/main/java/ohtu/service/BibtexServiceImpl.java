
package ohtu.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.domain.Reference;
import org.springframework.stereotype.Service;

@Service
public class BibtexServiceImpl implements BibtexService{

    @Override
    public String generate(Reference reference) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<String> generate(List<Reference> references) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
//    @Override
//    public String generate(Reference reference) {
//        return reference.toBibtex();
//    }
//
//    @Override
//    public List<String> generate(List<Reference> references) {
//        List<String> bibtexList = new ArrayList<String>();
//        for (Reference ref : references) {
//            bibtexList.add(ref.toBibtex());
//        }
//        return bibtexList;
//    }
    
}
