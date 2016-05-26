/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.controller.RegistarCandidaturaController;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Demonstracao;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Representante;
import centroexposicoes.ui.components.DialogNovoProduto;
import centroexposicoes.ui.components.DialogSelecionarExposicao;
import centroexposicoes.ui.components.ExposicaoSelecionavel;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.ui.components.ModeloListProdutos;
import centroexposicoes.ui.components.ModeloTabelaListaDemonstracao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Interface gráfica para o registo de candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistarCandidaturaUI extends GlobalJFrame implements ExposicaoSelecionavel {

    /**
     * Exposição selecionada pelo UI.
     */
    private Exposicao exposicaoSelecionada;
    private Representante repSelecionado;
    private List<Exposicao> listaExposicoes;
    private List<Demonstracao> listaDemonstracoes;

    private final RegistarCandidaturaController controller;

    private ModeloListProdutos modeloListProdutos;
    private JList jListProdutos;
    private JTable listaDemonstracoesJTable;
    private JButton btnRemoverProduto;

    private JTextField txtNomeEmpresa;
    private JTextArea txtMorada;
    private JTextField txtTelemovel;
    private JTextField txtAreaExpositor;
    private JTextField txtNumConvites;

    private static final Dimension LBL_TAMANHO = new Dimension(94, 16);
    final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
    final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
    private static final int CAMPO_TXT_LARGURA = 20;
    private static final int CAMPO_NUM_LARGURA = 6;

    public RegistarCandidaturaUI(CentroExposicoes centroExposicoes, Representante representante) {

        this.controller = new RegistarCandidaturaController(centroExposicoes);
        this.repSelecionado = representante;

        this.listaExposicoes = controller.getExposições();

        //APENAS PARA TESTAR INICIO
        Exposicao e1 = new Exposicao();
        this.listaExposicoes.add(e1);
        this.listaExposicoes.add(e1);
        this.listaExposicoes.add(e1);
        this.listaExposicoes.add(e1);
        //APENAS PARA TESTAR FIM

        new DialogSelecionarExposicao<>(this, this.listaExposicoes);
        controller.novaCandidatura(exposicaoSelecionada);
        this.listaDemonstracoes = controller.getListaDemonstracoes();

        //APENAS PARA TESTAR INICIO
        Demonstracao d1 = new Demonstracao();
        this.listaDemonstracoes.add(d1);
        this.listaDemonstracoes.add(d1);
        this.listaDemonstracoes.add(d1);
        this.listaDemonstracoes.add(d1);
        //APENAS PARA TESTAR FIM

        setLayout(new GridLayout(1, 3));
        criarComponentes();

        setVisible(true);
    }

    private void criarComponentes() {

        add(criarPainelDados());
        add(criarPainelProdutos());
        add(criarPainelDemonstracoes());
    }

    private JPanel criarPainelDados() {

        JPanel painelDados = new JPanel(new GridLayout(5, 1));

        JLabel lblNomeEmpresa = new JLabel("Nome Empresa:", JLabel.RIGHT);
        this.txtNomeEmpresa = new JTextField(CAMPO_TXT_LARGURA);
        JPanel pNomeEmpresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNomeEmpresa.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        pNomeEmpresa.add(lblNomeEmpresa);
        pNomeEmpresa.add(txtNomeEmpresa);

        JLabel lblTelemovel = new JLabel("Telemóvel:", JLabel.RIGHT);
        this.txtTelemovel = new JTextField(CAMPO_TXT_LARGURA);
        JPanel pTelemovel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pTelemovel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        pTelemovel.add(lblTelemovel);
        pTelemovel.add(txtTelemovel);

        JLabel lblAreaExpositor = new JLabel("Área do expositor:", JLabel.RIGHT);
        this.txtAreaExpositor = new JTextField(CAMPO_NUM_LARGURA);
        JPanel pAreaExpositor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pAreaExpositor.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        pAreaExpositor.add(lblAreaExpositor);
        pAreaExpositor.add(txtAreaExpositor);

        JLabel lblNumConvites = new JLabel("Número de Convites:", JLabel.RIGHT);
        this.txtNumConvites = new JTextField(CAMPO_NUM_LARGURA);
        JPanel pNumConvites = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNumConvites.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        pNumConvites.add(lblNumConvites);
        pNumConvites.add(txtNumConvites);

        painelDados.add(pNomeEmpresa);
        painelDados.add(criarPainelMorada());
        painelDados.add(pTelemovel);
        painelDados.add(pAreaExpositor);
        painelDados.add(pNumConvites);

        return painelDados;
    }

    private JPanel criarPainelProdutos() {

        JPanel pProdutos = new JPanel(new BorderLayout());

        JPanel pTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pTitulo.add(new JLabel("Lista de Produtos"));

        pProdutos.add(pTitulo, BorderLayout.NORTH);
        pProdutos.add(criarJListProdutos(), BorderLayout.CENTER);

        JPanel pBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBotao.add(criarBotaoAddProduto());

        pBotao.add(criarBotaoRemoveProduto());
        pProdutos.add(pBotao, BorderLayout.SOUTH);

        return pProdutos;
    }

    private JPanel criarPainelDemonstracoes() {
        JPanel pDemonstracoes = new JPanel(new BorderLayout());

        JPanel pTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pTitulo.add(new JLabel("Selecione as demonstrações pretendidas:"));

        pDemonstracoes.add(pTitulo, BorderLayout.NORTH);
        pDemonstracoes.add(criarScrollPaneDemonstrações(), BorderLayout.CENTER);
        pDemonstracoes.add(criarPainelConfirmar(), BorderLayout.SOUTH);

        return pDemonstracoes;
    }

    private JScrollPane criarScrollPaneDemonstrações() {
        listaDemonstracoesJTable = new JTable(new ModeloTabelaListaDemonstracao(listaDemonstracoes));
        listaDemonstracoesJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(listaDemonstracoesJTable);

        final int MARGEM_SUPERIOR = 20, MARGEM_INFERIOR = 20;
        final int MARGEM_ESQUERDA = 20, MARGEM_DIREITA = 20;
        scrollPane.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA,
                MARGEM_INFERIOR,
                MARGEM_DIREITA));

        return scrollPane;
    }

    private JPanel criarPainelConfirmar() {
        JPanel p = new JPanel();
        setBackground(Color.RED);

        p.add(criarBotaoConfirmar());

        return p;
    }

    private JButton criarBotaoConfirmar() {
        JButton btn = new JButton("Confirmar Dados");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO verificações
                String nomeEmpresa = txtNomeEmpresa.getText();
                String morada = txtMorada.getText();
                String telemovel = txtTelemovel.getText();
                float areaExpositor = Float.parseFloat(txtAreaExpositor.getText());
                int numeroConvites = Integer.parseInt(txtNumConvites.getText());
                controller.setDados(nomeEmpresa, morada, telemovel, areaExpositor, numeroConvites);

                List<Demonstracao> listaDemonstracoesSelecionadas = getListaDemonstracoesSelecionadas();
                controller.setListaDemonstracoes(listaDemonstracoesSelecionadas);

                String message = String.format("%s\n\nOs seus dados estão corretos?", controller.getCandidatura());
                int confirma = JOptionPane.showConfirmDialog(rootPane, message);

                if (confirma == JOptionPane.YES_OPTION) {
                    controller.registaCandidatura();
                    dispose();
                }
            }
        });
        return btn;
    }

    private List<Demonstracao> getListaDemonstracoesSelecionadas() {
        List<Demonstracao> listaDemonstracoesSelecionadas = new ArrayList<>();

        for (int row : listaDemonstracoesJTable.getSelectedRows()) {
            listaDemonstracoesSelecionadas.add(listaDemonstracoes.get(row));
        }

        return listaDemonstracoesSelecionadas;
    }

