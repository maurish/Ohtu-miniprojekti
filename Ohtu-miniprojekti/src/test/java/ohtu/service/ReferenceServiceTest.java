package ohtu.service;

import java.util.List;
import java.util.UUID;
import ohtu.domain.Reference;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)                             //PAKOLLISIA
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/front-controller-servlet.xml"}) //PAKOLLISIA
public class ReferenceServiceTest {

    @Autowired
    ApplicationContext context;
    ReferenceService repo;
    int preSize;                                            //Kertoo kuinka paljon kamaa ennenku lisättii jtn

    @Before
    public void setUp() {
        repo = context.getBean(ReferenceService.class);             //spring kontekstista hakee "olion"
        preSize = repo.listAll().size();
    }

    @Test
    public void beanHasBeenLoadedToContext() {
        assertNotNull(repo);
    }

    @Test
    public void serviceReturnsEmptyList() {
        assertTrue(repo.listAll() instanceof List);
        assertNotNull(repo.listAll());
    }

    @Test
    public void addingOneReferenceShowsUpOnList() {
        repo.add(createReference());
        assertEquals(preSize + 1, repo.listAll().size());
        assertTrue(repo.listAll().get(preSize).getAuthor().contains("testAuthor"));
    }

    @Test
    public void addingMultipleReferenceShowsUpOnList() {
        int amount = 50;
        for (int i = 0; i < amount; i++) {
            repo.add(createReference());
        }
        assertEquals(preSize + amount, repo.listAll().size());
        List<Reference> list = repo.listAll();
        for (int i = 0; i < amount; i++) {
            Reference ref = list.get(preSize + i);
            assertTrue(ref.getAuthor().contains("testAuthor"));
            assertTrue(ref.getTitle().contains("testTitle"));
        }
    }

    @Test
    public void addingReferenceGivesItUniqueId() {
        repo.add(createReference());
        repo.add(createReference());
        List<Reference> list = repo.listAll();
        assertEquals(preSize + 2, list.size());
        assertFalse(list.get(preSize).equals(list.get(preSize + 1)));
    }

    private Reference createReference() {           //Luo uuden referencen jolle se antaa testauthorin ja titlen
        Reference ref = new Reference();
        ref.setAuthor("testAuthor " + UUID.randomUUID());
        ref.setTitle("testTitle " + UUID.randomUUID());
        ref.setPubYear(2012);
        return ref;
    }
}
