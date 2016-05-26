/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import centroexposicoes.utils.Validar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma candidatura.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Candidatura implements Serializable {

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
     * Lista de produtos que o expositor pretende expor.
     */
    private List<Produto> listaProdutos;

    /**
     * Lista de demonstrações da exposicão que o expositor pretende participar.
     */
    private List<Demonstracao> listaDemonstracoes;
    /**
     * Lista de avaliações da candidatura.
     */
    private List<Avaliacao> listaAvaliacoes;

    /**
     * Nome comercial da empresa por omissão.
     */
    private static final String NOME_EMPRESA_POR_OMISSAO = "Sem designação";
    /**
     * Morada por omissão.
     */
    private static final String MORADA_POR_OMISSAO = "Sem morada";
    /**
     * Número do telemóvel por omissão.
     */
    private static final String TELEMOVEL_POR_OMISSAO = "Número indefinido";
    /**
     * Área da exposição pretendida por omissão.
     */
    private static final float AREA_EXPOSITOR_POR_OMISSAO = 100.0f;
    /**
     * Quantidade de convites a adquirir.
     */
    private static final int NUMERO_CONVITES_POR_OMISSAO = 10;

    /**
     * Constrói uma instância da candidatura com os valores por omissão.
     */
    public Candidatura() {

        this.nomeEmpresa = NOME_EMPRESA_POR_OMISSAO;
        this.morada = MORADA_POR_OMISSAO;
        this.telemovel = TELEMOVEL_POR_OMISSAO;
        this.areaExpositor = AREA_EXPOSITOR_POR_OMISSAO;
        this.numeroConvites = NUMERO_CONVITES_POR_OMISSAO;
        this.listaProdutos = new ArrayList<>();
        this.listaDemonstracoes = new ArrayList<>();
        this.listaAvaliacoes = new ArrayList<>();
    }

    /**
     * Constrói uma instância da candidatura com os valores recebidos por
     * paramêtros.
     *
     *
     * @param nomeEmpresa nome comercial da empresa
     * @param morada morada do expositor
     * @param telemovel telemovel do expositor
     * @param areaExpositor area pretendida pelo expositor
     * @param numeroConvites número de convites necessário
     * @param listaProdutos lista de produtos que pretende expor
     * @param listaDemonstracoes lista de demonstrações que pretende participar
     * @param listaAvaliacoes lista de avaliações
     */
    public Candidatura(String nomeEmpresa, String morada, String telemovel, float areaExpositor, int numeroConvites, List listaProdutos, List listaDemonstracoes, List listaAvaliacoes) {

        this.nomeEmpresa = nomeEmpresa;
        this.morada = morada;
        this.telemovel = telemovel;
        this.areaExpositor = areaExpositor;
        this.numeroConvites = numeroConvites;
        this.listaProdutos = new ArrayList<>(listaProdutos);
        this.listaDemonstracoes = new ArrayList<>(listaDemonstracoes);
        this.listaAvaliacoes = new ArrayList<>(listaAvaliacoes);
    }

    /**
     * Constrói uma instância da candidatura a partir de outra candidatura.
     *
     * @param outraCandidatura candidatura que pretende copiar.
     */
    public Candidatura(Candidatura outraCandidatura) {

        this.nomeEmpresa = outraCandidatura.nomeEmpresa;
        this.morada = outraCandidatura.morada;
        this.telemovel = outraCandidatura.telemovel;
        this.areaExpositor = outraCandidatura.areaExpositor;
        this.numeroConvites = outraCandidatura.numeroConvites;
        this.listaProdutos = new ArrayList<>(outraCandidatura.listaProdutos);
        this.listaDemonstracoes = new ArrayList<>(outraCandidatura.listaDemonstracoes);
        this.listaAvaliacoes = new ArrayList<>(outraCandidatura.listaAvaliacoes);
    }

    /**
     * Devolve o nome comercial da empresa.
     *
     * @return o nome comercial da empresa.
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * Modifica o nome comercial da empresa.
     *
     * @param nomeEmpresa o nome comercial da empresa.
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    /**
     * Devolve a morada do expositor.
     *
     * @return a morada do expositor.
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Modifica a morada do expositor.
     *
     * @param morada a morada do expositor.
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Devolve o número de telemovel.
     *
     * @return o número de telemovel.
     */
    public String getTelemovel() {
        return telemovel;
    }

    /**
     * Modifica o número de telemovel.
     *
     * @param telemovel o número de telemovel.
     */
    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    /**
     * Devolve a area pretendida do expositor.
     *
     * @return a area pretendida do expositor.
     */
    public float getAreaExpositor() {
        return areaExpositor;
    }

    /**
     * Modifica a area pretendida do expositor.
     *
     * @param areaExpositor a area pretendida do expositor.
     */
    public void setAreaExpositor(float areaExpositor) {
        this.areaExpositor = areaExpositor;
    }

    /**
     * Devolve o número de convites pretendidos pelo expositor.
     *
     * @return o número de convites pretendidos pelo expositor.
     */
    public int getNumeroConvites() {
        return numeroConvites;
    }

    /**
     * Modifica o número de convites pretendidos pelo expositor.
     *
     * @param numeroConvites o número de convites pretendidos pelo expositor.
     */
    public void setNumeroConvites(int numeroConvites) {
        this.numeroConvites = numeroConvites;
    }

    /**
     * Devolve a lista de produtos da candidatura (Composição).
     *
     * @return a lista de produtos da candidatura (Composição).
     */
    public List<Produto> getListaProdutos() {
        return new ArrayList<>(this.listaProdutos);
    }

    /**
     * Modifica a lista de produtos da candidatura.
     *
     * @param listaProdutos a lista de produtos da candidatura.
     */
    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = new ArrayList<>(listaProdutos);
    }

    /**
     * Devolve a lista de demonstrações em que pretende participar (Composição).
     *
     * @return a lista de demonstrações em que pretende participar (Composição).
     */
    public List<Demonstracao> getListaDemonstracoes() {
        return new ArrayList<>(this.listaDemonstracoes);
    }

    /**
     * Modifica a lista de demonstrações em que pretende participar.
     *
     * @param listaDemonstracoes a lista de demonstrações em que pretende
     * participar.
     */
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        this.listaDemonstracoes = new ArrayList<>(listaDemonstracoes);
    }

    /**
     * Devolve a lista de avaliações.
     * 
     * @return lista de avaliações
     */
    public List<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    /**
     * Modifica a lista de avaliações.
     * 
     * @param listaAvaliacoes lista de avaliações
     */
    public void setListaAvaliacoes(List<Avaliacao> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }

    /**
     * Cria um novo produto a expor.
     *
     * @param designacao designação do produto a expor.
     * @return um produto a expor.
     */
    public Produto novoProduto(String designacao) {

        return new Produto(designacao);
    }

    /**
     * Valida e adiciona o produto a lista de produtos da candidatura.
     *
     * @param produto produto a expor.
     *
     * @return true se adicionar o produto a lista ou false se não adicionar.
     */
    public boolean adicionarProduto(Produto produto) {

        return produto.valida() && validarProduto(produto) ? addProduto(produto) : false;
    }
    
    public boolean removerProduto(Produto produto) {
        
        return produto.valida() && !validarProduto(produto) ? removeProduto(produto) : false;
    }

    /**
     * Verifica se já existe o produto na lista de produtos.
     *
     * @param produto produto a expor.
     * @return true se não existe na lista de produtos e false se já existir.
     */
    private boolean validarProduto(Produto produto) {

        return !this.listaProdutos.contains(produto);
    }

    /**
     * Adiciona um produto a lista de produtos.
     *
     * @param produto produto a expor.
     */
    private boolean addProduto(Produto produto) {

        return this.listaProdutos.add(produto);
    }
    
    private boolean removeProduto(Produto produto) {
        
        return this.listaProdutos.remove(produto);
    }

    /**
     * Cria uma nova avaliação com os parâmetros por omissão.
     * 
     * @return nova avaliação
     */
    public  Avaliacao novaAvaliacao()
    {
        return new Avaliacao();
    }
    
    public boolean adicionarAvaliacao(Avaliacao avaliacao) {

        return avaliacao.validar() && validarAvaliacao(avaliacao) ? addAvaliacao(avaliacao) : false;
    }
    private boolean validarAvaliacao(Avaliacao avaliacao)
    {
        return !this.listaAvaliacoes.contains(avaliacao);
    }
    private boolean addAvaliacao(Avaliacao avaliacao)
    {
        return this.listaAvaliacoes.add(avaliacao);
    }
    /**
     * Verifica se a candidatura é válida.
     *
     * @return true se for válida ou false se for inválida.
     */
    public boolean valida() {

        return Validar.validaString(this.nomeEmpresa)
                && Validar.validaString(this.morada)
                && Validar.validaString(this.telemovel)
                && (this.areaExpositor > 0.0)
                && (this.numeroConvites > 0)
                && this.listaProdutos != null
                && this.listaDemonstracoes != null;
    }

    /**
     * Devolve a descrição textual de todos os atributos de uma candidatura.
     *
     * @return caraterísticas da candidatura.
     */
    @Override
    public String toString() {

        return "Candidatura{"
                + "nomeEmpresa=" + nomeEmpresa
                + ", morada=" + morada
                + ", telemovel=" + telemovel
                + ", areaExpositor=" + areaExpositor
                + ", numeroConvites=" + numeroConvites
                + '}';
    }

    /**
     * Compara se outro objeto é igual a esta Candidatura.
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
        Candidatura outraCandidatura = (Candidatura) outroObjeto;

        return this.nomeEmpresa.equals(outraCandidatura.nomeEmpresa)
                && this.morada.equals(outraCandidatura.morada)
                && this.telemovel.equals(outraCandidatura.telemovel)
                && this.areaExpositor == outraCandidatura.areaExpositor
                && this.numeroConvites == outraCandidatura.numeroConvites
                && this.listaDemonstracoes.equals(outraCandidatura.listaDemonstracoes)
                && this.listaProdutos.equals(outraCandidatura.listaProdutos)
                && this.listaAvaliacoes.equals(outraCandidatura.listaAvaliacoes);
    }
}
