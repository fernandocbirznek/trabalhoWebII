package beans;

import java.io.Serializable;
import java.util.Date;

public class AtendimentoBeans implements Serializable  {
    private int idAtendimento;
    private Date dataAtendimento;
    private long diasAtrasadosAtendimento;
    private int usuarioAtendimento;
    private boolean situacaoAtendimento;
    private String produtoAtendimento;
    private int tipoAtendimento;
    private String descricaoAtendimento;
    private String solucaoAtendimento;
    private String tipoAtendimentoString;
    private String dataAtendimentoString;
    
    public AtendimentoBeans() {}

    public AtendimentoBeans(int idAtendimento, Date dataAtendimento, long diasAtrasadosAtendimento, int usuarioAtendimento, boolean situacaoAtendimento, String produtoAtendimento, int tipoAtendimento, String descricaoAtendimento, String solucaoAtendimento) {
        this.idAtendimento = idAtendimento;
        this.dataAtendimento = dataAtendimento;
        this.diasAtrasadosAtendimento = diasAtrasadosAtendimento;
        this.usuarioAtendimento = usuarioAtendimento;
        this.situacaoAtendimento = situacaoAtendimento;
        this.produtoAtendimento = produtoAtendimento;
        this.tipoAtendimento = tipoAtendimento;
        this.descricaoAtendimento = descricaoAtendimento;
        this.solucaoAtendimento = solucaoAtendimento;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public long getDiasAtrasadosAtendimento() {
        return diasAtrasadosAtendimento;
    }

    public void setDiasAtrasadosAtendimento(long diasAtrasadosAtendimento) {
        this.diasAtrasadosAtendimento = diasAtrasadosAtendimento;
    }

    public int getUsuarioAtendimento() {
        return usuarioAtendimento;
    }

    public void setUsuarioAtendimento(int usuarioAtendimento) {
        this.usuarioAtendimento = usuarioAtendimento;
    }

    public boolean getSituacaoAtendimento() {
        return situacaoAtendimento;
    }

    public void setSituacaoAtendimento(boolean situacaoAtendimento) {
        this.situacaoAtendimento = situacaoAtendimento;
    }

    public String getProdutoAtendimento() {
        return produtoAtendimento;
    }

    public void setProdutoAtendimento(String produtoAtendimento) {
        this.produtoAtendimento = produtoAtendimento;
    }

    public int getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(int tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public String getSolucaoAtendimento() {
        return solucaoAtendimento;
    }

    public void setSolucaoAtendimento(String solucaoAtendimento) {
        this.solucaoAtendimento = solucaoAtendimento;
    }

    public String getTipoAtendimentoString() {
        return tipoAtendimentoString;
    }

    public void setTipoAtendimentoString(String tipoAtendimentoString) {
        this.tipoAtendimentoString = tipoAtendimentoString;
    }

    public String getDataAtendimentoString() {
        return dataAtendimentoString;
    }

    public void setDataAtendimentoString(String dataAtendimentoString) {
        this.dataAtendimentoString = dataAtendimentoString;
    }
     
     
}
