package facade;

import beans.AtendimentoBeans;
import beans.UsuarioBeans;
import dao.ClienteDao;
import dao.ConnectionFactory;
import exception.AtualizarClienteException;
import exception.BuscarAtendimentoClienteException;
import exception.BuscarAtendimentoIdException;
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
    
    public static void atualizarCliente(HttpServletRequest request) throws AtualizarClienteException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            String id = request.getParameter("id");
            String nome = request.getParameter("nomeCompletoAlterar");
            String telefone = request.getParameter("telefoneAlterar");
            telefone = telefone.replace("(", "");
            telefone = telefone.replace(")", "");
            telefone = telefone.replace("-", "");
            String senha = request.getParameter("senhaAlterar");
            String rua = request.getParameter("ruaAlterar");
            String numero = request.getParameter("numeroAlterar");
            String complemento = request.getParameter("complementoAlterar");
            String bairro = request.getParameter("bairroAlterar");
            String cep = request.getParameter("cepAlterar");
            cep = cep.replace(".", "");
            cep = cep.replace("-", "");
            String cidade = request.getParameter("cidadeAlterar");
            String estado = request.getParameter("estadoAlterar");

            UsuarioBeans cliente = new UsuarioBeans();
            cliente.setIdUsuario(Integer.parseInt(id));
            cliente.setNomeUsuario(nome);
            cliente.setTelefoneUsuario(telefone);
            cliente.setSenhaUsuario(senha);
            cliente.setRuaUsuario(rua);
            cliente.setNumeroUsuario(numero);
            cliente.setComplementoUsuario(complemento);
            cliente.setBairroUsuario(bairro);
            cliente.setCepUsuario(cep);
            cliente.setCidadeUsuario(Integer.parseInt(cidade));
            cliente.setEstadoUsuario(Integer.parseInt(estado));
            
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
    
    public static void inserirAtendimento(HttpServletRequest request) throws InserirAtendimentoException {
        try (ConnectionFactory factory = new ConnectionFactory()) {

            String data = request.getParameter("dataInserir");
            String tipo = request.getParameter("tipoInserir");
            String cliente = request.getParameter("clienteInserir");
            String solucao = request.getParameter("solucaoInserir");
            String descricao = request.getParameter("descricaoInserir");
            String situacao = request.getParameter("situacaoInserir");
            String produto = request.getParameter("produtoInserir");
            
            AtendimentoBeans atendimento = new AtendimentoBeans();
            //atendimento.setDataAtendimento(data);
            //TODO, NECESSÁRIO TRANSFORMAR DATA PARA TIPO ADEQUADO
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateToStr = dateFormat.format(data);
            atendimento.setDataAtendimento(dateToStr);
            
            atendimento.setTipoAtendimento(tipo);
            atendimento.setUsuarioAtendimento(cliente);
            atendimento.setSolucaoAtendimento(solucao);
            atendimento.setDescricaoAtendimento(descricao);
            atendimento.setSituacaoAtendimento(situacao);
            atendimento.setProdutoAtendimento(produto);
            
            ClienteDao clienteDao = new ClienteDao(factory.getConnection());
            clienteDao.inserirAtendimentoCliente(atendimento);        
        } catch (DaoException e) {
            throw new InserirAtendimentoException("Erro ao alterar cliente: " + request, e);
        }
    }
}
