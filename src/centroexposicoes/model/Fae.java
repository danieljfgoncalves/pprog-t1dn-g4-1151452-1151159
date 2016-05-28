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
public class Fae implements Ator, Serializable {

    /**
     * Os dados do fae.
     */
    private Utilizador utilizadorFae;

    /**
     * Contador de candidaturas por avaliar.
     */
    private int contCandPorAvaliar;

    /**
     * Contador de candidaturas avaliadas.
     */
    private int contCandAvaliadas;

    /**
     * Contador de candidaturas por avaliar por omissão.
     */
    private static final int CONT_POR_AVALIAR_POR_OMISSAO = 0;

    /**
     * Contador de candidaturas avaliadas por omissão.
     */
    private static final int CONT_AVALIADAS_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de funcionário de apoio à exposição com os valores
     * por omissão.
     */
    public Fae() {
        utilizadorFae = new Utilizador();
        contCandPorAvaliar = CONT_POR_AVALIAR_POR_OMISSAO;
        contCandAvaliadas = CONT_AVALIADAS_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de funcionário de apoio à exposição recebendo o
     * utilizador.
     *
     * @param utilizador utilizador a ser definido
     */
    public Fae(Utilizador utilizador) {
        utilizadorFae = utilizador;
        contCandPorAvaliar = CONT_POR_AVALIAR_POR_OMISSAO;
        contCandAvaliadas = CONT_AVALIADAS_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de funcionário de apoio à exposição copiando outro
     * FAE.
     *
     * @param fae outro Fae a ser copiado
     */
    public Fae(Fae fae) {
        utilizadorFae = new Utilizador(fae.utilizadorFae);
        contCandPorAvaliar = fae.contCandAvaliadas;
        contCandAvaliadas = fae.contCandPorAvaliar;
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
     * Devolve o contador de candidaturas por avaliar.
     *
     * @return o contador de candidaturas por avaliar
     */
    public int getContCandPorAvaliar() {
        return contCandPorAvaliar;
    }

    /**
     * Modifica o contador de candidaturas por avaliar.
     *
     * @param contCandPorAvaliar o contador de candidaturas por avaliar
     */
    public void setContCandPorAvaliar(int contCandPorAvaliar) {
        this.contCandPorAvaliar = contCandPorAvaliar;
    }

    /**
     * Devolve o contador de candidaturas avaliaadas.
     *
     * @return o contador de candidaturas avaliaadas
     */
    public int getContCandAvaliadas() {
        return contCandAvaliadas;
    }

    /**
     * Modifica o contador de candidaturas avaliaadas.
     *
     * @param contCandAvaliadas o contador de candidaturas avaliaadas
     */
    public void setContCandAvaliadas(int contCandAvaliadas) {
        this.contCandAvaliadas = contCandAvaliadas;
    }

    /**
     * Devolve o nome de utilizador do FAE (Ator).
     *
     * @return o nome de utilizador do FAE (Ator)
     */
    @Override
    public String getNome() {

        return this.utilizadorFae.getNome();
    }

    /**
     * Aumenta o contador de candidaturas por avaliar.
     */
    public void aumentarContCandPorAvaliar() {
        this.setContCandPorAvaliar(this.getContCandPorAvaliar() + 1);
    }

    /**
     * Reduz o contador de candidaturas por avaliar e aumenta o contador de
     * candidaturas avaliadas.
     */
    public void reduzirContCandPorAvaliar() {
        this.setContCandPorAvaliar(this.getContCandPorAvaliar() - 1);
        this.setContCandAvaliadas(this.getContCandAvaliadas() + 1);
    }

    /**
     * Gera uma representação textual do utilizador.
     *
     * @return representação textual do utilizador.
     */
    @Override
    public String toString() {
        return "Fae{" + "utilizadorFae=" + utilizadorFae + ", contCandPorAvaliar=" + contCandPorAvaliar + ", contCandAvaliadas=" + contCandAvaliadas + '}';
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
