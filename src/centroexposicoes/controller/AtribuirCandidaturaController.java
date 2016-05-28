/**
 * Fornece as classes que comunicam com o modelo e a interface gráfica.
 */
package centroexposicoes.controller;

import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.ListaAtribuicoes;
import centroexposicoes.model.MecanismoAtribuicao;
import centroexposicoes.model.Organizador;
import centroexposicoes.model.RegistoExposicoes;
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
        this.exposicao.setListaAtribuicoes(new ListaAtribuicoes(listaAtribuicoes));
    }
}
