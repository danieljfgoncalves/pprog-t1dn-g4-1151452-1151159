/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Exposicao;

/**
 * Interface para UIs com exposições selecionáveis.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public interface ExposicaoSelecionavel {
    /**
     * Modifica a exposição selecionada.
     * 
     * @param exposicao exposição selecionada.
     */
    public void setExposicao(Exposicao exposicao);
}
