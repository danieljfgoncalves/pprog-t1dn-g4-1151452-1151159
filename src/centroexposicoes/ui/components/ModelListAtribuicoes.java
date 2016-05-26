/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Atribuicao;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 * Modelo de comunicação para a lista de exposicoes.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ModelListAtribuicoes extends AbstractListModel {

    private final List<Atribuicao> listaAtribuicoes;

    public ModelListAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    @Override
    public int getSize() {
        return this.listaAtribuicoes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return String.format("%s - %s", this.listaAtribuicoes.get(index).getCandidatura().getNomeEmpresa(),
                this.listaAtribuicoes.get(index).getCandidatura().getTelemovel());
    }

}
