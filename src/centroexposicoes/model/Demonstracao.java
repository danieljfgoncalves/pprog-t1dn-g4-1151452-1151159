/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

/**
 * Representa uma demonstração.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Demonstracao
{
    /**
     * Código único para a demonstração.
     */
    private String codigoUnico;
    /**
     * Designação da demonstração.
     */
    private String designacao;
    
    /**
     * Número de instâncias de demonstrações criadas;
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
    public Demonstracao()
    {
        codigoUnico = TEXTO_CODIGO_UNICO + ++contagemDemonstracao;
        designacao = DESIGNACAO_POR_OMISSÃO;
    }
    
    /**
     * Constrói uma instância de demonstração recebendo a designação.
     */
    public Demonstracao(String designacao)
    {
        codigoUnico = TEXTO_CODIGO_UNICO + ++contagemDemonstracao;
        this.designacao = designacao;
    }
}