//    //ao alterar txtField não está a alterar no objeto enviado por parâmetro.
//    private JPanel criarPainelCampo(String lblTexto, JTextField txtField, int largura) {
//
//        JLabel lbl = new JLabel(lblTexto, JLabel.RIGHT);
//        lbl.setPreferredSize(LBL_TAMANHO);
//
//        txtField.setColumns(largura);
//
//        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
//
//        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
//                MARGEM_INFERIOR, MARGEM_DIREITA));
//        p.add(lbl);
//        p.add(txtField);
//
//        return p;
//    }
    private JPanel criarPainelMorada() {

        this.txtMorada = new JTextArea(4, CAMPO_TXT_LARGURA);
        JLabel lblMorada = new JLabel("Morada:", JLabel.RIGHT);
        JPanel pMorada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pMorada.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        pMorada.add(lblMorada);
        pMorada.add(this.txtMorada);

        return pMorada;
    }

    private JScrollPane criarJListProdutos() {

        this.setModeloListProdutos(new ModeloListProdutos(controller));

        this.jListProdutos = new JList(getModeloListProdutos());

        this.jListProdutos.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!jListProdutos.isSelectionEmpty()) {
                    btnRemoverProduto.setEnabled(true);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(jListProdutos);

        final int S_MARGEM_SUPERIOR = 20, S_MARGEM_INFERIOR = 20;
        final int S_MARGEM_ESQUERDA = 20, S_MARGEM_DIREITA = 20;
        scrollPane.setBorder(BorderFactory.createEmptyBorder(S_MARGEM_SUPERIOR,
                S_MARGEM_ESQUERDA,
                S_MARGEM_INFERIOR,
                S_MARGEM_DIREITA));

        return scrollPane;
    }

    private JButton criarBotaoAddProduto() {

        JButton btn = new JButton("Adiciona Produto");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new DialogNovoProduto(RegistarCandidaturaUI.this);
            }
        });

        return btn;
    }

    private JButton criarBotaoRemoveProduto() {

        this.btnRemoverProduto = new JButton("Eliminar Produto");
        this.btnRemoverProduto.setEnabled(false);

        this.btnRemoverProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int index = jListProdutos.getSelectedIndex();
                    boolean produtoRemovido = removerProduto(index);
                    if (produtoRemovido) {
                        btnRemoverProduto.setEnabled(false);
                        JOptionPane.showMessageDialog(rootPane,
                                "Produto removido com exito!",
                                "Remover Produto",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            RegistarCandidaturaUI.this,
                            ex.getMessage(),
                            "Erro a remover produto",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return this.btnRemoverProduto;
    }

    public boolean novoProduto(String designacao) {

        return this.modeloListProdutos.addRow(designacao);
    }

    public boolean removerProduto(int index) {

        return this.modeloListProdutos.removeRow(index);
    }

    @Override
    public void setExposicao(Exposicao exposicao) {
        exposicaoSelecionada = exposicao;

        this.controller.novaCandidatura(exposicao);
    }

    /**
     * Método para testar o UI.
     *
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {

        CentroExposicoes ce = new CentroExposicoes();

        List<Exposicao> listaExposicoes = new ArrayList<>();
        Exposicao e1 = new Exposicao();
        Exposicao e2 = new Exposicao();
        listaExposicoes.add(e1);
        listaExposicoes.add(e2);

        new RegistarCandidaturaUI(ce, new Representante());
    }

    /**
     * @return the modeloListProdutos
     */
    public ModeloListProdutos getModeloListProdutos() {
        return modeloListProdutos;
    }

    /**
     * @param modeloListProdutos the modeloListProdutos to set
     */
    public void setModeloListProdutos(ModeloListProdutos modeloListProdutos) {
        this.modeloListProdutos = modeloListProdutos;
    }
}
