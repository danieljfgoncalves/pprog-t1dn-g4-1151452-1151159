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
public class ModeloTabelaListaExposicao extends AbstractTableModel {

    /**
     * Nome das colunas da tabela.
     */
    private static final String[] nomesColunas = {"Título", "Data Inicial", "Data Final"};
    /**
     * lista de exposições.
     */
    private final List<Exposicao> listaExposicoes;

    /**
     * Cria uma instância de ModeloTabelaListaExposicao.
     *
     * @param listaExposicoes lista de exposições
     */
    public ModeloTabelaListaExposicao(List<Exposicao> listaExposicoes) {
        this.listaExposicoes = listaExposicoes;
    }

    /**
     * Devolve o número de linhas da tabela.
     *
     * @return número de linhas
     */
    @Override
    public int getRowCount() {
        return listaExposicoes.size();
    }

    /**
     * Devolve o número de colunas da tabela.
     *
     * @return número de colunas da tabela
     */
    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    /**
     * Devolve o nome da coluna a partir do seu índice.
     *
     * @param column índica da coluna
     * @return nome da coluna
     */
    @Override
    public String getColumnName(int column) {
        return nomesColunas[column];
    }

    /**
     * Devolve a descrição do elemento especificado.
     *
     * @param rowIndex índice da linha
     * @param columnIndex índice da coluna
     * @return descrição do elemento
     */
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
