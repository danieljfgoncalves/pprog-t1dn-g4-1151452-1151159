/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Atribuicao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de comunicação para a lista de atribuições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModeloTabelaAtribuicoes extends AbstractTableModel {

    private static final String[] nomesColunas = {"Nome de Empresa", "FAE"};
    private List<Atribuicao> listaAtribuicoes;

    public ModeloTabelaAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    @Override
    public int getRowCount() {
        return listaAtribuicoes.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return columnIndex == 0 ? listaAtribuicoes.get(rowIndex).getCandidatura().getNomeEmpresa()
                : listaAtribuicoes.get(rowIndex).getFae().getNome();
    }

}
