package ohtu.service;

import java.util.List;
import ohtu.domain.Reference;

public interface ReferenceService {                                             //Rajapinta ReferenceServiceImpl:lle  
    
    Reference add(Reference ref);
    List<Reference> listAll();
    Reference findByRefid(String id);
    boolean delete(Reference ref);
    boolean delete(Long id);
    void deleteMany(Long... ids);
    Reference update(Reference ref);
    boolean containsRefId(String id);
    boolean breaksReferenceConstraint(Reference ref);

    Reference findById(Long id);
    List<Reference> findByIds(Long... ids);
    
}
