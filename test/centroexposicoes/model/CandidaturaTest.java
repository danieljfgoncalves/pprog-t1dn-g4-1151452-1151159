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
 * Classe de teste JUnit da Candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class CandidaturaTest {

    public CandidaturaTest() {
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
     * Test of getNomeEmpresa method, of class Candidatura.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");
        Candidatura instance = new Candidatura();
        instance.setNomeEmpresa("empresa");
        String expResult = "empresa";
        String result = instance.getNomeEmpresa();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNomeEmpresa method, of class Candidatura.
     */
    @Test
    public void testSetNomeEmpresa() {
        System.out.println("setNomeEmpresa");
        String nomeEmpresa = "empresa";
        Candidatura instance = new Candidatura();
        instance.setNomeEmpresa(nomeEmpresa);
        assertEquals(instance.getNomeEmpresa(), nomeEmpresa);
    }

    /**
     * Test of getMorada method, of class Candidatura.
     */
    @Test
    public void testGetMorada() {
        System.out.println("getMorada");
        Candidatura instance = new Candidatura();
        instance.setMorada("morada");
        String expResult = "morada";
        String result = instance.getMorada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMorada method, of class Candidatura.
     */
    @Test
    public void testSetMorada() {
        System.out.println("setMorada");
        String morada = "morada";
        Candidatura instance = new Candidatura();
        instance.setMorada(morada);
        assertEquals(instance.getMorada(), morada);
    }

    /**
     * Test of getTelemovel method, of class Candidatura.
     */
    @Test
    public void testGetTelemovel() {
        System.out.println("getTelemovel");
        Candidatura instance = new Candidatura();
        instance.setTelemovel("910000000");
        String expResult = "910000000";
        String result = instance.getTelemovel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelemovel method, of class Candidatura.
     */
    @Test
    public void testSetTelemovel() {
        System.out.println("setTelemovel");
        String telemovel = "910000000";
        Candidatura instance = new Candidatura();
        instance.setTelemovel(telemovel);
        assertEquals(instance.getTelemovel(), telemovel);
    }

    /**
     * Test of getAreaExpositor method, of class Candidatura.
     */
    @Test
    public void testGetAreaExpositor() {
        System.out.println("getAreaExpositor");
        Candidatura instance = new Candidatura();
        instance.setAreaExpositor(1.25F);
        float expResult = 1.25F;
        float result = instance.getAreaExpositor();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of setAreaExpositor method, of class Candidatura.
     */
    @Test
    public void testSetAreaExpositor() {
        System.out.println("setAreaExpositor");
        float areaExpositor = 1.25F;
        Candidatura instance = new Candidatura();
        instance.setAreaExpositor(areaExpositor);
        assertEquals(instance.getAreaExpositor(), areaExpositor, 0.0001F);
    }

    /**
     * Test of getNumeroConvites method, of class Candidatura.
     */
    @Test
    public void testGetNumeroConvites() {
        System.out.println("getNumeroConvites");
        Candidatura instance = new Candidatura();
        instance.setNumeroConvites(1);
        int expResult = 1;
        int result = instance.getNumeroConvites();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumeroConvites method, of class Candidatura.
     */
    @Test
    public void testSetNumeroConvites() {
        System.out.println("setNumeroConvites");
        int numeroConvites = 1;
        Candidatura instance = new Candidatura();
        instance.setNumeroConvites(numeroConvites);
        assertEquals(instance.getNumeroConvites(), numeroConvites);
    }

    /**
     * Test of getListaProdutos method, of class Candidatura.
     */
    @Test
    public void testGetListaProdutos() {
        System.out.println("getListaProdutos");
        Candidatura instance = new Candidatura();
        List<Produto> expResult = null;
        List<Produto> result = instance.getListaProdutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaProdutos method, of class Candidatura.
     */
    @Test
    public void testSetListaProdutos() {
        System.out.println("setListaProdutos");
        List<Produto> listaProdutos = null;
        Candidatura instance = new Candidatura();
        instance.setListaProdutos(listaProdutos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDemonstracoes method, of class Candidatura.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        Candidatura instance = new Candidatura();
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaDemonstracoes method, of class Candidatura.
     */
    @Test
    public void testSetListaDemonstracoes() {
        System.out.println("setListaDemonstracoes");
        List<Demonstracao> listaDemonstracoes = null;
        Candidatura instance = new Candidatura();
        instance.setListaDemonstracoes(listaDemonstracoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novoProduto method, of class Candidatura.
     */
    @Test
    public void testNovoProduto() {
        System.out.println("novoProduto");
        String designacao = "produto1";
        Candidatura instance = new Candidatura();
        Produto expResult = new Produto("produto1");
        Produto result = instance.novoProduto(designacao);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarProduto method, of class Candidatura.
     */
    @Test
    public void testAdicionarProduto() {
        System.out.println("adicionarProduto");
        Produto produto = null;
        Candidatura instance = new Candidatura();
        boolean expResult = false;
        boolean result = instance.adicionarProduto(produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Candidatura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Candidatura instance = new Candidatura();
        String expResult = "Candidatura{nomeEmpresa=Sem designação, morada=Sem morada, telemovel=Número indefinido, areaExpositor=1.0, numeroConvites=0}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
