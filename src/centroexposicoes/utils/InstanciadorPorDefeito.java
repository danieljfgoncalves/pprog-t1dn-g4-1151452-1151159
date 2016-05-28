/*
 * Fornece as classes utilitárias para o centro de exposições.
 */
package centroexposicoes.utils;

import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.Avaliacao;
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
import centroexposicoes.model.Organizador;
import centroexposicoes.model.Produto;
import centroexposicoes.model.RegistoExposicoes;
import centroexposicoes.model.RegistoRepresentantes;
import centroexposicoes.model.Representante;
import centroexposicoes.model.Utilizador;
import java.util.ArrayList;
import java.util.List;

/**
 * Metodos para criar instâncias por defeito.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class InstanciadorPorDefeito {

    /**
     * Devolve um centro de exposições por defeito.
     *
     * @return um centro de exposições por defeito
     */
    public static CentroExposicoes getCentroExposicoesPorDefeito() {
        List<Organizador> lo = new ArrayList<>();
        lo.add(new Organizador(new Utilizador("Eric", "email", "ivo", "pass")));
        lo.add(new Organizador(new Utilizador("Ricardo", "email", "ivo", "pass")));
        lo.add(new Organizador(new Utilizador("Renato", "email", "ivo", "pass")));
        ListaOrganizadores listaOrganizadores = new ListaOrganizadores(lo);

        Fae ivo = new Fae(new Utilizador("Ivo", "email", "ivo", "pass"));
        List<Fae> lf = new ArrayList<>();
        lf.add(ivo);
        lf.add(new Fae(new Utilizador("Daniel", "email", "ivo", "pass")));
        ListaFaes listaFaes = new ListaFaes(lf);

        List<Demonstracao> listaDemonstracoes = new ArrayList<>();
        listaDemonstracoes.add(new Demonstracao("Git Hub"));
        listaDemonstracoes.add(new Demonstracao("Getting started with bootstrap."));
        listaDemonstracoes.add(new Demonstracao("Hackaton"));

        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("chapéu"));
        listaProdutos.add(new Produto("bola"));
        listaProdutos.add(new Produto("guarda chuva"));
        listaProdutos.add(new Produto("raquete"));

        Candidatura sonae = new Candidatura("SONAE", "Porto",
                "918765432", 42.2f, 4,
                listaProdutos, listaDemonstracoes, new ArrayList<>());
        List<Avaliacao> listAvaliacoes = new ArrayList<>();

        List<Candidatura> lc = new ArrayList<>();
        lc.add(new Candidatura(sonae));
        lc.add(new Candidatura("PortoTech", "Boavista", "912121212", 9100.3f, 100, listaProdutos, listaDemonstracoes, listAvaliacoes));
        ListaCandidaturas listaCandidaturas = new ListaCandidaturas(lc);

        List<Atribuicao> la = new ArrayList<>();
        ListaAtribuicoes listaAtribuicoes = new ListaAtribuicoes(la);

        Exposicao e1 = new Exposicao("Carros", "Expôr carros",
                new Data(2016, 6, 10), new Data(2016, 8, 20),
                new Data(2016, 6, 15), new Data(2016, 7, 15),
                new Local("Maia"), listaFaes, listaOrganizadores,
                listaCandidaturas, listaDemonstracoes, listaAtribuicoes);

        lo.remove(1);
        lo.add(new Organizador(new Utilizador("Abilio", "email", "asta", "pass")));
        ListaOrganizadores listaOrganizadores2 = new ListaOrganizadores(lo);
        Exposicao e2 = new Exposicao("Motas", "Expôr motas",
                new Data(2016, 8, 10), new Data(2016, 9, 12),
                new Data(2016, 8, 12), new Data(2016, 8, 15),
                new Local("Gaia"), listaFaes, listaOrganizadores2,
                listaCandidaturas, listaDemonstracoes, listaAtribuicoes);

        List<Exposicao> listaExposicoes = new ArrayList();
        listaExposicoes.add(e1);
        listaExposicoes.add(e2);

        RegistoExposicoes registoExposicoes = new RegistoExposicoes(listaExposicoes);

        List<Representante> lr = new ArrayList<>();
        lr.add(new Representante(new Utilizador("Bob", "email", "ivo", "pass")));
        RegistoRepresentantes registoRepresentantes = new RegistoRepresentantes(lr);

        CentroExposicoes centroExposicoes = new CentroExposicoes(registoExposicoes, registoRepresentantes);

        return centroExposicoes;

    }
}
