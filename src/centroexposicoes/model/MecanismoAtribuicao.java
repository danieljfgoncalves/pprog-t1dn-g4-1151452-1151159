/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.List;

/**
 * Representa um mecanismo de atribuição.
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
}
