/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma lista de atribuições e é responsável por gerir e registar os
 * atribuições de uma exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ListaAtribuicoes implements Serializable {

    /**
     * Lista de atribuições.
     */
    private List<Atribuicao> listaAtribuicoes;

    /**
     * Constrói uma instância de lista de Atribuições.
     */
    public ListaAtribuicoes() {
        listaAtribuicoes = new ArrayList<>();
    }

    /**
     * Constrói uma instância de lista de Atribuições recebendo uma lista de
     * Atribuições.
     *
     * @param listaAtribuicoes lista de Atribuições.
     */
    public ListaAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.listaAtribuicoes = new ArrayList<>(listaAtribuicoes);
    }

    /**
     * Constrói uma instância de lista de Atribuições copiando uma lista de
     * Atribuições.
     *
     * @param listaAtribuicoes lista de Atribuições.
     */
    public ListaAtribuicoes(ListaAtribuicoes listaAtribuicoes) {
        this.listaAtribuicoes = new ArrayList<>(listaAtribuicoes.listaAtribuicoes);
    }

    /**
     * Devolve a lista de Atribuições.
     *
     * @return lista de Atribuições.
     */
    public List<Atribuicao> getListaAtribuicoes() {
        return new ArrayList<>(this.listaAtribuicoes);
    }

    /**
     * Modifica a lista de Atribuições.
     *
     * @param listaAtribuicoes lista de Atribuições.
     */
    public void setListaAtribuicoes(List<Atribuicao> listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * Cria uma nova atribuição.
     *
     * @param candidatura candidatura a ser avaliada.
     * @param fae FAE a avaliar
     * @return atribuição criada
     */
    public Atribuicao novaAtribuicao(Candidatura candidatura, Fae fae) {

        return new Atribuicao(candidatura, fae);
    }

    /**
     * Verifica se uma atribuicao é válida.
     *
     * @param atribuicao atribuição a ser verificada
     * @return true se for válida, false caso contrário
     */
    public boolean validarAtribuicoes(Atribuicao atribuicao) {

        return (!this.listaAtribuicoes.contains(atribuicao));
    }

    /**
     * Remove uma atribuição da lista.
     *
     * @param atribuicao atribuição a ser removida
     * @return true se for removido com sucesso
     */
    public boolean removerAtribuicao(Atribuicao atribuicao) {
        return listaAtribuicoes.remove(atribuicao);
    }

    /**
     * Devolve a representação textual de todos os atributos da lista de
     * Atribuições.
     *
     * @return representação textual de todos os atributos da lista de
     * Atribuições.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ListaAtribuicoes{ ");
        for (Atribuicao atribuicao : listaAtribuicoes) {
            s.append(String.format("%s%n", atribuicao));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compara se outro objeto é igual a esta ListaAtribuicoes.
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
        ListaAtribuicoes outraListaAtribuicoes = (ListaAtribuicoes) outroObjeto;

        return listaAtribuicoes.equals(outraListaAtribuicoes.listaAtribuicoes);
    }
}
