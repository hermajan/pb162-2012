package cz.muni.fi.pb162.project.db;


/**
 * Exception for error when saving data to a remote server.
 * 
 * @author Jan Hermann 
 * @version 12.11.2012
 */
public class DbException extends Exception {
    public DbException() {
        super();
    }
    public DbException(String msg) {
        super(msg);
    }
    public DbException(Throwable cause) {
        super(cause);
    }
    public DbException(String message, Throwable cause) {
        super(message, cause);
    }
}