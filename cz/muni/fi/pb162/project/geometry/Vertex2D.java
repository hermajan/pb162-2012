package cz.muni.fi.pb162.project.geometry;

/**
 * Defines triangle
 * 
 * @author Jan Hermann 
 * @version 08.10.2012
 */
public class Vertex2D {
    private double x;
    private double y;

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
}
