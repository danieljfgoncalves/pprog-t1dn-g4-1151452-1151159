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
 * Testes unitários para a classe Utilizador.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class UtilizadorTest {
    
    public UtilizadorTest() {
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
     * Test of getNome method, of class Utilizador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        String expResult = "Ivo Ferro";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Utilizador.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Ivo Castro Ferro";
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        instance.setNome(nome);
        assertEquals(instance.getNome(), nome);
    }

    /**
     * Test of getEmail method, of class Utilizador.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        String expResult = "ivoferro@sapo.pt";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Utilizador.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "1151159@isep.ipp.pt";
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        instance.setEmail(email);
        assertEquals(instance.getEmail(), email);
    }

    /**
     * Test of getUsername method, of class Utilizador.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        String expResult = "ivoferro";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Utilizador.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "ivocastroferro";
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        instance.setUsername(username);
        assertEquals(instance.getUsername(), username);
    }

    /**
     * Test of getPassword method, of class Utilizador.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        String expResult = "123+qwe";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Utilizador.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "qwe+123";
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        instance.setPassword(password);
        assertEquals(instance.getPassword(), password);
    }

    /**
     * Test of toString method, of class Utilizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        String expResult = "Nome: Ivo Ferro; Email: ivoferro@sapo.pt; Username: ivoferro; Password: 123+qwe";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outroObjeto = null;
        Utilizador instance = new Utilizador("Ivo Ferro", "ivoferro@sapo.pt", "ivoferro", "123+qwe");
        boolean expResult = false;
        boolean result = instance.equals(outroObjeto);
        assertEquals(expResult, result);
    }
    
}
