package exception;

public class BuscarUsuarioException extends Exception {
    public BuscarUsuarioException() {}
    public BuscarUsuarioException(String string){
        super(string);
    }
    public BuscarUsuarioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
