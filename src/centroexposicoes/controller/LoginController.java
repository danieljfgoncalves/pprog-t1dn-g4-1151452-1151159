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
import centroexposicoes.model.Utilizador;
import java.util.ArrayList;
import java.util.List;

/**
 * Comunicador entre o UI e Model acerca do login da aplicação.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class LoginController {

    private ListaFaes listaFaes;
    private ListaOrganizadores listaOrganizadores;
    private List<Representante> listaRepresentantes;

    public LoginController(CentroExposicoes centroExposicoes) {

        RegistoExposicoes registoExposicoes = centroExposicoes.getRegistoExposicoes();

        this.listaFaes = new ListaFaes();
        this.listaOrganizadores = new ListaOrganizadores();
        setupListasFaesOrganizadores(registoExposicoes);
        this.listaRepresentantes = new ArrayList<>(centroExposicoes.getRegistoRepresentantes().getListaRepresentantes());
    }

    public ListaFaes getListaFaes() {
        return listaFaes;
    }

    public void setListaFaes(ListaFaes listaFaes) {
        this.listaFaes = listaFaes;
    }

    public ListaOrganizadores getListaOrganizadores() {
        return listaOrganizadores;
    }

    public void setListaOrganizadores(ListaOrganizadores listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }

    public List<Representante> getListaRepresentantes() {
        return listaRepresentantes;
    }

    public void setListaRepresentantes(List<Representante> listaRepresentantes) {
        this.listaRepresentantes = listaRepresentantes;
    }

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
