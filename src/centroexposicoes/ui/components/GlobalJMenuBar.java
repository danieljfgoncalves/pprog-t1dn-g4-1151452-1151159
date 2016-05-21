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
     * Opção sair do menu.
     */
    private JMenuItem menuItemSair;
    /**
     * Opção terminar sessão do menu.
     */
    private JMenuItem menuItemTerminarSessao;
    /**
     * Valor de opções.
     */
    private static final String OPCOES = "Opções";
    /**
     * Valor de terminar sessão.
     */
    private static final String TERMINAR_SESSAO = "Terminar sessão";
    /**
     * Valor de sair.
     */
    private static final String SAIR = "Sair";
    
    /**
     * Constrói uma instância de GlobalJMenuBar por omissão.
     */
    public GlobalJMenuBar()
    {
        JMenu menuOpcoes = new JMenu(OPCOES);
        menuOpcoes.setMnemonic(KeyEvent.VK_O);
        
        menuItemTerminarSessao = new JMenuItem(TERMINAR_SESSAO, 'T');
        menuItemTerminarSessao.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));
        
        menuItemSair = new JMenuItem(SAIR, 'S');
        menuItemSair.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        
        menuItemTerminarSessao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO ir para a janela principal de selecionar utilizador.
            }
        });
        
        menuOpcoes.add(menuItemTerminarSessao);
        menuOpcoes.add(menuItemSair);
        
        add(menuOpcoes);
    }

    /**
     * Devolve o item sair do menu.
     * 
     * @return item sair do menu
     */
    public JMenuItem getMenuItemSair() {
        return menuItemSair;
    }
    /**
     * Modifica o item sair do menu.
     * 
     * @param menuItemSair item sair do menu
     */
    public void setMenuItemSair(JMenuItem menuItemSair) {
        this.menuItemSair = menuItemSair;
    }
    /**
     * Devolve o item terminar sessão do menu.
     * 
     * @return item terminar sessão do menu
     */
    public JMenuItem getMenuItemTerminarSessao() {
        return menuItemTerminarSessao;
    }
    /**
     * Modifica o item terminar sessão do menu.
     * 
     * @param menuItemTerminarSessao item terminar sessão do menu
     */
    public void setMenuItemTerminarSessao(JMenuItem menuItemTerminarSessao) {
        this.menuItemTerminarSessao = menuItemTerminarSessao;
    }
    
    
}
