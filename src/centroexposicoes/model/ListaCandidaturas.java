/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por armazenar e gerir as candidaturas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ListaCandidaturas
{
    /**
     * Lista das candidaturas.
     */
    private final List<Candidatura> listaCandidaturas;
    
    /**
     * Constrói uma instância de lista de candidaturas.
     */
    public ListaCandidaturas()
    {
        listaCandidaturas = new ArrayList<>();
    }
}
