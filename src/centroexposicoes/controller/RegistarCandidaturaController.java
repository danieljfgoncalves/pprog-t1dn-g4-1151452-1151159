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
 * Comunicador entre o UI e Model acerca do registo de candidaturas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class RegistarCandidaturaController
{
    /**
     * Registo de exposições. Contém a lista de exposições.
     */
    private final RegistoExposicoes registoExposicoes;
    /**
     * Lista de demonstrações.
     */
    private List<Demonstracao> listaDemonstracoes;
    /**
     * Exposição.
     */
    private Exposicao exposicao;
    /**
     * Candidatura.
     */
    private Candidatura candidatura;
    /**
     * Produto.
     */
    private Produto produto;
    
    /**
     * Cria uma instância do controller para o registo de candidaturas, recebendo o centro de exposições.
     * 
     * @param centroExposicoes Centro de exposições.
     */
    public RegistarCandidaturaController(CentroExposicoes centroExposicoes)
    {
        registoExposicoes = centroExposicoes.getRegistoExposicoes();
    }
    
    /**
     * Devolve as exposições.
     * 
     * @return Exposições
     */
    public List<Exposicao> getExposições()
    {
        return registoExposicoes.getExposicoes();
    }
    
    /**
     * Cria a candidatura recebendo a exposição.
     * 
     * @param exposicao Exposição
     */
    public void novaCandidatura(Exposicao exposicao)
    {
        this.exposicao = exposicao;
        candidatura = exposicao.novaCandidatura();
    }
    
    /**
     * Define os dados da candidatura.
     * 
     * @param nomeEmpresa Nome da Empresa
     * @param morada Morada
     * @param telemovel Telemóvel
     * @param areaExpositor Area pretendida do expositor
     * @param numeroConvites Número de convites
     */
    public void setDados(String nomeEmpresa, String morada, String telemovel, float areaExpositor, int numeroConvites)
    {
        candidatura.setNomeEmpresa(nomeEmpresa);
        candidatura.setMorada(morada);
        candidatura.setTelemovel(telemovel);
        candidatura.setAreaExpositor(areaExpositor);
        candidatura.setNumeroConvites(numeroConvites);
    }
    
    /**
     * Adiciona um produto.
     * 
     * @param designacao Designação do produto
     */
    public void addProduto(String designacao)
    {
        produto = candidatura.novoProduto(designacao);
        candidatura.adicionarProduto(produto);
    }
    
    /**
     * Devolve a lista de demonstrações.
     * 
     * @return Lista de demonstrações
     */
    public List<Demonstracao> getListaDemonstracoes()
    {
        listaDemonstracoes = candidatura.getListaDemonstracoes();
        return listaDemonstracoes;
    }
    
    /**
     * Define a lista de demonstrações da candidatura.
     * 
     * @param listaDemonstracoes Lista de demonstrações
     */
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes)
    {
        candidatura.setListaDemonstracoes(listaDemonstracoes);
    }
    
    /**
     * Regista a candidatura.
     */
    public void registaCandidaturas()
    {
        exposicao.adicionarCandidatura(candidatura);
    }
}