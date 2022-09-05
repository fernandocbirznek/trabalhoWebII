package exception;

public class RemoverAtendimentoException extends Exception {
    public RemoverAtendimentoException() {}
    public RemoverAtendimentoException(String string){
        super(string);
    }
    public RemoverAtendimentoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
