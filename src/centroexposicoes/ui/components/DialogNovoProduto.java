/**
 * Fornece as classes que comunicam com o modelo e a interface gráfica.
 */
package centroexposicoes.ui.components;

import centroexposicoes.ui.RegistarCandidaturaUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Interface gráfica para criar um novo produto.
 *
 * @author Daniel Goncalves 1151452
 * @author Ivo Ferro 1151159
 */
public class DialogNovoProduto extends JDialog {

    /**
     * Janela que instância o dialogo.
     */
    private RegistarCandidaturaUI framePai;

    /**
     * Textfield onde o utilizador introduz a designação de um produto.
     */
    private JTextField txtDesignacao;

    /**
     * Constrói uma instância de DialogNovoProduto recebendo como paramêtro o
     * frame pai.
     *
     * @param framePai frame de onde o dialog será executado em modo modal.
     */
    public DialogNovoProduto(RegistarCandidaturaUI framePai) {
        super(framePai, "Novo Produto", true);
        this.framePai = framePai;

        criarPaineis();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    /**
     * Cria os paineis do UI.
     */
    private void criarPaineis() {

        JPanel pNorte = criarPainelNorte();
        JPanel pSul = criarPainelSul();

        add(pNorte, BorderLayout.NORTH);
        add(pSul, BorderLayout.CENTER);

    }

    /**
     * Devolve o painel norte com os seus componentes.
     *
     * @return o painel norte com os seus componentes.
     */
    private JPanel criarPainelNorte() {

        JLabel lblDesignacao = new JLabel("Designação:", JLabel.RIGHT);

        final int CAMPO_LARGURA = 20;
        this.txtDesignacao = new JTextField(CAMPO_LARGURA);

        JPanel painelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        painelNorte.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        painelNorte.add(lblDesignacao);
        painelNorte.add(this.txtDesignacao);

        return painelNorte;
    }

    /**
     * Devolve o painel sul com os seus componentes.
     *
     * @return o painel sul com os seus componentes.
     */
    private JPanel criarPainelSul() {

        JButton btnOK = criarBotaoOK();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = criarBotaoCancelar();

        JPanel painelSul = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        painelSul.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        painelSul.add(btnOK);
        painelSul.add(btnCancelar);

        return painelSul;
    }

    /**
     * Devolve o o botão ok.
     *
     * @return o botão ok.
     */
    private JButton criarBotaoOK() {

        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String designacao = txtDesignacao.getText();
                    if (designacao.length() < 1) {
                        throw new IllegalArgumentException("Designção não é válida! Introduza novamente.");
                    }

                    boolean produtoAdicionado = framePai.novoProduto(designacao);

                    if (!produtoAdicionado) {
                        throw new IllegalArgumentException("O produto ja existe! Introduza outro.");
                    } else {
                        JOptionPane.showMessageDialog(rootPane,
                                "Produto adicionado com exito!",
                                "Adicionar Produto",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    dispose();

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            framePai,
                            ex.getMessage(),
                            "Designação inválida",
                            JOptionPane.WARNING_MESSAGE);
                    txtDesignacao.requestFocusInWindow();
                }
            }
        }
        );

        return btn;
    }

    /**
     * Devolve o o botão cancelar.
     *
     * @return o botão cancelar.
     */
    private JButton criarBotaoCancelar() {

        JButton btn = new JButton("Cancelar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        return btn;
    }

    /**
     * Método para testar o UI.
     *
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {

//        DialogNovoProduto dialog = new DialogNovoProduto(new RegistarCandidaturaUI());
    }
}
