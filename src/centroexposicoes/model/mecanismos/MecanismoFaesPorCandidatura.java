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
import javax.swing.JOptionPane;

/**
 * Representa um mecanismo de atribuição: Cada candidatura é atribuida a um
 * número pretendido de FAEs.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class MecanismoFaesPorCandidatura implements MecanismoAtribuicao, Serializable {

    /**
     * Descrição reduzida do mecanismo.
     */
    private static final String DESCRICAO_MECANISMO = "Atribuicao para quantidade definida de FAEs";

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

        int numeroFaesPorCandidatura = -1;
        do {
            try {
                numeroFaesPorCandidatura = Integer.parseInt(JOptionPane.showInputDialog("Introduza o número de FAEs pretendidos por candidatura:"));
                if (numeroFaesPorCandidatura > listaFaes.size() || numeroFaesPorCandidatura < 1) {
                    throw new IllegalArgumentException("Número inválido de FAEs.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Insira um valor válido por favor..", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, String.format("Só é possível atribuir até %d FAE por candidatura.", listaFaes.size()), "Número FAE Inválido", JOptionPane.ERROR_MESSAGE);
            }

        } while (numeroFaesPorCandidatura > listaFaes.size() || numeroFaesPorCandidatura < 1);

        int countAtribuidos = 0;
        for (Candidatura candidatura : listaCandidaturas) {

            for (int i = 0; i < numeroFaesPorCandidatura; i++) {

                if (countAtribuidos > listaFaes.size() - 1) {
                    countAtribuidos = 0;
                }
                Atribuicao atribuicao = registoAtribuicoes.novaAtribuicao(candidatura, listaFaes.get(countAtribuidos));
                listaAtribuicoes.add(atribuicao);

                countAtribuidos++;

            }
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
