/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por armazenar e gerir exposições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistoExposicoes implements Serializable {

    /**
     * Lista das exposições.
     */
    private List<Exposicao> listaExposicoes;

    /**
     * Constrói uma instância de registo de exposições.
     */
    public RegistoExposicoes() {
        listaExposicoes = new ArrayList<>();
    }

    /**
     * Constrói uma instância de registo de exposições recebendo a lista de
     * exposições.
     *
     * @param listaExposicoes lista de exposições
     */
    public RegistoExposicoes(List<Exposicao> listaExposicoes) {
        this.listaExposicoes = new ArrayList<>(listaExposicoes);
    }

    /**
     * Constrói uma instância de registo de exposições copiando outro registo de
     * exposições.
     *
     * @param registoExposicoes registo de exposições a ser copiado
     */
    public RegistoExposicoes(RegistoExposicoes registoExposicoes) {
        this.listaExposicoes = new ArrayList<>(registoExposicoes.listaExposicoes);
    }

    /**
     * Devolve a lista de exposições.
     *
     * @return lista de exposições
     */
    public List<Exposicao> getListaExposicoes() {
        return listaExposicoes;
    }

    /**
     * Modifica a lista de exposições
     *
     * @param listaExposicoes lista de exposições
     */
    public void setListaExposicoes(List<Exposicao> listaExposicoes) {
        this.listaExposicoes = listaExposicoes;
    }
    
    /**
     * Devolve as exposicoes que o fae especificado pertence como tal.
     * 
     * @param fae funcionário de apoio às exposições.
     * @return lista de exposições do fae
     */
    public List<Exposicao> getListaExposicoesDoFae(Fae fae)
    {
        List<Exposicao> listaExposicoesDoFae = new ArrayList<>();
        
        for (Exposicao exposicao : listaExposicoes) {
            if (exposicao.getListaFaes().getListaFaes().contains(fae)) {
                listaExposicoesDoFae.add(exposicao);
            }
        }
        
        return listaExposicoesDoFae;
    }

    /**
     * Devolve a representação textual de todos os atributos do registo de
     * exposições.
     *
     * @return representação textual de todos os atributos do registo de
     * exposições
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("RegistoExposicoes{");
        for (Exposicao exposicao : listaExposicoes) {
            s.append(String.format("%s%n", exposicao));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compara se outro objeto é igual a este RegistoExposicoes.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais. False caso contrário
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        RegistoExposicoes outroRegistoExposicoes = (RegistoExposicoes) outroObjeto;

        return listaExposicoes.equals(outroRegistoExposicoes.listaExposicoes);
    }
}
