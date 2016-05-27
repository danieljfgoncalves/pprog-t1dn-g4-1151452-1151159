/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.MecanismoAtribuicao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de mecanismos.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListMecanismos extends AbstractListModel {

    private List<MecanismoAtribuicao> listaMecanismos;
    
    public ModelListMecanismos(List<MecanismoAtribuicao> listaMecanismos) {
        
        this.listaMecanismos = listaMecanismos;
    }

    @Override
    public int getSize() {
        return this.listaMecanismos.size();
    }

    @Override
    public Object getElementAt(int index) {
        
        return this.listaMecanismos.get(index).getDescricao();
    }
    
}