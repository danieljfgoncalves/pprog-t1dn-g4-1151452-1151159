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

    /**
     * Devolve a lista de exposições.
     *
     * @return a lista de exposições
     */
    public List<Exposicao> getListaExposicoes() {

        RegistoExposicoes registoExposicoes = this.centroExposicoes.getRegistoExposicoes();

        return registoExposicoes.getListaExposicoesPorOrganizador(this.organizador);
    }

    /**
     * Modifica a exposicão.
     *
     * @param exposicao a exposição
     */
    public void setExposicao(Exposicao exposicao) {

        this.exposicao = exposicao;
    }

    /**
     * Devolve a lista de mecanismos.
     *
     * @return a lista de mecanismos
     */
    public List<MecanismoAtribuicao> getListaMecanismos() {

        return this.centroExposicoes.getRegistoMecanismos().getListaMecanismos();
    }

    /**
     * Modifica o mecanismo.
     *
     * @param mecanismo o mecanismo
     */
    public void setMecanismo(MecanismoAtribuicao mecanismo) {

        this.mecanismoSelecionado = mecanismo;
    }

    /**
     * Devolve a lista de atribuições.
     *
     * @return a lista de atribuições
     */
    public List<Atribuicao> getListaAtribuicoes() {

        return this.mecanismoSelecionado.getListaAtribuicoes(this.exposicao);
    }

    /**
     * Regista a lista de atribuições na exposição em causa.
     *
     * @param listaAtribuicoes a lista de atribuições
     */
    public void registarAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.exposicao.setListaAtribuicoes(new ListaAtribuicoes(listaAtribuicoes));
    }
}
