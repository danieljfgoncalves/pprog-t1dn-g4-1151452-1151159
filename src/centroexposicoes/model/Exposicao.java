/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.util.ArrayList;
import java.util.List;
import utilitarios.Data;

/**
 * Representa uma Exposição.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Exposicao {

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
     * Lista das candidaturas da exposição.
     */
    private ListaCandidaturas listaCandidaturas;

    /**
     * Lista das demonstrações da exposição.
     */
    private List<Demonstracao> listaDemonstracoes;

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
    private Local LOCAL_POR_OMISSAO = new Local();

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
        this.listaCandidaturas = new ListaCandidaturas();
        this.listaDemonstracoes = new ArrayList<>();
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
     * @param listaCandidaturas lista de candidaturas da exposição.
     * @param listaDemonstracoes lista de demonstrações da exposição.
     */
    public Exposicao(String titulo, String descricao, Data dataInicio, Data dataFim,
            Data subInicio, Data subFim, Local local, ListaCandidaturas listaCandidaturas,
            List<Demonstracao> listaDemonstracoes) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.subInicio = subInicio;
        this.subFim = subFim;
        this.local = local;
        this.listaCandidaturas = new ListaCandidaturas(listaCandidaturas);
        this.listaDemonstracoes = new ArrayList<>(listaDemonstracoes);
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
        this.listaCandidaturas = new ListaCandidaturas(getListaCandidaturas());
        this.listaDemonstracoes = new ArrayList<>(outraExposicao.listaDemonstracoes);
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
        this.listaCandidaturas = listaCandidaturas;
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
        this.listaDemonstracoes = listaDemonstracoes;
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
     * @return True se for adicionada com sucesso
     */
    public boolean adicionarCandidatura(Candidatura candidatura) {
        return getListaCandidaturas().adicionarCandidatura(candidatura);
    }

    /**
     * Devolve a descrição textual de todos os atributos de uma candidatura.
     *
     * @return caraterísticas da candidatura.
     */
    @Override
    public String toString() {
        return "Exposicao{" + "titulo=" + titulo + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", subInicio=" + subInicio + ", subFim=" + subFim + ", local=" + local + ", listaCandidaturas=" + listaCandidaturas + ", listaDemonstracoes=" + listaDemonstracoes + ", LOCAL_POR_OMISSAO=" + LOCAL_POR_OMISSAO + '}';
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
                && this.listaCandidaturas.equals(outraExpo.listaCandidaturas)
                && this.listaDemonstracoes.equals(outraExpo.listaDemonstracoes);
    }

}
