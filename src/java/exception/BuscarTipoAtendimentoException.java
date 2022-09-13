package exception;

public class BuscarTipoAtendimentoException extends Exception {
    public BuscarTipoAtendimentoException() {}
    public BuscarTipoAtendimentoException(String string){
        super(string);
    }
    public BuscarTipoAtendimentoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
