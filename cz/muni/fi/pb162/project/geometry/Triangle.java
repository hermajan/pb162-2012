package cz.muni.fi.pb162.project.geometry;

/**
 * Defines triangle
 * 
 * @author Jan Hermann 
 * @version 01.10.2012
 */
public class Triangle {
    private Vertex2D a;
    private Vertex2D b;
    private Vertex2D c;
    
    /**
     * Returns vertex A
     * 
     * @return Vertex A
     */
    public Vertex2D getVertexA() {
        return a;
    }
    /**
     * Sets point A
     * 
     * @param vert New vertex A
    */
    public void setVertexA(Vertex2D vert) {
        a=vert;
    }

    /**
     * Returns vertex B
     * 
     * @return Vertex B
     */
    public Vertex2D getVertexB() {
        return b;
    }
    /**
     * Sets point B
     * 
     * @param vert New vertex B
    */
    public void setVertexB(Vertex2D vert) {
        b=vert;
    }
    
    /**
     * Returns vertex C
     * 
     * @return Vertex C
     */
    public Vertex2D getVertexC() {
        return c;
    }
    /**
     * Sets point C
     * 
     * @param vert New vertex C
    */
    public void setVertexC(Vertex2D vert) {
        c=vert;
    }
 
    /**
     * Checks equilateral of triangle
     * 
     * @return true if triangle is equilateral, false otherwise
     */
    public boolean isEquilateral() {
        return((Math.abs(a.distance(b)-a.distance(c)) < 0.001) && (Math.abs(a.distance(b)-b.distance(c)) < 0.001));
        
        
    }
    
    /**
     * Returns string in format "Triangle: vertices=[ax, ay] [bx, by] [cx, cy]"
     * 
     * @return string in format "Triangle: vertices=[ax, ay] [bx, by] [cx, cy]"
     */
    public String toString() {
        return "Triangle: vertices="+a.toString()+" "+b.toString()+" "+c.toString();
    }
    
}

