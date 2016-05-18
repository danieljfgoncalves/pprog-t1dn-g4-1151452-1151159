/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

/**
 * Representa um produto.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Produto {

    /**
     * Designação do produto que pretende expor.
     */
    private String designacao;

    /**
     * Constrói uma instância do Produto com os valores por omissão.
     */
    public Produto() {

    }

    /**
     * Constrói uma instância do Produto com os valores recebidos por
     * paramêtros.
     *
     * @param designacao designação do produto a expor.
     */
    public Produto(String designacao) {

        this.designacao = designacao;
    }

    /**
     * Constrói uma instância do Produto a partir de outro produto.
     *
     * @param outroProduto produto que pretende copiar.
     */
    public Produto(Produto outroProduto) {

        this.designacao = outroProduto.designacao;
    }

    /**
     * Devolve a designação do produto.
     *
     * @return a designação do produto.
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Modifica a designação do produto.
     *
     * @param designacao a designação do produto.
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    /**
     * Verifica se o produto é válido. 
     * 
     * @return true se for válido ou false se for inválido.
     */
    public boolean valida() {
        
        return (!this.designacao.trim().isEmpty() && this.designacao != null);
    }

    /**
     * Devolve a descrição textual de todos os atributos de um produto.
     *
     * @return caraterísticas de um produto.
     */
    @Override
    public String toString() {
        return "Produto{" + "designacao=" + designacao + '}';
    }

}
