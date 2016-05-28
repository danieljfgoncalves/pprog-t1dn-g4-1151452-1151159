/*
 * Fornece as classe que controlam a interface gráfica.
 */
package centroexposicoes.ui;

import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.utils.FicheiroCentroExposicoes;

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
            if (false) { //se lido com sucesso do ficheiro txt.
                //TODO ler apartir do ficheiro de texto
            } else {
                //Caso não consiga ler nem pelo ficheiro binário 
                //e nem pelo ficheiro de texto, gerar um novo 
                //ficheiro binário com dados pré-definidos e ler
                //apartir desse novo ficheiro gerado.
                FicheiroCentroExposicoes.guardarCentroDefault(FicheiroCentroExposicoes.NOME);
                centroExposicoes = FicheiroCentroExposicoes.ler(FicheiroCentroExposicoes.NOME);
            }
        }

        centroExposicoes.setRegistoMecanismos();
        new LoginUI(centroExposicoes);
    }

}
