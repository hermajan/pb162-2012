package cz.muni.fi.pb162.project.geometry;


/**
 * RegularOctagon
 * 
 * @author Jan Hermann
 * @version 22.10.2012
 */
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * Constructor for objects of class RegularOctagon
     */
    public RegularOctagon(Vertex2D center,double length) {
        super(center,8,length);
    }
}
