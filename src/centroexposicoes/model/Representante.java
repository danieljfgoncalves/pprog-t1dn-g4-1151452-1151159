/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;

/**
 * Representa um representante de expositor.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Representante implements Ator, Serializable {


    /**
     * Dados de utilizador do representante.
     */
    private Utilizador utilizador;

    /**
     * Dados de utilizador do representante por omissão.
     */
    private static final Utilizador UTILIZADOR_POR_OMISSAO = new Utilizador();

    /**
     * Constroi uma instância de representante com os valores por omissão.
     */
    public Representante() {
        this.utilizador = UTILIZADOR_POR_OMISSAO;
    }

    /**
     * Constroi uma instância de representante com os valores por recebidos por
     * paramêtros.
     *
     * @param utilizador dados de utilizador do representante.
     */
    public Representante(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Constroi uma instância de representante com os valores copiados de outro
     * representante.
     *
     * @param outroRepresentante outro representante que pretende copiar.
     */
    public Representante(Representante outroRepresentante) {
        this.utilizador = outroRepresentante.utilizador;
    }

    /**
     * Devolve o objeto utilizador do representante.
     *
     * @return o objeto utilizador do representante.
     */
    public Utilizador getUtilizador() {
        return utilizador;
    }

    /**
     * Modifica o objeto utilizador do representante.
     *
     * @param utilizador o objeto utilizador do representante.
     */
    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * Devolve a descrição textual de todos os atributos de um representante.
     *
     * @return caraterísticas da candidatura.
     */
    @Override
    public String toString() {
        return "Representante{" + "utilizador=" + utilizador + '}';
    }

    /**
     * Compara se outro objeto é igual a este organzidor.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais. False caso contrário.
     */
    @Override
    public boolean equals(Object outroObjeto) {

        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Representante outroRepresentante = (Representante) outroObjeto;

        return this.utilizador.equals(outroRepresentante.utilizador);
    }

    @Override
    public String getNome() {
        
        return this.utilizador.getNome();
    }
}
