/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Atribuicao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de exposicoes.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListAtribuicoes extends AbstractListModel {

    /**
     * Lista de atribuições.
     */
    private final List<Atribuicao> listaAtribuicoes;

    /**
     * Cria uma instância de ModelListAtribuicoes.
     *
     * @param listaAtribuicoes lista de atribuições
     */
    public ModelListAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * Obtém o número de elementos da lista.
     *
     * @return número de elementos
     */
    @Override
    public int getSize() {
        return this.listaAtribuicoes.size();
    }

    /**
     * Obtém o elemento da lista no índice indicado.
     *
     * @param index índice da lista
     * @return elemento da lista.
     */
    @Override
    public Object getElementAt(int index) {
        return String.format("%s - %s", this.listaAtribuicoes.get(index).getCandidatura().getNomeEmpresa(),
                this.listaAtribuicoes.get(index).getCandidatura().getTelemovel());
    }

}
