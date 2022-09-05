package beans;

import java.io.Serializable;

public class ProdutoBeans implements Serializable {
    private int idProduto;
    private String nomeProduto;
    private String categoriaProduto;
    private String descricaoProduto;
    private double pesoProduto;
    
    public ProdutoBeans () {}

    public ProdutoBeans(int idProduto, String nomeProduto, String categoriaProduto, String descricaoProduto, double pesoProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.descricaoProduto = descricaoProduto;
        this.pesoProduto = pesoProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getPesoProduto() {
        return pesoProduto;
    }

    public void setPesoProduto(double pesoProduto) {
        this.pesoProduto = pesoProduto;
    }
    
    
}
