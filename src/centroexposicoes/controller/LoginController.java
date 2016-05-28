/**
 * Fornece as classes que comunicam com o modelo e a interface gráfica.
 */
package centroexposicoes.controller;

import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Fae;
import centroexposicoes.model.ListaFaes;
import centroexposicoes.model.ListaOrganizadores;
import centroexposicoes.model.Organizador;
import centroexposicoes.model.RegistoExposicoes;
import centroexposicoes.model.Representante;
import java.util.ArrayList;
import java.util.List;

/**
 * Comunicador entre o UI e Model acerca do login da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class LoginController {

    /**
     * Lista de funcionários de apoio à exposição.
     */
    private ListaFaes listaFaes;

    /**
     * Lista de organizadores.
     */
    private ListaOrganizadores listaOrganizadores;

    /**
     * Lista de representantes.
     */
    private List<Representante> listaRepresentantes;

    /**
     * Cria uma instância de LoginController.
     *
     * @param centroExposicoes centro de exposições
     */
    public LoginController(CentroExposicoes centroExposicoes) {

        RegistoExposicoes registoExposicoes = centroExposicoes.getRegistoExposicoes();

        this.listaFaes = new ListaFaes();
        this.listaOrganizadores = new ListaOrganizadores();
        setupListasFaesOrganizadores(registoExposicoes);
        this.listaRepresentantes = new ArrayList<>(centroExposicoes.getRegistoRepresentantes().getListaRepresentantes());
    }

    /**
     * Devolve a lista de faes.
     *
     * @return lista de faes
     */
    public ListaFaes getListaFaes() {
        return listaFaes;
    }

    /**
     * Modifica a lista de faes.
     *
     * @param listaFaes lista de faes
     */
    public void setListaFaes(ListaFaes listaFaes) {
        this.listaFaes = listaFaes;
    }

    /**
     * Devolve a lista de organizadores.
     *
     * @return lista de organizadores
     */
    public ListaOrganizadores getListaOrganizadores() {
        return listaOrganizadores;
    }

    /**
     * Modifica a lista de organizadores.
     *
     * @param listaOrganizadores lista de organizadores
     */
    public void setListaOrganizadores(ListaOrganizadores listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }

    /**
     * Devolve a lista de representantes.
     *
     * @return lista de representantes
     */
    public List<Representante> getListaRepresentantes() {
        return listaRepresentantes;
    }

    /**
     * Modifica a lista de representantes.
     *
     * @param listaRepresentantes lista de representantes
     */
    public void setListaRepresentantes(List<Representante> listaRepresentantes) {
        this.listaRepresentantes = listaRepresentantes;
    }

    /**
     * Define lista de faes e organizadores.
     *
     * @param registoExposicoes registo de exposições
     */
    private void setupListasFaesOrganizadores(RegistoExposicoes registoExposicoes) {

        List<Fae> lf = this.listaFaes.getListaFaes();
        List<Organizador> lo = this.listaOrganizadores.getListaOrganizadores();

        for (Exposicao exposicao : registoExposicoes.getListaExposicoes()) {
            for (Fae fae : exposicao.getListaFaes().getListaFaes()) {

                if (!lf.contains(fae)) {
                    lf.add(fae);
                }
            }
            for (Organizador organizador : exposicao.getListaOrganizadores().getListaOrganizadores()) {

                if (!lo.contains(organizador)) {
                    lo.add(organizador);
                }

            }
        }

        this.listaFaes.setListaFaes(lf);
        this.listaOrganizadores.setListaOrganizadores(lo);
    }
}
