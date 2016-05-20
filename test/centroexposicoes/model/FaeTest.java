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
 * Testes unitários para a classe Fae.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class FaeTest {
    
    public FaeTest() {
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
     * Test of getUtilizadorFae method, of class Fae.
     */
    @Test
    public void testGetUtilizadorFae() {
        System.out.println("getUtilizadorFae");
        Fae instance = new Fae(new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe"));
        Utilizador expResult = new Utilizador();
        Utilizador result = instance.getUtilizadorFae();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUtilizadorFae method, of class Fae.
     */
    @Test
    public void testSetUtilizadorFae() {
        System.out.println("setUtilizadorFae");
        Utilizador utilizadorFae = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        Fae instance = new Fae(new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe"));
        instance.setUtilizadorFae(utilizadorFae);
        assertEquals(instance.getUtilizadorFae(), utilizadorFae);
    }

    /**
     * Test of toString method, of class Fae.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Fae instance = new Fae(new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe"));
        String expResult = String.format("Utilizador FAE:%nNome: Ivo Ferro; Email: ivoferro@sapo.pt; Username: ivoferro; Password: 123+qwe");
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Fae.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        Fae instance = new Fae(new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe"));
        assertTrue(instance.equals(outroObjeto));
    }
    
}
