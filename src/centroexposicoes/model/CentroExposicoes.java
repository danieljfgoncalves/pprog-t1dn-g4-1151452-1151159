/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um centro de exposições.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class CentroExposicoes implements Serializable {

    /**
     * Exposições do centro de exposições.
     */
    private RegistoExposicoes registoExposicoes;
    /**
     * Mecanismos do centro de exposições.
     */
    private RegistoMecanismos registoMecanismos;
    /**
     * Representantes de Expositor do centro de exposições.
     */
    private RegistoRepresentantes registoRepresentantes;

    private static final String DIR_MECANISMOS = "src/centroexposicoes/model/mecanismos/";

    /**
     * Constrói uma instância de centro de exposições com os valores por
     * oimissão.
     */
    public CentroExposicoes() {
        registoExposicoes = new RegistoExposicoes();
        registoRepresentantes = new RegistoRepresentantes();
        registoMecanismos = new RegistoMecanismos(lerMecanismos());
    }

    /**
     * Constrói uma instância de centro de exposições recebendo o registo de
     * exposições, o registo de mecanismos e registo de representantes.
     *
     * @param registoExposicoes registo de exposições
     * @param registoRepresentantes registo de representantes
     */
    public CentroExposicoes(RegistoExposicoes registoExposicoes, RegistoRepresentantes registoRepresentantes) {
        this.registoExposicoes = new RegistoExposicoes(registoExposicoes);
        this.registoMecanismos = new RegistoMecanismos(lerMecanismos());
        this.registoRepresentantes = new RegistoRepresentantes(registoRepresentantes);
    }

    /**
     * Constrói uma instância de centro de exposições copiando outro centro de
     * exposições.
     *
     * @param centroExposicoes centro de exposições
     */
    public CentroExposicoes(CentroExposicoes centroExposicoes) {
        registoExposicoes = new RegistoExposicoes(centroExposicoes.registoExposicoes);
        registoMecanismos = new RegistoMecanismos(centroExposicoes.registoMecanismos);
        registoRepresentantes = new RegistoRepresentantes(centroExposicoes.registoRepresentantes);
    }

    /**
     * Devolve o registo de exposições.
     *
     * @return Registo de exposições.
     */
    public RegistoExposicoes getRegistoExposicoes() {
        return new RegistoExposicoes(registoExposicoes);
    }

    /**
     * Modifica o registo de exposições.
     *
     * @param registoExposicoes registo de exposições
     */
    public void setRegistoExposicoes(RegistoExposicoes registoExposicoes) {
        this.registoExposicoes = new RegistoExposicoes(registoExposicoes);
    }

    /**
     * Devolve o registo de mecanismos.
     *
     * @return registo de mecanismos
     */
    public RegistoMecanismos getRegistoMecanismos() {
        return new RegistoMecanismos(registoMecanismos);
    }

    /**
     * Modifica o registo de mecanismos.
     *
     * @param registoMecanismos registo de mecanismos
     */
    public void setRegistoMecanismos(RegistoMecanismos registoMecanismos) {
        this.registoMecanismos = new RegistoMecanismos(registoMecanismos);
    }

    /**
     * Devolve o registo de representantes.
     *
     * @return Registo de representantes.
     */
    public RegistoRepresentantes getRegistoRepresentantes() {
        return new RegistoRepresentantes(registoRepresentantes);
    }

    /**
     * Modifica o registo de representantes.
     *
     * @param registoRepresentantes registo de representantes
     */
    public void setRegistoRepresentantes(RegistoRepresentantes registoRepresentantes) {
        this.registoRepresentantes = new RegistoRepresentantes(registoRepresentantes);
    }

    private List<MecanismoAtribuicao> lerMecanismos() {

        List<MecanismoAtribuicao> listaMecanismos = new ArrayList<>();

        try {
            Files.walk(Paths.get(DIR_MECANISMOS)).forEach(filePath -> {

                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);

                    String extension = filePath.toString().substring(filePath.toString().indexOf('.'));

                    if (extension.equals(".java")) {
                        String caminhoSemExtensao = filePath.toString().substring(
                                filePath.toString().indexOf('/') + 1, filePath.toString().indexOf('.'));

                        String caminho = caminhoSemExtensao.replace('/', '.');

                        try {

                            Class cls = Class.forName(caminho);
                            Object objeto = (Object) cls.newInstance();
                            listaMecanismos.add((MecanismoAtribuicao) objeto);

                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                            // TODO
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            });
        } catch (IOException ex) {
            // TODO
            System.out.println(ex.getMessage());
        }
        return listaMecanismos;
    }

    /**
     * Gera uma representação textual do centro de exposições.
     *
     * @return representação textual do centro de exposições.
     */
    @Override
    public String toString() {
        return String.format("CentroExposicoes{registoExposicoes=%s, registoMecanismos=%s}", registoExposicoes, registoMecanismos);
    }

    /**
     * Compara se outro objeto é igual a este centro de exposições.
     *
     * @param outroObjeto objeto a comparar
     * @return true se forem iguais, false caso contrário.
     */
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        CentroExposicoes outroCentroExposicoes = (CentroExposicoes) outroObjeto;

        return registoExposicoes.equals(outroCentroExposicoes.registoExposicoes) && registoMecanismos.equals(outroCentroExposicoes.registoMecanismos);
    }
}
