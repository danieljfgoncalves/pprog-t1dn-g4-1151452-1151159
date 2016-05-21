/*
 * Fornece classes para componentes do UI do centro de exposições.
 */
package centroexposicoes.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Representa o menubar da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class GlobalJMenuBar extends JMenuBar
{
    /**
     * Valor de opções.
     */
    private static final String OPCOES = "Opções";
    /**
     * Valor de terminar sessão.
     */
    private static final String TERMINAR_SESSAO = "Terminar sessão";
    
    /**
     * Constrói uma instância de GlobalJMenuBar por omissão.
     */
    public GlobalJMenuBar()
    {
        JMenu menuOpcoes = new JMenu(OPCOES);
        menuOpcoes.setMnemonic(KeyEvent.VK_O);
        
        JMenuItem menuItemTerminarSessao = new JMenuItem(TERMINAR_SESSAO, 'T');
        menuItemTerminarSessao.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));
        
        menuItemTerminarSessao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO ir para a janela principal de selecionar utilizador.
            }
        });
        
        menuOpcoes.add(menuItemTerminarSessao);
        
        add(menuOpcoes);
    }
    
}
