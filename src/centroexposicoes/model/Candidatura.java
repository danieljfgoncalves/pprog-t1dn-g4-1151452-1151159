/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

/**
 * Representa uma candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Candidatura
{
    /**
     * Nome comercial da empresa.
     */
    private String nomeEmpresa;
    /**
     * Morada.
     */
    private String morada;
    /**
     * Número do telemóvel.
     */
    private String telemovel;
    /**
     * Área da exposição pretendida.
     */
    private float areaExpositor;
    /**
     * Quantidade de convites a adquirir.
     */
    private int numeroConvites;
    
    /**
     * Constrói uma instância da candidatura com os valores por omissão.
     */
    public Candidatura()
    {
        
    }
}
