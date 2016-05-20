/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroexposicoes.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários para a class CentroExposicoes.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class CentroExposicoesTest {
    
    public CentroExposicoesTest() {
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
     * Test of getRegistoExposicoes method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoExposicoes expResult = new RegistoExposicoes();
        RegistoExposicoes result = instance.getRegistoExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class CentroExposicoes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CentroExposicoes instance = new CentroExposicoes();
        String expResult = String.format("Registo Exposições:%n");
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
