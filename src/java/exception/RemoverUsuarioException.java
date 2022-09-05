package exception;

public class RemoverUsuarioException extends Exception {
    public RemoverUsuarioException() {}
    public RemoverUsuarioException(String string){
        super(string);
    }
    public RemoverUsuarioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
