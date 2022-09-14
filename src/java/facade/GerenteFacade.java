package facade;

import beans.AtendimentoBeans;
import beans.EstadoBeans;
import beans.UsuarioBeans;
import dao.ClienteDao;
import dao.ConnectionFactory;
import dao.EstadoDao;
import dao.GerenteDao;
import exception.AdicionarUsuarioException;
import exception.BuscarAtendimentosException;
import exception.BuscarEstadoException;
import exception.BuscarUsuarioException;
import exception.BuscarUsuariosException;
import exception.DaoException;
import exception.RemoverUsuarioException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class GerenteFacade {
    public static List<UsuarioBeans> buscarUsuarios() throws BuscarUsuariosException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            GerenteDao gerenteDao = new GerenteDao(factory.getConnection());
            List<UsuarioBeans> usuarios = gerenteDao.buscarUsuarios();   
            return usuarios;
        } catch (DaoException e) {
            throw new BuscarUsuariosException("Erro ao buscar todos os usuários do sistema.", e);
        }
    }
    
    public static UsuarioBeans buscarUsuario(int id) throws BuscarUsuarioException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            GerenteDao gerenteDao = new GerenteDao(factory.getConnection());
            UsuarioBeans cliente = gerenteDao.buscarUsuario(id);  
            return cliente;
        } catch (DaoException e) {
            throw new BuscarUsuarioException("Erro ao buscar usuario: id = " + id, e);
        }
    }
    
    public static void adicionarUsuario(UsuarioBeans usuario) throws AdicionarUsuarioException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            GerenteDao gerenteDao = new GerenteDao(factory.getConnection());
            gerenteDao.adicionarUsuario(usuario);   
        } catch (DaoException e) {
            throw new AdicionarUsuarioException("Erro ao adicionar usuário.", e);
        }
    }
    
    public static void removerUsuario(int id) throws RemoverUsuarioException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            clienteDao.remover(id);  
        } catch (DaoException e) {
            throw new RemoverUsuarioException("Erro ao remover usuario ", e);
        }
    }

    public static List<EstadoBeans> buscarEstados() throws BuscarEstadoException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            EstadoDao estadoDao = new EstadoDao(factory.getConnection());
            List<EstadoBeans> estados = estadoDao.buscarEstados();  
            return estados;
        } catch (DaoException e) {
            throw new BuscarEstadoException("Erro ao buscar estados ", e);
        }
    }
    
    public static List<AtendimentoBeans> buscarAtendimentos() throws BuscarAtendimentosException, ParseException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            GerenteDao gerenteDao = new GerenteDao(factory.getConnection());
            List<AtendimentoBeans> atendimentos = gerenteDao.buscarAtendimentos();  
            return atendimentos;
        } catch (DaoException e) {
            throw new BuscarAtendimentosException("Erro ao buscar atendimentos!!!", e);
        }
    }
}
