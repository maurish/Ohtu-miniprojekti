/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ohtu.domain.Reference;
import org.eclipse.persistence.internal.jpa.parsing.ConcatNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)                             //PAKOLLISIA
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/front-controller-servlet.xml"}) //PAKOLLISIA
public class BibtexServiceTest {

    @Autowired
    ApplicationContext context;
    BibtexService service;
    ArrayList<Reference> list;

    @Before
    public void setUp() {
        service = context.getBean(BibtexService.class);
        list = new ArrayList<Reference>();
    }

    @Test
    public void beanFound() {
    }

    @Test
    public void generateListReturnsEmptyList() {
        List list = service.generate(new ArrayList());
        assertEquals(0, list.size());
    }

    @Test
    public void generatingAndAddingIncreasesSize() {
        Reference ref1 = createRef();
        Reference ref2 = createRef();
        list.add(ref2);
        list.add(ref1);
        List<String> bibtexs = service.generate(list);
        assertEquals(2, bibtexs.size());
        for (int i = 0; i < bibtexs.size(); i++) {
            String ref = bibtexs.get(i);
            assertTrue(ref.contains("testAuthor"));
            assertTrue(ref.contains("testTitle"));
        }

    }
    
    @Test
    public void bibtexSyntaxContainsRightElements() {
        Reference ref1 = createRef();
        String bibtex = ref1.toBibtex();
        System.out.println(bibtex);
        checkParam(bibtex,"author","testAuthor");
    }
    
    private void checkParam(String bibtex, String name, String value){
        assertTrue(bibtex.matches("[\\s\\S]*"+name+"\\s+=\\s+\""+value+"\\s[0-9a-z\\-]*\"[\\s\\S]*"));
        // [\s\S]*author\s+=\s+"testAuthor\s[0-9a-z\-]*"[\s\S]*
    }

    private Reference createRef() {
        Reference ref = new Reference();
        ref.setAuthor("testAuthor " + UUID.randomUUID());
        ref.setTitle("testTitle " + UUID.randomUUID());
        return ref;
    }
}
