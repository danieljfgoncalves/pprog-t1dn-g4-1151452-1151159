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
    
    private CentroExposicoes centroExposicoes;
    
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
        centroExposicoes = new CentroExposicoes();
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
        CentroExposicoes instance = centroExposicoes;
        RegistoExposicoes expResult = new RegistoExposicoes();
        RegistoExposicoes result = instance.getRegistoExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegistoExposicoes method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoExposicoes() {
        System.out.println("setRegistoExposicoes");
        RegistoExposicoes registoExposicoes = new RegistoExposicoes();
        CentroExposicoes instance = centroExposicoes;
        instance.setRegistoExposicoes(registoExposicoes);
        assertEquals(instance.getRegistoExposicoes(), registoExposicoes);
    }

    /**
     * Test of getRegistoMecanismos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoMecanismos() {
        System.out.println("getRegistoMecanismos");
        CentroExposicoes instance = centroExposicoes;
        RegistoMecanismos expResult = new RegistoMecanismos();
        RegistoMecanismos result = instance.getRegistoMecanismos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegistoMecanismos method, of class CentroExposicoes.
     */
    @Test
    public void testSetRegistoMecanismos() {
        System.out.println("setRegistoMecanismos");
        RegistoMecanismos registoMecanismos = new RegistoMecanismos();
        CentroExposicoes instance = centroExposicoes;
        instance.setRegistoMecanismos(registoMecanismos);
        assertEquals(instance.getRegistoMecanismos(), registoMecanismos);
    }

    /**
     * Test of toString method, of class CentroExposicoes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CentroExposicoes instance = centroExposicoes;
        RegistoExposicoes registoExposicoes = new RegistoExposicoes();
        RegistoMecanismos registoMecanismos = new RegistoMecanismos();
        String expResult = String.format("CentroExposicoes{registoExposicoes=%s, registoMecanismos=%s}", registoExposicoes, registoMecanismos); 
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class CentroExposicoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new CentroExposicoes();
        CentroExposicoes instance = centroExposicoes;
        assertTrue(instance.equals(outroObjeto));
    }
    
}
