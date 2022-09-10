package funcionario.model;

import java.io.Serializable;

public class Categoria implements Serializable {
    private int id;
    private String nome;

    public Categoria(){}
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

