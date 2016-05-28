/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.controller.RegistarCandidaturaController;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Demonstracao;
import centroexposicoes.model.Exposicao;
import centroexposicoes.ui.components.DialogNovoProduto;
import centroexposicoes.ui.components.DialogSelecionarExposicao;
import centroexposicoes.ui.components.ExposicaoSelecionavel;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.ui.components.ModeloListProdutos;
import centroexposicoes.ui.components.ModeloTabelaListaDemonstracao;
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
import javax.swing.border.TitledBorder;
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
    /**
     * Lista de exposições.
     */
    private final List<Exposicao> listaExposicoes;
    /**
     * Lista de demonstrações.
     */
    private List<Demonstracao> listaDemonstracoes;
    /**
     * Controller do Registar candidaturas.
     */
    private final RegistarCandidaturaController controller;
    /**
     * Centro de exposições.
     */
    private final CentroExposicoes centroExposicoes;

    /**
     * ModelList para expor a lista de produtos.
     */
    private ModeloListProdutos modeloListProdutos;
    /**
     * lista UI da lista dos produtos.
     */
    private JList jListProdutos;
    /**
     * tabela UI da lista dos produtos.
     */
    private JTable listaDemonstracoesJTable;
    /**
     * Botão remover produto.
     */
    private JButton btnRemoverProduto;

    /**
     * Campo de texto para o nome da empresa.
     */
    private JTextField txtNomeEmpresa;
    /**
     * Campo de texto para a morada.
     */
    private JTextArea txtMorada;
    /**
     * Campo de texto para o nome da empresa.
     */
    private JTextField txtTelemovel;
    /**
     * Campo de texto para a area do expositor.
     */
    private JTextField txtAreaExpositor;
    /**
     * Campo de texto para o número de convites.
     */
    private JTextField txtNumConvites;

    /**
     * Dimensão standard de um label.
     */
    final Dimension LBL_TAMANHO = new Dimension(94, 16);
    /**
     * Dimensão da janela.
     */
    final Dimension JANELA_TAMANHO = new Dimension(1200, 600);
    /**
     * Margens de um campo.
     */
    final int MARGEM_S_CAMPO = 0, MARGEM_I_CAMPO = 0,
            MARGEM_E_CAMPO = 10, MARGEM_D_CAMPO = 0;
    /**
     * Largura dos campos.
     */
    final int CAMPO_TXT_LARGURA = 20, CAMPO_NUM_LARGURA = 6;
    /**
     * Border vazio para criar insets.
     */
    final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);
    /**
     * Dimensão de um scroll.
     */
    final Dimension SCROLL_TAMANHO = new Dimension(300, 500);

    /**
     * Constroi uma instância de RegistarCandidaturasUI.
     *
     * @param centroExposicoes centro de exposições
     */
    public RegistarCandidaturaUI(CentroExposicoes centroExposicoes) {
        super(centroExposicoes);

        this.centroExposicoes = centroExposicoes;
        this.controller = new RegistarCandidaturaController(centroExposicoes);

        this.listaExposicoes = controller.getExposições();

        new DialogSelecionarExposicao<>(this, this.listaExposicoes, centroExposicoes);
        if (this.exposicaoSelecionada == null) {
            dispose();
        } else {

            controller.novaCandidatura(exposicaoSelecionada);
            this.listaDemonstracoes = controller.getListaDemonstracoes();

            setLayout(new GridLayout(1, 3));
            criarComponentes();

            pack();
            setSize(JANELA_TAMANHO);
            setMinimumSize(new Dimension(getWidth(), getHeight()));
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    /**
     * Cria os componentes da janela.
     */
    private void criarComponentes() {

        add(criarPainelDados());
        add(criarPainelProdutos());
        add(criarPainelDemonstracoes());
    }

    /**
     * Devolve o painel com os campos para colocar os dados.
     *
     * @return o painel com os campos para colocar os dados
     */
    private JPanel criarPainelDados() {

        JPanel painelDados = new JPanel(new FlowLayout(FlowLayout.TRAILING, 10, 10));

        JLabel lblNomeEmpresa = new JLabel("Nome Empresa:", JLabel.RIGHT);
        lblNomeEmpresa.setSize(LBL_TAMANHO);
        this.txtNomeEmpresa = new JTextField(CAMPO_TXT_LARGURA);
        JPanel pNomeEmpresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNomeEmpresa.setBorder(new EmptyBorder(MARGEM_S_CAMPO, MARGEM_E_CAMPO,
                MARGEM_I_CAMPO, MARGEM_D_CAMPO));
        pNomeEmpresa.add(lblNomeEmpresa);
        pNomeEmpresa.add(txtNomeEmpresa);

        JLabel lblTelemovel = new JLabel("Telemóvel:", JLabel.RIGHT);
        lblTelemovel.setSize(LBL_TAMANHO);
        this.txtTelemovel = new JTextField(CAMPO_TXT_LARGURA);
        JPanel pTelemovel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pTelemovel.setBorder(new EmptyBorder(MARGEM_S_CAMPO, MARGEM_E_CAMPO,
                MARGEM_I_CAMPO, MARGEM_D_CAMPO));
        pTelemovel.add(lblTelemovel);
        pTelemovel.add(txtTelemovel);

        JLabel lblAreaExpositor = new JLabel("Área do expositor:", JLabel.RIGHT);
        lblAreaExpositor.setSize(LBL_TAMANHO);
        this.txtAreaExpositor = new JTextField(CAMPO_NUM_LARGURA);
        JPanel pAreaExpositor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pAreaExpositor.setBorder(new EmptyBorder(MARGEM_S_CAMPO, MARGEM_E_CAMPO,
                MARGEM_I_CAMPO, MARGEM_D_CAMPO));
        pAreaExpositor.add(lblAreaExpositor);
        pAreaExpositor.add(txtAreaExpositor);

        JLabel lblNumConvites = new JLabel("Número de Convites:", JLabel.RIGHT);
        lblNumConvites.setSize(LBL_TAMANHO);
        this.txtNumConvites = new JTextField(CAMPO_NUM_LARGURA);
        JPanel pNumConvites = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNumConvites.setBorder(new EmptyBorder(MARGEM_S_CAMPO, MARGEM_E_CAMPO,
                MARGEM_I_CAMPO, MARGEM_D_CAMPO));
        pNumConvites.add(lblNumConvites);
        pNumConvites.add(txtNumConvites);

        painelDados.add(pNomeEmpresa);
        painelDados.add(criarPainelMorada());
        painelDados.add(pTelemovel);
        painelDados.add(pAreaExpositor);
        painelDados.add(pNumConvites);

        return painelDados;
    }

    /**
     * Devolve o painel com os produtos e os botões para adicionar/remover
     * produtos.
     *
     * @return o painel com os produtos e os botões para adicionar/remover
     * produtos
     */
    private JPanel criarPainelProdutos() {

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(PADDING_BORDER);

        JPanel pBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBotao.add(criarBotaoAddProduto());
        pBotao.add(criarBotaoRemoveProduto());

        painel.add(criarScrollPaneProdutos(), BorderLayout.NORTH);
        painel.add(pBotao, BorderLayout.CENTER);

        return painel;
    }

    /**
     * Devolve o painel com as demonstrações.
     *
     * @return o painel com as demonstrações
     */
    private JPanel criarPainelDemonstracoes() {

        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(PADDING_BORDER);

        painel.add(criarScrollPaneDemonstrações(), BorderLayout.NORTH);
        painel.add(criarPainelBotoesConfirmar(), BorderLayout.SOUTH);

        return painel;
    }

    /**
     * Devolve o scroll qie incorpora a lista de demonstrações
     *
     * @return o scroll qie incorpora a lista de demonstrações
     */
    private JPanel criarScrollPaneDemonstrações() {

        JPanel painelScroll = new JPanel(new GridLayout());
        painelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Selecione as demonstrações pretendidas:", TitledBorder.LEFT, TitledBorder.TOP));

        listaDemonstracoesJTable = new JTable(new ModeloTabelaListaDemonstracao(listaDemonstracoes));
        listaDemonstracoesJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(listaDemonstracoesJTable);
        scrollPane.setBorder(PADDING_BORDER);

        painelScroll.setMinimumSize(scrollPane.getMinimumSize());
        painelScroll.add(scrollPane);

        return painelScroll;
    }

    /**
     * Devolve o scroll que incorpora a lista de produtos
     *
     * @return o scroll que incorpora a lista de produtos
     */
    private JPanel criarScrollPaneProdutos() {

        JPanel painelScroll = new JPanel(new GridLayout());
        painelScroll.setBorder(BorderFactory.createTitledBorder(PADDING_BORDER,
                "Lista de Produtos:", TitledBorder.LEFT, TitledBorder.TOP));

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
        scrollPane.setBorder(PADDING_BORDER);

        painelScroll.add(scrollPane);

        return painelScroll;
    }

    /**
     * Cria o painel com os botões confirmar e cancelar.
     *
     * @return o painel com os botões confirmar e cancelar
     */
    private JPanel criarPainelBotoesConfirmar() {
        JPanel p = new JPanel(new FlowLayout());
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());

        return p;
    }

    /**
     * Cria o botão confirmar.
     *
     * @return o botão confirmar
     */
    private JButton criarBotaoConfirmar() {
        JButton btn = new JButton("Confirmar Dados");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtNomeEmpresa.getText().isEmpty()
                            || txtNomeEmpresa.getText().isEmpty()
                            || txtMorada.getText().isEmpty()
                            || txtTelemovel.getText().isEmpty()
                            || txtAreaExpositor.getText().isEmpty()
                            || txtNumConvites.getText().isEmpty()) {
                        throw new IllegalArgumentException("Dados em falta.");
                    }
                    if (jListProdutos.getModel().getSize() < 1) {
                        throw new IllegalArgumentException("Defina pelo menos um produto.");
                    }

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
                        new LoginUI(centroExposicoes);
                    }

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            rootPane,
                            ex.getMessage(),
                            "Número inválido",
                            JOptionPane.WARNING_MESSAGE);
                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            rootPane,
                            ex.getMessage(),
                            "Dados inválidos",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return btn;
    }

    /**
     * Cria o botão cancelar.
     *
     * @return o botão cancelar
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
     * Devolve a lista demonstracões selecionadas.
     *
     * @return a lista demonstracões selecionadas
     */
    private List<Demonstracao> getListaDemonstracoesSelecionadas() {
        List<Demonstracao> listaDemonstracoesSelecionadas = new ArrayList<>();

        for (int row : listaDemonstracoesJTable.getSelectedRows()) {
            listaDemonstracoesSelecionadas.add(listaDemonstracoes.get(row));
        }

        return listaDemonstracoesSelecionadas;
    }

    /**
     * Cria o painel com a morada.
     *
     * @return o painel com a morada
     */
    private JPanel criarPainelMorada() {

        this.txtMorada = new JTextArea(4, CAMPO_TXT_LARGURA);
        JLabel lblMorada = new JLabel("Morada:", JLabel.RIGHT);
        JPanel pMorada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pMorada.setBorder(new EmptyBorder(MARGEM_S_CAMPO, MARGEM_E_CAMPO,
                MARGEM_I_CAMPO, MARGEM_D_CAMPO));
        pMorada.add(lblMorada);
        pMorada.add(this.txtMorada);

        return pMorada;
    }

    /**
     * Cria o Botão para adicionar um produto.
     *
     * @return o Botão para adicionar um produto
     */
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

    /**
     * Cria o Botão para remover um produto.
     *
     * @return o Botão para remover um produto
     */
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

    /**
     * Cria um novo produto.
     *
     * @param designacao designação do produto
     * @return um novo produto
     */
    public boolean novoProduto(String designacao) {

        return this.modeloListProdutos.addRow(designacao);
    }

    /**
     * Remove um produto.
     *
     * @param index index do produto na lista de produtos.
     * @return um produto
     */
    public boolean removerProduto(int index) {

        return this.modeloListProdutos.removeRow(index);
    }

    /**
     * Devolve o modelo da lista de produtos.
     *
     * @return o modelo da lista de produtos
     */
    public ModeloListProdutos getModeloListProdutos() {
        return modeloListProdutos;
    }

    /**
     * Modifica o modelo da lista de produtos.
     *
     * @param modeloListProdutos o modelo da lista de produtos
     */
    public void setModeloListProdutos(ModeloListProdutos modeloListProdutos) {
        this.modeloListProdutos = modeloListProdutos;
    }

    /**
     * Modifica a exposição selecionada.
     *
     * @param exposicao exposição selecionada.
     */
    @Override
    public void setExposicao(Exposicao exposicao) {

        exposicaoSelecionada = exposicao;
    }
}
