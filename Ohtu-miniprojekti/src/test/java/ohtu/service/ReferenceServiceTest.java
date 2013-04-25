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
    Long invalidId = Long.valueOf("123123123123");

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
        create();
        assertEquals(preSize + 1, repo.listAll().size());
        assertTrue(repo.listAll().get(preSize).getAuthor().contains("testAuthor"));
    }

    @Test
    public void addingMultipleReferenceShowsUpOnList() {
        int amount = 50;
        for (int i = 0; i < amount; i++) {
            create();
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
        create();
        create();
        List<Reference> list = repo.listAll();
        assertEquals(preSize + 2, list.size());
        assertFalse(list.get(preSize).equals(list.get(preSize + 1)));
    }

    private Reference createReference() {           //Luo uuden referencen jolle se antaa testauthorin ja titlen
        Reference ref = new Reference();
        ref.setAuthor("testAuthor " + UUID.randomUUID());
        ref.setTitle("testTitle " + UUID.randomUUID());
        ref.setPubYear(2012);
        ref.setRefId("testID" + UUID.randomUUID());
        return ref;
    }

    @Test
    public void creatingOneAndDeletingOneShouldEqualZero() {
        Reference added = create();
        repo.delete(added);
        assertEquals(preSize, repo.listAll().size());
    }

    @Test
    public void updateWorks() {
        Integer year = 1988;
        Reference added = create();
        added.setPubYear(year);
        repo.update(added);
        assertEquals(year, repo.findById(added.getId()).getPubYear());
    }

    @Test
    public void findByIdFoundNothingIfDeleted() {
        Reference added = create();
        repo.delete(added);
        assertNull(repo.findById(added.getId()));
    }

    @Test
    public void findByIdsWorks() {
        Reference added1 = create();
        Reference added2 = create();
        List<Reference> findByIds = repo.findByIds(added1.getId(), added2.getId());
        assertEquals(2, findByIds.size());
    }

    @Test
    public void findOneByIdsAndIdIsSame() {
        Reference added1 = create();
        assertEquals(repo.findById(added1.getId()), repo.findByIds(added1.getId()).get(0));

    }

    @Test
    public void findByIdsWithInvalidIdsReturnsEmptyList() {
        create();
        assertEquals(0, repo.findByIds(invalidId).size());
    }

    @Test
    public void finByIdsWithValidAndInvalidIdsReturnsCorrectList() {
        Reference added = create();
        List<Reference> list = repo.findByIds(added.getId(), invalidId);
        assertEquals(1, list.size());
        assertEquals(added, list.get(0));
    }

    private Reference create() {
        return repo.add(createReference());
    }

    @Test
    public void breaksReferenceConstraintUsingUniqueRefIdWorks() {
        Reference added = create();
        assertFalse(repo.breaksReferenceConstraint(added));
    }

    @Test
    public void breaksReferenceConstraintUsingSameId() {
        Reference added = create();
        Reference added2 = new Reference();
        added2.setRefId(added.getRefId());
        assertTrue(repo.breaksReferenceConstraint(added2));
    }
}
