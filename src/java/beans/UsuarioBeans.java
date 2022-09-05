package beans;

import java.io.Serializable;

public class UsuarioBeans implements Serializable {
    private int idUsuario;
    private String nomeUsuario;
    private String cpfUsuario;
    private String emailUsuario;
    private String ruaUsuario;
    private String numeroUsuario;
    private String complementoUsuario;
    private String bairroUsuario;
    private String cepUsuario;
    private int cidadeUsuario;
    private int estadoUsuario;
    private String telefoneUsuario;
    private String senhaUsuario;
    private String cargoUsuario;
    
    public UsuarioBeans() {}

    public UsuarioBeans(int idUsuario, String nomeUsuario, String cpfUsuario, String emailUsuario, String ruaUsuario, String numeroUsuario, String complementoUsuario, String bairroUsuario, String cepUsuario, int cidadeUsuario, int estadoUsuario, String telefoneUsuario, String senhaUsuario, String cargoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.emailUsuario = emailUsuario;
        this.ruaUsuario = ruaUsuario;
        this.numeroUsuario = numeroUsuario;
        this.complementoUsuario = complementoUsuario;
        this.bairroUsuario = bairroUsuario;
        this.cepUsuario = cepUsuario;
        this.cidadeUsuario = cidadeUsuario;
        this.estadoUsuario = estadoUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.senhaUsuario = senhaUsuario;
        this.cargoUsuario = cargoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getRuaUsuario() {
        return ruaUsuario;
    }

    public void setRuaUsuario(String ruaUsuario) {
        this.ruaUsuario = ruaUsuario;
    }

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(String numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public String getComplementoUsuario() {
        return complementoUsuario;
    }

    public void setComplementoUsuario(String complementoUsuario) {
        this.complementoUsuario = complementoUsuario;
    }

    public String getBairroUsuario() {
        return bairroUsuario;
    }

    public void setBairroUsuario(String bairroUsuario) {
        this.bairroUsuario = bairroUsuario;
    }

    public String getCepUsuario() {
        return cepUsuario;
    }

    public void setCepUsuario(String cepUsuario) {
        this.cepUsuario = cepUsuario;
    }

    public int getCidadeUsuario() {
        return cidadeUsuario;
    }

    public void setCidadeUsuario(int cidadeUsuario) {
        this.cidadeUsuario = cidadeUsuario;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(int estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getCargoUsuario() {
        return cargoUsuario;
    }

    public void setCargoUsuario(String cargoUsuario) {
        this.cargoUsuario = cargoUsuario;
    }
}
