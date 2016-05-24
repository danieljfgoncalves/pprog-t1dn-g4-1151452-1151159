/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;

/**
 * Representa um funcionário de apoio à exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Fae implements Serializable {

    /**
     * Os dados do fae.
     */
    private Utilizador utilizadorFae;

    /**
     * Constrói uma instância de funcionário de apoio à exposição com os valores
     * por omissão.
     */
    public Fae() {
        utilizadorFae = new Utilizador();
    }

    /**
     * Constrói uma instância de funcionário de apoio à exposição recebendo o
     * utilizador.
     *
     * @param utilizador utilizador a ser definido
     */
    public Fae(Utilizador utilizador) {
        utilizadorFae = utilizador;
    }

    /**
     * Constrói uma instância de funcionário de apoio à exposição copiando outro
     * FAE.
     *
     * @param fae outro Fae a ser copiado
     */
    public Fae(Fae fae) {
        utilizadorFae = new Utilizador(fae.utilizadorFae);
    }

    /**
     * Devolve o utilizador fae.
     *
     * @return utilizador fae
     */
    public Utilizador getUtilizadorFae() {
        return utilizadorFae;
    }

    /**
     * Modifica o utilizador fae.
     *
     * @param utilizadorFae utilizador fae
     */
    public void setUtilizadorFae(Utilizador utilizadorFae) {
        this.utilizadorFae = utilizadorFae;
    }

    /**
     * Gera uma representação textual do utilizador.
     *
     * @return representação textual do utilizador.
     */
    @Override
    public String toString() {
        return String.format("Fae{utilizadorFae:%s}", utilizadorFae);
    }

    /**
     * Compara se outro objeto é igual a este utilizador.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Fae outroFae = (Fae) outroObjeto;

        return utilizadorFae.equals(outroFae.utilizadorFae);
    }
}
