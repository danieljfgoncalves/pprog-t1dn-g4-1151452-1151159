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
    
    /**
     * Adiciona uma candidatura à lista de candidaturas, validando ao detalhe.
     * 
     * @param candidatura Candidatura a ser adicionada
     * @return True se for adicionada com sucesso
     */
    public boolean adicionarCandidatura(Candidatura candidatura)
    {
        return validarCandidatura(candidatura) ? addCandidatura(candidatura) : false;
    }
    
    /**
     * Valida uma candidatura.
     * 
     * @param candidatura Candidatura a ser validada
     * @return True se for válida
     */
    private boolean validarCandidatura(Candidatura candidatura)
    {
        return !listaCandidaturas.contains(candidatura);
    }
    
    /**
     * Adiciona uma candidatura à lista de candidaturas.
     * 
     * @param candidatura Candidatura a ser adicionada
     * @return True se for adicionada com sucesso
     */
    private boolean addCandidatura(Candidatura candidatura)
    {
        return listaCandidaturas.add(candidatura);
    }
}
