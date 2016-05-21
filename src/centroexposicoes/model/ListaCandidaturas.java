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
    private List<Candidatura> listaCandidaturas;
    
    /**
     * Constrói uma instância de lista de candidaturas.
     */
    public ListaCandidaturas()
    {
        listaCandidaturas = new ArrayList<>();
    }
    /**
     * Constrói uma instância de lista de candidaturas recebendo uma lista de candidaturas.
     * 
     * @param listaCandidaturas lista de candidaturas
     */
    public ListaCandidaturas(List<Candidatura> listaCandidaturas)
    {
        this.listaCandidaturas = new ArrayList<>(listaCandidaturas);
    }
    /**
     * Constrói uma instância de lista de candidaturas copiando uma lista de candidaturas.
     * 
     * @param listaCandidaturas lista de candidaturas
     */
    public ListaCandidaturas(ListaCandidaturas listaCandidaturas)
    {
        this.listaCandidaturas = new ArrayList<>(listaCandidaturas.listaCandidaturas);
    }

    /**
     * Devolve a lista de candidaturas.
     * 
     * @return lista de candidaturas
     */
    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }
    /**
     * Modifica a lista de candidaturas.
     * 
     * @param listaCandidaturas lista de candidaturas
     */
    public void setListaCandidaturas(List<Candidatura> listaCandidaturas) {
        this.listaCandidaturas = listaCandidaturas;
    }
    
    /**
     * Adiciona uma candidatura à lista de candidaturas, validando ao detalhe.
     * 
     * @param candidatura Candidatura a ser adicionada
     * @return True se for adicionada com sucesso
     */
    public boolean adicionarCandidatura(Candidatura candidatura)
    {
        return candidatura.valida() && validarCandidatura(candidatura) ? addCandidatura(candidatura) : false;
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
    
    /**
     * Devolve a representação textual de todos os atributos da lista de candidaturas.
     * 
     * @return representação textual de todos os atributos da lista de candidaturas
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("ListaCandidaturas{");
        for (Candidatura candidatura : listaCandidaturas) {
            s.append(String.format("%s%n", candidatura));
        }
        s.append("}");
        return s.toString();
    }
    /**
     * Compara se outro objeto é igual a esta ListaCandidaturas.
     * 
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais. False caso contrário
     */
    @Override
    public boolean equals(Object outroObjeto)
    {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        ListaCandidaturas outraListaCandidaturas = (ListaCandidaturas) outroObjeto;
        
        return listaCandidaturas.equals(outraListaCandidaturas.listaCandidaturas);
    }
}
