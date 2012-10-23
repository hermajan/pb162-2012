package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.*;

/**
 * Painting geometric objects to the screen
 * 
 * @author Jan Hermann
 * @version 23.10.2012
 */
public class Painting {
    public static void main(String[] args) {
        Vertex2D v1=new Vertex2D(-100,0);
        Vertex2D v2=new Vertex2D(0,100);
        Vertex2D v3=new Vertex2D(100,-100);
        Triangle t=new Triangle(v1,v2,v3);
        Circle c=new Circle(v1,100);
        
        
        PaintDemo pd=new PaintDemo();
        pd.paintVertex(v1);
        pd.paintVertex(v2);
        pd.paintVertex(v3);
        pd.paintTriangle(t);
        pd.paintCircle(c);
        
        pd.startPainting();
    }
}
