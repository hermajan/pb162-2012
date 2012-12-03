package cz.muni.fi.pb162.project.geometry;

/**
 * Defines 2D vertex 
 * 
 * @author Jan Hermann 
 * @version 03.12.2012
 */
public class Vertex2D implements Comparable<Vertex2D> {
    private double x;
    private double y;

    /**
     * Constructor for objects of class Vertex2D
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Vertex2D(double x, double y) {
        this.x=x;
        this.y=y;
    }
    /**
     * Returns coordinate X
     * 
     * @return Coordinate x
    */
    public double getX() {
        return x;
    }    
    /*
     * Sets coordinate X
     *
     * @param someY New coordinate for X
     */
    /*public void setX(double someX) {
        this.x=someX;
    }*/

    /**
     * Returns coordinate Y
     * 
     * @return Coordinate Y
     */
    public double getY() {
        return y;
    }  
    /*
     * Sets coordinate Y
     *
     * @param someY New coordinate for Y
     */
    /*public void setY(double someY) {
        this.y=someY;
    }*/

    /**
     * Return coordinates in format [X, Y]
     * 
     * @return Coordinates in format [X, Y]
     */
    public String toString() {
        return "["+x+", "+y+"]";
    }

    /**
     * Return distance between points
     *
     * @param point Some other point
     * @return Distance between points
     */
    public double distance(Vertex2D point) {
        if(point==null) {
            return -1.0;
        }
        double otherX=point.getX();
        double otherY=point.getY();

        double d=Math.pow(otherX-x,2)+Math.pow(otherY-y,2);
        return Math.sqrt(d);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        //if(obj instanceof Vertex2D) {
        if(getClass()==obj.getClass()) {
            final Vertex2D v=(Vertex2D)obj;
            if(this.x!=v.getX()) {
                return false;
            }
            if(this.y!=v.getY()) {
                return false;
            }
            return true;
        } else {
            return false;
        }   
    }
    @Override
    public int hashCode() {
        return new Double(x).hashCode()+new Double(y).hashCode();
    }
    
    public int compareTo(Vertex2D v) {
        if(v==null) { return -1; }
        if(this.equals(v)) { return 0; }
       
        if(this.x==v.getX()) {
            if(this.y>v.getY()) { return 1; }
            else { return -1; }
        }
        
        if(this.x>v.getX()) { return 1; }
        else { return -1; }
    }
    /*public int compareTo(Object o) {
        Vertex2D v=(Vertex2D)o;
        if(v==null) { return -1; }
        if(this.equals(v)) { return 0; }
       
        if(this.x==v.getX()) {
            if(this.y>v.getY()) { return 1; }
            else { return -1; }
        }
       
        if(this.x>v.getX()) { return 1; }
        else { return -1; }
    }*/
}
