package dao;

import exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/trabalhowebii?autoReconnect=true&useSSL=false";
    private static String LOGIN = "mysql";
    private static String SENHA = "mysql";
    
    private Connection con = null;
    
    public Connection getConnection() throws DaoException {
        if(con == null){
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, LOGIN, SENHA);
            } 
            catch(ClassNotFoundException e){
                throw new DaoException("Driver do banco não encontrado: " + DRIVER, e);
            }
            catch(SQLException e){
                throw new DaoException("Erro conectando ao BD: " + URL + "/" + LOGIN + "/" + SENHA, e);
            }
        }
        return con;
    }

    @Override
    public void close() {
        if(con != null) {
            try {
                con.close();
                con = null;
            } catch (Exception e) {
                System.out.println("Erro fechando a conexão. IGNORADO");
                e.printStackTrace();
            }
        }
    }
}
