package cz.muni.fi.pb162.project.db;


/**
 * Exception for error when there was succeeded to establish a connection, but failed to save data for several attempts.
 * 
 * @author Jan Hermann
 * @version 12.11.2012
 */
public class CannotStoreException extends DbException {
    public CannotStoreException() {
        super();
    }
    public CannotStoreException(String msg) {
        super(msg);
    }
    public CannotStoreException(Throwable cause) {
        super(cause);
    }
    public CannotStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}