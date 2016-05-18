/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

/**
 * Representa um centro de exposições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class CentroExposicoes
{
    /**
     * Exposições do centro de exposições.
     */
    private RegistoExposicoes registoExposicoes;
    
    /**
     * Constrói uma instância de centro de exposições com os valores por oimissão.
     */
    public CentroExposicoes()
    {
        registoExposicoes = new RegistoExposicoes();
    }
    
    /**
     * Devolve o registo de exposições.
     * 
     * @return Registo de exposições.
     */
    public RegistoExposicoes getRegistoExposicoes()
    {
        return registoExposicoes;
    }
    
}
