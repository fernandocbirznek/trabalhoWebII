package exception;

public class AdicionarUsuarioException extends Exception {
    public AdicionarUsuarioException() {}
    public AdicionarUsuarioException(String string){
        super(string);
    }
    public AdicionarUsuarioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
