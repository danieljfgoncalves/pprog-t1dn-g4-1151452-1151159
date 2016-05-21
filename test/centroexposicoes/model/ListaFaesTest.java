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
 * Testes unitários para a class ListaFaes.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ListaFaesTest {
    
    public ListaFaesTest() {
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
     * Test of getListaFaes method, of class ListaFaes.
     */
    @Test
    public void testGetListaFaes() {
        System.out.println("getListaFaes");
        List<Fae> listaFaes = new ArrayList<>();
        listaFaes.add(new Fae());
        ListaFaes instance = new ListaFaes(listaFaes);
        List<Fae> expResult = new ArrayList<>(listaFaes);
        List<Fae> result = instance.getListaFaes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaFaes method, of class ListaFaes.
     */
    @Test
    public void testSetListaFaes() {
        System.out.println("setListaFaes");
        List<Fae> listaFaes = new ArrayList<>();
        listaFaes.add(new Fae());
        ListaFaes instance = new ListaFaes();
        instance.setListaFaes(listaFaes);
        assertEquals(instance.getListaFaes(), listaFaes);
    }

    /**
     * Test of toString method, of class ListaFaes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ListaFaes instance = new ListaFaes();
        StringBuilder s = new StringBuilder();
        s.append("ListaFaes{");
        for (Fae fae : instance.getListaFaes()) {
            s.append(String.format("%s%n", fae));
        }
        s.append("}");
        String expResult = s.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ListaFaes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new ListaFaes();
        ListaFaes instance = new ListaFaes();
        assertTrue(instance.equals(outroObjeto));
    }
    
}
