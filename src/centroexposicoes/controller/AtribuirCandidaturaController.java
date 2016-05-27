/**
 * Fornece as classes que comunicam com o modelo e a interface gráfica.
 */
package centroexposicoes.controller;

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
import centroexposicoes.model.RegistoExposicoes;
import centroexposicoes.model.RegistoMecanismos;
import centroexposicoes.model.RegistoRepresentantes;
import centroexposicoes.model.Representante;
import centroexposicoes.model.Utilizador;
import centroexposicoes.model.mecanismos.MecanismoMenosCarga;
import centroexposicoes.utils.Data;
import centroexposicoes.utils.InstanciadorPorDefeito;
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
        
    }
}
