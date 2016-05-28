/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Candidatura;
import centroexposicoes.model.Demonstracao;
import centroexposicoes.model.Produto;
import centroexposicoes.ui.AvaliarCandidaturaUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 * Interface gráfica de um diálogo mostar uma candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class DialogVerCandidatura extends JDialog {

    /**
     * Janela que instância o diálogo.
     */
    private AvaliarCandidaturaUI framePai;

    /**
     * Candidatura a ser mostrada.
     */
    private Candidatura candidatura;

    /**
     * JList de produtos.
     */
    private JList<Produto> jListaProdutos;

    /**
     * JList de demonstrações.
     */
    private JList<Demonstracao> jListaDemonstracoes;

    /**
     * Título do diálogo.
     */
    private static final String TITULO = "Nova avaliação";

    /**
     * Constrói um diálogo ver candidatura recebendo o frame pai.
     *
     * @param framePai frame pai
     * @param candidatura candidatura a visualizar
     */
    public DialogVerCandidatura(AvaliarCandidaturaUI framePai, Candidatura candidatura) {
        super(framePai, TITULO, true);
        this.framePai = framePai;
        this.candidatura = candidatura;

        criarComponentes();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    /**
     * Cria os componentes do diálogo.
     */
    private void criarComponentes() {
        JPanel panelComponents = new JPanel(new GridLayout(2, 1, 0, 10));
        panelComponents.add(criarPainelCampos());
        panelComponents.add(CriarPainelTabelasBotoes());
        panelComponents.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelComponents);
    }

    /**
     * Cria o painel com os campos da candidatura.
     *
     * @return painel dos campos
     */
    private JPanel criarPainelCampos() {
        JPanel painelCampos = new JPanel(new GridLayout(3, 1));

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        JLabel labelNomeEmpresa = new JLabel("Nome Empresa: " + candidatura.getNomeEmpresa());
        JLabel labelTelemovel = new JLabel("Telemóvel: " + candidatura.getTelemovel());
        p1.add(labelNomeEmpresa);
        p1.add(labelTelemovel);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        JLabel labelMorada = new JLabel("Morada: " + candidatura.getMorada());
        p2.add(labelMorada);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        JLabel labelAreaExpositor = new JLabel(String.format("Área expositor: %.2f", candidatura.getAreaExpositor()));
        JLabel labelNumeroConvites = new JLabel("Número de convites: " + candidatura.getNumeroConvites());
        p3.add(labelAreaExpositor);
        p3.add(labelNumeroConvites);

        painelCampos.add(p1);
        painelCampos.add(p2);
        painelCampos.add(p3);

        painelCampos.setBorder(BorderFactory.createTitledBorder("Dados"));

        return painelCampos;
    }

    /**
     * Cria o painel com as tabelas e botões.
     *
     * @return painel com as tabelas e botões
     */
    private JPanel CriarPainelTabelasBotoes() {
        JPanel painelTabelasBotoes = new JPanel(new BorderLayout(0, 10));

        painelTabelasBotoes.add(criarPainelTabelas(), BorderLayout.CENTER);
        painelTabelasBotoes.add(criarBotãoRegressar(), BorderLayout.SOUTH);

        return painelTabelasBotoes;
    }

    /**
     * Criar o painel para as tabelas.
     *
     * @return painel das tabelas
     */
    private JPanel criarPainelTabelas() {
        JPanel painelTabelas = new JPanel(new GridLayout(1, 2, 10, 0));

        painelTabelas.add(criarPainelTabelaProdutos());
        painelTabelas.add(criarPainelTabelaDemonstracoes());

        return painelTabelas;
    }

    /**
     * Criar o botão regressar.
     *
     * @return botão regressar.
     */
    private JButton criarBotãoRegressar() {
        JButton botaoRegressar = new JButton("Regressar");

        botaoRegressar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return botaoRegressar;
    }

    /**
     * Criar o painel para a tabela produtos.
     *
     * @return painel para a tabela produtos.
     */
    private JPanel criarPainelTabelaProdutos() {
        JPanel painelProdutos = new JPanel(new BorderLayout(0, 5));

        JLabel labelTitulo = new JLabel("Produtos:", SwingConstants.CENTER);
        jListaProdutos = new JList();
        jListaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListaProdutos.setModel(new ModelListProdutosSimples(candidatura.getListaProdutos()));

        JScrollPane jScrollProdutos = new JScrollPane(jListaProdutos);

        painelProdutos.add(labelTitulo, BorderLayout.NORTH);
        painelProdutos.add(jScrollProdutos, BorderLayout.CENTER);

        return painelProdutos;
    }

    /**
     * Cria o painel para a tabela demonstrações.
     *
     * @return painel para a tabela demonstrações
     */
    private JPanel criarPainelTabelaDemonstracoes() {
        JPanel painelDemonstracoes = new JPanel(new BorderLayout(0, 5));

        JLabel labelTitulo = new JLabel("Demonstrações:", SwingConstants.CENTER);
        jListaDemonstracoes = new JList();
        jListaDemonstracoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListaDemonstracoes.setModel(new ModelListDemonstracoes(candidatura.getListaDemonstracoes()));

        JScrollPane jScrollDemonstracoes = new JScrollPane(jListaDemonstracoes);

        painelDemonstracoes.add(labelTitulo, BorderLayout.NORTH);
        painelDemonstracoes.add(jScrollDemonstracoes, BorderLayout.CENTER);

        return painelDemonstracoes;
    }

}
