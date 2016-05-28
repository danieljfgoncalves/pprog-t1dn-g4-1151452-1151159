/*
 * Fornece as classes que contém os mecanismos de atribuição de candidaturas.
 */
package centroexposicoes.model.mecanismos;

import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.Candidatura;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Fae;
import centroexposicoes.model.ListaAtribuicoes;
import centroexposicoes.model.MecanismoAtribuicao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um mecanismo de atribuição: Atribui uma candidatura a cada FAE
 * equitativamente.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class MecanismoCargaEquitativa implements MecanismoAtribuicao, Serializable {

    /**
     * Descrição reduzida do mecanismo.
     */
    private static final String DESCRICAO_MECANISMO = "Atribuição carga equitativa";

    /**
     * Gera uma lista de atribuições.
     *
     * @param exposicao Exposição
     * @return Atribuições
     */
    @Override
    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao) {
        //registo atribuições para criar as atribuições (high-cohesion)
        ListaAtribuicoes registoAtribuicoes = exposicao.getListaAtribuicoes();

        List<Candidatura> listaCandidaturas = new ArrayList<>(exposicao.getListaCandidaturas().getListaCandidaturas());
        List<Fae> listaFaes = new ArrayList<>(exposicao.getListaFaes().getListaFaes());

        List<Atribuicao> listaAtribuicoes = new ArrayList<>();

        int countAtribuidos = 0;
        for (Candidatura candidatura : listaCandidaturas) {

            if (countAtribuidos > listaFaes.size() - 1) {
                countAtribuidos = 0;
            }
            Atribuicao atribuicao = registoAtribuicoes.novaAtribuicao(candidatura, listaFaes.get(countAtribuidos));
            countAtribuidos++;

            listaAtribuicoes.add(atribuicao);
        }

        return listaAtribuicoes;
    }

    /**
     * Devolve a descrição do mecanismo.
     *
     * @return a descrição do mecanismo
     */
    @Override
    public String getDescricao() {
        return DESCRICAO_MECANISMO;
    }

}
