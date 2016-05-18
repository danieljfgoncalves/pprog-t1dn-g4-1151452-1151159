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
    private ListaCandidaturas listaCandidaturas;
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
     * 
     * @return 
     */
    public Candidatura novaCandidatura()
    {
        return new Candidatura();
    }
    
    /**
     * 
     * @return 
     */
    public List<Demonstracao> getListaDemonstracoes()
    {
        return listaDemonstracoes;
    }
    
    public boolean adicionarCandidatura(Candidatura candidatura)
    {
        return listaCandidaturas.adicionarCandidatura(candidatura);
    }
}
