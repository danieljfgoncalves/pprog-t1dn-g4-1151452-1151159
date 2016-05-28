/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma lista de organizadores e é responsável por gerir e registar os
 * organizadores de uma exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ListaOrganizadores implements Serializable {

    /**
     * Lista de organizadores.
     */
    private List<Organizador> listaOrganizadores;

    /**
     * Constrói uma instância de lista de Organizadores.
     */
    public ListaOrganizadores() {
        listaOrganizadores = new ArrayList<>();
    }

    /**
     * Constrói uma instância de lista de Organizadores recebendo uma lista de
     * Organizadores.
     *
     * @param listaOrganizadores lista de organizadores
     */
    public ListaOrganizadores(List<Organizador> listaOrganizadores) {
        this.listaOrganizadores = new ArrayList<>(listaOrganizadores);
    }

    /**
     * Constrói uma instância de lista de organizadores copiando uma lista de
     * Organizadores.
     *
     * @param listaOrganizadores lista de organizadores
     */
    public ListaOrganizadores(ListaOrganizadores listaOrganizadores) {
        this.listaOrganizadores = new ArrayList<>(listaOrganizadores.listaOrganizadores);
    }

    /**
     * Devolve a lista de Organizadores.
     *
     * @return lista de organizadores
     */
    public List<Organizador> getListaOrganizadores() {
        return new ArrayList<>(this.listaOrganizadores);
    }

    /**
     * Modifica a lista de Organizadores.
     *
     * @param listaOrganizadores lista de organizadores
     */
    public void setListaOrganizadores(List<Organizador> listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }

    /**
     * Devolve a representação textual de todos os atributos da lista de
     * Organizadores.
     *
     * @return representação textual de todos os atributos da lista de
     * Organizadores
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ListaOrganizadores{ ");
        for (Organizador organizador : listaOrganizadores) {
            s.append(String.format("%s%n", organizador));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compara se outro objeto é igual a esta ListaOrganizadores.
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
        ListaOrganizadores outraListaOrganizadores = (ListaOrganizadores) outroObjeto;

        return listaOrganizadores.equals(outraListaOrganizadores.listaOrganizadores);
    }
}
