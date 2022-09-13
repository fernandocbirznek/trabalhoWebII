package facade;

import beans.EstadoBeans;
import dao.ConnectionFactory;
import dao.EstadoDao;
import exception.BuscarEstadoException;
import exception.DaoException;
import java.util.List;

public class EstadoCidadeFacade {
    public static List<EstadoBeans> buscarEstado() throws BuscarEstadoException {
        try (ConnectionFactory factory = new ConnectionFactory()) {  
            EstadoDao estadoDao = new EstadoDao(factory.getConnection());
            List<EstadoBeans> listaEstado = estadoDao.buscarEstados();  
            return listaEstado;
        } catch (DaoException e) {
            throw new BuscarEstadoException("Erro ao buscar atendimento: id = ", e);
        }
    }
}
