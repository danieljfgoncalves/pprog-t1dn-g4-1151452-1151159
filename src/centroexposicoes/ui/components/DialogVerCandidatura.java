/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Candidatura;
import centroexposicoes.model.Demonstracao;
import centroexposicoes.model.Produto;
import centroexposicoes.ui.AvaliarCandidaturaUI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setLayout(new GridLayout(2, 1));

        add(criarPainelCampos());
        add(CriarPainelTabelasBotoes());
    }

    /**
     * Cria o painel com os campos da candidatura.
     *
     * @return painel dos campos
     */
    private JPanel criarPainelCampos() {
        JPanel painelCampos = new JPanel();
        
        JLabel labelNomeEmpresa = new JLabel("Nome Empresa: " +  candidatura.getNomeEmpresa());
        JLabel labelTelemovel = new JLabel("Telemóvel: " + candidatura.getTelemovel());
        JLabel labelMorada = new JLabel("Morada: " + candidatura.getMorada());
        JLabel labelAreaExpositor = new JLabel(String.format("Área expositor: %.2f", candidatura.getAreaExpositor()));
        JLabel labelNumeroConvites = new JLabel("Número de convites: " + candidatura.getNumeroConvites());
        
        painelCampos.add(labelNomeEmpresa);
        painelCampos.add(labelTelemovel);
        painelCampos.add(labelMorada);
        painelCampos.add(labelAreaExpositor);
        painelCampos.add(labelNumeroConvites);
        
        return painelCampos;
    }

    /**
     * Cria o painel com as tabelas e botões.
     *
     * @return painel com as tabelas e botões
     */
    private JPanel CriarPainelTabelasBotoes() {
        JPanel painelTabelasBotoes = new JPanel(new BorderLayout());

        painelTabelasBotoes.add(criarPainelTabelas(), BorderLayout.CENTER);
        painelTabelasBotoes.add(criarBotãoRegressar(), BorderLayout.SOUTH);

        return painelTabelasBotoes;
    }

    private JPanel criarPainelTabelas() {
        JPanel painelTabelas = new JPanel(new GridLayout(1, 2));

        painelTabelas.add(criarPainelTabelaProdutos());
        painelTabelas.add(criarPainelTabelaDemonstracoes());

        return painelTabelas;
    }

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

    private JPanel criarPainelTabelaProdutos() {
        JPanel painelProdutos = new JPanel(new BorderLayout());

        JLabel labelTitulo = new JLabel("Produtos:", SwingConstants.CENTER);
        jListaProdutos = new JList();
        jListaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListaProdutos.setModel(new ModelListProdutosSimples(candidatura.getListaProdutos()));
        
        JScrollPane jScrollProdutos = new JScrollPane(jListaProdutos);

        painelProdutos.add(labelTitulo);
        painelProdutos.add(jScrollProdutos);
        
        return painelProdutos;
    }

    private JPanel criarPainelTabelaDemonstracoes() {
        JPanel painelDemonstracoes = new JPanel(new BorderLayout());

        JLabel labelTitulo = new JLabel("Demonstrações:", SwingConstants.CENTER);
        jListaDemonstracoes = new JList();
        jListaDemonstracoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListaDemonstracoes.setModel(new ModelListDemonstracoes(candidatura.getListaDemonstracoes()));
        
        JScrollPane jScrollDemonstracoes = new JScrollPane(jListaDemonstracoes);

        painelDemonstracoes.add(labelTitulo);
        painelDemonstracoes.add(jScrollDemonstracoes);
        
        return painelDemonstracoes;
    }

}
