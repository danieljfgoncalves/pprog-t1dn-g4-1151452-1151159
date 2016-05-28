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

    /**
     * Nome das colunas da tabela.
     */
    private static final String[] nomesColunas = {"Nome de Empresa", "FAE"};
    /**
     * Lista de atribuições
     */
    private final List<Atribuicao> listaAtribuicoes;

    /**
     * Cria uma instâncida de ModeloTabelaAtribuicoes.
     *
     * @param listaAtribuicoes lista de atribuições
     */
    public ModeloTabelaAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * Devolve o número de linhas da tabela.
     *
     * @return número de linhas
     */
    @Override
    public int getRowCount() {
        return listaAtribuicoes.size();
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

        return columnIndex == 0 ? listaAtribuicoes.get(rowIndex).getCandidatura().getNomeEmpresa()
                : listaAtribuicoes.get(rowIndex).getFae().getNome();
    }

}
