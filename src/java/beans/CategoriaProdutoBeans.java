package beans;

import java.io.Serializable;

public class CategoriaProdutoBeans implements Serializable {
    private int idCategoriaProduto;
    private String nomeCategoriaProduto;
    
    public CategoriaProdutoBeans () {}

    public CategoriaProdutoBeans(int idCategoriaProduto, String nomeCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
        this.nomeCategoriaProduto = nomeCategoriaProduto;
    }

    public int getIdCategoriaProduto() {
        return idCategoriaProduto;
    }

    public void setIdCategoriaProduto(int idCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
    }

    public String getNomeCategoriaProduto() {
        return nomeCategoriaProduto;
    }

    public void setNomeCategoriaProduto(String nomeCategoriaProduto) {
        this.nomeCategoriaProduto = nomeCategoriaProduto;
    }
}
