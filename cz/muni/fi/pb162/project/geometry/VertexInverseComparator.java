package cz.muni.fi.pb162.project.geometry;
import java.util.Comparator;
 
/**
 * Write a description of class VertexInverseComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VertexInverseComparator implements Comparator {
    public int compare(Vertex2D o1,Vertex2D o2) {
        return compare(o1,o2);
    }
    public int compare(Object o1, Object o2) {
        Vertex2D v1=(Vertex2D)o1;
        Vertex2D v2=(Vertex2D)o2;
        return (v1.compareTo(v2)*(-1));
    }
}