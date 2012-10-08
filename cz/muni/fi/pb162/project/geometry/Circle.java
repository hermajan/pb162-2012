package cz.muni.fi.pb162.project.geometry;


/**
 * Defines circle
 * 
 * @author Jan Hermann 
 * @version 08.10.2012
 */
public class Circle {
    private Vertex2D center;
    private double radius;

    /**
     * Constructor for objects of class Circle
     */
    public Circle(Vertex2D center, double radius) {
        this.center=center;
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
     * Returns center
     * 
     * @return center
     */
    public Vertex2D getCenter() {
        return center;
    }
    
    /**
     * Returns circle in format "Circle: center=[<x>, <y>], radius=<radius>"
     * 
     * @return circle in format "Circle: center=[<x>, <y>], radius=<radius>"
     */
    public String toString() {
        return  "Circle: center="+center.toString()+", radius="+radius;
    }
}
