/**
 * Fornece as classes que comunicam com o modelo e a interface gráfica.
 */
package centroexposicoes.controller;

import centroexposicoes.model.Candidatura;
import centroexposicoes.model.CentroExposicoes;
import centroexposicoes.model.Demonstracao;
import centroexposicoes.model.Exposicao;
import centroexposicoes.model.Produto;
import centroexposicoes.model.RegistoExposicoes;
import java.util.ArrayList;
import java.util.List;

/**
 * Comunicador acerca do registo de candidaturas entre o UI e Model .
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistarCandidaturaController
{
    private final RegistoExposicoes registoExposicoes;
    private List<Demonstracao> listaDemonstracoes;
    private Exposicao exposicao;
    private Candidatura candidatura;
    private Produto produto;
    
    public RegistarCandidaturaController(CentroExposicoes centroExposicoes)
    {
        registoExposicoes = centroExposicoes.getRegistoExposicoes();
    }
    
    public List<Exposicao> getExposições()
    {
        return registoExposicoes.getExposicoes();
    }
    
    public void novaCandidatura(Exposicao exposicao)
    {
        this.exposicao = exposicao;
        candidatura = exposicao.novaCandidatura();
    }
    
    public void setDados(String nomeEmpresa, String morada, String telemovel, float areaExpositor, int qtConvites)
    {
        candidatura.setNomeEmpresa(nomeEmpresa);
        candidatura.setMorada(morada);
        candidatura.setTelemovel(telemovel);
        candidatura.setAreaExpositor(areaExpositor);
        candidatura.setNumeroConvites(qtConvites);
    }
    
    public void addProduto(String designacao)
    {
        produto = candidatura.novoProduto(designacao);
        candidatura.adicionarProduto(produto);
    }
    
    public List<Demonstracao> getListaDemonstracoes()
    {
        listaDemonstracoes = candidatura.getListaDemonstracoes();
        return listaDemonstracoes;
    }
    
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes)
    {
        candidatura.setListaDemonstracoes(listaDemonstracoes);
    }
    
    public void registaCandidaturas()
    {
        exposicao.adicionarCandidatura(candidatura);
    }
}
