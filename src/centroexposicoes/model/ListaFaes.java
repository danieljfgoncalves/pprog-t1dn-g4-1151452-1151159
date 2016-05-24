/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por armazenar e gerir os funcionários de apoio à exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ListaFaes implements Serializable {

    /**
     * Lista de funcionários de apoio à exposição (FAE).
     */
    private List<Fae> listaFaes;

    /**
     * Constrói uma instância de lista de faes.
     */
    public ListaFaes() {
        listaFaes = new ArrayList<>();
    }

    /**
     * Constrói uma instância de lista de faes recebendo uma lista de faes.
     *
     * @param listaFaes lista de faes
     */
    public ListaFaes(List<Fae> listaFaes) {
        this.listaFaes = new ArrayList<>(listaFaes);
    }

    /**
     * Constrói uma instância de lista de faes copiando uma lista de faes.
     *
     * @param listaFaes lista de faes
     */
    public ListaFaes(ListaFaes listaFaes) {
        this.listaFaes = new ArrayList<>(listaFaes.listaFaes);
    }

    /**
     * Devolve a lista de faes.
     *
     * @return lista de faes
     */
    public List<Fae> getListaFaes() {
        return listaFaes;
    }

    /**
     * Modifica a lista de faes.
     *
     * @param listaFaes lista de faes
     */
    public void setListaFaes(List<Fae> listaFaes) {
        this.listaFaes = listaFaes;
    }

    /**
     * Devolve a representação textual de todos os atributos da lista de faes.
     *
     * @return representação textual de todos os atributos da lista de faes
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ListaFaes{");
        for (Fae fae : listaFaes) {
            s.append(String.format("%s%n", fae));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compara se outro objeto é igual a esta ListaFaes.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais. False caso contrário
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        ListaFaes outraListaFaes = (ListaFaes) outroObjeto;

        return listaFaes.equals(outraListaFaes.listaFaes);
    }
}
