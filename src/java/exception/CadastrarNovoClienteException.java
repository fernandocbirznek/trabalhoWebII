package exception;

public class CadastrarNovoClienteException extends Exception {
    public CadastrarNovoClienteException() {}
    public CadastrarNovoClienteException(String string){
        super(string);
    }
    public CadastrarNovoClienteException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
