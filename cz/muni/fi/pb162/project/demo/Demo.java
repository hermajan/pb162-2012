package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.*;

/**
 * Creates triangle and work with it
 * 
 * @author Jan Hermann 
 * @version 01.10.2012
 */
public class Demo {
    /**
     * Method launches methods from other classes
     */
    public static void main(String[] args)  {
        Vertex2D v1=new Vertex2D();
        Vertex2D v2=new Vertex2D();
        Vertex2D v3=new Vertex2D();
        
        v1.setX(-1);
        v1.setY(0);
        v2.setX(0);
        v2.setY(1);
        v3.setX(1);
        v3.setY(-1);
        
        Triangle t=new Triangle();
        t.setVertexA(v1);
        t.setVertexB(v2);
        t.setVertexC(v3);
        
        System.out.println(t.toString());
    }
}
