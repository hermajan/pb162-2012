package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.test.AbstractTest;
import cz.muni.fi.pb162.project.test.OutputTester;
import cz.muni.fi.pb162.project.demo.Demo;
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
    
    @Test public void task01() { // 1 bod
        task = 1;
        
        BasicRulesTester.testRunnableClass(Demo.class);
        pointsPerTest += 1.0;
        
        OutputTester ot = new OutputTester();
        ot.captureOutput();
        Demo.main(null);
        boolean b1 = ot.outputEqualsIgnoreCase("Hello World!");
        boolean b2 = ot.outputEquals("Hello World!");
        ot.releaseOutput();
        assertTrue("Chybny vystup, zalezi i na mezerach apod.", b1);
        assertTrue("Chybny vystup, zalezi i na velikosti pismen!", b2);

        pointsPerTest += 1.0;
    }
    
    @Test public void task02() { // 1 bod
        task = 2;
        pointsPerTest += 1.0;
    }
    
    @Test public void task03() { // 1 bod
        task = 3;
        pointsPerTest += 1.0;
    }
    
    @Override
    public void tearDown() {
        
        switch(task) {
            case 2: 
                pointsTotal += pointsPerTest;
                mapPoints.put(task, pointsPerTest);
                mapComments.put(task, "Cvicici zkontroluje JavaDoc ve tride Demo");
                break;
            case 3: 
                pointsTotal += pointsPerTest;
                mapPoints.put(task, pointsPerTest);
                mapComments.put(task, "Cvicici zkontroluje ukol a jeho odevzdani");
                break;
            default:
                super.tearDown();
        }
    }
}
