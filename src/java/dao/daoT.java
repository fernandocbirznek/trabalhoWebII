package dao;

import exception.DaoException;
import java.util.List;

public interface daoT<T> {
    T buscarId(int l) throws DaoException;
    List<T> buscarTodos() throws DaoException;
    void inserir(T t) throws DaoException;
    void atualizar(T t) throws DaoException;
    void remover(int t) throws DaoException;
}
