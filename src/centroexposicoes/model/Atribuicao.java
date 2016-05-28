/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;

/**
 * Representa uma atribuição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Atribuicao implements Serializable {

    /**
     * Candidatura atribuida.
     */
    private Candidatura candidatura;

    /**
     * FAE atribuido.
     */
    private Fae fae;

    /**
     * Candidatura atribuida por omissão.
     */
    private static final Candidatura CANDIDATURA_POR_OMISSAO = new Candidatura();

    /**
     * FAE atribuido por omissão.
     */
    private static final Fae FAE_POR_OMISSAO = new Fae();

    /**
     * Constroi uma instância de atribuição com os valores por omissão.
     */
    public Atribuicao() {
        this.candidatura = CANDIDATURA_POR_OMISSAO;
        this.fae = FAE_POR_OMISSAO;
    }

    /**
     * Constroi uma instância de atribuição com os valores recebidos por
     * paramêtros.
     *
     * @param candidatura candidatura atribuida
     * @param fae fae atribuido
     */
    public Atribuicao(Candidatura candidatura, Fae fae) {
        this.candidatura = candidatura;
        this.fae = fae;
    }

    /**
     * Constroi uma instância de atribuição com os valores copiados por outra
     * atribuição.
     *
     * @param outraAtribuicao atribuição que pretende copiar
     */
    public Atribuicao(Atribuicao outraAtribuicao) {
        this.candidatura = outraAtribuicao.candidatura;
        this.fae = outraAtribuicao.fae;
    }

    /**
     * Devolve a candidatura atribuida.
     *
     * @return a candidatura atribuida
     */
    public Candidatura getCandidatura() {
        return candidatura;
    }

    /**
     * Modifica a candidatura atribuida.
     *
     * @param candidatura candidatura atribuida
     */
    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    /**
     * Devolve o fae atribuido.
     *
     * @return o fae atribuido
     */
    public Fae getFae() {
        return fae;
    }

    /**
     * Modifica o fae atribuido.
     *
     * @param fae fae atribuido
     */
    public void setFae(Fae fae) {
        this.fae = fae;
    }

    /**
     * Devolve a descrição textual de todos os atributos de um representante.
     *
     * @return caraterísticas da candidatura
     */
    @Override
    public String toString() {

        return "Atribuicao{" + "candidatura=" + candidatura
                + ", fae=" + fae
                + '}';
    }

    /**
     * Compara se outro objeto é igual a esta atribuição.
     *
     * @param outroObjeto objeto a comparar
     *
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
        Atribuicao outraAtribuicao = (Atribuicao) outroObjeto;

        return this.candidatura.equals(outraAtribuicao.candidatura)
                && this.fae.equals(outraAtribuicao.fae);
    }
}
