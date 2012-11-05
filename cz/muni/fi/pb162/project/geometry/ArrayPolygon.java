package cz.muni.fi.pb162.project.geometry;


/**
 * ArrayPolygon
 * 
 * @author Jan Hermann
 * @version 05.11.2012
 */
public class ArrayPolygon extends SimplePolygon {
    private Vertex2D[] array;

    /**
     * Constructor for objects of class ArrayPolygon
     */
    public ArrayPolygon(Vertex2D[] arr) throws IllegalArgumentException {
        if(arr==null) {
            throw new IllegalArgumentException("Vertex array is null!");
        }
        else {
            array=new Vertex2D[arr.length];
            for(int i=0;i<(array.length);i++) {
                if(arr[i]==null) {
                    throw new IllegalArgumentException("Element "+i+" of vertex array is null!");
                }
                else {
                    array[i]=new Vertex2D(arr[i].getX(),arr[i].getY());
                }
            }
        }
    }

    public int getNumVertices() {
        return array.length;
    }
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if(index<0) {
            throw new IllegalArgumentException("Index is below zero!");
        }
        else {
            return array[index%getNumVertices()];
        }
    }
}
