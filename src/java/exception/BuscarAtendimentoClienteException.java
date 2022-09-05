package exception;

public class BuscarAtendimentoClienteException extends Exception {
    public BuscarAtendimentoClienteException() {}
    public BuscarAtendimentoClienteException(String string){
        super(string);
    }
    public BuscarAtendimentoClienteException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
