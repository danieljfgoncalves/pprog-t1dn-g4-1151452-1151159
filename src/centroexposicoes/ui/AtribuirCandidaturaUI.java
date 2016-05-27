/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.controller.AtribuirCandidaturaController;
import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Demonstracao;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.FicheiroCentroExposicoes;
import centroexposicoes.model.MecanismoAtribuicao;
import centroexposicoes.model.Organizador;
import static centroexposicoes.ui.RegistarCandidaturaUI.PADDING_BORDER;
import centroexposicoes.ui.components.DialogSelecionarExposicao;
import centroexposicoes.ui.components.ExposicaoSelecionavel;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.ui.components.ModelListMecanismos;
import centroexposicoes.ui.components.ModeloListProdutos;
import centroexposicoes.ui.components.ModeloTabelaAtribuicoes;
import centroexposicoes.utils.InstanciadorPorDefeito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    private List<Atribuicao> listaAtribuicoes;

    private JList listaMecanismosUI;
    private JButton btnGerar;
    private JTable tabelaAtribuicoesUI;

    final Dimension JANELA_TAMANHO = new Dimension(800, 600);
    final int MARGEM_S_CAMPO = 0, MARGEM_I_CAMPO = 0,
            MARGEM_E_CAMPO = 10, MARGEM_D_CAMPO = 0;
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

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
            this.listaAtribuicoes = new ArrayList<>();

            criarComponentes();

            pack();
            setSize(JANELA_TAMANHO);
            setMinimumSize(new Dimension(getWidth(), getHeight()));
            setLocationRelativeTo(null);
            setVisible(true);
        }

    }

    private void criarComponentes() {

        setLayout(new BorderLayout(10, 20));
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelEste(), BorderLayout.CENTER);
        add(criarPainelBotoesConfirmar(), BorderLayout.SOUTH);
    }

    private JPanel criarPainelOeste() {

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(PADDING_BORDER);

        JPanel pBotaoGerar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBotaoGerar.add(criarBotaoGerar());

        painel.add(criarScrollPaneMecanismos(), BorderLayout.CENTER);
        painel.add(pBotaoGerar, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarPainelEste() {

        JPanel painel = new JPanel(new GridLayout());
        painel.setBorder(PADDING_BORDER);

        painel.add(criarScrollPaneAtribuicoes());
        return painel;
    }

    private JPanel criarScrollPaneMecanismos() {

        JPanel painelScroll = new JPanel(new GridLayout());
        painelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Escolha o mecanismo pretendido:", TitledBorder.LEFT, TitledBorder.TOP));

        this.listaMecanismosUI = new JList(new ModelListMecanismos(this.listaMecanismos));
        this.listaMecanismosUI.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                btnGerar.setEnabled((!listaMecanismosUI.isSelectionEmpty()));
            }
        });

        JScrollPane scrollPane = new JScrollPane(this.listaMecanismosUI);
        scrollPane.setBorder(PADDING_BORDER);

        painelScroll.add(scrollPane);

        return painelScroll;
    }

    private JPanel criarScrollPaneAtribuicoes() {

        JPanel painelScroll = new JPanel(new GridLayout());
        painelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Verifique a lista de Atribuições:", TitledBorder.LEFT, TitledBorder.TOP));

        this.tabelaAtribuicoesUI = new JTable();
        this.tabelaAtribuicoesUI.setVisible(false);

        JScrollPane scrollPane = new JScrollPane(this.tabelaAtribuicoesUI);
        scrollPane.setBorder(PADDING_BORDER);

        painelScroll.add(scrollPane);

        return painelScroll;
    }

    private JButton criarBotaoGerar() {
        this.btnGerar = new JButton("Gerar Atribuições");
        this.btnGerar.setEnabled(false);
        this.btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO verificações

                int row = listaMecanismosUI.getSelectedIndex();
                controller.setMecanismo(listaMecanismos.get(row));
                listaAtribuicoes = controller.getListaAtribuicoes();
                tabelaAtribuicoesUI.setModel(new ModeloTabelaAtribuicoes(listaAtribuicoes));
                tabelaAtribuicoesUI.setVisible(true);
            }
        });
        return this.btnGerar;
    }

    private JPanel criarPainelBotoesConfirmar() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());

        return p;
    }

    private JButton criarBotaoConfirmar() {
        JButton btn = new JButton("Confirmar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO verificações
                try {
                    if (listaAtribuicoes.size() < 1) {
                        throw new IllegalArgumentException("Tem de gerar as atribuições primeiro.");
                    }

                    String message = "Confirma as atribuições?";
                    int confirma = JOptionPane.showConfirmDialog(rootPane, message);

                    if (confirma == JOptionPane.YES_OPTION) {
                        controller.registarAtribuicoes(listaAtribuicoes);
                        dispose();
                        new LoginUI(centroExposicoes, ficheiroCE);
                    }

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            rootPane,
                            ex.getMessage(),
                            "Atribuir Candidaturas",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btn;
    }

    private JButton criarBotaoCancelar() {

        JButton btn = new JButton("Cancelar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginUI(centroExposicoes, ficheiroCE);
            }
        });
        return btn;
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
