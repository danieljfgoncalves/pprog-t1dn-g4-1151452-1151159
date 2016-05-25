/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Ator;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de atores.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * 
 * @param <T> Class que implementa Ator (ex. FAE, Organizador, etc.).
 */
public class ModelListAtor<T extends Ator> extends AbstractListModel {

    private List<T> listaAtores;
    
    public ModelListAtor(List<T> listaAtores) {
        
        this.listaAtores = listaAtores;
    }

    @Override
    public int getSize() {
        return this.listaAtores.size();
    }

    @Override
    public Object getElementAt(int index) {
        
        return this.listaAtores.get(index).getNome();
    }
    
}
