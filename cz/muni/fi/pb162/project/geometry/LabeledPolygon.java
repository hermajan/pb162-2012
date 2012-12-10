package cz.muni.fi.pb162.project.geometry;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Labeled polygon
 * 
 * @author Jan Hermann 
 * @version 10.12.2012
 */
public class LabeledPolygon extends SimplePolygon implements PolygonIO {
    private SortedMap<String,Vertex2D> map;

    /**
     * Constructor for objects of class LabeledPolygon.
     */
    public LabeledPolygon() {
        map=new TreeMap<String, Vertex2D>();
    }
   
    public int getNumVertices() {
       return map.size();
    }
    
    /**
     * Adds vertex to sorted map
     * 
     * @param label Label of vertex
     * @param vert Vertex
     */
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
        
        List<Vertex2D> vertices=new ArrayList<Vertex2D>();
        Iterator<Map.Entry<String,Vertex2D>> entries=map.entrySet().iterator();
        while(entries.hasNext()) {
            Map.Entry<String,Vertex2D> entry=entries.next();
            vertices.add(entry.getValue());
        }
        return vertices.get(index%getNumVertices());
    }
    
    public Collection<String> getLabels(Vertex2D vert) {
        Collection<String> labels=new ArrayList<String>();
        Iterator<Map.Entry<String,Vertex2D>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String,Vertex2D> entry = entries.next();
            Vertex2D v=getVertex(entry.getKey());
            if(v.equals(vert)) {
                labels.add(entry.getKey());
            }
        }
        return Collections.unmodifiableCollection(labels);
   }
    
   public Collection<Vertex2D> getSortedVertices() {
       List<Vertex2D> sorted=new ArrayList<Vertex2D>();
       for(int i=0; i<map.size(); i++) {
           if(!sorted.contains(getVertex(i))) {
               sorted.add(getVertex(i));  
           }
       }
       
       Collections.sort(sorted);
       return Collections.unmodifiableCollection(sorted);
   }
   
   public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> c) {
       List<Vertex2D> sorted=new ArrayList<Vertex2D>();
       for(int i=0; i<map.size(); i++) {
           if(!sorted.contains(getVertex(i))) { 
               sorted.add(getVertex(i)); 
           }
       }
   
       Collections.sort(sorted,c);
       return Collections.unmodifiableCollection(sorted);
   }
   
   
   public void read(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;

        while ((line = reader.readLine()) != null) {
            //if(line.matches("^\\d+ \\d+ \\w+$")) {
                String[] array=line.split(" ",3);
                Vertex2D v=new Vertex2D(Double.parseDouble(array[0]),Double.parseDouble(array[1]));
                addVertex(array[2],v);
            //} 
        }
    }
    
    public void read(File file) throws IOException {
        InputStream is=new FileInputStream(file);
        read(is);
    }
    
    public void write(OutputStream os) throws IOException {
        BufferedWriter bufwri = new BufferedWriter(new OutputStreamWriter(os));
        for(int i=0;i<map.size();i++) {
            Vertex2D v=getVertex(i);
            Collection<String> labels=new ArrayList<String>();
            labels=getLabels(v);
            for(int j=0;j<labels.size();j++) {
                bufwri.write(v.getX()+" "+v.getY()+" ");//+labels.get(j));
                bufwri.newLine();
            }
        }
        bufwri.flush();
    }
    
    public void write(File file) throws IOException {
        OutputStream os=new FileOutputStream(file);
        write(os);
    }
}
