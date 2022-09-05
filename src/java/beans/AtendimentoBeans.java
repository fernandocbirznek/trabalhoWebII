package beans;

import java.io.Serializable;

public class AtendimentoBeans implements Serializable  {
    private int idAtendimento;
    private String dataAtendimento;
    private long diasAtrasadosAtendimento;
    private String usuarioAtendimento;
    private String situacaoAtendimento;
    private String produtoAtendimento;
    private String tipoAtendimento;
    private String descricaoAtendimento;
    private String solucaoAtendimento;
    
     public AtendimentoBeans() {}

    public AtendimentoBeans(int idAtendimento, String dataAtendimento, long diasAtrasadosAtendimento, String usuarioAtendimento, String situacaoAtendimento, String produtoAtendimento, String tipoAtendimento, String descricaoAtendimento, String solucaoAtendimento) {
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

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public long getDiasAtrasadosAtendimento() {
        return diasAtrasadosAtendimento;
    }

    public void setDiasAtrasadosAtendimento(long diasAtrasadosAtendimento) {
        this.diasAtrasadosAtendimento = diasAtrasadosAtendimento;
    }

    public String getUsuarioAtendimento() {
        return usuarioAtendimento;
    }

    public void setUsuarioAtendimento(String usuarioAtendimento) {
        this.usuarioAtendimento = usuarioAtendimento;
    }

    public String getSituacaoAtendimento() {
        return situacaoAtendimento;
    }

    public void setSituacaoAtendimento(String situacaoAtendimento) {
        this.situacaoAtendimento = situacaoAtendimento;
    }

    public String getProdutoAtendimento() {
        return produtoAtendimento;
    }

    public void setProdutoAtendimento(String produtoAtendimento) {
        this.produtoAtendimento = produtoAtendimento;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
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
     
     
}
