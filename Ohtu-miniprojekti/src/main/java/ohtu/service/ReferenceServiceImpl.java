package ohtu.service;

import java.util.ArrayList;
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
        if (containsRefId(ref.getRefId())) {
            return null;
        }
        generateRefId(ref);
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

    @Override
    public boolean delete(Reference ref) {
        return delete(ref.getId());
    }

    @Override
    public boolean delete(Long id) {
        if (!repo.exists(id)) {

            return false;
        }
        repo.delete(id);
        return true;
    }

    @Override
    public Reference update(Reference ref) {
        if (breaksReferenceConstraint(ref)) {
            return null;
        }
        return repo.save(ref);
    }

    @Override
    public boolean containsRefId(String id) {
        return repo.findByRefId(id) != null;
    }

    private void generateRefId(Reference ref) {
        if (blank(ref.getRefId())) {
            // @TODO auto generation for refid
        }
    }

    private boolean blank(String refId) {
        return refId == null || refId.isEmpty() || refId.equals("");
    }

    @Override
    public Reference findById(Long id) {
        return repo.findOne(id);
    }

    @Override
    public List<Reference> findByIds(Long... ids) {
        List<Reference> ret = new ArrayList<Reference>();
        for (Long id : ids) {
            Reference found = findById(id);
            if (found != null) {
                ret.add(found);
            }
        }
        return ret;
    }

    @Override
    public void deleteMany(Long... ids) {
        for (Long id : ids) {
            delete(id);
        }
    }

    @Override
    public boolean breaksReferenceConstraint(Reference ref) {
        String refId = ref.getRefId();
        Reference found = repo.findByRefId(refId);
        if (found==null){
            return false;
        }
        if (found.getId().equals(ref.getId())){
            return false;
        }
        return true;
    }



}
