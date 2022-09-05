package exception;

public class DaoException extends Exception {
    public DaoException() {}
    public DaoException(String string){
        super(string);
    }
    public DaoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
