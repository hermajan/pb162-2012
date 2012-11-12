package cz.muni.fi.pb162.project.db;
import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

/**
 * Storing graphical objects to a remote database server.
 * 
 * @author Jan Hermann
 * @version 12.11.2012
 */
public class MyStorage implements Storage {
    private Connector connector;
    private int maxAttempts;

    /**
     * Constructor for objects of class MyStorage
     */
    public MyStorage(Connector connector,int maxAttempts) {
        if(connector==null) {
            throw new NullPointerException("connector");
        }
        else {
            this.connector=connector;
        }
        if(maxAttempts<1) {
            throw new IllegalArgumentException("maxAttempts");
        }
        else {
            this.maxAttempts=maxAttempts;
        }
    }
    
    public void store(String host, Object data) throws DbException {
        Connection connection;
        try {
            connection=connector.getConnection(host);
        }
        catch(UnknownHostException uhe) {
            throw new DbUnreachableException("Unknown host!",uhe);
        }
        catch(NoRouteToHostException rhe) {
            throw new DbUnreachableException("No route to host!",rhe);
        }
        
        for(int i=1;i<=maxAttempts;i++) {
            try {
                connection.sendData(data);
                break;
            }
            catch(IOException ioe) {
                if(i==maxAttempts) {
                    throw new CannotStoreException("Can't store data!",ioe);
                }
            }
        }
    }
}
