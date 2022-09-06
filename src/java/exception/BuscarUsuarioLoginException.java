package exception;

public class BuscarUsuarioLoginException extends Exception {
    public BuscarUsuarioLoginException() {}
    public BuscarUsuarioLoginException(String string){
        super(string);
    }
    public BuscarUsuarioLoginException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
