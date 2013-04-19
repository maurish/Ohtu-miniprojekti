package ohtu.service;

import java.util.List;
import ohtu.domain.Reference;

public interface ReferenceService {                                             //Rajapinta ReferenceServiceImpl:lle  
    
    Reference add(Reference ref);
    List<Reference> listAll();
    Reference findByRefid(String id);
    boolean delete(Reference ref);
    boolean delete(Long id);
    Reference update(Reference ref);
    boolean containsRefId(String id);
    
}
