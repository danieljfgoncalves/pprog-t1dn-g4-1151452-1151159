package centroexposicoes.ui;

import centroexposicoes.controller.AvaliarCandidaturasController;
import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.Avaliacao;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Fae;
import centroexposicoes.ui.components.DialogNovaAvaliacao;
import centroexposicoes.ui.components.DialogVerCandidatura;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.ui.components.ModelListAtribuicoes;
import centroexposicoes.ui.components.ModelListExposicoes;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Interface gráfica para a avaliação de candidaturas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class AvaliarCandidaturaUI extends GlobalJFrame {

    /**
     * Controlador para avaliar candidatura.
     */
    private final AvaliarCandidaturasController controller;
    /**
     * Centro de exposições.
     */
    private final CentroExposicoes centroExposicoes;

    /**
     * Lista de exposições.
     */
    private final List<Exposicao> listaExposicoes;
    /**
     * Lista para as exposições.
     */
    private JList<Exposicao> jListaExposicoes;

    /**
     * Lista de atribuições.
     */
    private List<Atribuicao> listaAtribuicoes;
    /**
     * Lista de atribuições.
     */
    private JList<Atribuicao> jListaAtribuicoes;

    /**
     * Botão ver candidatura.
     */
    private JButton botaoVerCandidatura;
    /**
     * Botõ avaliar candidatura.
     */
    private JButton botaoAvaliarCandidatura;

    /**
     * Dimensão da janela.
     */
    private static final Dimension DIMENSAO_JANELA = new Dimension(600, 400);

    /**
     * Cria uma instância de candidatura UI.
     * 
     * @param centroExposicoes centro de exposições
     * @param fae Funcionário de apoio à exposição
     */
    public AvaliarCandidaturaUI(CentroExposicoes centroExposicoes, Fae fae) {
        super(centroExposicoes);

        this.centroExposicoes = centroExposicoes;
        this.controller = new AvaliarCandidaturasController(centroExposicoes, fae);
        this.listaExposicoes = controller.getListaExposicoesDoFae();

        criarComponentes();

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(DIMENSAO_JANELA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Cria os componentes para a UI.
     */
    private void criarComponentes() {
        JPanel panelComponents = new JPanel(new BorderLayout(10, 10));
        panelComponents.add(criarPainelListas(), BorderLayout.CENTER);
        panelComponents.add(criarPainelBotoes(), BorderLayout.SOUTH);
        panelComponents.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelComponents);
    }

    /**
     * Criar o painel das listas.
     * 
     * @return painel das listas
     */
    private JPanel criarPainelListas() {
        JPanel painelListas = new JPanel(new GridLayout(1, 2, 10, 0));

        painelListas.add(criarPainelExposicoes());
        painelListas.add(criarPainelAtribuicoes());

        return painelListas;
    }

    /**
     * Cria o painel das exposições.
     * 
     * @return painel das exposições
     */
    private JPanel criarPainelExposicoes() {
        JPanel painelExposicoes = new JPanel(new BorderLayout(10, 10));

        JLabel labelTitulo = new JLabel("Selecione uma exposição:", SwingConstants.CENTER);
        jListaExposicoes = new JList();
        jListaExposicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListaExposicoes.setModel(new ModelListExposicoes(listaExposicoes));

        jListaExposicoes.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jListaExposicoes.getSelectedIndex() >= 0) {
                    listaAtribuicoes = controller.getListaAtribuicoesPorAvaliar(listaExposicoes.get(jListaExposicoes.getSelectedIndex()));
                    jListaAtribuicoes.setModel(new ModelListAtribuicoes(listaAtribuicoes));
                } else {
                    listaAtribuicoes = new ArrayList<>();
                    jListaAtribuicoes.setModel(new ModelListAtribuicoes(listaAtribuicoes));
                }
            }
        });

        JScrollPane jScrollExposicoes = new JScrollPane(jListaExposicoes);

        painelExposicoes.add(labelTitulo, BorderLayout.NORTH);
        painelExposicoes.add(jScrollExposicoes, BorderLayout.CENTER);

        return painelExposicoes;
    }

    /**
     * Cria o painel das atribuições.
     * 
     * @return painel das atribuições
     */
    private JPanel criarPainelAtribuicoes() {
        JPanel painelAtribuicoes = new JPanel(new BorderLayout(10, 10));

        JLabel labelTitulo = new JLabel("Selecione uma atribuição:", SwingConstants.CENTER);
        jListaAtribuicoes = new JList();
        jListaAtribuicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jListaAtribuicoes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                botaoVerCandidatura.setEnabled(!jListaAtribuicoes.isSelectionEmpty());
                botaoAvaliarCandidatura.setEnabled(!jListaAtribuicoes.isSelectionEmpty());
            }
        });

        JScrollPane jScrollAtribuicoes = new JScrollPane(jListaAtribuicoes);

        painelAtribuicoes.add(labelTitulo, BorderLayout.NORTH);
        painelAtribuicoes.add(jScrollAtribuicoes, BorderLayout.CENTER);

        return painelAtribuicoes;
    }

    /**
     * Cria o painel dos botões.
     * 
     * @return painel dos botões
     */
    private JPanel criarPainelBotoes() {
        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 10, 0));

        painelBotoes.add(criarBotaoVerCandidatura());
        painelBotoes.add(criarBotaoAvaliarCandidatura());
        painelBotoes.add(criarBotaoSair());

        return painelBotoes;
    }

    /**
     * Cria o painel de ver candidatura.
     * 
     * @return painel de ver candidatura
     */
    private JButton criarBotaoVerCandidatura() {
        botaoVerCandidatura = new JButton("Ver Candidatura");
        botaoVerCandidatura.setEnabled(false);

        botaoVerCandidatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogVerCandidatura(AvaliarCandidaturaUI.this, controller.getCandidatura(listaAtribuicoes.get(jListaAtribuicoes.getSelectedIndex())));
            }
        });

        return botaoVerCandidatura;
    }

    /**
     * Cria o botão de avaliar candidatura.
     * 
     * @return botão de avaliar candidatura
     */
    private JButton criarBotaoAvaliarCandidatura() {
        botaoAvaliarCandidatura = new JButton("Avaliar Candidatura");
        botaoAvaliarCandidatura.setEnabled(false);

        botaoAvaliarCandidatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getCandidatura(listaAtribuicoes.get(jListaAtribuicoes.getSelectedIndex()));
                new DialogNovaAvaliacao(AvaliarCandidaturaUI.this);
            }
        });

        return botaoAvaliarCandidatura;
    }

    /**
     * Cria o botão sair.
     * @return botão sair
     */
    private JButton criarBotaoSair() {
        JButton botaoSair = new JButton("Sair");

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginUI(centroExposicoes);
            }
        });

        return botaoSair;
    }

    /**
     * Regista a avaliação.
     * 
     * @param avaliacao avaliação
     * @param textoJustificativo texto justificativo
     * @return true se for gerado com sucesso, false caso contrário
     */
    public boolean registaAvaliacao(Avaliacao.TipoAvaliacao avaliacao, String textoJustificativo) {
        controller.setAvaliacao(listaAtribuicoes.get(jListaAtribuicoes.getSelectedIndex()), avaliacao, textoJustificativo);
        boolean registadaComSucesso = controller.registaAvaliacao();
        if (registadaComSucesso) {
            boolean removidoComSucesso = controller.removerAtribuicao(listaAtribuicoes.get(jListaAtribuicoes.getSelectedIndex()));
            listaAtribuicoes = controller.getListaAtribuicoesPorAvaliar(listaExposicoes.get(jListaExposicoes.getSelectedIndex()));
            jListaAtribuicoes.setModel(new ModelListAtribuicoes(listaAtribuicoes));
            if (removidoComSucesso) {
                JOptionPane.showMessageDialog(rootPane, "Candidatura avaliada com sucesso!",
                        "Avaliação concluída", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return registadaComSucesso;
    }
}
