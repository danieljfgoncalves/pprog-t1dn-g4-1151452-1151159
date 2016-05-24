/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsável pelo registo e gestão de mecanismos.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistoMecanismos implements Serializable {

    /**
     * Lista das mecanismos.
     */
    private List<MecanismoAtribuicao> listaMecanismos;

    /**
     * Constrói uma instância de registo de mecanismos.
     */
    public RegistoMecanismos() {
        listaMecanismos = new ArrayList<>();
    }

    /**
     * Constrói uma instância de registo de mecanismos recebendo a lista de
     * mecanismos.
     *
     * @param listaMecanismos lista de mecanismos
     */
    public RegistoMecanismos(List<MecanismoAtribuicao> listaMecanismos) {
        this.listaMecanismos = new ArrayList<>(listaMecanismos);
    }

    /**
     * Constrói uma instância de registo de mecanismos copiando outro registo de
     * mecanismos.
     *
     * @param outroRegistoMecanismos registo de mecanismos a ser copiado
     */
    public RegistoMecanismos(RegistoMecanismos outroRegistoMecanismos) {
        this.listaMecanismos = new ArrayList<>(outroRegistoMecanismos.listaMecanismos);
    }

    /**
     * Devolve a lista de mecanismos.
     *
     * @return lista de mecanismos.
     */
    public List<MecanismoAtribuicao> getListaMecanismos() {
        return new ArrayList<>(this.listaMecanismos);
    }

    /**
     * Modifica a lista de mecanismos.
     *
     * @param listaMecanismos lista de mecanismos.
     */
    public void setListaExposicoes(List<MecanismoAtribuicao> listaMecanismos) {
        this.listaMecanismos = listaMecanismos;
    }

    /**
     * Devolve a descrição textual de todos os atributos de um registo de
     * mecanismos.
     *
     * @return caraterísticas do registo de mecanismos.
     */
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("RegistoMecanismos{ ");
        for (MecanismoAtribuicao mecanismo : this.listaMecanismos) {
            s.append(String.format("%s%n", mecanismo));
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Compara se outro objeto é igual a este Registo de mecanismos.
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
        RegistoMecanismos outroRegistoMecanismos = (RegistoMecanismos) outroObjeto;

        return this.listaMecanismos.equals(outroRegistoMecanismos.listaMecanismos);
    }
}
