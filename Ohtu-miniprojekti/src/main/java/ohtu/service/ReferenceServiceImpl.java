package ohtu.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.domain.Reference;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements ReferenceService {         //Käytetään tietokannan käsittelyyn
    
    List<Reference> refs;

    public ReferenceServiceImpl() {
        this.refs=new ArrayList<Reference>();
    }
    @Override
    public void add(Reference ref) {
        refs.add(ref);
    }

    @Override
    public List<Reference> listAll() {
        return refs;
    }
}
