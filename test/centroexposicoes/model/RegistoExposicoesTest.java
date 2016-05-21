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
 * Testes unitários para a class RegistoExposicoes.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistoExposicoesTest {
    
    public RegistoExposicoesTest() {
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
     * Test of getListaExposicoes method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        List<Exposicao> listaExposicoes = new ArrayList<>();
        listaExposicoes.add(new Exposicao());
        RegistoExposicoes instance = new RegistoExposicoes(listaExposicoes);
        List<Exposicao> expResult = listaExposicoes;
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaExposicoes method, of class RegistoExposicoes.
     */
    @Test
    public void testSetListaExposicoes() {
        System.out.println("setListaExposicoes");
        List<Exposicao> listaExposicoes = new ArrayList<>();
        listaExposicoes.add(new Exposicao());
        RegistoExposicoes instance = new RegistoExposicoes();
        instance.setListaExposicoes(listaExposicoes);
        assertEquals(instance.getListaExposicoes(), listaExposicoes);
    }

    /**
     * Test of toString method, of class RegistoExposicoes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        List<Exposicao> listaExposicoes = new ArrayList<>();
        listaExposicoes.add(new Exposicao());
        RegistoExposicoes instance = new RegistoExposicoes(listaExposicoes);
        StringBuilder expResult = new StringBuilder();
        expResult.append("RegistoExposicoes{");
        for (Exposicao exposicao : instance.getListaExposicoes()) {
            expResult.append(String.format("%s%n", exposicao));
        }
        expResult.append("}");
        String result = instance.toString();
        assertEquals(expResult.toString(), result);
    }

    /**
     * Test of equals method, of class RegistoExposicoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjecto = new RegistoExposicoes();
        RegistoExposicoes instance = new RegistoExposicoes();
        assertTrue(instance.equals(outroObjecto));
    }
    
}
