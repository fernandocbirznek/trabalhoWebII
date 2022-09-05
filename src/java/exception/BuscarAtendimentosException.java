package exception;

public class BuscarAtendimentosException extends Exception {
    public BuscarAtendimentosException() {}
    public BuscarAtendimentosException(String string){
        super(string);
    }
    public BuscarAtendimentosException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
