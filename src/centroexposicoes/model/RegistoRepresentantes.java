/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por armazenar e gerir representantes de expositor.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistoRepresentantes implements Serializable {

    /**
     * Lista das representantes.
     */
    private List<Representante> listaRepresentantes;

    /**
     * Constrói uma instância de registo de representantes.
     */
    public RegistoRepresentantes() {
        listaRepresentantes = new ArrayList<>();
    }

    /**
     * Constrói uma instância de registo de representantes recebendo a lista de
     * representantes.
     *
     * @param listaRepresentantes lista de representantes
     */
    public RegistoRepresentantes(List<Representante> listaRepresentantes) {
        this.listaRepresentantes = new ArrayList<>(listaRepresentantes);
    }

    /**
     * Constrói uma instância de registo de representantes copiando outro
     * registo de representantes.
     *
     * @param registoRepresentantes registo de representantes a ser copiado
     */
    public RegistoRepresentantes(RegistoRepresentantes registoRepresentantes) {
        this.listaRepresentantes = new ArrayList<>(registoRepresentantes.listaRepresentantes);
    }

    /**
     * Devolve a lista de representantes.
     *
     * @return lista de representantes
     */
    public List<Representante> getListaRepresentantes() {
        return listaRepresentantes;
    }

    /**
     * Modifica a lista de representantes
     *
     * @param listaRepresentantes lista de representantes
     */
    public void setListaRepresentantes(List<Representante> listaRepresentantes) {
        this.listaRepresentantes = listaRepresentantes;
    }

    /**
     * Devolve a representação textual de todos os atributos do registo de
     * representantes.
     *
     * @return representação textual de todos os atributos do registo de
     * representantes
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("RegistoRepresentantes{");
        for (Representante rep : listaRepresentantes) {
            s.append(String.format("%s%n", rep));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compara se outro objeto é igual a este RegistoRepresentantes.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        RegistoRepresentantes outroRegistoRepresentantes = (RegistoRepresentantes) outroObjeto;

        return listaRepresentantes.equals(outroRegistoRepresentantes.listaRepresentantes);
    }
}
