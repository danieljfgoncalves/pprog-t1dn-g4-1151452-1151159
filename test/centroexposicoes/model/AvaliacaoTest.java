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
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class AvaliacaoTest {
    
    public AvaliacaoTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDecisao method, of class Avaliacao.
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        Avaliacao instance = new Avaliacao();
        Avaliacao.TipoAvaliacao expResult = null;
        Avaliacao.TipoAvaliacao result = instance.getDecisao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDecisao method, of class Avaliacao.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        Avaliacao.TipoAvaliacao decisao = null;
        Avaliacao instance = new Avaliacao();
        instance.setDecisao(decisao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAtribuicao method, of class Avaliacao.
     */
    @Test
    public void testGetAtribuicao() {
        System.out.println("getAtribuicao");
        Avaliacao instance = new Avaliacao();
        Atribuicao expResult = null;
        Atribuicao result = instance.getAtribuicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtribuicao method, of class Avaliacao.
     */
    @Test
    public void testSetAtribuicao() {
        System.out.println("setAtribuicao");
        Atribuicao atribuicao = null;
        Avaliacao instance = new Avaliacao();
        instance.setAtribuicao(atribuicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTxtJustificativo method, of class Avaliacao.
     */
    @Test
    public void testGetTxtJustificativo() {
        System.out.println("getTxtJustificativo");
        Avaliacao instance = new Avaliacao();
        String expResult = "";
        String result = instance.getTxtJustificativo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTxtJustificativo method, of class Avaliacao.
     */
    @Test
    public void testSetTxtJustificativo() {
        System.out.println("setTxtJustificativo");
        String txtJustificativo = "";
        Avaliacao instance = new Avaliacao();
        instance.setTxtJustificativo(txtJustificativo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Avaliacao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Avaliacao instance = new Avaliacao();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Avaliacao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = null;
        Avaliacao instance = new Avaliacao();
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
