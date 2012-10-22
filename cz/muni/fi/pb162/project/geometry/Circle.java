package cz.muni.fi.pb162.project.geometry;


/**
 * Defines circle
 * 
 * @author Jan Hermann 
 * @version 22.10.2012
 */
public class Circle extends GeneralRegularPolygon implements Solid {
    //private Vertex2D center;
    private double radius;

    /**
     * Constructor for objects of class Circle
     */
    public Circle(Vertex2D center, double radius) {
        super(center,Integer.MAX_VALUE,0);
        this.radius=radius;
    }

    /**
     * Constructor for objects of class Circle
     */
    public Circle() {
        this(new Vertex2D(0,0),1);
    }
    
    /**
     * Returns radius
     * 
     * @return radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Returns circle in format "Circle: center=[<x>, <y>], radius=<radius>"
     * 
     * @return circle in format "Circle: center=[<x>, <y>], radius=<radius>"
     */
    public String toString() {
        return  "Circle: center="+getCenter().toString()+", radius="+radius;
    }
    
    public double getLength() {
        return 2*Math.PI*radius;
    }
    
    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }
}
