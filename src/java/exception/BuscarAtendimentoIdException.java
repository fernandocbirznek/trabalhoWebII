package exception;

public class BuscarAtendimentoIdException extends Exception {
    public BuscarAtendimentoIdException() {}
    public BuscarAtendimentoIdException(String string){
        super(string);
    }
    public BuscarAtendimentoIdException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
