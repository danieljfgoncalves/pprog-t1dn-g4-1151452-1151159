/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável por armazenar e gerir os funcionários de apoio à exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class ListaFaes
{
    private final List<Fae> listaFaes;
    
    public ListaFaes()
    {
        listaFaes = new ArrayList<>();
    }
}
