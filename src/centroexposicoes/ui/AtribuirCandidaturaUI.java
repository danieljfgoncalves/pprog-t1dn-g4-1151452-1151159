/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.controller.AtribuirCandidaturaController;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.FicheiroCentroExposicoes;
import centroexposicoes.model.MecanismoAtribuicao;
import centroexposicoes.model.Organizador;
import centroexposicoes.ui.components.DialogSelecionarExposicao;
import centroexposicoes.ui.components.ExposicaoSelecionavel;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.utils.InstanciadorPorDefeito;
import java.util.List;

/**
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class AtribuirCandidaturaUI extends GlobalJFrame implements ExposicaoSelecionavel {

    private CentroExposicoes centroExposicoes;
    private AtribuirCandidaturaController controller;
    private FicheiroCentroExposicoes ficheiroCE;
    private Exposicao exposicaoSelecionada;
    private List<MecanismoAtribuicao> listaMecanismos;

    public AtribuirCandidaturaUI(CentroExposicoes centroExposicoes, Organizador organizador, FicheiroCentroExposicoes ficheiroCE) {

        this.centroExposicoes = centroExposicoes;
        this.ficheiroCE = ficheiroCE;
        this.controller = new AtribuirCandidaturaController(centroExposicoes, organizador);

        List<Exposicao> listaExposicoes = this.controller.getListaExposicoes(organizador);
        new DialogSelecionarExposicao<>(this, listaExposicoes, centroExposicoes, ficheiroCE);
        if (this.exposicaoSelecionada == null) {
            dispose();
        } else {

            this.controller.setExposicao(this.exposicaoSelecionada);
            this.listaMecanismos = this.controller.getListaMecanismos();
        }

    }

    @Override
    public void setExposicao(Exposicao exposicao) {

        this.exposicaoSelecionada = exposicao;
    }

    public static void main(String[] args) {

        CentroExposicoes ce = InstanciadorPorDefeito.getCentroExposicoesPorDefeito();
        new LoginUI(ce, new FicheiroCentroExposicoes());
    }
}
