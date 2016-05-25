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

    private RegistarCandidaturaController controller;
    private List<Produto> listaProdutos;

    public ModeloListProdutos(RegistarCandidaturaController controller) {

        this.controller = controller;
        this.listaProdutos = controller.getListaProdutos();
    }

    @Override
    public int getSize() {

        return this.listaProdutos.size();
    }

    @Override
    public Object getElementAt(int index) {

        return this.listaProdutos.get(index).getDesignacao();
    }

    public boolean addRow(String designacao) {
        int rowCount = getSize();
        
        boolean produtoAdicionado = this.controller.addProduto(designacao);
        this.listaProdutos = controller.getListaProdutos();
        
        if (produtoAdicionado) {
            fireIntervalAdded(this, rowCount, rowCount);
        }
        return produtoAdicionado;
    }

//    public boolean removeRow(int index) {
//        
//        
//        boolean produtoRemovido = listaTelefonica.removerTelefone(telefone);
//        if (telefoneRemovido) {
//            fireTableRowsDeleted(row, row);
//        }
//        return telefoneRemovido;
//    }
}
