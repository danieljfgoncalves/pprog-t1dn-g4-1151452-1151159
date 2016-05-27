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
import javafx.util.Pair;

/**
 * Representa um mecanismo de atribuição: Atribui candidaturas aos faes com
 * menos candidaturas por avaliar e o critério de desempate é a quantidade de
 * candidaturas atribuidas da exposição em causa.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class MecanismoMenosCarga implements MecanismoAtribuicao, Serializable {

    private static final String DESCRICAO_MECANISMO = "Atribuição por menos carga";

    private void definirAtribuicoes(List<Pair<Fae, Integer>> listaFaesEcarga) {

        Comparator criterio = (Comparator<Pair>) (Pair p1, Pair p2) -> {

            Fae fae1 = (Fae) p1.getKey();
            Fae fae2 = (Fae) p2.getKey();
            int carga1 = (int) p1.getValue();
            int carga2 = (int) p2.getValue();

            return (fae1.getContCandPorAvaliar() < fae2.getContCandPorAvaliar())
                    ? -1 : (fae1.getContCandPorAvaliar() > fae2.getContCandPorAvaliar())
                            ? 1 : (carga1 < carga2)
                                    ? -1 : (carga1 > carga2)
                                            ? 1 : 0;
        };

        Collections.sort(listaFaesEcarga, criterio);
    }

    private  List<Pair<Fae, Integer>> criarRelacaoFaeCarga(List<Fae> listaFaes) {

        List<Pair<Fae, Integer>> listaFaeCarga = new ArrayList<>();

        for (Fae fae : listaFaes) {
            listaFaeCarga.add(new Pair<>(fae, 0));
        }
        return listaFaeCarga;
    }

    @Override
    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao) {

        ListaAtribuicoes registoAtribuicoes = exposicao.getListaAtribuicoes();

        List<Candidatura> listaCandidaturas = exposicao.getListaCandidaturas().getListaCandidaturas();
        List<Fae> listaFaes = exposicao.getListaFaes().getListaFaes();
        List<Pair<Fae, Integer>> listaFaesEcarga = criarRelacaoFaeCarga(listaFaes);
        List<Atribuicao> listaAtribuicoes = new ArrayList<>();

        for (Candidatura candidatura : listaCandidaturas) {

            definirAtribuicoes(listaFaesEcarga);

            Pair<Fae, Integer> par = listaFaesEcarga.get(0);
            Fae fae = par.getKey();
            Integer carga = par.getValue();

            Atribuicao atribuicao = registoAtribuicoes.novaAtribuicao(candidatura, fae);
            if (registoAtribuicoes.validarAtribuicoes(atribuicao)) {
                
                listaAtribuicoes.add(atribuicao);
                fae.aumentarContCandPorAvaliar();
                carga++;
                
                par = new Pair<>(fae, carga);
                listaFaesEcarga.set(0, par);
            }
        }

        return listaAtribuicoes;
    }

    @Override
    public String getDescricao() {
        return DESCRICAO_MECANISMO;
    }
     
}
