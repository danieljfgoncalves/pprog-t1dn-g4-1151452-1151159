/**
 * Fornece as classes que comunicam com o modelo e a interface gráfica.
 */
package centroexposicoes.controller;

import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.Candidatura;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Demonstracao;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Fae;
import centroexposicoes.model.ListaAtribuicoes;
import centroexposicoes.model.ListaCandidaturas;
import centroexposicoes.model.ListaFaes;
import centroexposicoes.model.ListaOrganizadores;
import centroexposicoes.model.Local;
import centroexposicoes.model.MecanismoAtribuicao;
import centroexposicoes.model.Organizador;
import centroexposicoes.model.RegistoExposicoes;
import centroexposicoes.model.RegistoMecanismos;
import centroexposicoes.model.RegistoRepresentantes;
import centroexposicoes.model.Representante;
import centroexposicoes.model.Utilizador;
import centroexposicoes.model.mecanismos.Mecanismo2;
import centroexposicoes.utils.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Comunicador entre o UI e Model acerca da atribuição de candidaturas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class AtribuirCandidaturaController {

    /**
     * O organizador que iniciou a sessão.
     */
    private final Organizador organizador;

    /**
     * Registo de exposições. Contém a lista de exposições.
     */
    private final CentroExposicoes centroExposicoes;

    /**
     * Exposicao selecionada pelo organizador.
     */
    private Exposicao exposicao;

    /**
     * Lista de Atribuições;
     */
    private ListaAtribuicoes registoAtribuicoes;

    /**
     * Mecanismo selecionado pelo Organizador.
     */
    private MecanismoAtribuicao mecanismoSelecionado;

    /**
     * Cria uma instância do controller para a atribuição de candidaturas,
     * recebendo o centro de exposições e o organizador.
     *
     * @param centroExposicoes Centro de Exposições
     * @param organizador Organizador que iniciou a sessão
     */
    public AtribuirCandidaturaController(CentroExposicoes centroExposicoes, Organizador organizador) {

        this.organizador = organizador;
        this.centroExposicoes = centroExposicoes;
    }

    public List<Exposicao> getListaExposicoes(Organizador organizador) {

        RegistoExposicoes registoExposicoes = this.centroExposicoes.getRegistoExposicoes();

        return registoExposicoes.getListaExposicoesPorOrganizador(organizador);
    }

    public void setExposicao(Exposicao exposicao) {

        this.exposicao = exposicao;
        this.registoAtribuicoes = exposicao.getListaAtribuicoes();
    }

    public List<MecanismoAtribuicao> getListaMecanismos() {

        return this.centroExposicoes.getRegistoMecanismos().getListaMecanismos();
    }

    public void setMecanismo(MecanismoAtribuicao mecanismo) {

        this.mecanismoSelecionado = mecanismo;
    }

    public List<Atribuicao> getListaAtribuicoes() {

        return this.mecanismoSelecionado.getListaAtribuicoes(this.exposicao);
    }

    public void registarAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.registoAtribuicoes.setListaAtribuicoes(listaAtribuicoes);
    }

    public static void main(String[] args) {

        List<Organizador> lo = new ArrayList<>();
        lo.add(new Organizador(new Utilizador("Eric", "email", "ivo", "pass")));
        lo.add(new Organizador(new Utilizador("Ricardo", "email", "ivo", "pass")));
        lo.add(new Organizador(new Utilizador("Renato", "email", "ivo", "pass")));
        ListaOrganizadores listaOrganizadores = new ListaOrganizadores(lo);

        Fae ivo = new Fae(new Utilizador("Ivo", "email", "ivo", "pass"));
        ivo.setContCandPorAvaliar(3);

        Fae renato = new Fae(new Utilizador("Renato", "email", "ivo", "pass"));
        renato.setContCandPorAvaliar(1);
        
        List<Fae> lf = new ArrayList<>();
//        lf.add(new Fae(new Utilizador("Eric", "email", "ivo", "pass")));
        lf.add(new Fae(new Utilizador("Daniel", "email", "ivo", "pass")));
        lf.add(ivo);
        lf.add(renato);
        ListaFaes listaFaes = new ListaFaes(lf);

        List<Demonstracao> listaDemonstracoes = new ArrayList<>();
        listaDemonstracoes.add(new Demonstracao("Git Hub"));
        listaDemonstracoes.add(new Demonstracao("Getting started with bootstrap."));
        listaDemonstracoes.add(new Demonstracao("Hackaton"));

        Candidatura sonae = new Candidatura("SONAE", "Porto", "918765432", 42.2f, 4, lo, listaDemonstracoes);

        List<Candidatura> lc = new ArrayList<>();
        lc.add(new Candidatura(sonae));
        lc.add(new Candidatura("PortoTech", "Boavista", "912121212", 9100.3f, 100, lo, listaDemonstracoes));
        lc.add(new Candidatura("LisboaTech", "Boavista", "912121212", 9100.3f, 100, lo, listaDemonstracoes));
        lc.add(new Candidatura("GaiaTech", "Boavista", "912121212", 9100.3f, 100, lo, listaDemonstracoes));
        lc.add(new Candidatura("MaiaTech", "Boavista", "912121212", 9100.3f, 100, lo, listaDemonstracoes));
        lc.add(new Candidatura("PovoaTech", "Boavista", "912121212", 9100.3f, 100, lo, listaDemonstracoes));
        ListaCandidaturas listaCandidaturas = new ListaCandidaturas(lc);

        List<Atribuicao> la = new ArrayList<>();
        ListaAtribuicoes listaAtribuicoes = new ListaAtribuicoes(la);

        Exposicao e1 = new Exposicao("Carros", "Expôr carros",
                new Data(2016, 6, 10), new Data(2016, 8, 20),
                new Data(2016, 6, 15), new Data(2016, 7, 15),
                new Local("Maia"), listaFaes, listaOrganizadores,
                listaCandidaturas, listaDemonstracoes, listaAtribuicoes);

        List<Exposicao> listaExposicoes = new ArrayList();
        listaExposicoes.add(e1);

        List<MecanismoAtribuicao> listaMecanismos = new ArrayList();
        Mecanismo2 m = new Mecanismo2();
        listaMecanismos.add(m);
        RegistoMecanismos registoMecanismos = new RegistoMecanismos(listaMecanismos);

        RegistoExposicoes registoExposicoes = new RegistoExposicoes(listaExposicoes);

        List<Representante> lr = new ArrayList<>();
        lr.add(new Representante(new Utilizador("Bob", "email", "ivo", "pass")));
        RegistoRepresentantes registoRepresentantes = new RegistoRepresentantes(lr);

        CentroExposicoes centroExposicoes = new CentroExposicoes(registoExposicoes, registoMecanismos, registoRepresentantes);
        
        AtribuirCandidaturaController controller = new AtribuirCandidaturaController(centroExposicoes, new Organizador());
        
        controller.setExposicao(e1);
        controller.setMecanismo(m);
        
        List<Atribuicao> laTeste = controller.getListaAtribuicoes();
        
        
        
    }
}
