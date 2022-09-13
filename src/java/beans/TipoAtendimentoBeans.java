package beans;

import java.io.Serializable;

public class TipoAtendimentoBeans implements Serializable {
    private int idTipoAtendimento;
    private String nomeTipoAtendimento;
    
    public TipoAtendimentoBeans() {} 

    public TipoAtendimentoBeans(int idTipoAtendimento, String nomeTipoAtendimento) {
        this.idTipoAtendimento = idTipoAtendimento;
        this.nomeTipoAtendimento = nomeTipoAtendimento;
    }

    public int getIdTipoAtendimento() {
        return idTipoAtendimento;
    }

    public void setIdTipoAtendimento(int idTipoAtendimento) {
        this.idTipoAtendimento = idTipoAtendimento;
    }

    public String getNomeTipoAtendimento() {
        return nomeTipoAtendimento;
    }

    public void setNomeTipoAtendimento(String nomeTipoAtendimento) {
        this.nomeTipoAtendimento = nomeTipoAtendimento;
    }
}
