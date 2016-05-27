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

    private final RegistoExposicoes registoExposicoes;
    private Fae fae;
    Exposicao exposicao;
    Candidatura candidatura;
    Avaliacao avaliacao;

    public AvaliarCandidaturasController(CentroExposicoes centroExposicoes, Fae fae) {
        registoExposicoes = centroExposicoes.getRegistoExposicoes();
        this.fae = fae;
    }

    public List<Exposicao> getListaExposicoesDoFae() {
        return registoExposicoes.getListaExposicoesDoFae(fae);
    }

    public List<Atribuicao> getListaAtribuicoesPorAvaliar(Exposicao exposicao) {
        this.exposicao = exposicao;
        return this.exposicao.getListaAtribuicoesPorAvaliar(fae);
    }

    public Candidatura getCandidatura(Atribuicao atribuicao) {
        this.candidatura = atribuicao.getCandidatura();
        return this.candidatura;
    }

    public void setAvaliacao(Atribuicao atribuicao, Avaliacao.TipoAvaliacao decisao, String txtDescritivo) {
        avaliacao = candidatura.novaAvaliacao();
        avaliacao.setAtribuicao(atribuicao);
        avaliacao.setDecisao(decisao);
        avaliacao.setTxtJustificativo(txtDescritivo);
    }

    public boolean registaAvaliacao() {
        
        boolean registarAvaliacao = candidatura.adicionarAvaliacao(avaliacao); 
        
        if (registarAvaliacao) {
            fae.reduzirContCandPorAvaliar();
        }
        
        return registarAvaliacao;
    }
}
