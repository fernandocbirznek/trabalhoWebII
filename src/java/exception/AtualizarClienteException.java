package exception;

public class AtualizarClienteException extends Exception {
    public AtualizarClienteException() {}
    public AtualizarClienteException(String string){
        super(string);
    }
    public AtualizarClienteException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
