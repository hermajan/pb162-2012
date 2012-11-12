package cz.muni.fi.pb162.project.db;


/**
 * Exception for error when connecting to the remote database server.
 * 
 * @author Jan Hermann
 * @version 12.11.2012
 */
public class DbUnreachableException extends DbException {
    public DbUnreachableException() {
        super();
    }
    public DbUnreachableException(String msg) {
        super(msg);
    }
    public DbUnreachableException(Throwable cause) {
        super(cause);
    }
    public DbUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }
}
