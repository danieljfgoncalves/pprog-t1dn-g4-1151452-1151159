/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.model.Exposicao;
import centroexposicoes.ui.components.ExposicaoSelecionavel;
import centroexposicoes.ui.components.GlobalJFrame;

/**
 * Interface gráfica para o registo de candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistarCandidaturaUI extends GlobalJFrame implements ExposicaoSelecionavel
{
    /**
     * Exposição selecionada pelo UI.
     */
    private Exposicao exposicaoSelecionada;
    
    public RegistarCandidaturaUI()
    {
        
    }
    
    /**
     * Método para testar o UI.
     *  
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        new RegistarCandidaturaUI();
    }

    @Override
    public void setExposicao(Exposicao exposicao) {
        exposicaoSelecionada = exposicao;
    }
}
