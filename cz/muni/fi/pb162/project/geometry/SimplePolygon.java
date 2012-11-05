package cz.muni.fi.pb162.project.geometry;


/**
 * SimplePolygon
 * 
 * @author Jan Hermann
 * @version 05.11.2012
 */
public abstract class SimplePolygon implements Polygon {
    public double getWidth() {
        Vertex2D min=getVertex(0);
        Vertex2D max=getVertex(0);
        
        for(int i=0;i<getNumVertices();i++) {
            if(min.getX()>getVertex(i).getX()) {
                min=getVertex(i);
            }
            if(max.getX()<getVertex(i).getX()) {
                max=getVertex(i);
            }
        }
        
        return max.getX()-min.getX();
    }
    public double getHeight() {
        Vertex2D min=getVertex(0);
        Vertex2D max=getVertex(0);
        
        for(int i=0;i<getNumVertices();i++) {
            if(min.getY()>getVertex(i).getY()) {
                min=getVertex(i);
            }
            if(max.getY()<getVertex(i).getY()) {
                max=getVertex(i);
            }
        }
        
        return max.getY()-min.getY();
    }
    
    public double getLength() {
        double len=0;
        
        for(int i=0;i<(getNumVertices()-1);i++) {
            len=len+getVertex(i).distance(getVertex(i+1));
        }
        
        len=len+getVertex(getNumVertices()-1).distance(getVertex(0));
        return len;
    }
    
    public double getArea() {
        double result=0;
        
        for(int i=0;i<(getNumVertices());i++) {
            result=result+((getVertex(i).getX()*getVertex(i+1).getY())-(getVertex(i+1).getX()*getVertex(i).getY()));
        }
        
        return result*0.5;
    }
    
    public String toString() {
        String result="Polygon: vertices =";
        for(int i=0;i<getNumVertices();i++) {
            result=result+" "+getVertex(i).toString();
        }
        return result;
    }
}
