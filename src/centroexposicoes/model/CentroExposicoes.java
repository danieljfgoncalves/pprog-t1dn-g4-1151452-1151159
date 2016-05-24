/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;

/**
 * Representa um centro de exposições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class CentroExposicoes implements Serializable {

    /**
     * Exposições do centro de exposições.
     */
    private RegistoExposicoes registoExposicoes;
    /**
     * Mecanismos do centro de exposições.
     */
    private RegistoMecanismos registoMecanismos;

    /**
     * Constrói uma instância de centro de exposições com os valores por
     * oimissão.
     */
    public CentroExposicoes() {
        registoExposicoes = new RegistoExposicoes();
        registoMecanismos = new RegistoMecanismos();
    }

    /**
     * Constrói uma instância de centro de exposições recebendo o registo de
     * exposições e o registo de mecanismos.
     *
     * @param registoExposicoes registo de exposições
     * @param registoMecanismos registo de mecanismos
     */
    public CentroExposicoes(RegistoExposicoes registoExposicoes, RegistoMecanismos registoMecanismos) {
        this.registoExposicoes = new RegistoExposicoes(registoExposicoes);
        this.registoMecanismos = new RegistoMecanismos(registoMecanismos);
    }

    /**
     * Constrói uma instância de centro de exposições copiando outro centro de
     * exposições.
     *
     * @param centroExposicoes centro de exposições
     */
    public CentroExposicoes(CentroExposicoes centroExposicoes) {
        registoExposicoes = new RegistoExposicoes(centroExposicoes.registoExposicoes);
        registoMecanismos = new RegistoMecanismos(centroExposicoes.registoMecanismos);
    }

    /**
     * Devolve o registo de exposições.
     *
     * @return Registo de exposições.
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return new RegistoExposicoes(registoExposicoes);
    }

    /**
     * Modifica o registo de exposições.
     *
     * @param registoExposicoes registo de exposições
     */
    public void setRegistoExposicoes(RegistoExposicoes registoExposicoes) {
        this.registoExposicoes = new RegistoExposicoes(registoExposicoes);
    }

    /**
     * Devolve o registo de mecanismos.
     *
     * @return registo de mecanismos
     */
    public RegistoMecanismos getRegistoMecanismos() {
        return new RegistoMecanismos(registoMecanismos);
    }

    /**
     * Modifica o registo de mecanismos.
     *
     * @param registoMecanismos registo de mecanismos
     */
    public void setRegistoMecanismos(RegistoMecanismos registoMecanismos) {
        this.registoMecanismos = new RegistoMecanismos(registoMecanismos);
    }

    /**
     * Gera uma representação textual do centro de exposições.
     *
     * @return representação textual do centro de exposições.
     */
    @Override
    public String toString() {
        return String.format("CentroExposicoes{registoExposicoes=%s, registoMecanismos=%s}", registoExposicoes, registoMecanismos);
    }

    /**
     * Compara se outro objeto é igual a este centro de exposições.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais, false caso contrário.
     */
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        CentroExposicoes outroCentroExposicoes = (CentroExposicoes) outroObjeto;

        return registoExposicoes.equals(outroCentroExposicoes.registoExposicoes) && registoMecanismos.equals(outroCentroExposicoes.registoMecanismos);
    }

}
