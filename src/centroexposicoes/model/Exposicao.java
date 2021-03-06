/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import centroexposicoes.utils.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma Exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Exposicao implements Serializable {

    /**
     * Titulo da exposição.
     */
    private String titulo;

    /**
     * Descrição da exposição.
     */
    private String descricao;

    /**
     * Data do início da exposição.
     */
    private Data dataInicio;

    /**
     * Data do fim da exposição.
     */
    private Data dataFim;

    /**
     * Data do início de submissão de candidaturas da exposição.
     */
    private Data subInicio;

    /**
     * Data do fim de submissão de candidaturas da exposição.
     */
    private Data subFim;

    /**
     * Local da exposição.
     */
    private Local local;

    /**
     * Lista de faes da exposição.
     */
    private ListaFaes listaFaes;

    /**
     * Lista de organizadores da exposição.
     */
    private ListaOrganizadores listaOrganizadores;

    /**
     * Lista das candidaturas da exposição.
     */
    private ListaCandidaturas listaCandidaturas;

    /**
     * Lista das demonstrações da exposição.
     */
    private List<Demonstracao> listaDemonstracoes;

    /**
     * Lista das atribuições.
     */
    private ListaAtribuicoes listaAtribuicoes;

    /**
     * Titulo da exposição por omissão.
     */
    private static final String TITULO_POR_OMISSAO = "Sem titulo";

    /**
     * Descrição da exposição por omissão.
     */
    private static final String DESCRICAO_POR_OMISSAO = "Sem descrição";

    /**
     * Data do início da exposição por omissão.
     */
    private static final Data DATA_INICIO_POR_OMISSAO = new Data();

    /**
     * Data do fim da exposição por omissão.
     */
    private static final Data DATA_FIM_POR_OMISSAO = new Data();

    /**
     * Data do início de submissão de candidaturas da exposição por omissão.
     */
    private static final Data SUB_INICIO_POR_OMISSAO = new Data();

    /**
     * Data do fim de submissão de candidaturas da exposição por omissão.
     */
    private static final Data SUB_FIM_POR_OMISSAO = new Data();

    /**
     * Local da exposição por omissão.
     */
    private static final Local LOCAL_POR_OMISSAO = new Local();

    /**
     * Constrói uma instância de exposição com os valores por omissão.
     */
    public Exposicao() {

        this.titulo = TITULO_POR_OMISSAO;
        this.descricao = DESCRICAO_POR_OMISSAO;
        this.dataInicio = DATA_INICIO_POR_OMISSAO;
        this.dataFim = DATA_FIM_POR_OMISSAO;
        this.subInicio = SUB_INICIO_POR_OMISSAO;
        this.subFim = SUB_FIM_POR_OMISSAO;
        this.listaFaes = new ListaFaes();
        this.listaOrganizadores = new ListaOrganizadores();
        this.listaCandidaturas = new ListaCandidaturas();
        this.listaDemonstracoes = new ArrayList<>();
        this.listaAtribuicoes = new ListaAtribuicoes();
        this.local = LOCAL_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de exposição com os valores por recebidos por
     * paramêtros.
     *
     * @param titulo titulo da exposição.
     * @param descricao descrição da exposição.
     * @param dataInicio data do início da exposição.
     * @param dataFim data do fim da exposição.
     * @param subInicio data do início de submissão de candidaturas da
     * exposição.
     * @param subFim data do fim de submissão de candidaturas da exposição.
     * @param local local da exposição.
     * @param listaFaes lista de faes da exposição.
     * @param listaOrganizadores lista de organizadores da exposição.
     * @param listaCandidaturas lista de candidaturas da exposição.
     * @param listaDemonstracoes lista de demonstrações da exposição.
     * @param listaAtribuicoes lista de atribuições da exposição.
     */
    public Exposicao(String titulo, String descricao, Data dataInicio, Data dataFim,
            Data subInicio, Data subFim, Local local, ListaFaes listaFaes, ListaOrganizadores listaOrganizadores, ListaCandidaturas listaCandidaturas,
            List<Demonstracao> listaDemonstracoes, ListaAtribuicoes listaAtribuicoes) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.subInicio = subInicio;
        this.subFim = subFim;
        this.local = local;
        this.listaFaes = new ListaFaes(listaFaes);
        this.listaOrganizadores = new ListaOrganizadores(listaOrganizadores);
        this.listaCandidaturas = new ListaCandidaturas(listaCandidaturas);
        this.listaDemonstracoes = new ArrayList<>(listaDemonstracoes);
        this.listaAtribuicoes = new ListaAtribuicoes(listaAtribuicoes);
    }

    /**
     * Constrói uma instância de exposição copiando os valores de outra
     * exposição.
     *
     * @param outraExposicao a exposição que pretende copiar.
     */
    public Exposicao(Exposicao outraExposicao) {
        this.titulo = outraExposicao.titulo;
        this.descricao = outraExposicao.descricao;
        this.dataInicio = outraExposicao.dataInicio;
        this.dataFim = outraExposicao.dataFim;
        this.subInicio = outraExposicao.subInicio;
        this.subFim = outraExposicao.subFim;
        this.local = outraExposicao.local;
        this.listaFaes = new ListaFaes(outraExposicao.listaFaes);
        this.listaOrganizadores = new ListaOrganizadores(outraExposicao.listaOrganizadores);
        this.listaCandidaturas = new ListaCandidaturas(outraExposicao.listaCandidaturas);
        this.listaDemonstracoes = new ArrayList<>(outraExposicao.listaDemonstracoes);
        this.listaAtribuicoes = new ListaAtribuicoes(outraExposicao.listaAtribuicoes);
    }

    /**
     * Devolve o titulo da exposição.
     *
     * @return o titulo da exposição.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Modifica o titulo da exposição.
     *
     * @param titulo titulo da exposição.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devolve a descrição da exposição.
     *
     * @return a descricao da exposição.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Modifica a descrição da exposição.
     *
     * @param descricao descricao da exposição.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Devolve a data do início da exposição.
     *
     * @return a data do início da exposição.
     */
    public Data getDataInicio() {
        return dataInicio;
    }

    /**
     * Modifica a data do início da exposição.
     *
     * @param dataInicio data do início da exposição.
     */
    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Devlove a data do fim da exposição.
     *
     * @return a data do fim da exposição.
     */
    public Data getDataFim() {
        return dataFim;
    }

    /**
     * Modifica a data do fim da exposição.
     *
     * @param dataFim data do fim da exposição.
     */
    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Devolve a data do início da submissão de candidaturas da exposição.
     *
     * @return a data do início da submissão de candidaturas da exposição.
     */
    public Data getSubInicio() {
        return subInicio;
    }

    /**
     * Modifica a data do início da submissão de candidaturas da exposição.
     *
     * @param subInicio data do início da submissão de candidaturas da
     * exposição.
     */
    public void setSubInicio(Data subInicio) {
        this.subInicio = subInicio;
    }

    /**
     * Devolve a data do fim da submissão de candidaturas da exposição.
     *
     * @return a data do fim da submissão de candidaturas da exposição.
     */
    public Data getSubFim() {
        return subFim;
    }

    /**
     * Modifica a data do fim da submissão de candidaturas da exposição.
     *
     * @param subFim data do fim da submissão de candidaturas da exposição.
     */
    public void setSubFim(Data subFim) {
        this.subFim = subFim;
    }

    /**
     * Devolve o local da exposição.
     *
     * @return o local da exposição.
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Modifica o local da exposição.
     *
     * @param local local da exposição.
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Devolve a lista de faes da exposição.
     *
     * @return a lista de faes da exposição.
     */
    public ListaFaes getListaFaes() {
        return new ListaFaes(this.listaFaes);
    }

    /**
     * Modifica a lista de faes da exposição.
     *
     * @param listaFaes lista de faes da exposição.
     */
    public void setListaFaes(ListaFaes listaFaes) {
        this.listaFaes = new ListaFaes(listaFaes);
    }

    /**
     * Devolve a lista de candidaturas da exposição.
     *
     * @return a lista de candidaturas da exposição.
     */
    public ListaCandidaturas getListaCandidaturas() {
        return new ListaCandidaturas(this.listaCandidaturas);
    }

    /**
     * Modifica a lista de candidaturas da exposição.
     *
     * @param listaCandidaturas listaCandidaturas da exposição.
     */
    public void setListaCandidaturas(ListaCandidaturas listaCandidaturas) {
        this.listaCandidaturas = new ListaCandidaturas(listaCandidaturas);
    }

    /**
     * Devolve a lista de organizadores da exposição.
     *
     * @return a lista de organizadores da exposição.
     */
    public ListaOrganizadores getListaOrganizadores() {
        return new ListaOrganizadores(this.listaOrganizadores);
    }

    /**
     * Modifica a lista de organizadores da exposição.
     *
     * @param listaOrganizadores lista organizadores da exposição.
     */
    public void setListaOrganizadores(ListaOrganizadores listaOrganizadores) {
        this.listaOrganizadores = new ListaOrganizadores(listaOrganizadores);
    }

    /**
     * Devolve a lista de demonstrações da exposição.
     *
     * @return a lista de demonstrações da exposição.
     */
    public List<Demonstracao> getListaDemonstracoes() {
        return new ArrayList<>(this.listaDemonstracoes);
    }

    /**
     * Modifica a lista de demonstrações da exposição.
     *
     * @param listaDemonstracoes lista de demonstracoes da exposição.
     */
    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes) {
        this.listaDemonstracoes = new ArrayList<>(listaDemonstracoes);
    }

    /**
     * Devolve a lista de Atribuições.
     *
     * @return listra de atribuições
     */
    public ListaAtribuicoes getListaAtribuicoes() {
        return new ListaAtribuicoes(listaAtribuicoes);
    }

    /**
     * Modifica a lista de Atribuições.
     *
     * @param listaAtribuicoes lista de atribuições
     */
    public void setListaAtribuicoes(ListaAtribuicoes listaAtribuicoes) {
        this.listaAtribuicoes = new ListaAtribuicoes(listaAtribuicoes);
    }

    /**
     * Devolve a listra de atribuições por avaliar do fae especificado.
     *
     * @param fae funcionário de apoio à exposição
     * @return listra de atribuições por avaliar do fae especificado
     */
    public List<Atribuicao> getListaAtribuicoesPorAvaliar(Fae fae) {
        List<Atribuicao> listaAtribuicoesPorAvaliar = new ArrayList<>();
        List<Atribuicao> la = this.listaAtribuicoes.getListaAtribuicoes();

        for (Atribuicao atribuicao : la) {
            if (atribuicao.getFae().equals(fae)) {
                listaAtribuicoesPorAvaliar.add(atribuicao);
            }
        }

        return listaAtribuicoesPorAvaliar;
    }

    /**
     * Cria uma nova candidatura com os valores por omissão.
     *
     * @return Candidatura criada.
     */
    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    /**
     * Adiciona uma candidatura.
     *
     * @param candidatura Candidatura a ser adicionada
     *
     * @return True se for adicionada com sucesso
     */
    public boolean adicionarCandidatura(Candidatura candidatura) {
        return getListaCandidaturas().adicionarCandidatura(candidatura);
    }

    /**
     * Remove uma atribuição da lista.
     *
     * @param atribuicao atribuição a ser removida
     *
     * @return true se for removido com sucesso
     */
    public boolean removerAtribuicao(Atribuicao atribuicao) {
        return listaAtribuicoes.removerAtribuicao(atribuicao);
    }

    /**
     * Devolve a descrição textual de todos os atributos de uma candidatura.
     *
     * @return caraterísticas da candidatura.
     */
    @Override
    public String toString() {
        return "Exposicao{" + "titulo=" + titulo + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", subInicio=" + subInicio + ", subFim=" + subFim + ", local=" + local + ", listaFaes=" + listaFaes + ", listaOrganizadores=" + listaOrganizadores + ", listaCandidaturas=" + listaCandidaturas + ", listaDemonstracoes=" + listaDemonstracoes + '}';
    }

    /**
     * Compara se outro objeto é igual a esta exposição.
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
        Exposicao outraExpo = (Exposicao) outroObjeto;

        return this.titulo.equals(outraExpo.titulo)
                && this.descricao.equals(outraExpo.descricao)
                && this.dataInicio.equals(outraExpo.dataInicio)
                && this.dataFim.equals(outraExpo.dataFim)
                && this.subInicio.equals(outraExpo.subInicio)
                && this.subFim.equals(outraExpo.subFim)
                && this.local.equals(outraExpo.local)
                && this.listaOrganizadores.equals(outraExpo.listaOrganizadores)
                && this.listaFaes.equals(outraExpo.listaFaes)
                && this.listaCandidaturas.equals(outraExpo.listaCandidaturas)
                && this.listaDemonstracoes.equals(outraExpo.listaDemonstracoes);
    }

}
