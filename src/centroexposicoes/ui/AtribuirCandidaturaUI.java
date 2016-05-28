/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.controller.AtribuirCandidaturaController;
import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.MecanismoAtribuicao;
import centroexposicoes.model.Organizador;
import centroexposicoes.ui.components.DialogSelecionarExposicao;
import centroexposicoes.ui.components.ExposicaoSelecionavel;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.ui.components.ModelListMecanismos;
import centroexposicoes.ui.components.ModeloTabelaAtribuicoes;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Interface gráfica para atribuir candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class AtribuirCandidaturaUI extends GlobalJFrame implements ExposicaoSelecionavel {

    /**
     * Centro de exposições.
     */
    private final CentroExposicoes centroExposicoes;
    /**
     * Controller para atribuir candidatura.
     */
    private final AtribuirCandidaturaController controller;
    /**
     * Exposição selecionada no UI.
     */
    private Exposicao exposicaoSelecionada;
    /**
     * Lista de mecanismos de atribuição.
     */
    private List<MecanismoAtribuicao> listaMecanismos;
    /**
     * Lista de atribuições.
     */
    private List<Atribuicao> listaAtribuicoes;

    /**
     * Lista para os mecanismos.
     */
    private JList listaMecanismosUI;
    /**
     * Botão para gerar.
     */
    private JButton btnGerar;
    /**
     * Tabela de atribuições.
     */
    private JTable tabelaAtribuicoesUI;

    /**
     * Dimensão da janela
     */
    final Dimension JANELA_TAMANHO = new Dimension(800, 600);
    /**
     * Margens para o UI.
     */
    final int MARGEM_S_CAMPO = 0, MARGEM_I_CAMPO = 0,
            MARGEM_E_CAMPO = 10, MARGEM_D_CAMPO = 0;
    /**
     * Border para o UI.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Inicia o UI de atribuir candidaturas.
     *
     * @param centroExposicoes centro de exposições
     * @param organizador organizador
     */
    public AtribuirCandidaturaUI(CentroExposicoes centroExposicoes, Organizador organizador) {
        super(centroExposicoes);

        this.centroExposicoes = centroExposicoes;
        this.controller = new AtribuirCandidaturaController(centroExposicoes, organizador);

        List<Exposicao> listaExposicoes = this.controller.getListaExposicoes();
        new DialogSelecionarExposicao<>(this, listaExposicoes, centroExposicoes);
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

    /**
     * Cria os componentes para o UI.
     */
    private void criarComponentes() {

        setLayout(new BorderLayout(10, 20));
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelEste(), BorderLayout.CENTER);
        add(criarPainelBotoesConfirmar(), BorderLayout.SOUTH);
    }

    /**
     * Cria o painel oeste.
     *
     * @return painel oeste
     */
    private JPanel criarPainelOeste() {

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(PADDING_BORDER);

        JPanel pBotaoGerar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBotaoGerar.add(criarBotaoGerar());

        painel.add(criarScrollPaneMecanismos(), BorderLayout.CENTER);
        painel.add(pBotaoGerar, BorderLayout.SOUTH);

        return painel;
    }

    /**
     * Cria o painel este.
     *
     * @return painel este
     */
    private JPanel criarPainelEste() {

        JPanel painel = new JPanel(new GridLayout());
        painel.setBorder(PADDING_BORDER);

        painel.add(criarScrollPaneAtribuicoes());
        return painel;
    }

    /**
     * Criar o painel de mecanismos.
     *
     * @return painle de mecanismos
     */
    private JPanel criarScrollPaneMecanismos() {

        JPanel painelScroll = new JPanel(new GridLayout());
        painelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Escolha o mecanismo pretendido:", TitledBorder.LEFT, TitledBorder.TOP));

        this.listaMecanismosUI = new JList(new ModelListMecanismos(this.listaMecanismos));
        this.listaMecanismosUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

    /**
     * Cria o painel para as atribuições.
     *
     * @return painel de atribuições
     */
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

    /**
     * Criar o botão gerar.
     *
     * @return botão gerar
     */
    private JButton criarBotaoGerar() {
        this.btnGerar = new JButton("Gerar Atribuições");
        this.btnGerar.setEnabled(false);
        this.btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = listaMecanismosUI.getSelectedIndex();
                controller.setMecanismo(listaMecanismos.get(row));
                listaAtribuicoes = controller.getListaAtribuicoes();
                tabelaAtribuicoesUI.setModel(new ModeloTabelaAtribuicoes(listaAtribuicoes));
                tabelaAtribuicoesUI.setVisible(true);
            }
        });
        return this.btnGerar;
    }

    /**
     * Criar o painel para o botão confirmar.
     *
     * @return panel para o botão confirmar
     */
    private JPanel criarPainelBotoesConfirmar() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());

        return p;
    }

    /**
     * Criar o botão confirmar.
     *
     * @return botão confirmar
     */
    private JButton criarBotaoConfirmar() {
        JButton btn = new JButton("Confirmar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (listaAtribuicoes.size() < 1) {
                        throw new IllegalArgumentException("Tem de gerar as atribuições primeiro.");
                    }

                    String message = "Confirma as atribuições?";
                    int confirma = JOptionPane.showConfirmDialog(rootPane, message);

                    if (confirma == JOptionPane.YES_OPTION) {
                        controller.registarAtribuicoes(listaAtribuicoes);
                        dispose();
                        new LoginUI(centroExposicoes);
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

    /**
     * Criar o botão cancelar.
     *
     * @return botão cancelar
     */
    private JButton criarBotaoCancelar() {

        JButton btn = new JButton("Cancelar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginUI(centroExposicoes);
            }
        });
        return btn;
    }

    /**
     * Define uma exposição.
     *
     * @param exposicao exposição
     */
    @Override
    public void setExposicao(Exposicao exposicao) {

        this.exposicaoSelecionada = exposicao;
    }
}
