package funcionario.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private int id;
    private String nome;
    private Categoria categoria;
    private String descricao;
    private String peso;

    public Produto(int id,String nome, String descricao,String peso ){
        this.id=id;
        this.nome=nome;
        this.descricao=descricao;
        this.peso=peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
