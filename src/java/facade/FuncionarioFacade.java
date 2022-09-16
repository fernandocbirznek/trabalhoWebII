package facade;

import beans.Categoria;
import dao.AdicionaCategoriaDao;

import java.io.IOException;
import java.util.ArrayList;

public class FuncionarioFacade {

    public static ArrayList<Categoria> getCategoria(ArrayList<Categoria> cats, Categoria cat) throws IOException{
        AdicionaCategoriaDao.getCategoria(cats,cat);
        return cats;
    }
}
