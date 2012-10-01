package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.OutputTester;
import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.test.AbstractTest;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.demo.Demo;
import cz.muni.fi.pb162.project.geometry.Triangle;
import java.lang.reflect.Field;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Radek Oslejsek <oslejsek@fi.muni.cz>, Masaryk University, Faculty of Informatics
 */
public class ProjectTest extends AbstractTest {
    
    public ProjectTest() {
        numTasks = 3;
    }
    
    @Test public void task01() { // 1.5 bodu
        task = 1;
        
        BasicRulesTester.testMethodsAndAttributes(Vertex2D.class);
        assertEquals("Pocet atributu", 2, Vertex2D.class.getDeclaredFields().length);
        for (Field field: Vertex2D.class.getDeclaredFields()) {
            assertEquals("Typ atributu", Double.TYPE, field.getType());
        }
        
        Vertex2D vert = new Vertex2D();
        vert.setX(-1.2);
        vert.setY(1.2);
        assertTrue("setX() + getX()", vert.getX() == -1.2);
        assertTrue("setY() + getY()", vert.getY() ==  1.2);
        pointsPerTest += 0.5;
        
        assertEquals("toString()", "[-1.2, 1.2]", vert.toString());
        pointsPerTest += 0.5;
        
        Vertex2D vert2 = new Vertex2D();
        vert2.setX(1.3);
        vert2.setY(1.3);
        double dist = vert.distance(vert2);
        assertTrue("distance()", dist > 2.5 && dist < 2.503);
        pointsPerTest += 0.5;
    }
    
    @Test public void task02() { // 1.5 bodu
        task = 2; 
        
        BasicRulesTester.testMethodsAndAttributes(Triangle.class);
        assertEquals("Pocet atributu", 3, Triangle.class.getDeclaredFields().length);   
        
        Vertex2D vert1 = new Vertex2D();
        Vertex2D vert2 = new Vertex2D();
        Vertex2D vert3 = new Vertex2D();
        vert1.setX(-1.2);
        vert1.setY( 0.0);
        vert2.setX( 1.2);
        vert2.setY( 0.0);
        vert3.setX( 0.0);
        vert3.setY( 2.07846097);
        
        Triangle tri = new Triangle();
        tri.setVertexA(vert1);
        tri.setVertexB(vert2);
        tri.setVertexC(vert3);
        
        assertTrue("getVertexA()", tri.getVertexA().getX() == -1.2 && tri.getVertexA().getY() == 0.0);
        pointsPerTest += 0.5;

        assertEquals("toString()", "Triangle: vertices=[-1.2, 0.0] [1.2, 0.0] [0.0, 2.07846097]", tri.toString());
        pointsPerTest += 0.5;
        
        assertTrue("isEquilateral()", tri.isEquilateral());
        vert3.setY(5);
        assertFalse("isEquilateral()", tri.isEquilateral());
        pointsPerTest += 0.5;
    }
    
    @Test public void task03() { // 1 bod
        task = 3;
        
        BasicRulesTester.testRunnableClass(Demo.class);
        
        OutputTester ot = new OutputTester();
        ot.captureOutput();
        Demo.main(null);
        boolean eq = ot.outputEquals("Triangle: vertices=[-1.0, 0.0] [0.0, 1.0] [1.0, -1.0]");
        ot.releaseOutput();
        assertTrue("Spatny vystup metody Demo.main()", eq);        
        
        pointsPerTest += 1.0;
    }
}
