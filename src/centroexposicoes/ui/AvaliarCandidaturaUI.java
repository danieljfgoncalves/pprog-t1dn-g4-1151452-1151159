package centroexposicoes.ui;

import centroexposicoes.controller.AvaliarCandidaturasController;
import centroexposicoes.model.Atribuicao;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Fae;
import centroexposicoes.ui.components.GlobalJFrame;
import centroexposicoes.ui.components.ModelListAtribuicoes;
import centroexposicoes.ui.components.ModelListExposicoes;
import centroexposicoes.utils.InstanciadorPorDefeito;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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

    private AvaliarCandidaturasController controller;

    private List<Exposicao> listaExposicoes;
    private JList<Exposicao> jListaExposicoes;

    private List<Atribuicao> listaAtribuicoes;
    private JList<Atribuicao> jListaAtribuicoes;

    private JButton botaoVerCandidatura;
    private JButton botaoAvaliarCandidatura;
    
    private static final Dimension DIMENSAO_JANELA = new Dimension(600, 400);

    public AvaliarCandidaturaUI(CentroExposicoes centroExposicoes, Fae fae) {
        this.controller = new AvaliarCandidaturasController(centroExposicoes, fae);
        this.listaExposicoes = controller.getListaExposicoesDoFae();

        criarComponentes();

        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setSize(DIMENSAO_JANELA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void criarComponentes() {
        add(criarPainelListas(), BorderLayout.CENTER);
        add(criarPainelBotoes(), BorderLayout.SOUTH);
    }

    private JPanel criarPainelListas() {
        JPanel painelListas = new JPanel(new GridLayout(1, 2));

        painelListas.add(criarPainelExposicoes());
        painelListas.add(criarPainelAtribuicoes());

        return painelListas;
    }

    private JPanel criarPainelExposicoes() {
        JPanel painelExposicoes = new JPanel(new BorderLayout());

        JLabel labelTitulo = new JLabel("Selecione uma exposição:", SwingConstants.CENTER);
        jListaExposicoes = new JList();
        jListaExposicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListaExposicoes.setModel(new ModelListExposicoes(listaExposicoes));
        
        this.jListaExposicoes.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                listaAtribuicoes = controller.getListaAtribuicoesPorAvaliar(listaExposicoes.get(jListaExposicoes.getSelectedIndex()));
                jListaAtribuicoes.setModel(new ModelListAtribuicoes(listaAtribuicoes));
            }
        });
        
        JScrollPane jScrollExposicoes = new JScrollPane(jListaExposicoes);

        painelExposicoes.add(labelTitulo, BorderLayout.NORTH);
        painelExposicoes.add(jScrollExposicoes, BorderLayout.CENTER);

        return painelExposicoes;
    }

    private JPanel criarPainelAtribuicoes() {
        JPanel painelAtribuicoes = new JPanel(new BorderLayout());

        JLabel labelTitulo = new JLabel("Selecione uma atribuição:", SwingConstants.CENTER);
        jListaAtribuicoes = new JList();
        jListaAtribuicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jListaAtribuicoes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                botaoVerCandidatura.setEnabled(true);
                botaoAvaliarCandidatura.setEnabled(true);
            }
        });
        
        JScrollPane jScrollAtribuicoes = new JScrollPane(jListaAtribuicoes);

        painelAtribuicoes.add(labelTitulo, BorderLayout.NORTH);
        painelAtribuicoes.add(jScrollAtribuicoes, BorderLayout.CENTER);

        return painelAtribuicoes;
    }

    private JPanel criarPainelBotoes() {
        JPanel painelBotoes = new JPanel(new GridLayout(1, 3));

        painelBotoes.add(criarBotaoVerCandidatura());
        painelBotoes.add(criarBotaoAvaliarCandidatura());
        painelBotoes.add(criarBotaoSair());

        return painelBotoes;
    }

    private JButton criarBotaoVerCandidatura() {
        botaoVerCandidatura = new JButton("Ver Candidatura");
        botaoVerCandidatura.setEnabled(false);

        botaoVerCandidatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO abrir diálogo ver candidatura
            }
        });

        return botaoVerCandidatura;
    }

    private JButton criarBotaoAvaliarCandidatura() {
        botaoAvaliarCandidatura = new JButton("Avaliar Candidatura");
        botaoAvaliarCandidatura.setEnabled(false);

        botaoAvaliarCandidatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO abrir diálogo nova avaliação
            }
        });

        return botaoAvaliarCandidatura;
    }

    private JButton criarBotaoSair() {
        JButton botaoSair = new JButton("Sair");

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return botaoSair;
    }

    public static void main(String[] args) {
        CentroExposicoes ce = InstanciadorPorDefeito.getCentroExposicoesPorDefeito();
        Fae f = ce.getRegistoExposicoes().getListaExposicoes().get(0).getListaFaes().getListaFaes().get(0);
        new AvaliarCandidaturaUI(ce, f);
    }
}