
package ohtu.service;

import java.util.List;
import ohtu.domain.Reference;


public interface BibtexService {
    void generate(Reference reference);
    void generate(List<Reference> references);
}
