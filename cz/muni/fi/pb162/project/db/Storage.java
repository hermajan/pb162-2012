package cz.muni.fi.pb162.project.db;

/**
 * This interface handles the persistent storage of graphical objects.
 * 
 * @author Radek Oslejsek &lt;oslejsek&amp;fi.muni.cz&gt;, 
 * Masaryk University, Faculty of Informatics
 */
public interface Storage {
    
    /**
     * Stores data in remote Db server.
     * 
     * @param host Address of remote DB server
     * @param obj Data to store
     * @throws DbException if the storage fails for some reason
     */
    void store(String host, Object data) throws DbException;
    
}
