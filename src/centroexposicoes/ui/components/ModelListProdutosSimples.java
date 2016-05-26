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

    private final List<Produto> listaProdutos;

    public ModelListProdutosSimples(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public int getSize() {
        return this.listaProdutos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listaProdutos.get(index).getDesignacao();
    }

}
