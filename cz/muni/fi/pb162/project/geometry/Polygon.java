package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Solid;

/**
 * Interface for general polygons including iregular polygons
 * 
 * @author Radek Oslejsek <oslejsek@fi.muni.cz>, Masaryk University, Faculty of Informatics
 */
public interface Polygon extends Solid {
    
    /**
     * Returns vertex at given index modulo number of indices.
     * 
     * @param index vertex index
     * @return vertex at given index modulo number of indices
     * @throws IllegalArgumentException if index is negative
     */
    Vertex2D getVertex(int index) throws IllegalArgumentException;

    /**
     * Returns number of vertices of the polygon.
     * 
     * @return number of ertices
     */
    int getNumVertices();
}
