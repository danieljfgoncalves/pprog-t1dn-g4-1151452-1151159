/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.MecanismoAtribuicao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de mecanismos.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListMecanismos extends AbstractListModel {

    /**
     * Lista de mecanismos.
     */
    private List<MecanismoAtribuicao> listaMecanismos;

    /**
     * Constrói uma instância de ModelListMecanismos.
     *
     * @param listaMecanismos lista de mecanismos
     */
    public ModelListMecanismos(List<MecanismoAtribuicao> listaMecanismos) {

        this.listaMecanismos = listaMecanismos;
    }

    /**
     * Obtém o número de elementos da lista.
     *
     * @return número de elementos
     */
    @Override
    public int getSize() {
        return this.listaMecanismos.size();
    }

    /**
     * Obtém o elemento da lista no índice indicado.
     *
     * @param index índice da lista
     * @return elemento da lista.
     */
    @Override
    public Object getElementAt(int index) {

        return this.listaMecanismos.get(index).getDescricao();
    }

}
