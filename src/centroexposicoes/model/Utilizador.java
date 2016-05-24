/*
 * Fornece as classes que contém o modelo logístico de um centro de exposições.
 */
package centroexposicoes.model;

import java.io.Serializable;

/**
 * Representa um utilizador.
 *
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 */
public class Utilizador implements Serializable {

    /**
     * Nome do utilizador.
     */
    private String nome;
    /**
     * Email do utilizador.
     */
    private String email;
    /**
     * Username do utilizador.
     */
    private String username;
    /**
     * Password do utilizador.
     */
    private String password;

    /**
     * Contagem do número de instrâncias de utilizadores criadas.
     */
    private static int contagemNumeroUtilizadores = 0;
    /**
     * Nome do utilizador por omissão.
     */
    private static final String NOME_POR_OMISSAO = "Sem Nome";
    /**
     * Email do utilizador por omissão.
     */
    private static final String EMAIL_POR_OMISSAO = "nao_definido@error.pt";
    /**
     * Username do utilizador por omissão.
     */
    private static final String USERNAME_POR_OMISSAO = "nao_definido_";
    /**
     * password do utilizador por omissão.
     */
    private static final String PASSWORD_POR_OMISSAO = "P4SSW0RD";

    /**
     * Constrói um instância de utilizador com os valores por omissão.
     */
    public Utilizador() {
        contagemNumeroUtilizadores++;
        nome = NOME_POR_OMISSAO + contagemNumeroUtilizadores; //Fazer com que seja único
        email = EMAIL_POR_OMISSAO + contagemNumeroUtilizadores; //Fazer com que seja único
        password = PASSWORD_POR_OMISSAO;
    }

    /**
     * Constrói um instância de utilizador com os valores por omissão.
     *
     * @param nome nome do utilizador
     * @param email email do utilizador
     * @param username username do utilizador
     * @param password password do utilizador
     */
    public Utilizador(String nome, String email, String username, String password) {
        contagemNumeroUtilizadores++;
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Constrói um instância de utilizador copiando outro utilizador.
     *
     * @param utilizador outro utilizador
     */
    public Utilizador(Utilizador utilizador) {
        contagemNumeroUtilizadores++;
        nome = utilizador.nome;
        email = utilizador.email;
        username = utilizador.username;
        password = utilizador.password;
    }

    /**
     * Devolve o nome do utilizador.
     *
     * @return nome do utilizador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do utilizador.
     *
     * @param nome nome do utilizador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o email do utilizador.
     *
     * @return email do utilizador
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o email do utilizador.
     *
     * @param email email do utilizador
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devolve o username do utilizador.
     *
     * @return username do utilizador
     */
    public String getUsername() {
        return username;
    }

    /**
     * Modifica o username do utilizador.
     *
     * @param username username do utilizador
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devolve a password do utilizador.
     *
     * @return password do utilizador
     */
    public String getPassword() {
        return password;
    }

    /**
     * Modifica a password do utilizador.
     *
     * @param password password do utilizador
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gera uma representação textual do utilizador.
     *
     * @return representação textual do utilizador.
     */
    @Override
    public String toString() {
        return String.format("Nome: %s; Email: %s; Username: %s; Password: %s", nome, email, username, password);
    }

    /**
     * Compara se outro objeto é igual a este utilizador.
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
        Utilizador outroUtilizador = (Utilizador) outroObjeto;

        return nome.equals(outroUtilizador.nome) && email.equals(outroUtilizador.email) && username.equals(outroUtilizador.username) && password.equals(outroUtilizador.password);
    }
}
