
package ohtu.service;

import java.util.List;
import ohtu.domain.Reference;


public interface BibtexService {
    String generate(Reference reference);
    List<String> generate(List<Reference> references);

    public String generateString(List<Reference> listAll);
}
