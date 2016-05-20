/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste JUnit do Produto.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ProdutoTest {
    
    public ProdutoTest() {
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
     * Test of getDesignacao method, of class Produto.
     */
    @Test
    public void testGetDesignacao() {
        System.out.println("getDesignacao");
        Produto instance = new Produto("honda");
        String expResult = "honda";
        String result = instance.getDesignacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDesignacao method, of class Produto.
     */
    @Test
    public void testSetDesignacao() {
        System.out.println("setDesignacao");
        String designacao = "honda";
        Produto instance = new Produto();
        instance.setDesignacao(designacao);
        assertEquals(instance.getDesignacao(), designacao);
    }

    /**
     * Test of valida method, of class Produto.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Produto instance = new Produto("honda");
        assertTrue(instance.valida());
    }

    /**
     * Test of toString method, of class Produto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Produto instance = new Produto("honda");
        String expResult = "Produto{designacao=honda}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Produto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Produto("honda");
        Produto instance = new Produto("honda");
        assertEquals(instance, obj);
    }
    
}
