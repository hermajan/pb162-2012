package cz.muni.fi.pb162.project.geometry;
import java.util.Comparator;
 
/**
 * Vertex inverse comparator
 *
 * @author Jan Hermann 
 * @version 03.12.2012
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {
    /*public int compare(Vertex2D o1,Vertex2D o2) {
        return compare(o1,o2);
    }
    public int compare(Object o1, Object o2) {
        Vertex2D v1=(Vertex2D)o1;
        Vertex2D v2=(Vertex2D)o2;
        return (v1.compareTo(v2)*(-1));
    }*/
    public int compare(Vertex2D o1,Vertex2D o2) {
        return (o1.compareTo(o2)*(-1));
    }
}