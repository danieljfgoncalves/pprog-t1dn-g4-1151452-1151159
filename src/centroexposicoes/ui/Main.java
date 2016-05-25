/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.FicheiroCentroExposicoes;

/**
 * Classe para o arranque da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Main
{

    /**
     * Método de arranque.
     * 
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args)
    {
        FicheiroCentroExposicoes ficheiroCentroExposicoes = new FicheiroCentroExposicoes();
        
        CentroExposicoes centroExposicoes = ficheiroCentroExposicoes.ler(FicheiroCentroExposicoes.NOME);
        
        if (centroExposicoes == null) {
            //TODO se não for possível ler a partir do ficheiro binário, ler apartir do ficheiro de texto.
        }
        
        //new LoginUI(centroExposicoes, ficheiroCentroExposicoes);
    }
    
}
