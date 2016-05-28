/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;

/**
 * Representa um organizador.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Organizador implements Ator, Serializable {

    /**
     * Dados de utilizador do organizador.
     */
    private Utilizador utilizador;

    /**
     * Dados de utilizador do organizador por omissão.
     */
    private static final Utilizador UTILIZADOR_POR_OMISSAO = new Utilizador();

    /**
     * Constroi uma instância de organizador com os valores por omissão.
     */
    public Organizador() {
        this.utilizador = UTILIZADOR_POR_OMISSAO;
    }

    /**
     * Constroi uma instância de organizador com os valores por recebidos por
     * paramêtros.
     *
     * @param utilizador dados de utilizador do organizador
     */
    public Organizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Constroi uma instância de organizador com os valores copiados de outro
     * organizador.
     *
     * @param outroOrganizador outro organizador que pretende copiar
     */
    public Organizador(Organizador outroOrganizador) {
        this.utilizador = outroOrganizador.utilizador;
    }

    /**
     * Devolve o objeto utilizador do organizador.
     *
     * @return o objeto utilizador do organizador
     */
    public Utilizador getUtilizador() {
        return utilizador;
    }

    /**
     * Modifica o objeto utilizador do organizador.
     *
     * @param utilizador o objeto utilizador do organizador
     */
    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve a descrição textual de todos os atributos de um organizador.
     *
     * @return caraterísticas da candidatura
     */
    @Override
    public String toString() {
        return "Organizador{" + "utilizador=" + utilizador + '}';
    }

    /**
     * Compara se outro objeto é igual a este organzidor.
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
        Organizador outroOrganizador = (Organizador) outroObjeto;

        return this.utilizador.equals(outroOrganizador.utilizador);
    }

    /**
     * Obtém o nome do organizador.
     *
     * @return nomde do organizador
     */
    @Override
    public String getNome() {

        return this.utilizador.getNome();
    }
}
