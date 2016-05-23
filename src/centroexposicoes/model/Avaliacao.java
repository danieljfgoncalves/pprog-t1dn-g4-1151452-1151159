/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

/**
 * Representa uma avaliação de uma candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Avaliacao {

    /**
     * Tipos de decisão de Avaliação.
     */
    public static enum TipoAvaliacao {
        
        Aprovado, Rejeitado, EmAvaliacao
    };

    /**
     * Decisão da avaliação.
     */
    private TipoAvaliacao decisao;

    /**
     * Atribuição da avaliação.
     */
    private Atribuicao atribuicao;

    /**
     * Texto justificativo da avaliação.
     */
    private String txtJustificativo;

    /**
     * Decisão da avaliação por omissão.
     */
    private static final TipoAvaliacao DECISAO_POR_OMISSAO = TipoAvaliacao.EmAvaliacao;

    /**
     * Atribuição da avaliação por omissão.
     */
    private static final Atribuicao ATRIBUICAO_POR_OMISSAO = new Atribuicao();

    /**
     * Texto justificativo da avaliação por omissão.
     */
    private static final String TXT_JUSTIFICATIVO_POR_OMISSAO = "Sem justificação";

    /**
     * Constroi uma instância de avaliação com os valores por omissão.
     */
    public Avaliacao() {
        this.decisao = DECISAO_POR_OMISSAO;
        this.atribuicao = ATRIBUICAO_POR_OMISSAO;
        this.txtJustificativo = TXT_JUSTIFICATIVO_POR_OMISSAO;
    }

    /**
     * Constroi uma instância de avaliação com os valores recebidos por
     * paramêtros.
     *
     * @param decisao decisao de uma avaliação.
     * @param atribuicao atribuição da avaliação.
     * @param txtJustificativo texto justificativo da avaliação.
     */
    public Avaliacao(TipoAvaliacao decisao, Atribuicao atribuicao, String txtJustificativo) {
        this.decisao = decisao;
        this.atribuicao = atribuicao;
        this.txtJustificativo = txtJustificativo;
    }

    /**
     * Constroi uma instância de avaliação com os valores copiados por outra
     * avaliação.
     *
     * @param outraAvaliacao avaliação que pretende copiar.
     */
    public Avaliacao(Avaliacao outraAvaliacao) {
        this.decisao = outraAvaliacao.decisao;
        this.atribuicao = outraAvaliacao.atribuicao;
        this.txtJustificativo = outraAvaliacao.txtJustificativo;
    }

    /**
     * Devolve a decisão da avaliação.
     *
     * @return a decisão da avaliação.
     */
    public TipoAvaliacao getDecisao() {
        return decisao;
    }

    /**
     * Modifica a decisão da avaliação.
     *
     * @param decisao decisão da avaliação.
     */
    public void setDecisao(TipoAvaliacao decisao) {
        this.decisao = decisao;
    }

    /**
     * Devolve a atribuição da avaliação.
     *
     * @return a atribuição da avaliação.
     */
    public Atribuicao getAtribuicao() {
        return atribuicao;
    }

    /**
     * Modifica a atribuição da avaliação.
     *
     * @param atribuicao atribuição da avaliação.
     */
    public void setAtribuicao(Atribuicao atribuicao) {
        this.atribuicao = atribuicao;
    }

    /**
     * Devolve o texto justificativo da avaliação.
     *
     * @return o texto justificativo da avaliação.
     */
    public String getTxtJustificativo() {
        return txtJustificativo;
    }

    /**
     * Modifica o texto justificativo da avaliação.
     *
     * @param txtJustificativo texto justificativo da avaliação.
     */
    public void setTxtJustificativo(String txtJustificativo) {
        this.txtJustificativo = txtJustificativo;
    }

    /**
     * Devolve a descrição textual de todos os atributos de um representante.
     *
     * @return caraterísticas da candidatura.
     */
    @Override
    public String toString() {
        return "Avaliacao{" + "decisao=" + decisao + ", atribuicao=" + atribuicao + ", txtJustificativo=" + txtJustificativo + '}';
    }

    /**
     * Compara se outro objeto é igual a esta avaliação.
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
        Avaliacao outraAvaliacao = (Avaliacao) outroObjeto;
        
        return this.decisao.equals(outraAvaliacao.decisao)
                && this.atribuicao.equals(outraAvaliacao.atribuicao)
                && this.txtJustificativo.equals(outraAvaliacao.txtJustificativo);
    }
}
