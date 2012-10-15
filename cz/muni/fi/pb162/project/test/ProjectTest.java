package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import java.lang.reflect.Field;
import cz.muni.fi.pb162.project.geometry.Gauger;
import cz.muni.fi.pb162.project.geometry.Solid;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.test.AbstractTest;
import cz.muni.fi.pb162.project.test.BasicRulesTester;
import java.lang.reflect.Modifier;
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

    @Override
    public void tearDown() {
        
        switch(task) {
            case 2: 
                pointsTotal += pointsPerTest;
                mapPoints.put(task, pointsPerTest);
                mapComments.put(task, "Cvicici rucne zkontroluje Gauger (netestuje se)");
                break;
            case 3: 
                pointsTotal += pointsPerTest;
                mapPoints.put(task, pointsPerTest);
                mapComments.put(task, "Cvicici zkontroluje pouziti konstanty v Triangle.isEquilateral()");
                break;
            default:
                super.tearDown();
        }
    }    


    /*
    @Test public void task01() {
        task = 1;
        
        assertTrue("Trida Triangle neimplementuje pozadovane rozhrani -- chyba v hlavicce tridy", Colored.class.isAssignableFrom(Triangle.class));
        assertTrue("Trida Circle neimplementuje pozadovane rozhrani -- chyba v hlavicce tridy", Colored.class.isAssignableFrom(Circle.class));

        Vertex2D v1 = new Vertex2D(-1,0);
        Vertex2D v2 = new Vertex2D(1,0);
        Vertex2D v3 = new Vertex2D(0,1);
        ColoredObsolete tri = new Triangle(v1, v2, v3);
        ColoredObsolete cir = new Circle();
        
        assertEquals("Barva trojuhelniku", "white", tri.getColor());
        assertEquals("Barva kruhu", "white", cir.getColor());
        pointsPerTest += 0.5;
        
        assertEquals("Triangle.toString()", "Triangle: vertices=[-1.0, 0.0] [1.0, 0.0] [0.0, 1.0], color=white", tri.toString());
        assertEquals("Circle.toString()", "Circle: center=[0.0, 0.0], radius=1.0, color=white", cir.toString());
        pointsPerTest += 0.5;
    }
    */

    @Test public void task01() {
        task = 1;

        assertTrue("Trida Triangle neimplementuje pozadovane rozhrani -- chyba v hlavicce tridy", Solid.class.isAssignableFrom(Triangle.class));
        assertTrue("Trida Circle neimplementuje pozadovane rozhrani -- chyba v hlavicce tridy", Solid.class.isAssignableFrom(Circle.class));

        Solid tri = new Triangle(new Vertex2D(-1,0), new Vertex2D(1,0), new Vertex2D(0,1));
        Solid cir = new Circle();
        
        assertTrue("Triangle.getWidth()", tri.getWidth() == 2.0);
        assertTrue("Triangle.getHeight()", tri.getHeight() == 1.0);
        assertTrue("Triangle.getLength()", Math.abs(tri.getLength() - 4.82842712474619) < 0.001);
        assertTrue("Triangle.getArea()", Math.abs(tri.getArea() - 1.0) < 0.001);
        pointsPerTest += 1.0;
        
        assertTrue("Circle.getWidth()", cir.getWidth() == 2.0);
        assertTrue("Circle.getHeight()", cir.getHeight() == 2.0);
        assertTrue("Circle.getLength()", Math.abs(cir.getLength() - (Math.PI * 2.0)) < 0.001);
        assertTrue("Circle.getArea()", Math.abs(cir.getArea() - Math.PI) < 0.001);
        pointsPerTest += 1.0;
    }

    @Test public void task02() {
        task = 2;
        pointsPerTest += 1.0;
    }

    @Test public void task03() {
        task = 3;
        boolean hasStaticField = false;
        for (Field field : Triangle.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                hasStaticField = true;
                break;
            }
        }
        if (!hasStaticField) fail("Epsilon neni verejna konstanta");
        BasicRulesTester.testAttributes(Triangle.class);
        pointsPerTest += 1.0;
    }

}
