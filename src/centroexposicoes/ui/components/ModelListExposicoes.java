/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Exposicao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de exposicoes.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListExposicoes extends AbstractListModel {

    private List<Exposicao> listaExposicoes;

    public ModelListExposicoes(List<Exposicao> listaExposicoes) {
        this.listaExposicoes = listaExposicoes;
    }

    @Override
    public int getSize() {
        return this.listaExposicoes.size();
    }

    @Override
    public Object getElementAt(int index) {      
        return this.listaExposicoes.get(index).getTitulo();
    }

}
