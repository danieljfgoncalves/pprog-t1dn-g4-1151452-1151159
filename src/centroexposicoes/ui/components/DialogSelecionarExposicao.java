/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.Exposicao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Interface gráfica de um diálogo para selecionar uma exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class DialogSelecionarExposicao extends JDialog
{
    /**
     * Janela que instância o diálogo.
     */
    private GlobalJFrame framePai;
    /**
     * Título da janela.
     */
    private static final String TITULO = "Selecionar exposicao";
    /**
     * Texto selecionar exposição.
     */
    private static final String SELECIONAR_EXPOSICAO = "Selecione uma exposicao:";
    
    
    /**
     * Constrói um diálogo para selecionar uma exposição.
     */
    public DialogSelecionarExposicao(GlobalJFrame framePai, List<Exposicao> listaExposicoes)
    {
        super(framePai, TITULO, true);
        
        this.framePai = framePai;
        
        criarComponentes(listaExposicoes);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    /**
     * Cria os componentes da interface gráfica.
     */
    private void criarComponentes(List<Exposicao> listaExposicoes)
    {
        JPanel p1 = criarPainelSelecionarExposicao();
        JPanel p2 = criarPainelListaExposicoes(listaExposicoes);
        JPanel p3 = criarPainelBotoes();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }
    
    /**
     * Cria o painel superior com a label para selecionar a exposição.
     * 
     * @return painel superior.
     */
    private JPanel criarPainelSelecionarExposicao()
    {
        JLabel lbl = new JLabel(SELECIONAR_EXPOSICAO, JLabel.CENTER);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);

        return p;
    }
    
    /**
     * Cria o painel central com a lista de exposições.
     * 
     * @param listaExposicoes lista de exposições
     * @return painel com lista de exposições
     */
    private JPanel criarPainelListaExposicoes(List<Exposicao> listaExposicoes)
    {
        String[] exposicoes = new String[listaExposicoes.size()];
        for (int i = 0; i < exposicoes.length; i++) {
            exposicoes[i] = listaExposicoes.get(i).getTitulo();
        }
        JList listaExposicoesJList = new JList<>(exposicoes);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(listaExposicoesJList);

        return p;
    }
    
    /**
     * Cria o painel inferior com botões.
     * 
     * @return painel inferior.
     */
    private JPanel criarPainelBotoes() {
        JButton btnSelecionarExposicao = criarBotaoSelecionarExposicao();
        getRootPane().setDefaultButton(btnSelecionarExposicao);
        
        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnSelecionarExposicao);

        return p;
    }
    
    /**
     * Cria o botão selecionar exposição.
     * 
     * @return botão selecionar exposição
     */
    private JButton criarBotaoSelecionarExposicao() {
        JButton btn = new JButton("Selecionar Exposição");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO fechar janela e enviar exposicao seleciona
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
        List<Exposicao> listaExposicoes = new ArrayList<>();
        Exposicao e1 = new Exposicao();
        Exposicao e2 = new Exposicao();
        listaExposicoes.add(e1);
        listaExposicoes.add(e2);
        GlobalJFrame framePai = new GlobalJFrame();
        
        new DialogSelecionarExposicao(framePai, listaExposicoes);
    }
}
