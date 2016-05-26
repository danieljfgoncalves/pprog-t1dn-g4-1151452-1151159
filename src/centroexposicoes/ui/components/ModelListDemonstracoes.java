/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Demonstracao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de demonstrações.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListDemonstracoes extends AbstractListModel {

    private final List<Demonstracao> listaDemonstracoes;

    public ModelListDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        this.listaDemonstracoes = listaDemonstracoes;
    }

    @Override
    public int getSize() {
        return this.listaDemonstracoes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listaDemonstracoes.get(index).getDesignacao();
    }

}
