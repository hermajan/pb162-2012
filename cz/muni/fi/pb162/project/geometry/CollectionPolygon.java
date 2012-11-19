package cz.muni.fi.pb162.project.geometry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Collection of polygon
 * 
 * @author Jan Hermann
 * @version 19.11.2012
 */
public class CollectionPolygon extends SimplePolygon {
    private List<Vertex2D> list;

    /**
     * Constructor for objects of class CollectionPolygon.
     * 
     * @param arr Vertex2D array for copy
     * @throws IllegalArgumentException if arr is null or contains null
     */
    public CollectionPolygon(Vertex2D[] arr) throws IllegalArgumentException  {
        if(arr==null) {
            throw new IllegalArgumentException ("Vertex list is null!");
        }
        else {
            list=new ArrayList<Vertex2D>();
            for(int i=0;i<arr.length;i++) {
                if(arr[i]==null) {
                    throw new IllegalArgumentException("Element "+i+" of vertex list is null!");
                }
                else {
                    list.add(arr[i]);
                }
            }
        }
    }

    public int getNumVertices() {
        return list.size();
    }
    
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if(index<0) {
            throw new IllegalArgumentException("Index is below zero!");
        }
        else {
            return list.get(index%getNumVertices());
        }
    }
    
    /**
     * Get all vertices.
     * 
     * @return Collection of vertices
     */
    public Collection<Vertex2D> getVertices() {
        Collection<Vertex2D> col=new ArrayList<Vertex2D>();
        col.addAll(list);
        return Collections.unmodifiableCollection(col);
    }
    
    /**
     * Inverts vertices.
     * 
     * @return Collection of inverted vertices
     */
    public CollectionPolygon invert() {
        Vertex2D[] ver=new Vertex2D[getNumVertices()];
        int j=0;
        for(int i=list.size()-1;i>=0;i--) {
            ver[j]=list.get(i);
            j++;
        }
        return new CollectionPolygon(ver);
    }
}
