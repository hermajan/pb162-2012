package cz.muni.fi.pb162.project.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Radek Oslejsek <oslejsek@fi.muni.cz>, Masaryk University, Faculty of Informatics
 */
public abstract class AbstractTest {

    protected static double pointsTotal = 0.0;
    protected double        pointsPerTest = 0.0;
    protected static int    task = 0;
    protected static int    numTasks = 4;
    protected static Map<Integer,Double> mapPoints = new TreeMap<Integer,Double>();
    protected static Map<Integer,String> mapComments = new TreeMap<Integer,String>();
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        //System.out.println("Body (vypisuji se pouze ty ukoly, jejichz testy uspely): ");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (task != numTasks) return; // hack: BlueJ run this method multiple times
        
        for (Integer i: mapPoints.keySet()) {
            Double v = mapPoints.get(i);
            if (v == null) continue;
            System.out.print(i + ". ukol: " + v);
            String comment = mapComments.get(i);
            if (comment != null) System.out.print(" - " + comment);
            System.out.println();
        }
        System.out.println("Celkem:  " + pointsTotal);
        
        // hack: BlueJ run this method multiple times
        pointsTotal = 0.0;
        mapPoints = new TreeMap<Integer,Double>();
        mapComments = new TreeMap<Integer,String>();
    }
    
    @Before
    public void setUp() {
        pointsPerTest = 0.0;
    }
    
    @After
    public void tearDown() {
        pointsTotal += pointsPerTest;
        mapPoints.put(task, pointsPerTest);
        mapComments.put(task, null);
    }    
}
