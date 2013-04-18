package ohtu.service;

import java.util.List;
import ohtu.domain.Reference;
import ohtu.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements ReferenceService {         //Käytetään tietokannan käsittelyyn

    @Autowired
    ReferenceRepository repo;

    @Override
    public Reference add(Reference ref) {
       return repo.save(ref);
    }

    @Override
    public List<Reference> listAll() {
        return repo.findAll();
    }

    @Override
    public Reference findByRefid(String id) {
        return repo.findByRefId(id);
    }
    
    
}
