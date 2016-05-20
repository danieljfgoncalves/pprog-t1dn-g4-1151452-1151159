/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import centroexposicoes.utils.Validar;
import java.util.Objects;

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
     * Designação do produto que pretende expor por omissão.
     */
    private static final String DESIGNACAO_POR_OMISSAO = "Sem designação";
    
    /**
     * Constrói uma instância do Produto com os valores por omissão.
     */
    public Produto() {

        this.designacao = DESIGNACAO_POR_OMISSAO;
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

        return Validar.validaString(this.designacao);
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
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Produto)) {
            return false;
        }

        final Produto outroProduto = (Produto) obj;

        return this.designacao.equals(outroProduto.designacao);
    }
}
