package modelDominio;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 123L;

    private int codUsuario;
    private String nome;
    private String email;
    private String senha;
    private int foco;
    private String cref;

    public Usuario(int codUsuario, String nome, String email, String senha, int foco, String cref) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foco = foco;
        this.cref = cref;
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(String nome, String email, String senha, int foco, String cref) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foco = foco;
        this.cref = cref;
    }

    public Usuario(int codUsuario, String nome, String email, String senha, String cref) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cref = cref;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int codUsuario, String nome, String email, String senha, int foco) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foco = foco;
    }

    public Usuario(String nome, String email, String senha, int foco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foco = foco;
    }

    public Usuario(int codUsuario, String nome) {
        this.codUsuario = codUsuario;
        this.nome = nome;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getFoco() {
        return foco;
    }

    public String getCref() {
        return cref;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setFoco(int foco) {
        this.foco = foco;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foco=" + foco + ", cref=" + cref + '}';
    }


}
