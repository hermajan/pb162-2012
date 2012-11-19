package cz.muni.fi.pb162.project.geometry;


/**
 * GeneralRegularPolygon
 * 
 * @author Jan Hermann
 * @version 22.10.2012
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private Vertex2D center;
    private int edges;
    private double length;
    private Color color;

    /**
     * Constructor for objects of class GeneralRegularPolygon
     */
    public GeneralRegularPolygon(Vertex2D center,int edges,double length) {
        this.center=center;
        this.edges=edges;
        this.length=length;
        this.color=Color.WHITE;
    }

    public int getNumEdges() {
        return edges;
    }
    
    public double getEdgeLength() {
        return length;
    }

    public Vertex2D getCenter() {
        return center;
    }
    
    public double getRadius() {
        return length/(2*Math.sin(Math.PI/edges));
    }
    
    public double getArea() {
        return (1.0/2.0)*edges*Math.pow(getRadius(),2)*Math.sin((2*Math.PI)/edges);
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color=color;
    }
    
    public double getWidth() {
        return 2*getRadius();
    }
    

    public double getHeight() {
        return 2*getRadius();
    }

    public double getLength() {
        return edges*length;
    }
    
    /**
     * Returns string in format "<n>-gon: center=[<center>], edge length=<length>, color=<color>"
     * 
     * @return string in format "<n>-gon: center=[<center>], edge length=<length>, color=<color>"
     */
    public String toString() {
        return edges+"-gon: center="+center+", edge length="+length+", color="+color;
    }
}
