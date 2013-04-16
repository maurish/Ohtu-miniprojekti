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
    private Book book;
    private Article art;
    private Inproceedings inproc;

    @Before
    public void setUp() {
        ref = createReference();
        book = new Book();
        art = new Article();
        inproc = new Inproceedings();
    }

    @Test
    public void bookAttributesContainsRightAttributes() {
        book.setAuthor("Anniina");
        book.setTitle("Kokkauskirja");
        book.setPubYear(2001);

        assertEquals(book.attributes().size(), 5, 0.00001);
        assertTrue(book.attributes().containsKey("author"));
        assertTrue(book.attributes().containsKey("title"));
        assertTrue(book.attributes().containsKey("pubYear"));
        assertTrue(book.attributes().containsKey("editor"));
        assertTrue(book.attributes().containsKey("publisher"));

    }

    @Test
    public void atricleAttributesContainsRightAttributes() {
        art.setAuthor("Anniina");
        art.setTitle("Kokkauskirja");
        art.setPubYear(2001);

        assertEquals(art.attributes().size(), 10, 0.00001);
        assertTrue(art.attributes().containsKey("author"));
        assertTrue(art.attributes().containsKey("title"));
        assertTrue(art.attributes().containsKey("pubYear"));
        assertTrue(art.attributes().containsKey("journal"));
        assertTrue(art.attributes().containsKey("publisher"));
        assertTrue(art.attributes().containsKey("volume"));
        assertTrue(art.attributes().containsKey("number"));
        assertTrue(art.attributes().containsKey("pubMonth"));
        assertTrue(art.attributes().containsKey("pages"));
        assertTrue(art.attributes().containsKey("address"));

    }

    @Test
    public void inprocAttributesContainsRightAttributes() {
        inproc.setAuthor("Anniina");
        inproc.setTitle("Kokkauskirja");
        inproc.setPubYear(2001);

        assertEquals(inproc.attributes().size(), 6, 0.00001);
        assertTrue(inproc.attributes().containsKey("author"));
        assertTrue(inproc.attributes().containsKey("title"));
        assertTrue(inproc.attributes().containsKey("pubYear"));
        assertTrue(inproc.attributes().containsKey("publish month"));
        assertTrue(inproc.attributes().containsKey("book title"));
        assertTrue(inproc.attributes().containsKey("organisation"));

    }

    @Test
    public void setIdChangesIdCorrectly() {
        Reference ref = createReference();
        ref.setId(Long.MIN_VALUE);
        assertTrue(Long.MIN_VALUE == ref.getId());
    }

    @Test
    public void constructerCreatesCorrectReference() {
        Reference ref = new Reference("Anniina", "testiKirja");
        assertEquals("Anniina", ref.getAuthor());
        assertEquals("testiKirja", ref.getTitle());
        assertNotNull(ref);
    }

    private Reference createReference() {           //Luo uuden referencen jolle se antaa testauthorin ja titlen
        Reference ref = new Reference();
        ref.setAuthor("testAuthor " + UUID.randomUUID());
        ref.setTitle("testTitle " + UUID.randomUUID());
        ref.setPubYear(2001);
        return ref;
    }
}
