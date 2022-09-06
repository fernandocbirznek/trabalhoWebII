package dao;

import beans.UsuarioBeans;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private static final String BUSCARUSUARIOLOGIN = "SELECT id_usuario, nome_usuario, email_usuario, senha_usuario, cpf_usuario, rua_usuario, numero_usuario, "
            + "complemento_usuario, bairro_usuario, cep_usuario, cidade_usuario, estado_usuario, telefone_usuario, cargo_usuario "
            + "FROM tb_usuario WHERE email_usuario = ? AND senha_usuario = ?";
    
    private Connection con = null;
    
    public LoginDao(Connection con) throws DaoException {
        if(con == null) {
            throw new DaoException("Conexão nula ao criar UsuarioDAO");
        }
        this.con = con;
    }
    
    public UsuarioBeans buscarUsuarioLogin(String email, String senha) throws DaoException {
        UsuarioBeans usuario = new UsuarioBeans();
        try(PreparedStatement st = con.prepareStatement(BUSCARUSUARIOLOGIN)) {
            st.setString(1, email);
            st.setString(2, senha);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setEmailUsuario(rs.getString("email_usuario"));
                usuario.setSenhaUsuario(rs.getString("senha_usuario"));
                usuario.setCpfUsuario(rs.getString("cpf_usuario"));
                usuario.setRuaUsuario(rs.getString("rua_usuario"));
                usuario.setNumeroUsuario(rs.getString("numero_usuario"));
                usuario.setComplementoUsuario(rs.getString("complemento_usuario"));
                usuario.setBairroUsuario(rs.getString("bairro_usuario"));
                usuario.setCepUsuario(rs.getString("cep_usuario"));
                usuario.setCidadeUsuario(rs.getInt("cidade_usuario"));
                usuario.setEstadoUsuario(rs.getInt("estado_usuario"));
                usuario.setTelefoneUsuario(rs.getString("telefone_usuario"));
                usuario.setCargoUsuario(rs.getInt("cargo_usuario"));
            }
            return usuario;
        } catch(SQLException e) {
            throw new DaoException("Erro buscando um usuário: " + BUSCARUSUARIOLOGIN, e);
        }
    }
}
	
