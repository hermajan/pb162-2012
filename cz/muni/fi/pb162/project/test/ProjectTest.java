package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.AbstractTest;
import cz.muni.fi.pb162.project.geometry.Circle;
import org.junit.AfterClass;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Radek Oslejsek <oslejsek@fi.muni.cz>, Masaryk University, Faculty of Informatics
 */
public class ProjectTest extends AbstractTest {

    @Override
    public void tearDown() {
        
        switch(task) {
            case 3: 
                pointsTotal += pointsPerTest;
                mapPoints.put(task, pointsPerTest);
                mapComments.put(task, "Zkontrolovat instanciaci objektu ve tride Demo!");
                break;
            case 4: 
                pointsTotal += pointsPerTest;
                mapPoints.put(task, pointsPerTest);
                mapComments.put(task, "Zkontrolovat vzajemne volani konstruktoru ve tride Circle! Jinak -0.5 bodu.");
                break;
                /*
            case 5: 
                pointsTotal += pointsPerTest;
                System.out.print(task + ". ukol: " + pointsPerTest + " - Zkontrolovat vzajemne volani konstruktoru ve tride Square!");
                break;
                 */
            default:
                super.tearDown();
        }
    }    


    @Test public void task01() {
        task = 1;

        Vertex2D v1 = new Vertex2D(-1,0);
        Vertex2D v2 = new Vertex2D(1,0);
        Vertex2D v3 = new Vertex2D(0,1);
        Triangle tri = new Triangle(v1, v2, v3);
        assertTrue("Konstruktor Vertex2D", v1.getX() == -1.0);
        assertTrue("Konstruktor Triangle", tri.getVertexA().getX() == -1.0 && tri.getVertexA().getY() == 0.0);
        pointsPerTest += 1.0;        
    }

    @Test public void task02() {
        task = 2;

        Vertex2D v1 = new Vertex2D(-1,0);
        Vertex2D v2 = new Vertex2D(1,0);
        Vertex2D v3 = new Vertex2D(0,1);
        Triangle tri = new Triangle(v1, v2, v3);
        try {
            assertTrue("Vertex2D.distance", new Vertex2D(-1,0).distance(null) == -1.0);
        } catch (Exception ex) {
            fail("Vertex2D.distance");
        }
        
        try {
            assertEquals("Triangle.toString", "INVALID TRIANGLE", new Triangle(null, null, null).toString());
        } catch (Exception ex) {
            fail("Triangle.toString");
        }
        pointsPerTest += 1.0;        
    }

    @Test public void task03() {
        task = 3;
        pointsPerTest += 1.0;        
    }

    @Test public void task04() {
        task = 4;
        
        Circle c1 = new Circle();
        Circle c2 = new Circle(new Vertex2D(1.0, -1.0), 0.5);
        
        assertTrue("Parametricky konstruktor: spatny polomer", c2.getRadius() == 0.5);
        assertTrue("Parametricky konstruktor: spatny stred", c2.getCenter().getX() == 1.0 && c2.getCenter().getY() == -1.0);
        assertTrue("Bezparametricky konstruktor: spatny polomer", c1.getRadius() == 1.0);
        assertTrue("Bezparametricky konstruktor: spatny stred", c1.getCenter().getX() == 0.0 && c1.getCenter().getY() == 0.0);
        //c2.setRadius(0.3);
        //assertTrue("setRadius()", c2.getRadius() == 0.3);
        
        assertEquals("toString", "Circle: center=[1.0, -1.0], radius=0.5", c2.toString());
        
        pointsPerTest += 1.0;        
    }

    /*
    @Test public void task05() {
        task = 5;
        
        SquareASSIGNMENT s1 = new SquareASSIGNMENT();
        SquareASSIGNMENT s2 = new SquareASSIGNMENT(0.5);
        
        assertTrue("Bezparametricky konstruktor", s1.getEdge() == 1.0);
        assertTrue("Parametricky konstruktor", s2.getEdge() == 0.5);
        s2.setEdge(0.3);
        assertTrue("setEdge()", s2.getEdge() == 0.3);
        
        assertEquals("toString", "Square: 0.3x0.3", s2.toString());
        
        pointsPerTest += 0.5;        
    }
     */
}
