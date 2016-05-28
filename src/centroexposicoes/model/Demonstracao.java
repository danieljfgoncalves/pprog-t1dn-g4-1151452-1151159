/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;

/**
 * Representa uma demonstração.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Demonstracao implements Serializable {

    /**
     * Código único para a demonstração.
     */
    private final String codigoUnico;
    /**
     * Designação da demonstração.
     */
    private String designacao;

    /**
     * Número de instâncias de demonstrações criadas.
     */
    private static int contagemDemonstracao = 0;

    /**
     * Texto da demonstração por omissão.
     */
    private static final String TEXTO_CODIGO_UNICO = "DEMO-";

    /**
     * Designação da demonstração por omissão.
     */
    private static final String DESIGNACAO_POR_OMISSÃO = "Sem designação";

    /**
     * Constrói uma instância de demonstração com os valores por omissão.
     */
    public Demonstracao() {
        codigoUnico = TEXTO_CODIGO_UNICO + ++contagemDemonstracao;
        designacao = DESIGNACAO_POR_OMISSÃO;
    }

    /**
     * Constrói uma instância de demonstração recebendo a designação.
     *
     * @param designacao designacao
     */
    public Demonstracao(String designacao) {
        codigoUnico = TEXTO_CODIGO_UNICO + ++contagemDemonstracao;
        this.designacao = designacao;
    }

    /**
     * Constrói uma instância de demonstração copiando outra demonstração.
     *
     * @param demonstracao
     */
    public Demonstracao(Demonstracao demonstracao) {
        this.codigoUnico = demonstracao.codigoUnico;
        this.designacao = demonstracao.designacao;
    }

    /**
     * Devolve o código único.
     *
     * @return código único
     */
    public String getCodigoUnico() {
        return codigoUnico;
    }

    /**
     * Devolve a designação.
     *
     * @return designação
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Modifica a designação.
     *
     * @param designacao designação
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Devolve a descrição textual de todos os atributos da demonstração.
     *
     * @return caraterísticas da demonstração
     */
    @Override
    public String toString() {
        return String.format("Demonstracao{codigoUnico=%s, designacao=%s}", codigoUnico, designacao);
    }

    /**
     * Compara se outro objeto é igual a esta demonstração.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || !(outroObjeto instanceof Produto)) {
            return false;
        }

        final Demonstracao outraDemonstracao = (Demonstracao) outroObjeto;

        return codigoUnico.equals(outraDemonstracao.codigoUnico) && designacao.equals(outraDemonstracao.designacao);
    }
}
