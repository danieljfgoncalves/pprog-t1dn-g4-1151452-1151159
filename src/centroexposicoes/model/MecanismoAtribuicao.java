/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.List;

/**
 * Interface de mecanismo de atribuição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public interface MecanismoAtribuicao
{

    /**
     * Gera uma lista de atribuições.
     *
     * @param exposicao Exposição
     * @return Atribuições
     */
    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao);
    
    /**
     * Devolve a descrição do mecanismo.
     * 
     * @return a descrição do mecanismo
     */
    public String getDescricao();
}
