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
    
    public boolean adicionarCandidatura(Candidatura candidatura)
    {
        return validarCandidatura(candidatura) ? addCandidatura(candidatura) : false;
    }
    
    private boolean validarCandidatura(Candidatura candidatura)
    {
        return !listaCandidaturas.contains(candidatura);
    }
    
    private boolean addCandidatura(Candidatura candidatura)
    {
        return listaCandidaturas.add(candidatura);
    }
}
