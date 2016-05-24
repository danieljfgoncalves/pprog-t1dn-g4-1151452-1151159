/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroexposicoes.ui.components;

import centroexposicoes.controller.RegistarCandidaturaController;
import centroexposicoes.model.Produto;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
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
