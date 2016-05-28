/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.controller.RegistarCandidaturaController;
import centroexposicoes.model.Produto;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de produtos.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModeloListProdutos extends AbstractListModel {

    /**
     * Controlador de registar candidatura.
     */
    private final RegistarCandidaturaController controller;
    /**
     * Lista de produtos.
     */
    private List<Produto> listaProdutos;

    /**
     * Constrói uma instância de modelo lista produtos.
     *
     * @param controller controlador de registar candidatura
     */
    public ModeloListProdutos(RegistarCandidaturaController controller) {

        this.controller = controller;
        this.listaProdutos = controller.getListaProdutos();
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

    /**
     * Adiciona um produto à lista.
     *
     * @param designacao designação do produto.
     * @return true se for adicionado com sucesso, false caso contrário.
     */
    public boolean addRow(String designacao) {
        int rowCount = getSize();

        boolean produtoAdicionado = this.controller.addProduto(designacao);

        if (produtoAdicionado) {
            this.listaProdutos = this.controller.getListaProdutos();
            fireIntervalAdded(this, rowCount, rowCount);
        }
        return produtoAdicionado;
    }

    /**
     * Remove o produto no índice indicado.
     *
     * @param index índice a remover
     * @return true se for removido com sucesso, false caso contrário
     */
    public boolean removeRow(int index) {

        String designacao = (String) getElementAt(index);

        boolean produtoRemovido = this.controller.removeProduto(designacao);
        if (produtoRemovido) {
            this.listaProdutos = this.controller.getListaProdutos();
            fireIntervalRemoved(this, index, index);
        }
        return produtoRemovido;
    }
}
