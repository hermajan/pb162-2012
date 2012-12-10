package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.AbstractTest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import static org.junit.Assert.*;
import org.junit.Test;

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
            case 3: 
                pointsTotal += pointsPerTest;
                mapPoints.put(task, pointsPerTest);
                mapComments.put(task, "Zkontroluje cvicici, zameri se na (ne)zavirani IO proudu (-0.5) a zbytecnou duplikaci kodu (-0.5)");
                break;
            default:
                super.tearDown();
        }
    }    
    
    @Test public void task01() {
        task = 1;
        
        LabeledPolygon pol = new LabeledPolygon();
        try {
            pol.read(new FileInputStream("cz/muni/fi/pb162/project/test/pol-ok.txt"));
            assertEquals("Chybne nactene vrcholy", 5, pol.getNumVertices());
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,0), pol.getVertex(0));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(0,-1), pol.getVertex(1));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(0,1), pol.getVertex(2));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,2), pol.getVertex(3));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,2), pol.getVertex(4));
            assertEquals("Chybne nactene vrcholy", new Vertex2D(-1,0), pol.getVertex("vrchol a"));
        } catch (IOException ex) {
            fail("read(InputStream) vyhodila IOException pri nacitani bezchybneho souboru: " + ex);
        }
        
        try {
            pol.read(new FileInputStream("cz/muni/fi/pb162/project/test/pol-error.txt"));
            fail("read(InputStream) neselhalo, prestoze jsou na vstupu chyby");
        } catch (IOException ex) { // ok
            assertEquals("read(InputStream) neselhalo atomicky", 5, pol.getNumVertices());
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(-1,0), pol.getVertex(0));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(0,-1), pol.getVertex(1));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(0,1), pol.getVertex(2));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(-1,2), pol.getVertex(3));
            assertEquals("read(InputStream) neselhalo atomicky", new Vertex2D(-1,2), pol.getVertex(4));
        } catch (Exception ex) {
            fail("read(InputStream) selhalo na chybnem vstupu s neocekavanou vyjimkou: " + ex);
        }
        
        pointsPerTest += 2.0;
    }

    @Test public void task02() {
        task = 2;

        LabeledPolygon pol = new LabeledPolygon();
        try {
            pol.read(new FileInputStream("cz/muni/fi/pb162/project/test/pol-ok.txt"));
        } catch (IOException ex) {
            fail("read(InputStream) neocekavane vyhodila IOException pri nacitani bezchybneho souboru: " + ex);
        }

        try {
            pol.write(new FileOutputStream("cz/muni/fi/pb162/project/test/pol-out.txt"));
        } catch (IOException ex) {
            fail("write(OutputStream) neocekavane vyhodila IOException pro zapisu do souboru: " + ex);
        }

        pol = new LabeledPolygon();
        try {
            pol.read(new FileInputStream("cz/muni/fi/pb162/project/test/pol-out.txt"));
        } catch (IOException ex) {
            fail("Nedokazi zpetne nacist data zapsana pomoci write(OutputStream), zkontrolujte si soubor pol-out.txt: " + ex);
        }

        pointsPerTest += 1.0;
    }

    @Test public void task03() {
        task = 3;
        pointsPerTest += 1.0;
    }
    
    
}
