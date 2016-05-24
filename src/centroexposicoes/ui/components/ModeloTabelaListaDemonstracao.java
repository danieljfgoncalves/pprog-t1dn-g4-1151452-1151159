/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Demonstracao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de comunicação para a lista de demonstrações.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModeloTabelaListaDemonstracao extends AbstractTableModel
{
    private static String[] nomesColunas = {"Código Único", "Designação"};
    private List<Demonstracao> listaDemonstracoes;

    public ModeloTabelaListaDemonstracao(List<Demonstracao> listaDemonstracoes)
    {
        this.listaDemonstracoes = listaDemonstracoes;
    }
    
    @Override
    public int getRowCount() {
        return listaDemonstracoes.size();
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
        String nomeColuna = getColumnName(columnIndex);
        return nomeColuna.equalsIgnoreCase(nomesColunas[0])
                ? listaDemonstracoes.get(rowIndex).getCodigoUnico()
                : listaDemonstracoes.get(rowIndex).getDesignacao();
    }
    
}
