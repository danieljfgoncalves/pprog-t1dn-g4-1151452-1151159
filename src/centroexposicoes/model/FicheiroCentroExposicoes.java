/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

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
    public static final String NOME = "CentroExposicoes.bin";

    public FicheiroCentroExposicoes() {
    }
    
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
}
