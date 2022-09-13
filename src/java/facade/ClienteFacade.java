package facade;

import beans.AtendimentoBeans;
import beans.TipoAtendimentoBeans;
import beans.UsuarioBeans;
import dao.ClienteDao;
import dao.ConnectionFactory;
import exception.AtualizarClienteException;
import exception.BuscarAtendimentoClienteException;
import exception.BuscarAtendimentoIdException;
import exception.BuscarTipoAtendimentoException;
import exception.CadastrarNovoClienteException;
import exception.DaoException;
import exception.InserirAtendimentoException;
import exception.RemoverAtendimentoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ClienteFacade {
    public static List<AtendimentoBeans> buscarAtendimentosCliente(int id) throws BuscarAtendimentoClienteException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            List<AtendimentoBeans> atendimentos = clienteDao.buscarAtendimentosCliente(id);   
            return atendimentos;
        } catch (DaoException e) {
            throw new BuscarAtendimentoClienteException("Erro ao buscar todos os atendimentos dos clientes.", e);
        }
    }
    
    public static AtendimentoBeans buscarAtendimentoId(int id) throws BuscarAtendimentoIdException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            AtendimentoBeans atendimento = clienteDao.buscarAtendimentoId(id);  
            return atendimento;
        } catch (DaoException e) {
            throw new BuscarAtendimentoIdException("Erro ao buscar atendimento: id = " + id, e);
        }
    }
    
    public static void atualizarCliente(UsuarioBeans cliente) throws AtualizarClienteException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            clienteDao.atualizar(cliente);   
        } catch (DaoException e) {
            throw new AtualizarClienteException("Erro ao alterar dados do cliente.", e);
        }
    }
    
    public static void removerAtendimentoCliente(int id) throws RemoverAtendimentoException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            clienteDao.remover(id);
        } catch (DaoException e) {
            throw new RemoverAtendimentoException("Erro ao buscar cliente: id = " + id, e);
        }
    }
    
    public static void cadastrarNovoCliente(UsuarioBeans novoCliente) throws CadastrarNovoClienteException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            clienteDao.cadastrarNovoCliente(novoCliente);
        } catch (DaoException e) {
            throw new CadastrarNovoClienteException("Erro ao buscar cliente: id = " + novoCliente, e);
        }
    }
    
    public static void inserirAtendimento(AtendimentoBeans atendimento) throws InserirAtendimentoException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            clienteDao.inserirAtendimentoCliente(atendimento);        
        } catch (DaoException e) {
            throw new InserirAtendimentoException("Erro ao cadastrar atendimento!!!", e);
        }
    }
    
    public static List<TipoAtendimentoBeans> buscarTipoAtendimento() throws BuscarTipoAtendimentoException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            List<TipoAtendimentoBeans> listaTipoAtendimentos = clienteDao.buscarTipoAtendimentos();  
            return listaTipoAtendimentos;
        } catch (DaoException e) {
            throw new BuscarTipoAtendimentoException("Erro ao buscar tipo atendimento!!!", e);
        }
    }
}
