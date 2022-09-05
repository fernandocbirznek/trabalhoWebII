package beans;

import java.io.Serializable;

public class LoginBeans implements Serializable {
    private int id;
    private String login;
    private String senha;
    private String logado;
    
    public LoginBeans() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogado() {
        return logado;
    }

    public void setLogado(String logado) {
        this.logado = logado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
