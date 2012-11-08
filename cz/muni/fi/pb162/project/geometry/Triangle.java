package cz.muni.fi.pb162.project.geometry;

/**
 * Defines triangle
 * 
 * @author Jan Hermann 
 * @version 08.11.2012
 */
public class Triangle extends ArrayPolygon implements Solid {
    /*private Vertex2D a;
    private Vertex2D b;
    private Vertex2D c;*/
    private Vertex2D[] v;
    public static final double EQUILATERAL=0.001;
    
    public Triangle(Vertex2D a,Vertex2D b,Vertex2D c) {
        super(new Vertex2D[]{a,b,c});
        v=new Vertex2D[]{a,b,c};
        /*this.a=a;
        this.b=b;
        this.c=c;*/
    }
    /*
     * Returns vertex A
     * 
     * @return Vertex A
     */
    /*public Vertex2D getVertexA() {
        return a;
    }*/
    /*
     * Sets point A
     * 
     * @param vert New vertex A
    */
    /*public void setVertexA(Vertex2D vert) {
        a=vert;
    }*/

    /*
     * Returns vertex B
     * 
     * @return Vertex B
     */
    /*public Vertex2D getVertexB() {
        return b;
    }*/
    /*
     * Sets point B
     * 
     * @param vert New vertex B
    */
    /*public void setVertexB(Vertex2D vert) {
        b=vert;
    }*/
    
    /*
     * Returns vertex C
     * 
     * @return Vertex C
     */
    /*public Vertex2D getVertexC() {
        return c;
    }*/
    /*
     * Sets point C
     * 
     * @param vert New vertex C
    */
    /*public void setVertexC(Vertex2D vert) {
        c=vert;
    }*/
 
    /**
     * Checks equilateral of triangle
     * 
     * @return true if triangle is equilateral, false otherwise
     */
    public boolean isEquilateral() {
        return((Math.abs(v[0].distance(v[1])-v[0].distance(v[2])) < EQUILATERAL) && (Math.abs(v[0].distance(v[1])-v[1].distance(v[2])) < EQUILATERAL));
    }
    
    /*
     * Returns string in format "Triangle: vertices=[ax, ay] [bx, by] [cx, cy]"
     * 
     * @return string in format "Triangle: vertices=[ax, ay] [bx, by] [cx, cy]"
     */
    /*public String toString() {
        if(a==null || b==null || c==null) {
            return "INVALID TRIANGLE";
        }
        else {
            return "Triangle: vertices="+a.toString()+" "+b.toString()+" "+c.toString();
        }
    }*/
    
    /*public double getWidth() {
        double minimum;
        double maximum;
        
        minimum=Math.min(a.getX(),b.getX());
        maximum=Math.max(a.getX(),b.getX());
        
        return Math.max(maximum,c.getX())-Math.min(minimum,c.getX());
    }
    
    public double getHeight() {
        double minimum;
        double maximum;
        
        minimum=Math.min(a.getY(),b.getY());
        maximum=Math.max(a.getY(),b.getY());
        
        return Math.max(maximum,c.getY())-Math.min(minimum,c.getY());
    }
    
    public double getLength() {
        return a.distance(b)+b.distance(c)+a.distance(c);
    }
    
    public double getArea() {
        double s;
        double sideA;
        double sideB;
        double sideC;
        
        sideA=a.distance(b);
        sideB=b.distance(c);
        sideC=a.distance(c);
        
        s=getLength()/2;
        return Math.sqrt(s * (s-sideA) * (s-sideB) * (s-sideC));
    }*/
}

