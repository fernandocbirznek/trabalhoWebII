package exception;

public class InserirAtendimentoException extends Exception {
    public InserirAtendimentoException() {}
    public InserirAtendimentoException(String string){
        super(string);
    }
    public InserirAtendimentoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
