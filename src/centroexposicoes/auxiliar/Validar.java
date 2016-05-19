/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centroexposicoes.auxiliar;

/**
 * Metodos auxiliares
 * 
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class Validar {
    
    /**
     * Verifica se o valor da string é válida.
     * 
     * @param text string que pretende validar.
     * @return true se for válido ou false se for inválido.
     */
    public static boolean validaString(String text) {
        return (!text.trim().isEmpty() && text != null);
    }
}
