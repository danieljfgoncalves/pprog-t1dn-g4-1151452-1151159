/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroexposicoes.model;

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
     * Test of getExposicoes method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoes() {
        System.out.println("getExposicoes");
        RegistoExposicoes instance = new RegistoExposicoes();
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getExposicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RegistoExposicoes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RegistoExposicoes instance = new RegistoExposicoes();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class RegistoExposicoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjecto = null;
        RegistoExposicoes instance = new RegistoExposicoes();
        boolean expResult = false;
        boolean result = instance.equals(outroObjecto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
