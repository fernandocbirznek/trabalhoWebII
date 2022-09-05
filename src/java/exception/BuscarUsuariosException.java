package exception;

public class BuscarUsuariosException extends Exception {
    public BuscarUsuariosException() {}
    public BuscarUsuariosException(String string){
        super(string);
    }
    public BuscarUsuariosException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
