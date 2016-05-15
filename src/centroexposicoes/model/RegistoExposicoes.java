/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por armazenar e gerir exposições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistoExposicoes
{
    /**
     * Lista das exposições.
     */
    private final List<Exposicao> listaExposicoes;
    
    /**
     * Constrói uma instância de registo de exposições.
     */
    public RegistoExposicoes()
    {
        listaExposicoes = new ArrayList<>();
    }
}
