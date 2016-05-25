/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import centroexposicoes.utils.Data;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Lê e guarda os dados do centro de exposições num ficheiro binário.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class FicheiroCentroExposicoes {
    /**
     * Nome do ficheiro por defeito.
     */
    public static final String NOME = "CentroExposicoes.bin";

    /**
     * Constrói uma instância de FicheiroCentroExposicoes por defeito.
     */
    public FicheiroCentroExposicoes() {
    }
    
    /**
     * Lê um ficheiro binário com o centro de exposições e devolve o centro de exposições.
     * 
     * @param nomeFicheiro nome do ficheiro a ler
     * @return centro de exposições
     */
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

    /**
     * Guarda os dados do centro de exposições num ficheiro binário
     * 
     * @param nomeFicheiro nome do ficheiro a guardar
     * @param centroExposicoes centro de exposições
     * @return true se for guardado com êxito, false caso contrário
     */
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
    
    /**
     * Cria um ficheiro binário com os dados por defeito.
     * (Este método poderá ser eventualmente removido)
     * 
     * @param nomeFicheiro nome do ficheiro binário
     * @return true se foi gerado com sucesso, false caso contrário.
     */
    public boolean guardarCentroDefault(String nomeFicheiro) {
        
        List<Organizador> lo = new ArrayList<>();
        lo.add(new Organizador(new Utilizador("Eric", "email", "ivo", "pass")));
        lo.add(new Organizador(new Utilizador("Ricardo", "email", "ivo", "pass")));
        lo.add(new Organizador(new Utilizador("Renato", "email", "ivo", "pass")));
        ListaOrganizadores listaOrganizadores = new ListaOrganizadores(lo);
        
        Fae ivo = new Fae(new Utilizador("Ivo", "email", "ivo", "pass")); 
        List<Fae> lf = new ArrayList<>();
        lf.add(new Fae(new Utilizador("Ivo", "email", "ivo", "pass")));
        lf.add(new Fae(new Utilizador("Daniel", "email", "ivo", "pass")));
        ListaFaes listaFaes = new ListaFaes(lf);
        
        List<Demonstracao> listaDemonstracoes = new ArrayList<>();
        listaDemonstracoes.add(new Demonstracao("Git Hub"));
        listaDemonstracoes.add(new Demonstracao("Getting started with bootstrap."));
        listaDemonstracoes.add(new Demonstracao("Hackaton"));
        
        Candidatura sonae = new Candidatura("SONAE", "Porto", "918765432", 42.2f, 4, lo, listaDemonstracoes);
        List<Candidatura> lc = new ArrayList<>();
        lc.add(new Candidatura(sonae));
        lc.add(new Candidatura("PortoTech", "Boavista", "912121212", 9100.3f, 100, lo, listaDemonstracoes));
        ListaCandidaturas listaCandidaturas = new ListaCandidaturas(lc);
        
        Exposicao e1 = new Exposicao("Carros", "Expôr carros", 
                new Data(2016, 6, 10), new Data(2016, 8, 20), 
                new Data(2016, 6, 15), new Data(2016, 7, 15), 
                new Local("Maia"), listaFaes, listaOrganizadores, 
                listaCandidaturas, listaDemonstracoes);
        
        List<Exposicao> listaExposicoes = new ArrayList();
        listaExposicoes.add(e1);
        
        List<MecanismoAtribuicao> listaMecanismos = new ArrayList();
        listaMecanismos.add(null);
        RegistoMecanismos registoMecanismos = new RegistoMecanismos(listaMecanismos);
        
        RegistoExposicoes registoExposicoes = new RegistoExposicoes(listaExposicoes);
        
        List<Representante> lr = new ArrayList<>();
        lr.add(new Representante(new Utilizador("Bob", "email", "ivo", "pass")));
        RegistoRepresentantes registoRepresentantes = new RegistoRepresentantes(lr);
        
        CentroExposicoes centroExposicoes = new CentroExposicoes(registoExposicoes, registoMecanismos, registoRepresentantes);
        
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
