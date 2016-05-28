/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Produto;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de produtos.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListProdutosSimples extends AbstractListModel {

    /**
     * Lista de produtos.
     */
    private final List<Produto> listaProdutos;

    /**
     * Criar uma instância de ModelListProdutosSimples.
     *
     * @param listaProdutos lista de produtos
     */
    public ModelListProdutosSimples(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    /**
     * Obtém o número de elementos da lista.
     *
     * @return número de elementos
     */
    @Override
    public int getSize() {
        return this.listaProdutos.size();
    }

    /**
     * Obtém o elemento da lista no índice indicado.
     *
     * @param index índice da lista
     * @return elemento da lista.
     */
    @Override
    public Object getElementAt(int index) {
        return this.listaProdutos.get(index).getDesignacao();
    }

}
