/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * Representa um template para o UI da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class GlobalJFrame extends JFrame {

    /**
     * Título da janela da aplicação por omissão.
     */
    private static final String APPLICATION_WINDOW_TITLE = "Centro de Exposições ISEP v0.1";

    public GlobalJFrame() {
        super(APPLICATION_WINDOW_TITLE);

        setJMenuBar(criarGlobalJMenuBar());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sair();
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private JMenuBar criarGlobalJMenuBar() {
        GlobalJMenuBar menuBar = new GlobalJMenuBar();
        menuBar.getMenuItemSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
        return menuBar;
    }

    private void sair() {
        //TODO guardar ficheiro bin. Possível diálogo?
        dispose();
    }
}
