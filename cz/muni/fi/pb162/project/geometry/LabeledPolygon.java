package cz.muni.fi.pb162.project.geometry;
import java.util.Collection;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Collection of polygon
 * 
 * @author Jan Hermann
 * @version 19.11.2012
 */
public class LabeledPolygon extends SimplePolygon {
    private TreeMap<String,Vertex2D> map;

    /**
     * Constructor for objects of class CollectionPolygon.
     * 
     * @param arr Vertex2D array for copy
     */
    public LabeledPolygon() {
        map=new TreeMap<String, Vertex2D>();
    }
   
    public int getNumVertices() {
       return map.size();
    }
    
    public void addVertex(String label, Vertex2D vert) throws IllegalArgumentException {
        if(label==null) {
            throw new IllegalArgumentException("Label is null!");
        }
        if(vert==null) {
            throw new IllegalArgumentException("Vertex is null!");
        }
        map.put(label,vert);
    }
    
    public Vertex2D getVertex(String label) throws IllegalArgumentException {
        if(map.containsKey(label)==false) {
            throw new IllegalArgumentException("Vertex label doesn't exist!");
        }
        return map.get(label);
    }
    
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if(index<0) {
            throw new IllegalArgumentException("Index is below zero!");
        }
       String key=map.firstKey();
       for(int i=0;i<(index%getNumVertices());i++) {
           key=map.higherKey(key);
       }
       return getVertex(key);
    }
    
    public Collection<String> getLabels(Vertex2D vert) {
       Collection<String> ret = new ArrayList<String>();
       for(int i=0;i<getNumVertices();i++) {
           Vertex2D tmp = getVertex(i);
           if(tmp.equals(vert)) {
               String key = map.firstKey();
               for(int j=0; j<i; j++) {
                   key = map.higherKey(key);    
               }
               ret.add(key);
           }
       }
       return Collections.unmodifiableCollection(ret);
   }
    
   public Collection<Vertex2D> getSortedVertices() {
       List<Vertex2D> sorted=new ArrayList<Vertex2D>();
       for(int i=0;i<map.size();i++) {
           if(!sorted.contains(getVertex(i))) {
               sorted.add(getVertex(i));  
           }
       }
       
       int size=sorted.size();
       Collection<Vertex2D> ret=new ArrayList<Vertex2D>();
       for(int i=0; i<size; i++) {
           Vertex2D min=sorted.get(0);
           for(int j=0; j<sorted.size(); j++) {
               if(min.compareTo(sorted.get(j))>0) min=sorted.get(j);    
           }
           ret.add(min);
           sorted.remove(min);
       }
       
       return Collections.unmodifiableCollection(ret);
       
   }
   
   public Collection<Vertex2D> getSortedVertices(Comparator c) {
       List<Vertex2D> sorted= new ArrayList<Vertex2D>();
       for(int i=0; i<map.size(); i++) {
           if(!sorted.contains(getVertex(i))) sorted.add(getVertex(i));  
       }
       
       int size=sorted.size();
       Collection<Vertex2D> ret=new ArrayList<Vertex2D>();
       
       for(int i=0; i<size; i++) {
           Vertex2D min=sorted.get(0);
           for(int j=0; j<sorted.size(); j++) {
               if(c.compare(min,sorted.get(j))>0) min=sorted.get(j);    
           }
           ret.add(min);
           sorted.remove(min);
       }
       
       return Collections.unmodifiableCollection(ret);
   }
}
