package dao;

import beans.AtendimentoBeans;
import beans.UsuarioBeans;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class GerenteDao {
    private static final String BUSCARUSUARIOS = "SELECT nome_usuario, cargo_usuario, id_usuario FROM tb_nomeTabela";
    private static final String BUSCARUSUARIOBYID = "SELECT nome_usuario, cpf_usuario, email_usuario, rua_usuario, numero_usuario, "
            + "complemento_usuario, bairro_usuario, cep_usuario, cidade_usuario, estado_usuario, telefone_usuario, cargo_usuario FROM tb_nomeTabela";
    private static final String ADICIONARUSUARIO = "INSERT INTO tb_nomeTabela(nome_usuario, cpf_usuario, email_usuario, rua_usuario, numero_usuario, "
            + "complemento_usuario, bairro_usuario, cep_usuario, cidade_usuario, estado_usuario, telefone_usuario, cargo_usuario, senha_usuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String BUSCARATENDIMENTOS = "SELECT id_atendimento, usuario_atendimento, data_atendimento, situacao_atendimento FROM tb_nomeTabela ORDER BY data_atendimento ASC";
    
    private Connection con = null;
    
    public GerenteDao(Connection con) throws DaoException {
        if(con == null) {
            throw new DaoException("Conexão nula ao criar GerenteDAO");
        }
        this.con = con;
    }
    
    public List<UsuarioBeans> buscarUsuarios() throws DaoException {
        List<UsuarioBeans> usuarios = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(BUSCARUSUARIOS)) {
            try (ResultSet rs = st.executeQuery()) {
                while(rs.next()){
                    UsuarioBeans usuario = new UsuarioBeans();
                    
                    usuario.setNomeUsuario(rs.getString(1));
                    usuario.setCargoUsuario(rs.getInt(2));
                    usuario.setIdUsuario(rs.getInt(3));
                    
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar usuarios: " + BUSCARUSUARIOS, e);
        }
        return usuarios;
    }
    
    public UsuarioBeans buscarUsuario(int id) throws DaoException {
        UsuarioBeans usuario = new UsuarioBeans();
        try(PreparedStatement st = con.prepareStatement(BUSCARUSUARIOBYID)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                usuario.setNomeUsuario(rs.getString(1));
                usuario.setCpfUsuario(rs.getString(2));
                usuario.setEmailUsuario(rs.getString(3));
                usuario.setRuaUsuario(rs.getString(4));
                usuario.setNumeroUsuario(rs.getString(5));
                usuario.setComplementoUsuario(rs.getString(6));
                usuario.setBairroUsuario(rs.getString(7));
                usuario.setCepUsuario(rs.getString(8));
                usuario.setCidadeUsuario(rs.getInt(9));
                usuario.setEstadoUsuario(rs.getInt(10));
                usuario.setTelefoneUsuario(rs.getString(11));
                usuario.setCargoUsuario(rs.getInt(12));
            }
            return usuario;
        } catch(SQLException e) {
            throw new DaoException("Erro buscando um usuário: " + BUSCARUSUARIOBYID, e);
        }
    }
    
    public void adicionarUsuario(UsuarioBeans usuario) throws DaoException {
        try (PreparedStatement st = con.prepareStatement(ADICIONARUSUARIO)) {
            st.setString(1, usuario.getNomeUsuario());
            st.setString(2, usuario.getCpfUsuario());
            st.setString(3, usuario.getEmailUsuario());
            st.setString(4, usuario.getRuaUsuario());
            st.setString(5, usuario.getNumeroUsuario());
            st.setString(6, usuario.getComplementoUsuario());
            st.setString(7, usuario.getBairroUsuario());
            st.setString(8, usuario.getCepUsuario());
            st.setInt(9, usuario.getCidadeUsuario());
            st.setInt(10, usuario.getEstadoUsuario());
            st.setString(11, usuario.getTelefoneUsuario());
            st.setInt(12, usuario.getCargoUsuario());
            st.setString(13, usuario.getSenhaUsuario());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao Inserir cliente: " + ADICIONARUSUARIO, e);
        } 
    }
    
    public List<AtendimentoBeans> buscarAtendimentos() throws DaoException, ParseException {
        List<AtendimentoBeans> atendimentos = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(BUSCARATENDIMENTOS)) {
            try (ResultSet rs = st.executeQuery()) {
                while(rs.next()){
                    AtendimentoBeans atendimento = new AtendimentoBeans();
                    atendimento.setIdAtendimento(rs.getInt(1));
                    atendimento.setUsuarioAtendimento(rs.getString(2));
                    atendimento.setDataAtendimento(rs.getString(3));
                    atendimento.setSituacaoAtendimento(rs.getString(4));
                    
                    //TODO, precisa verificar se ta certo essa formatação de dias atrasados
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
                    Date dataAtendimento = sdf.parse(rs.getString(3));
                    Date dataAtual = new java.util.Date();

                    long diferença = dataAtual.getTime() - dataAtendimento.getTime();

                    TimeUnit tempo = TimeUnit.DAYS; 
                    long dias = tempo.convert(diferença, TimeUnit.MILLISECONDS);
                    
                    atendimento.setDiasAtrasadosAtendimento(dias);
                    
                    atendimentos.add(atendimento);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar atendimentos: " + BUSCARATENDIMENTOS, e);
        }
        return atendimentos;
    }
}
