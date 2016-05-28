/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.utils.FicheiroCentroExposicoes;
import centroexposicoes.utils.FicheiroTxt;

/**
 * Classe para o arranque da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Main {

    /**
     * Método de arranque.
     *
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {

        CentroExposicoes centroExposicoes = FicheiroCentroExposicoes.ler(FicheiroCentroExposicoes.NOME);

        if (centroExposicoes == null) {
            //TODO se não for possível ler a partir do ficheiro binário, ler apartir do ficheiro de texto.
            centroExposicoes = FicheiroTxt.carregarCentroExposicoes();
            
            if (centroExposicoes == null) { 
                //se não for lido com sucesso do ficheiro txt.
                System.out.printf("Carregou o instanciador por defeito? %s%n%n", FicheiroCentroExposicoes.guardarCentroDefault(FicheiroCentroExposicoes.NOME));
                centroExposicoes = FicheiroCentroExposicoes.ler(FicheiroCentroExposicoes.NOME);
            }
        }
        
        centroExposicoes.setRegistoMecanismos();
        new LoginUI(centroExposicoes);
    }

}
