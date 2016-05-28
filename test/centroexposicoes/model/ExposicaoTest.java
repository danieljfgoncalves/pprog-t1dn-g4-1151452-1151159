/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import centroexposicoes.utils.Data;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários para a classe Exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ExposicaoTest {

    private Exposicao exposicao;
    private ListaCandidaturas listaCandidaturas;
    private List<Demonstracao> listaDemonstracoes;

    public ExposicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        List<Candidatura> lista = new ArrayList<>();
        lista.add(new Candidatura());
        lista.add(new Candidatura());
        lista.add(new Candidatura());
        listaCandidaturas = new ListaCandidaturas(lista);

        listaDemonstracoes = new ArrayList<>();
        listaDemonstracoes.add(new Demonstracao("demo1"));
        listaDemonstracoes.add(new Demonstracao("demo2"));
        listaDemonstracoes.add(new Demonstracao("demo3"));
        listaDemonstracoes.add(new Demonstracao("demo4"));

        exposicao = new Exposicao("expo1", "descricao1", new Data(2016, 01, 01), new Data(2016, 04, 01),
                new Data(2016, 02, 01), new Data(2016, 03, 01), new Local(), new ListaFaes(), new ListaOrganizadores(), listaCandidaturas, listaDemonstracoes, new ListaAtribuicoes());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTitulo method, of class Exposicao.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        String expResult = "expo1";
        String result = exposicao.getTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitulo method, of class Exposicao.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String titulo = "expo2";
        exposicao.setTitulo(titulo);
        assertEquals(exposicao.getTitulo(), titulo);
    }

    /**
     * Test of getDescricao method, of class Exposicao.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        String expResult = "descricao1";
        String result = exposicao.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescricao method, of class Exposicao.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "descricao2";
        exposicao.setDescricao(descricao);
        assertEquals(exposicao.getDescricao(), descricao);
    }

    /**
     * Test of getDataInicio method, of class Exposicao.
     */
    @Test
    public void testGetDataInicio() {
        System.out.println("getDataInicio");
        Data expResult = new Data(2016, 01, 01);
        Data result = exposicao.getDataInicio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataInicio method, of class Exposicao.
     */
    @Test
    public void testSetDataInicio() {
        System.out.println("setDataInicio");
        Data dataInicio = new Data(2016, 01, 02);
        exposicao.setDataInicio(dataInicio);
        assertEquals(exposicao.getDataInicio(), dataInicio);
    }

    /**
     * Test of getDataFim method, of class Exposicao.
     */
    @Test
    public void testGetDataFim() {
        System.out.println("getDataFim");
        Exposicao instance = new Exposicao();
        Data expResult = new Data(2016, 04, 01);
        Data result = exposicao.getDataFim();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataFim method, of class Exposicao.
     */
    @Test
    public void testSetDataFim() {
        System.out.println("setDataFim");
        Data dataFim = new Data(2016, 04, 02);
        exposicao.setDataFim(dataFim);
        assertEquals(exposicao.getDataFim(), dataFim);
    }

    /**
     * Test of getSubInicio method, of class Exposicao.
     */
    @Test
    public void testGetSubInicio() {
        System.out.println("getSubInicio");
        Data expResult = new Data(2016, 02, 01);
        Data result = exposicao.getSubInicio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubInicio method, of class Exposicao.
     */
    @Test
    public void testSetSubInicio() {
        System.out.println("setSubInicio");
        Data subInicio = new Data(2016, 02, 02);
        exposicao.setSubInicio(subInicio);
        assertEquals(exposicao.getSubInicio(), subInicio);
    }

    /**
     * Test of getSubFim method, of class Exposicao.
     */
    @Test
    public void testGetSubFim() {
        System.out.println("getSubFim");
        Data expResult = new Data(2016, 03, 01);
        Data result = exposicao.getSubFim();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubFim method, of class Exposicao.
     */
    @Test
    public void testSetSubFim() {
        System.out.println("setSubFim");
        Data subFim = new Data(2016, 03, 02);
        exposicao.setSubFim(subFim);
        assertEquals(exposicao.getSubFim(), subFim);
    }

    /**
     * Test of getLocal method, of class Exposicao.
     */
    @Test
    public void testGetLocal() {
        System.out.println("getLocal");
        Local expResult = new Local();
        Local result = exposicao.getLocal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocal method, of class Exposicao.
     */
    @Test
    public void testSetLocal() {
        System.out.println("setLocal");
        Local local = new Local("Lisboa");
        exposicao.setLocal(local);
        assertEquals(exposicao.getLocal(), local);
    }

    /**
     * Test of getListaCandidaturas method, of class Exposicao.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        ListaCandidaturas expResult = listaCandidaturas;
        ListaCandidaturas result = exposicao.getListaCandidaturas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaCandidaturas method, of class Exposicao.
     */
    @Test
    public void testSetListaCandidaturas() {
        System.out.println("setListaCandidaturas");
        ListaCandidaturas listaCandidaturas2 = new ListaCandidaturas();
        exposicao.setListaCandidaturas(listaCandidaturas2);
        assertEquals(exposicao.getListaCandidaturas(), listaCandidaturas2);
    }

    /**
     * Test of getListaDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        List<Demonstracao> expResult = listaDemonstracoes;
        List<Demonstracao> result = exposicao.getListaDemonstracoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testSetListaDemonstracoes() {
        System.out.println("setListaDemonstracoes");
        List<Demonstracao> listaDemonstracoes2 = new ArrayList<>();
        exposicao.setListaDemonstracoes(listaDemonstracoes2);
        assertEquals(listaDemonstracoes2, exposicao.getListaDemonstracoes());
    }

    /**
     * Test of novaCandidatura method, of class Exposicao.
     */
    @Test
    public void testNovaCandidatura() {
        System.out.println("novaCandidatura");
        Candidatura expResult = new Candidatura();
        Candidatura result = exposicao.novaCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarCandidatura method, of class Exposicao.
     */
    @Test
    public void testAdicionarCandidatura() {
        System.out.println("adicionarCandidatura");
        Candidatura candidatura = new Candidatura();
        candidatura.setNomeEmpresa("empresa");
        assertTrue(exposicao.adicionarCandidatura(candidatura));
    }

}
