/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import centroexposicoes.utils.InstanciadorPorDefeito;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Lê e guarda os dados do centro de exposições num ficheiro binário.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class FicheiroCentroExposicoes {

    /**
     * Nome do ficheiro por defeito.
     */
    public static final String NOME = "CentroExposicoes.bin";

    /**
     * Constrói uma instância de FicheiroCentroExposicoes por defeito.
     */
    public FicheiroCentroExposicoes() {
    }

    /**
     * Lê um ficheiro binário com o centro de exposições e devolve o centro de
     * exposições.
     *
     * @param nomeFicheiro nome do ficheiro a ler
     * @return centro de exposições
     */
    public CentroExposicoes ler(String nomeFicheiro) {
        CentroExposicoes centroExposicoes;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(nomeFicheiro));
            try {
                centroExposicoes = (CentroExposicoes) in.readObject();
            } finally {
                in.close();
            }
            return centroExposicoes;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    /**
     * Guarda os dados do centro de exposições num ficheiro binário
     *
     * @param nomeFicheiro nome do ficheiro a guardar
     * @param centroExposicoes centro de exposições
     * @return true se for guardado com êxito, false caso contrário
     */
    public boolean guardar(String nomeFicheiro, CentroExposicoes centroExposicoes) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(nomeFicheiro));
            try {
                out.writeObject(centroExposicoes);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Cria um ficheiro binário com os dados por defeito. (Este método poderá
     * ser eventualmente removido)
     *
     * @param nomeFicheiro nome do ficheiro binário
     * @return true se foi gerado com sucesso, false caso contrário.
     */
    public boolean guardarCentroDefault(String nomeFicheiro) {

        CentroExposicoes centroExposicoes = InstanciadorPorDefeito.getCentroExposicoesPorDefeito();

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(nomeFicheiro));
            try {
                out.writeObject(centroExposicoes);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
