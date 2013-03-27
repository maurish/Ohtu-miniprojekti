/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.service;

import java.util.List;
import ohtu.domain.Reference;
import org.springframework.stereotype.Service;

@Service
public class BibtexServiceImpl implements BibtexService{
    
    @Override
    public void generate(Reference reference) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void generate(List<Reference> references) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
