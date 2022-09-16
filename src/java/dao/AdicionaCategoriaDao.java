package dao;

import beans.Categoria;

import java.io.IOException;
import java.util.ArrayList;

public class AdicionaCategoriaDao {
    public static ArrayList<Categoria> getCategoria(ArrayList<Categoria> cats, Categoria cat) throws IOException{
        cats.add(cat);
        return cats;
    }
}
