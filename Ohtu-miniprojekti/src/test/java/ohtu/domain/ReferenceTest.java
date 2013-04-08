/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.domain;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author annisall
 */
public class ReferenceTest {
    
    private Reference ref;


    @Before
    public void setUp() {
        ref=createReference();
    }
    
    

    @Test
    public void setIdChangesIdCorrectly() {
        Reference ref = createReference();
        ref.setId(Long.MIN_VALUE);
        assertTrue(Long.MIN_VALUE == ref.getId());
    }
    
    @Test
    public void constructerCreatesCorrectReference() {
        Reference ref=new Reference("Anniina","testiKirja");
        assertEquals("Anniina", ref.getAuthor());
        assertEquals("testiKirja", ref.getTitle());
        assertNotNull(ref);
    }

    private Reference createReference() {           //Luo uuden referencen jolle se antaa testauthorin ja titlen
        Reference ref = new Reference();
        ref.setAuthor("testAuthor " + UUID.randomUUID());
        ref.setTitle("testTitle " + UUID.randomUUID());
        return ref;
    }
}
