/*
 * Fornece as classes utilitárias para o centro de exposições.
 */
package centroexposicoes.utils;

/**
 * Metodos auxiliares para validações.
 * 
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Validar {
    
    /**
     * Verifica se o valor da string é válida.
     * 
     * @param text string que pretende validar
     * @return true se for válido ou false se for inválido
     */
    public static boolean validaString(String text) {
        return (!text.trim().isEmpty() && text != null);
    }
}
