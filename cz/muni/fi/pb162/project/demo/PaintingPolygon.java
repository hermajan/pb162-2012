package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.*;

/**
 * Painting polygons to the screen
 * 
 * @author Jan Hermann
 * @version 29.10.2012
 */
public class PaintingPolygon {
    public static void main(String[] args) {
        Vertex2D v=new Vertex2D(0,0);
        GeneralRegularPolygon grp=new GeneralRegularPolygon(v,8,100);
        
        PaintDemo2 pd=new PaintDemo2();
        pd.paintRegularPolygon(grp);
        
        pd.startPainting();
    }
}
