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
 *
 * @author ASUS
 */
public class DemonstracaoTest {
    
    private Demonstracao demonstracao;
    
    public DemonstracaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        demonstracao = new Demonstracao("Carros Antigos");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCodigoUnico method, of class Demonstracao.
     */
    @Test
    public void testGetCodigoUnico() {
        System.out.println("getCodigoUnico");
        Demonstracao instance = demonstracao;
        String expResult = "DEMO-2";
        String result = instance.getCodigoUnico();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignacao method, of class Demonstracao.
     */
    @Test
    public void testGetDesignacao() {
        System.out.println("getDesignacao");
        Demonstracao instance = demonstracao;
        String expResult = "Carros Antigos";
        String result = instance.getDesignacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDesignacao method, of class Demonstracao.
     */
    @Test
    public void testSetDesignacao() {
        System.out.println("setDesignacao");
        String designacao = "Motas Antigas";
        Demonstracao instance = demonstracao;
        instance.setDesignacao(designacao);
        assertEquals(instance.getDesignacao(), designacao);
    }

    /**
     * Test of toString method, of class Demonstracao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Demonstracao instance = demonstracao;
        String expResult = "Demonstracao{codigoUnico=DEMO-3, designacao=Carros Antigos}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Demonstracao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = demonstracao;
        Demonstracao instance = demonstracao;
        assertTrue(instance.equals(outroObjeto));
    }
    
}
