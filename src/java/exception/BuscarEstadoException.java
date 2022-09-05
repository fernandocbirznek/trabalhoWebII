package exception;

public class BuscarEstadoException extends Exception {
    public BuscarEstadoException() {}
    public BuscarEstadoException(String string){
        super(string);
    }
    public BuscarEstadoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
