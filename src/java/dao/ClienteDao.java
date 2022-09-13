package dao;

import beans.AtendimentoBeans;
import beans.TipoAtendimentoBeans;
import beans.UsuarioBeans;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClienteDao implements daoT<UsuarioBeans> {
    private static final String ATUALIZAR = "UPDATE tb_usuario SET "
            + "nome_usuario = ?, "
            + "senha_usuario = ?, "
            + "rua_usuario = ?, "
            + "numero_usuario = ?, "
            + "complemento_usuario = ?, "
            + "bairro_usuario = ?, "
            + "cep_usuario = ?, "
            + "cidade_usuario = ?, "
            + "estado_usuario = ?, telefone_usuario = ? WHERE id_usuario = ?";
    
    private static final String SELECIONARATENDIMENTOS = "SELECT id, dataAtenidmento, cliente, situacao, descricao, solucao, fk_TipoAtendimento_idTipoAtendimento "
            + "FROM atendimento WHERE cliente = ?";
    
    private static final String REMOVERPORID = "DELETE FROM atendimento WHERE id = ?";
    
    private static final String SELECIONARATENDIMENTOPORID = "SELECT id, dataAtenidmento, "
            + "cliente, situacao, descricao, solucao, fk_TipoAtendimento_idTipoAtendimento "
            + "FROM atendimento WHERE id = ?";
    
    private static final String NOVOCLIENTE = "INSERT INTO tb_usuario(nome_usuario, email_usuario, senha_usuario, cpf_usuario, rua_usuario, numero_usuario, "
            + "complemento_usuario, bairro_usuario, cep_usuario, cidade_usuario, estado_usuario, telefone_usuario, cargo_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String INSERIRATENDIMENTO = "INSERT INTO Atendimento(id, dataAtenidmento, cliente, situacao, descricao, solucao, fk_TipoAtendimento_idTipoAtendimento) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SELECIONARTIPOATENDIMENTO = "SELECT * FROM TipoAtendimento";

    
    private Connection con = null;
    
    public ClienteDao(Connection con) throws DaoException {
        if(con == null) {
            throw new DaoException("Conexão nula ao criar UsuarioDAO");
        }
        this.con = con;
    }

    public AtendimentoBeans buscarAtendimentoId(int id) throws DaoException {
        AtendimentoBeans atendimento = new AtendimentoBeans();
        try(PreparedStatement st = con.prepareStatement(SELECIONARATENDIMENTOPORID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                atendimento.setTipoAtendimento(rs.getInt(1));
                java.util.Date data = new java.util.Date(rs.getDate(2).getTime());
                atendimento.setDataAtendimento(data);
                atendimento.setUsuarioAtendimento(rs.getInt(3));
                atendimento.setSituacaoAtendimento(rs.getBoolean(4));
                atendimento.setDescricaoAtendimento(rs.getString(5));
                atendimento.setSolucaoAtendimento(rs.getString(6));
                atendimento.setTipoAtendimento(rs.getInt(7));  
            }
            return atendimento;
        } catch(SQLException e) {
            throw new DaoException("Erro buscando um usuário: " + SELECIONARATENDIMENTOPORID, e);
        }
    }
    
    public void inserirAtendimentoCliente(AtendimentoBeans atendimento) throws DaoException {
        try (PreparedStatement st = con.prepareStatement(INSERIRATENDIMENTO)) {
            st.setInt(1, new Random().nextInt(10000));
            java.util.Date dt = atendimento.getDataAtendimento();
            st.setDate(2, new java.sql.Date(dt.getTime()));
            st.setInt(3, atendimento.getUsuarioAtendimento());
            st.setBoolean(4, atendimento.getSituacaoAtendimento());
            st.setString(5, atendimento.getDescricaoAtendimento());
            st.setString(6, atendimento.getSolucaoAtendimento());
            st.setInt(7, atendimento.getTipoAtendimento());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao cadastrar atendimento!!! " + INSERIRATENDIMENTO, e);
        } 
    }
    
    public void cadastrarNovoCliente(UsuarioBeans novoCliente) throws DaoException {
        try (PreparedStatement st = con.prepareStatement(NOVOCLIENTE)) {
            st.setString(1, novoCliente.getNomeUsuario());
            st.setString(2, novoCliente.getEmailUsuario());
            st.setString(3, novoCliente.getSenhaUsuario());
            st.setString(4, novoCliente.getCpfUsuario());
            st.setString(5, novoCliente.getRuaUsuario());
            st.setString(6, novoCliente.getNumeroUsuario());
            st.setString(7, novoCliente.getComplementoUsuario());
            st.setString(8, novoCliente.getBairroUsuario());
            st.setString(9, novoCliente.getCepUsuario());
            st.setInt(10, novoCliente.getCidadeUsuario());
            st.setInt(11, novoCliente.getEstadoUsuario());
            st.setString(12, novoCliente.getTelefoneUsuario());
            st.setInt(13, novoCliente.getCargoUsuario());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao cadastrar novo cliente: " + NOVOCLIENTE, e);
        } 
    }
    
    public List<AtendimentoBeans> buscarAtendimentosCliente(int id) throws DaoException {
        List<AtendimentoBeans> atendimentos = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(SELECIONARATENDIMENTOS)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                AtendimentoBeans atendimento = new AtendimentoBeans();

                atendimento.setIdAtendimento(rs.getInt(1));
                java.util.Date data = new java.util.Date(rs.getDate(2).getTime());
                atendimento.setDataAtendimento(data); 
                atendimento.setSituacaoAtendimento(rs.getBoolean(4));
                atendimento.setDescricaoAtendimento(rs.getString(5)); 
                atendimento.setSolucaoAtendimento(rs.getString(6));
                atendimento.setTipoAtendimento(rs.getInt(7));

                atendimentos.add(atendimento);
            } 
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar clientes: " + SELECIONARATENDIMENTOS, e);
        }
        return atendimentos;
    }

    public List<TipoAtendimentoBeans> buscarTipoAtendimentos() throws DaoException {
        List<TipoAtendimentoBeans> tipoAtendimentos = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(SELECIONARTIPOATENDIMENTO)) {
            try (ResultSet rs = st.executeQuery()) {
                while(rs.next()){
                    TipoAtendimentoBeans tipoAtendimento = new TipoAtendimentoBeans();
                    tipoAtendimento.setIdTipoAtendimento(rs.getInt(1));
                    tipoAtendimento.setNomeTipoAtendimento(rs.getString(2));
                    tipoAtendimentos.add(tipoAtendimento);
                }
            }
            return tipoAtendimentos;
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar tipos atendimentos: " + SELECIONARTIPOATENDIMENTO, e);
        }
    }
    
    @Override
    public void atualizar(UsuarioBeans cliente) throws DaoException {
        try (PreparedStatement st = con.prepareStatement(ATUALIZAR)) {
            st.setString(1, cliente.getNomeUsuario());
            st.setString(2, cliente.getSenhaUsuario());
            st.setString(3, cliente.getRuaUsuario());
            st.setString(4, cliente.getNumeroUsuario());
            st.setString(5, cliente.getComplementoUsuario());
            st.setString(6, cliente.getBairroUsuario());
            st.setString(7, cliente.getCepUsuario());
            st.setInt(8, cliente.getCidadeUsuario());
            st.setInt(9, cliente.getEstadoUsuario());
            st.setString(10, cliente.getTelefoneUsuario());
            st.setInt(11, cliente.getIdUsuario());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao Atualizar cliente: " + ATUALIZAR, e);
        } 
    }

    @Override
    public void remover(int id) throws DaoException {
        try(PreparedStatement st = con.prepareStatement(REMOVERPORID)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException("Erro ao remover atendimento: " + REMOVERPORID, e);
        }
    }
    
    @Override
    public UsuarioBeans buscarId(int l) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<UsuarioBeans> buscarTodos() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(UsuarioBeans t) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
