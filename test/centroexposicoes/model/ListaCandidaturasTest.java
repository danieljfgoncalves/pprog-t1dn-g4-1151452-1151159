/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários para a class ListaCandidaturas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ListaCandidaturasTest {
    
    public ListaCandidaturasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListaCandidaturas method, of class ListaCandidaturas.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        List<Candidatura> listaCandidaturas = new ArrayList<>();
        listaCandidaturas.add(new Candidatura());
        ListaCandidaturas instance = new ListaCandidaturas(listaCandidaturas);
        List<Candidatura> expResult = listaCandidaturas;
        List<Candidatura> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaCandidaturas method, of class ListaCandidaturas.
     */
    @Test
    public void testSetListaCandidaturas() {
        System.out.println("setListaCandidaturas");
        List<Candidatura> listaCandidaturas = new ArrayList<>();
        listaCandidaturas.add(new Candidatura());
        ListaCandidaturas instance = new ListaCandidaturas();
        instance.setListaCandidaturas(listaCandidaturas);
        assertEquals(instance.getListaCandidaturas(), listaCandidaturas);
    }

    /**
     * Test of adicionarCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testAdicionarCandidatura() {
        System.out.println("adicionarCandidatura");
        Candidatura candidatura = new Candidatura();
        ListaCandidaturas instance = new ListaCandidaturas();
        assertTrue(instance.adicionarCandidatura(candidatura));
    }

    /**
     * Test of toString method, of class ListaCandidaturas.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaCandidaturas instance = new ListaCandidaturas();
        StringBuilder s = new StringBuilder();
        s.append("ListaCandidaturas{");
        for (Candidatura candidatura : instance.getListaCandidaturas()) {
            s.append(String.format("%s%n", candidatura));
        }
        s.append("}");
        String expResult = s.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ListaCandidaturas.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new ListaCandidaturas();
        ListaCandidaturas instance = new ListaCandidaturas();
        assertTrue(instance.equals(outroObjeto));
    }
    
}
