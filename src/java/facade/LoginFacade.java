package facade;

import beans.UsuarioBeans;
import dao.ConnectionFactory;
import dao.LoginDao;
import exception.BuscarUsuarioLoginException;
import exception.DaoException;

public class LoginFacade {
    public static UsuarioBeans buscarUsuarioLogin(String email, String senha) throws BuscarUsuarioLoginException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            LoginDao loginDao = new LoginDao(factory.getConnection());
            UsuarioBeans usuario = loginDao.buscarUsuarioLogin(email, senha);   
            return usuario;
        } catch (DaoException e) {
            throw new BuscarUsuarioLoginException("Erro ao buscar todos os usuários do sistema.", e);
        }
    }
}
