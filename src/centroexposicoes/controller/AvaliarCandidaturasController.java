/**
 * Fornece as classes que comunicam com o modelo e a interface gráfica.
 */
package centroexposicoes.controller;

import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.Avaliacao;
import centroexposicoes.model.Candidatura;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Fae;
import centroexposicoes.model.RegistoExposicoes;
import java.util.List;

/**
 * Comunicador entre o UI e Model acerca da avaliação de candidaturas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class AvaliarCandidaturasController {

    /**
     * Registo de exposições.
     */
    private final RegistoExposicoes registoExposicoes;
    /**
     * Funcionário de apoio à exposição.
     */
    private final Fae fae;
    /**
     * Exposição.
     */
    private Exposicao exposicao;
    /**
     * Candidatura.
     */
    private Candidatura candidatura;
    /**
     * Avaliação.
     */
    private Avaliacao avaliacao;

    /**
     * Cria uma instância de AvaliarCandidaturasController.
     *
     * @param centroExposicoes Centro de exposições do contexto
     * @param fae Funcionário de apoio à exposição
     */
    public AvaliarCandidaturasController(CentroExposicoes centroExposicoes, Fae fae) {
        registoExposicoes = centroExposicoes.getRegistoExposicoes();
        this.fae = fae;
    }

    /**
     * Devolve a lista de exposições em que o Fae faz parte.
     *
     * @return lista de exposições do fae
     */
    public List<Exposicao> getListaExposicoesDoFae() {
        return registoExposicoes.getListaExposicoesDoFae(fae);
    }

    /**
     * Obtém a lista de atribuições do fae por avaliar.
     *
     * @param exposicao exposição em causa
     * @return lista de atribuições por avaliar
     */
    public List<Atribuicao> getListaAtribuicoesPorAvaliar(Exposicao exposicao) {
        this.exposicao = exposicao;
        return this.exposicao.getListaAtribuicoesPorAvaliar(fae);
    }

    /**
     * Devolve a candidatura de uma atribuição.
     *
     * @param atribuicao atribuição
     * @return candidatura
     */
    public Candidatura getCandidatura(Atribuicao atribuicao) {
        this.candidatura = atribuicao.getCandidatura();
        return this.candidatura;
    }

    /**
     * Modifica a avaliação.
     *
     * @param atribuicao atribuição
     * @param decisao decisão
     * @param txtDescritivo texto descritivo
     */
    public void setAvaliacao(Atribuicao atribuicao, Avaliacao.TipoAvaliacao decisao, String txtDescritivo) {
        avaliacao = candidatura.novaAvaliacao();
        avaliacao.setAtribuicao(atribuicao);
        avaliacao.setDecisao(decisao);
        avaliacao.setTxtJustificativo(txtDescritivo);
    }

    /**
     * Regista a avaliação.
     *
     * @return true se for registado com sucesso, false caso contrário
     */
    public boolean registaAvaliacao() {

        boolean registarAvaliacao = candidatura.adicionarAvaliacao(avaliacao);

        if (registarAvaliacao) {
            fae.reduzirContCandPorAvaliar();
        }

        return registarAvaliacao;
    }

    /**
     * Remove uma atribuição.
     *
     * @param atribuicao atribuição a ser removida
     * @return true se for removida com sucesso, false caso contrário
     */
    public boolean removerAtribuicao(Atribuicao atribuicao) {
        return exposicao.removerAtribuicao(atribuicao);
    }
}
