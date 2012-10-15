package cz.muni.fi.pb162.project.geometry;


/**
 * Defines Gauger
 * 
 * @author Jan Hermann
 * @version 15.10.2012
 */
public class Gauger {
    /**
     * Prints information about measurable object
     * 
     * @param m Measurable object
     */
    public static void printMeasurement(Measurable m) {
        System.out.println(m.toString());
        System.out.println("Perimeter: "+m.getLength());
    }
    
    /**
     * Prints information about solid object
     * 
     * @param s Solid object
     */
    public static void printMeasurement(Solid s) {
        printMeasurement((Measurable)s);
        System.out.println("Area: "+s.getArea());
    }
}
