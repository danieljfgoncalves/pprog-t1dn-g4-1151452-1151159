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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Representa um mecanismo de atribuição: Atribui uma candidatura a cada 2 FAEs.
 * As candidaturas com mais produtos são atribuidas aos FAEs com mais
 * experiência.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class MecanismoProdutosPorExperiencia implements MecanismoAtribuicao, Serializable {

    /**
     * Descrição reduzida do mecanismo.
     */
    private static final String DESCRICAO_MECANISMO = "Atribuição quantidade produtos por experiência";

    @Override
    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao) {

        //registo atribuições para criar as atribuições (high-cohesion)
        ListaAtribuicoes registoAtribuicoes = exposicao.getListaAtribuicoes();

        List<Candidatura> listaCandidaturas = getListaCandidaturasOrdenadaPorQuantidadeProdutos(exposicao);
        List<Fae> listaFaes = getListaFaesOrdenadaPorExperienciaCarga(exposicao);
        
        List<Atribuicao> listaAtribuicoes = new ArrayList<>();

        int countAtribuidos = 0;
        for (Candidatura candidatura : listaCandidaturas) {
            
            for (int i = 0; i < 2; i++) {
                if (countAtribuidos > listaFaes.size() - 1) {
                    countAtribuidos = 0;
                }
                Atribuicao atribuicao = registoAtribuicoes.novaAtribuicao(candidatura, listaFaes.get(countAtribuidos));
                countAtribuidos++;
                
                listaAtribuicoes.add(atribuicao);
            }
            
        }

        return listaAtribuicoes;
    }

    /**
     * Devolve a lista de faes ordenada por experiência e em caso de empate por
     * carga.
     *
     * @param exposicao exposição
     * @return lista faes ordenadas
     */
    private List<Fae> getListaFaesOrdenadaPorExperienciaCarga(Exposicao exposicao) {
        List<Fae> listaFaes = new ArrayList<>(exposicao.getListaFaes().getListaFaes());

        Comparator<Fae> comparatorFaeExperiência = (Fae fae1, Fae fae2) -> {
            return fae1.getContCandAvaliadas() > fae2.getContCandAvaliadas()
                    ? -1 : fae1.getContCandAvaliadas() < fae2.getContCandAvaliadas()
                            ? 1 : fae1.getContCandPorAvaliar() > fae2.getContCandPorAvaliar()
                                    ? -1 : fae1.getContCandPorAvaliar() < fae2.getContCandPorAvaliar()
                                            ? 1 : 0;
        };

        Collections.sort(listaFaes, comparatorFaeExperiência);

        return listaFaes;
    }

    /**
     * Devolve a lista de candidaturas ordenada por quantidade de produtos.
     * 
     * @param exposicao exposição
     * @return lista de candidaturas
     */
    private List<Candidatura> getListaCandidaturasOrdenadaPorQuantidadeProdutos(Exposicao exposicao) {
        List<Candidatura> listaCandidaturas = new ArrayList<>(exposicao.getListaCandidaturas().getListaCandidaturas());

        Comparator<Candidatura> comparatorNumeroProdutos = (Candidatura candidatura1, Candidatura candidatura2) -> {
            return candidatura1.getListaProdutos().size() > candidatura2.getListaProdutos().size()
                    ? -1 : candidatura1.getListaProdutos().size() < candidatura2.getListaProdutos().size()
                            ? 1 : 0;
        };
        Collections.sort(listaCandidaturas, comparatorNumeroProdutos);

        Collections.sort(listaCandidaturas, comparatorNumeroProdutos);

        return listaCandidaturas;
    }

    @Override
    public String getDescricao() {
        return DESCRICAO_MECANISMO;
    }

}
