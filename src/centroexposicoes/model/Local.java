package centroexposicoes.model;

/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
/**
 * Representa uma Localidade onde se realiza uma exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Local {

    /**
     * Localidade.
     */
    private String localidade;

    /**
     * Localidade por omissão.
     */
    private static final String LOCAL_POR_OMISSAO = "Porto";

    /**
     * Constrói uma instância de local com os valores por omissão.
     */
    public Local() {
        this.localidade = LOCAL_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de local recebendo os valores por paramêtros.
     *
     * @param localidade localidade.
     */
    public Local(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Constrói uma instância de local copiando os valores de outro local.
     *
     * @param outroLocal outro local que pretende copiar.
     */
    public Local(Local outroLocal) {
        this.localidade = outroLocal.localidade;
    }

    /**
     * Devolve a localidade.
     *
     * @return localidade.
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Modifica a localidade.
     *
     * @param localidade localidade.
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Devolve a descrição textual de todos os atributos de um local.
     *
     * @return caraterísticas do local.
     */
    @Override
    public String toString() {
        return "Local{" + "localidade=" + localidade + '}';
    }

    /**
     * Compara se outro objeto é igual a este local.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais. False caso contrário.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Local outraLocal = (Local) outroObjeto;
        
        return this.localidade.equals(outraLocal.localidade);
    }
}
