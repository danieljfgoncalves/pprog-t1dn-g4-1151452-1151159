/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Representante;
import centroexposicoes.ui.RegistarCandidaturaUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 * Interface gráfica de um diálogo para selecionar uma exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @param <T>
 */
public class DialogSelecionarExposicao<T extends GlobalJFrame & ExposicaoSelecionavel> extends JDialog
{
    /**
     * Janela que instância o diálogo.
     */
    private T framePai;
    /**
     * Lista com as exposições.
     */
    private List<Exposicao> listaExposicoes;
    /**
     * Tabela cmo as exposições.
     */
    private JTable listaExposicoesJTable;
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
    public DialogSelecionarExposicao(T framePai, List<Exposicao> listaExposicoes)
    {
        super(framePai, TITULO, true);
        
        this.framePai = framePai;
        this.listaExposicoes = listaExposicoes;
        
        criarComponentes();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    /**
     * Cria os componentes da interface gráfica.
     */
    private void criarComponentes()
    {
        JPanel p1 = criarPainelSelecionarExposicao();
        JScrollPane p2 = criarPainelListaExposicoes();
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
    private JScrollPane criarPainelListaExposicoes()
    {
        listaExposicoesJTable = new JTable(new ModeloTabelaListaExposicao(listaExposicoes));
        listaExposicoesJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(listaExposicoesJTable);

        final int MARGEM_SUPERIOR = 20, MARGEM_INFERIOR = 20;
        final int MARGEM_ESQUERDA = 20, MARGEM_DIREITA = 20;
        scrollPane.setBorder(BorderFactory.createEmptyBorder( MARGEM_SUPERIOR, 
                                                              MARGEM_ESQUERDA,
                                                              MARGEM_INFERIOR, 
                                                              MARGEM_DIREITA));

        return scrollPane;
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
                framePai.setExposicao(listaExposicoes.get(listaExposicoesJTable.getSelectedRow()));
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
        List<Exposicao> listaExposicoes = new ArrayList<>();
        Exposicao e1 = new Exposicao();
        Exposicao e2 = new Exposicao();
        listaExposicoes.add(e1);
        listaExposicoes.add(e2);
        
        CentroExposicoes ce =new CentroExposicoes();
        
        RegistarCandidaturaUI framePai = new RegistarCandidaturaUI(ce, new Representante());
        
        new DialogSelecionarExposicao(framePai, listaExposicoes);
    }
}
