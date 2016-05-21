/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Representa um template para o UI da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class GlobalJFrame extends JFrame
{
    /**
     * Título da janela da aplicação por omissão.
     */
    private static final String APPLICATION_WINDOW_TITLE = "Centro de Exposições ISEP v0.1";
    
    public GlobalJFrame()
    {
        super(APPLICATION_WINDOW_TITLE);
        
        setJMenuBar(new GlobalJMenuBar());
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
