package dao;

import beans.AtendimentoBeans;
import beans.UsuarioBeans;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements daoT<UsuarioBeans> {
    private static final String ATUALIZAR = "UPDATE NOMETABELA SET "
            + "nome_cliente = ?, "
            + "telefone_cliente = ?, "
            + "senha_cliente = ?, "
            + "rua_cliente = ?, "
            + "numero_cliente = ?, "
            + "complemento_cliente = ?, "
            + "bairro_cliente = ?, "
            + "cep_cliente = ?, "
            + "cidade_cliente = ?,"
            + "estado_cliente = ? WHERE id_cliente = ?";
    
    private static final String SELECIONARATENDIMENTOS = "SELECT tipo_atendimento, descricao_atendimento, "
            + "produto_atendimento, situacao_atendimento, data_atendimento, id_atendimento "
            + "FROM NOMETABELA WHERE cliente_atendimento = ?";
    
    private static final String INSERIRATENDIMENTOCLIENTE = "INSERT INTO NOMETABELA("
            + "data_atendimento, cliente_atendimento, situacao_atendimento, produto_atendimento, tipo_atendimento, "
            + "descricao_atendimento, solucao_atendimento) VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    private static final String REMOVERPORID = "DELETE FROM NOMETABELA WHERE id_atendimento = ?";
    
    private static final String SELECIONARATENDIMENTOPORID = "SELECT tipo_atendimento, descricao_atendimento, "
            + "produto_atendimento, situacao_atendimento, data_atendimento, solucao_atendimento "
            + "FROM NOMETABELA WHERE id_atendimento = ?";
    
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
                atendimento.setTipoAtendimento(rs.getString("tipo_atendimento"));
                atendimento.setDescricaoAtendimento(rs.getString("descricao_atendimento"));
                atendimento.setProdutoAtendimento(rs.getString("produto_atendimento"));
                atendimento.setSituacaoAtendimento(rs.getString("situacao_atendimento"));
                atendimento.setDataAtendimento(rs.getString("data_atendimento"));
                atendimento.setSolucaoAtendimento(rs.getString("solucao_atendimento"));
                
            }
            return atendimento;
        } catch(SQLException e) {
            throw new DaoException("Erro buscando um usuário: " + SELECIONARATENDIMENTOPORID, e);
        }
    }
    
    public void inserirAtendimentoCliente(AtendimentoBeans atendimento) throws DaoException {
        try (PreparedStatement st = con.prepareStatement(INSERIRATENDIMENTOCLIENTE)) {
            st.setString(1, atendimento.getDataAtendimento());
            st.setString(2, atendimento.getUsuarioAtendimento());
            st.setString(3, atendimento.getSituacaoAtendimento());
            st.setString(4, atendimento.getProdutoAtendimento());
            st.setString(5, atendimento.getTipoAtendimento());
            st.setString(6, atendimento.getDescricaoAtendimento());
            st.setString(7, atendimento.getSolucaoAtendimento());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao Inserir cliente: " + INSERIRATENDIMENTOCLIENTE, e);
        } 
    }
    
    public List<AtendimentoBeans> buscarAtendimentosCliente(int id) throws DaoException {
        List<AtendimentoBeans> atendimentos = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(SELECIONARATENDIMENTOS)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                AtendimentoBeans atendimento = new AtendimentoBeans();

                atendimento.setTipoAtendimento(rs.getString(1));
                atendimento.setDescricaoAtendimento(rs.getString(2));            
                atendimento.setProdutoAtendimento(rs.getString(3));
                atendimento.setSituacaoAtendimento(rs.getString(4));
                atendimento.setDataAtendimento(rs.getString(5));       
                atendimento.setIdAtendimento(rs.getInt(6));

                atendimentos.add(atendimento);
            } 
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar clientes: " + SELECIONARATENDIMENTOS, e);
        }
        return atendimentos;
    }

    @Override
    public void atualizar(UsuarioBeans cliente) throws DaoException {
        try (PreparedStatement st = con.prepareStatement(ATUALIZAR)) {
            st.setString(1, cliente.getNomeUsuario());
            st.setString(2, cliente.getTelefoneUsuario());
            st.setString(3, cliente.getSenhaUsuario());
            st.setString(4, cliente.getRuaUsuario());
            st.setString(5, cliente.getNumeroUsuario());
            st.setString(6, cliente.getComplementoUsuario());
            st.setString(7, cliente.getBairroUsuario());
            st.setString(8, cliente.getCepUsuario());
            st.setInt(9, cliente.getCidadeUsuario());
            st.setInt(10, cliente.getEstadoUsuario());
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
            throw new DaoException("Erro buscando um usuário: " + REMOVERPORID, e);
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
