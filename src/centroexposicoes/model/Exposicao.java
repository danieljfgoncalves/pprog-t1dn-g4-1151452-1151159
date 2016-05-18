/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma Exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Exposicao 
{
    /**
     * Lista das candidaturas da exposição.
     */
    private ListaCandidaturas listaCandidaturas;
    
    /**
     * Lista das demonstrações da exposição.
     */
    private List<Demonstracao> listaDemonstracoes;
    
    /**
     * Constrói uma instância de exposição com os valores por omissão.
     */
    public Exposicao()
    {
        listaCandidaturas = new ListaCandidaturas();
        listaDemonstracoes = new ArrayList<>();
    }
    
    /**
     * Cria uma nova candidatura com os valores por omissão.
     * 
     * @return Candidatura criada.
     */
    public Candidatura novaCandidatura()
    {
        return new Candidatura();
    }
    
    /**
     * Devolve a lista de demonstrações.
     * 
     * @return Lista de demonstrações.
     */
    public List<Demonstracao> getListaDemonstracoes()
    {
        return listaDemonstracoes;
    }
    
    /**
     * Adiciona uma candidatura.
     * 
     * @param candidatura Candidatura a ser adicionada
     * @return True se for adicionada com sucesso
     */
    public boolean adicionarCandidatura(Candidatura candidatura)
    {
        return listaCandidaturas.adicionarCandidatura(candidatura);
    }
}
