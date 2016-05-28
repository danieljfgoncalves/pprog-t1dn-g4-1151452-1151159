/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Avaliacao;
import centroexposicoes.ui.AvaliarCandidaturaUI;
import centroexposicoes.utils.Validar;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Interface gráfica de um diálogo para avaliar uma candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class DialogNovaAvaliacao extends JDialog {

    /**
     * Janela que instância o diálogo.
     */
    private AvaliarCandidaturaUI framePai;

    /**
     * RadioButtom aceitar.
     */
    private JRadioButton botaoRadioAceitar;

    /**
     * RadioButtom recursar.
     */
    private JRadioButton botaoRadioRecusar;

    /**
     * Texto justificativo.
     */
    private JTextArea txtJustificacao;

    /**
     * Título do diálogo.
     */
    private static final String TITULO = "Nova avaliação";

    /**
     * Constrói um diálogo nova avaliação recebendo o frame pai.
     *
     * @param framePai frame pai
     */
    public DialogNovaAvaliacao(AvaliarCandidaturaUI framePai) {
        super(framePai, TITULO, true);
        this.framePai = framePai;

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
        JPanel panelComponents = new JPanel(new BorderLayout(0, 10));
        panelComponents.add(criarPainelDecisao(), BorderLayout.NORTH);
        panelComponents.add(criarPainelJustificacao(), BorderLayout.CENTER);
        panelComponents.add(criarPainelBotoes(), BorderLayout.SOUTH);
        panelComponents.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelComponents);
    }

    /**
     * Cria o painel com os botões da decisão.
     *
     * @return painel de decisão
     */
    private JPanel criarPainelDecisao() {
        JPanel painelDecisao = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));

        botaoRadioAceitar = new JRadioButton("Aceitar");
        botaoRadioRecusar = new JRadioButton("Recusar");
        ButtonGroup botaoRadioGrupo = new ButtonGroup();
        botaoRadioGrupo.add(botaoRadioAceitar);
        botaoRadioGrupo.add(botaoRadioRecusar);

        painelDecisao.add(botaoRadioAceitar);
        painelDecisao.add(botaoRadioRecusar);

        return painelDecisao;
    }

    /**
     * Cria o painel para a justificação.
     *
     * @return painel de justificação
     */
    private JPanel criarPainelJustificacao() {
        JPanel painelJustificao = new JPanel(new BorderLayout(0, 10));

        JLabel labelJustificao = new JLabel("Justificação:", SwingConstants.CENTER);
        txtJustificacao = new JTextArea(6, 50);

        painelJustificao.add(labelJustificao, BorderLayout.NORTH);
        painelJustificao.add(txtJustificacao, BorderLayout.CENTER);

        return painelJustificao;
    }

    /**
     * Cria painel de botões.
     *
     * @return painel de botões
     */
    private JPanel criarPainelBotoes() {
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 0));

        painelBotoes.add(criarBotaoSubmeterAvaliacao());
        painelBotoes.add(criarBotaoCancelar());

        return painelBotoes;
    }

    /**
     * Cria o botão de submeter avaliação.
     *
     * @return botão de submeter avaliação
     */
    private JButton criarBotaoSubmeterAvaliacao() {
        JButton botaoSubmeterAvaliacao = new JButton("Submeter Avaliação");

        botaoSubmeterAvaliacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!(botaoRadioAceitar.isSelected() || botaoRadioRecusar.isSelected()) || !Validar.validaString(txtJustificacao.getText())) {
                        throw new IllegalArgumentException();
                    }
                    framePai.registaAvaliacao(botaoRadioAceitar.isSelected() ? Avaliacao.TipoAvaliacao.Aprovado : Avaliacao.TipoAvaliacao.Rejeitado, txtJustificacao.getText());
                    dispose();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Avaliação inválida! Insira todos os dados necessários.",
                            TITULO, JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return botaoSubmeterAvaliacao;
    }

    /**
     * Cria o botão cancelar.
     *
     * @return botão cancelar
     */
    private JButton criarBotaoCancelar() {
        JButton botaoCancelar = new JButton("Cancelar");

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return botaoCancelar;
    }
}
