/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Exposicao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de comunicação para a lista de exposições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModeloTabelaListaExposicao extends AbstractTableModel
{
    private static String[] nomesColunas = {"Título", "Data Inicial", "Data Final"};
    private List<Exposicao> listaExposicoes;

    public ModeloTabelaListaExposicao(List<Exposicao> listaExposicoes)
    {
        this.listaExposicoes = listaExposicoes;
    }
    
    @Override
    public int getRowCount() {
        return listaExposicoes.size();
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
                ? listaExposicoes.get(rowIndex).getTitulo()
                : nomeColuna.equalsIgnoreCase(nomesColunas[1])
                ? listaExposicoes.get(rowIndex).getDataInicio().toAnoMesDiaString()
                : listaExposicoes.get(rowIndex).getDataFim().toAnoMesDiaString();
    }
    
}
