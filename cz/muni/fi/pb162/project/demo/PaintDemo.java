package cz.muni.fi.pb162.project.demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Circle;

/**
 * 
 * Trida umoznujici vykresleni doposud dokoncenych grafickych objektu (bod, kruznici, trojuhelnik).
 * 
 * @author Bc. Pavel Beran (255625) and Jan Hermann
 * @version 08.11.2012
 *
 */

public class PaintDemo extends JFrame {

    /**
     * Znaci polovinu delky usecky pro vykresleni bodu.
     */
    public static final int VERT_LENGTH = 3;

    protected JPanel panel;
    
    private List<Vertex2D> vertices = new ArrayList<Vertex2D>();
    private List<Circle> circles = new ArrayList<Circle>();
    private List<Triangle> triangles = new ArrayList<Triangle>();
    
    private Color vertexColor;
    private Color circleColor;
    private Color triangleColor;
    
    /**
     * Defaultni konstruktor nastavi defaultni barvy pro telesa. Pozadi bile, body cervene, kruznice modre, trojuhelniky zelene
     */
    public PaintDemo() {
        this(Color.WHITE, Color.RED, Color.BLUE, Color.GREEN);
    }
    
    /**
     * Konstruktor umoznuje nastavit barvu pozadi. Body cervene, kruznice modre, trojuhelniky zelene
     * 
     * @param backgroundColor Barva pro pozadi
     */
    public PaintDemo(Color backgroundColor) {
        this(backgroundColor, Color.RED, Color.BLUE, Color.GREEN);
    }

    /**
     * Konstruktor umoznuje nastavit barvu teles. Pozadi bile.
     * 
     * @param vertexColor Barva pro body
     * @param circleColor Barva pro kruznice
     * @param triangleColor Barva pro trojuhelniky
     */
    public PaintDemo(Color vertexColor, Color circleColor, Color triangleColor) {
        this(Color.WHITE, vertexColor, circleColor, triangleColor);
    }

    /**
     * Konstruktor umoznuje nastavit vsechny barvy.
     * 
     * @param backgroundColor Barva pro pozadi
     * @param vertexColor Barva pro body
     * @param circleColor Barva pro kruznice
     * @param triangleColor Barva pro trojuhelniky
     */
    public PaintDemo(Color backgroundColor, Color vertexColor, Color circleColor, Color triangleColor) {
        initialize();
        panel.setBackground(backgroundColor);
        this.vertexColor = vertexColor;
        this.circleColor = circleColor;
        this.triangleColor = triangleColor;
    }
    
    private void initialize() {
        panel = new JPanel();
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vizualizace obrazců. Autor Pavel Beran (255625).");
        add(panel);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        myPaintAll(panel.getGraphics());
    }
    
    /**
     * Spustenim metody zacne vykreslovani vsech teles v seznamech.
     */
    public void startPainting() {
        paint(this.getGraphics());
    }
    
    /**
     * Metoda pro pridani bodu do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni bod mimo vykreslovaci prostor.
     * 
     * @param vertex Bod ktery chci vykreslit
     * @return true pokud se bod vykresli, false nikoliv
     */
    public boolean paintVertex(Vertex2D vertex) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - vertex.getX()));
        int y = (int) Math.rint(halfY - vertex.getY());
        
        if (x-VERT_LENGTH < 0 || x+VERT_LENGTH > width || y-VERT_LENGTH < 0 || y+VERT_LENGTH > height) {
            return false;
        }
        vertices.add(vertex);
        return true;
    }

    /**
     * Metoda pro pridani kruznice do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni kruznice mimo vykreslovaci prostor.
     * 
     * @param circle Kruznice kterou chci vykreslit
     * @return true pokud se kruznice vykresli, false nikoliv
     */
    public boolean paintCircle(Circle circle) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - circle.getCenter().getX()));
        int y = (int) Math.rint(halfY - circle.getCenter().getY());
        int r = (int) circle.getRadius();
        
        if (x-r < 0 || x+r > width || y-r < 0 || y+r > height) {
            return false;
        }
        circles.add(circle);
        return true;
    }

    /**
     * Metoda pro pridani trojuhelnika do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni trojuhelnik mimo vykreslovaci prostor.
     * 
     * @param triangle Trojuhelnik ktery chci vykreslit
     * @return true pokud se trojuhelnik vykresli, false nikoliv
     */
    public boolean paintTriangle(Triangle triangle) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        Vertex2D a = triangle.getVertex(0);
        Vertex2D b = triangle.getVertex(1);
        Vertex2D c = triangle.getVertex(2);
        
        int minX = width - ((int) Math.rint(halfX - Math.min(a.getX(), Math.min(b.getX(), c.getX()))));
        int maxX = width - ((int) Math.rint(halfX - Math.max(a.getX(), Math.max(b.getX(), c.getX()))));
        int minY = (int) Math.rint(halfY - Math.min(a.getY(), Math.min(b.getY(), c.getY())));
        int maxY = (int) Math.rint(halfY - Math.max(a.getY(), Math.max(b.getY(), c.getY())));
        
        if (minX < 0 || maxX > width || minY < 0 || maxY > height) {
            return false;
        }
        triangles.add(triangle);
        return true;
    }
    
    protected void paintVertex(Graphics g, Vertex2D v) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - v.getX()));
        int y = (int) Math.rint(halfY - v.getY());
        g.setColor(vertexColor);
        g.drawLine(x-VERT_LENGTH, y+VERT_LENGTH, x+VERT_LENGTH, y-VERT_LENGTH);
        g.drawLine(x-VERT_LENGTH, y-VERT_LENGTH, x+VERT_LENGTH, y+VERT_LENGTH);
    }
    
    protected void paintCircle(Graphics g, Circle c) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int r = (int) Math.rint(c.getRadius());
        int x = width - ((int) Math.rint(halfX - c.getCenter().getX()) + r);
        int y = (int) Math.rint(halfY - c.getCenter().getY()) - r;
        int w = (int) Math.rint(c.getWidth());
        int h = (int) Math.rint(c.getHeight());
        g.setColor(circleColor);
        g.drawOval(x, y, w, h);

    }
    
    protected void paintTriangle(Graphics g, Triangle tri) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int a1 = width - ((int) Math.rint(halfX - tri.getVertex(0).getX()));
        int a2 = (int) Math.rint(halfY - tri.getVertex(0).getY());
        int b1 = width - ((int) Math.rint(halfX - tri.getVertex(1).getX()));
        int b2 = (int) Math.rint(halfY - tri.getVertex(1).getY());
        int c1 = width - ((int) Math.rint(halfX - tri.getVertex(2).getX()));
        int c2 = (int) Math.rint(halfY - tri.getVertex(2).getY());

        g.setColor(triangleColor);
        Polygon triangle = new Polygon();
        triangle.addPoint(a1, a2);
        triangle.addPoint(b1, b2);
        triangle.addPoint(c1, c2);
        g.drawPolygon(triangle);
    }
    
    protected void paintCross(Graphics g) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        g.setColor(Color.BLACK);
        g.drawLine(0, halfY, width, halfY);
        g.drawLine(halfX, 0, halfX, height);
    }
    
    protected void myPaintAll(Graphics g) {
        paintCross(g);
        for (Vertex2D v : vertices) {
            paintVertex(g, v);
        }
        for (Circle c : circles) {
            paintCircle(g, c);
        }
        for (Triangle t : triangles) {
            paintTriangle(g, t);
        }
    }
}

