package dao;

import beans.CidadeBeans;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDao {
    private static final String SELECTCIDADEBYESTADOID = "SELECT id, nome FROM tb_cidade WHERE fk_estado_id = ?";
    
    private Connection con = null;
    
    public CidadeDao(Connection con) throws DaoException {
        if(con == null) {
            throw new DaoException("Conexão nula ao criar UsuarioDAO");
        }
        this.con = con;
    }
    
    public List<CidadeBeans> buscarCidadeNome(int idEstado) throws DaoException {
        List<CidadeBeans> cidades = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(SELECTCIDADEBYESTADOID)) {
            st.setInt(1, idEstado);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                CidadeBeans cidade = new CidadeBeans();
                cidade.setId(rs.getInt("id")); 
                cidade.setNome(rs.getString("nome")); 
                cidades.add(cidade);
            }
            return cidades;
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar clientes: " + SELECTCIDADEBYESTADOID, e);
        }
    }
}
