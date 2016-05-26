/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import centroexposicoes.model.MecanismoAtribuicao;
import centroexposicoes.model.Organizador;
import centroexposicoes.model.Produto;
import centroexposicoes.model.RegistoExposicoes;
import centroexposicoes.model.RegistoMecanismos;
import centroexposicoes.model.RegistoRepresentantes;
import centroexposicoes.model.Representante;
import centroexposicoes.model.Utilizador;
import java.util.ArrayList;
import java.util.List;

/**
 * Metodos para criar instâncias por defeito.
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class InstanciadorPorDefeito {

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
        Atribuicao atribuicao = new Atribuicao(sonae, ivo);
        Avaliacao avaliacao = new Avaliacao(Avaliacao.TipoAvaliacao.Aprovado, atribuicao, "Dentro do contexto.");
        List<Avaliacao> listAvaliacoes = new ArrayList<>();
        listAvaliacoes.add(avaliacao);
        sonae.setListaAvaliacoes(listAvaliacoes);

        List<Candidatura> lc = new ArrayList<>();
        lc.add(new Candidatura(sonae));
        lc.add(new Candidatura("PortoTech", "Boavista", "912121212", 9100.3f, 100, listaProdutos, listaDemonstracoes, listAvaliacoes));
        ListaCandidaturas listaCandidaturas = new ListaCandidaturas(lc);

        List<Atribuicao> la = new ArrayList<>();
        la.add(atribuicao);
        ListaAtribuicoes listaAtribuicoes = new ListaAtribuicoes(la);

        Exposicao e1 = new Exposicao("Carros", "Expôr carros",
                new Data(2016, 6, 10), new Data(2016, 8, 20),
                new Data(2016, 6, 15), new Data(2016, 7, 15),
                new Local("Maia"), listaFaes, listaOrganizadores,
                listaCandidaturas, listaDemonstracoes, listaAtribuicoes);

        List<Exposicao> listaExposicoes = new ArrayList();
        listaExposicoes.add(e1);

        List<MecanismoAtribuicao> listaMecanismos = new ArrayList();
        listaMecanismos.add(null);
        RegistoMecanismos registoMecanismos = new RegistoMecanismos(listaMecanismos);

        RegistoExposicoes registoExposicoes = new RegistoExposicoes(listaExposicoes);

        List<Representante> lr = new ArrayList<>();
        lr.add(new Representante(new Utilizador("Bob", "email", "ivo", "pass")));
        RegistoRepresentantes registoRepresentantes = new RegistoRepresentantes(lr);

        return new CentroExposicoes(registoExposicoes, registoMecanismos, registoRepresentantes);

    }
}
