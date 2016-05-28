/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Exposicao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de exposicoes.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListExposicoes extends AbstractListModel {

    /**
     * Lista de exposições.
     */
    private final List<Exposicao> listaExposicoes;

    /**
     * Cria uma instância de ModelListExposicoes.
     *
     * @param listaExposicoes lista de exposições
     */
    public ModelListExposicoes(List<Exposicao> listaExposicoes) {
        this.listaExposicoes = listaExposicoes;
    }

    /**
     * Obtém o número de elementos da lista.
     *
     * @return número de elementos
     */
    @Override
    public int getSize() {
        return this.listaExposicoes.size();
    }

    /**
     * Obtém o elemento da lista no índice indicado.
     *
     * @param index índice da lista
     * @return elemento da lista.
     */
    @Override
    public Object getElementAt(int index) {
        return String.format("%s (%s)", this.listaExposicoes.get(index).getTitulo(), this.listaExposicoes.get(index).getDataInicio());
    }

}
