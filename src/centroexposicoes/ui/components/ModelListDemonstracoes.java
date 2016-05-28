/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Demonstracao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de demonstrações.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListDemonstracoes extends AbstractListModel {

    /**
     * lista de demonstrações.
     */
    private final List<Demonstracao> listaDemonstracoes;

    /**
     * Cria uma instância de ModelListDemonstracoes.
     *
     * @param listaDemonstracoes lista de demontrações
     */
    public ModelListDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        this.listaDemonstracoes = listaDemonstracoes;
    }

    /**
     * Obtém o número de elementos da lista.
     *
     * @return número de elementos
     */
    @Override
    public int getSize() {
        return this.listaDemonstracoes.size();
    }

    /**
     * Obtém o elemento da lista no índice indicado.
     *
     * @param index índice da lista
     * @return elemento da lista.
     */
    @Override
    public Object getElementAt(int index) {
        return this.listaDemonstracoes.get(index).getDesignacao();
    }

}
