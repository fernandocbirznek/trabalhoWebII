package dao;

import beans.EstadoBeans;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDao {
    private static final String SELECTESTADOS = "SELECT id, nome, uf FROM estados";
    
    private Connection con = null;
    
    public EstadoDao(Connection con) throws DaoException {
        if(con == null) {
            throw new DaoException("Conexão nula ao criar EstadoDAO");
        }
        this.con = con;
    }
    
    public List<EstadoBeans> buscarEstados() throws DaoException {
        List<EstadoBeans> estados = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(SELECTESTADOS)) {
            try (ResultSet rs = st.executeQuery()) {
                while(rs.next()){
                    EstadoBeans estado = new EstadoBeans();
                    estado.setId(rs.getInt(1));
                    estado.setNome(rs.getString(2));
                    estado.setUf(rs.getString(3));
                    estados.add(estado);
                }
            }
            return estados;
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar clientes: " + SELECTESTADOS, e);
        }
    }
}
