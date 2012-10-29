package cz.muni.fi.pb162.project.demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
import java.util.ArrayList;

import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.GeneralRegularPolygon;

/**
 * 
 * Trida umoznujici vykresleni doposud dokoncenych grafickych objektu (bod, kruznici, trojuhelnik a polygon). Rozsiruje tridu PaintDemo.
 * 
 * @author Bc. Pavel Beran (255625)
 * @version 2012-10-23
 *
 */

public class PaintDemo2 extends PaintDemo {

    private List<GeneralRegularPolygon> polygons = new ArrayList<GeneralRegularPolygon>();

    private Color polygonColor;
    
    /**
     * Defaultni konstruktor nastavi defaultni barvy pro telesa. Polygony tyrkysove.
     */
    public PaintDemo2() {
        super();
        this.polygonColor = new Color(100, 220, 230);
    }
    
    /**
     * Konstruktor umoznuje nastavit barvu pozadi. Polygony jsou tyrkysove.
     * 
     * @param backgroundColor Barva pro pozadi
     */
    public PaintDemo2(Color backgroundColor) {
        super(backgroundColor);
        this.polygonColor = new Color(100, 220, 230);
    }

    /**
     * Konstruktor umoznuje nastavit barvu teles. Pozadi bile.
     * 
     * @param vertexColor Barva pro body
     * @param circleColor Barva pro kruznice
     * @param triangleColor Barva pro trojuhelniky
     * @param polygonColor Barva pro polygony
     */
    public PaintDemo2(Color vertexColor, Color circleColor, Color triangleColor, Color polygonColor) {
        super(vertexColor, circleColor, triangleColor);
        this.polygonColor = polygonColor;
    }

    /**
     * Konstruktor umoznuje nastavit vsechny barvy.
     * 
     * @param backgroundColor Barva pro pozadi
     * @param vertexColor Barva pro body
     * @param circleColor Barva pro kruznice
     * @param triangleColor Barva pro trojuhelniky
     * @param polygonColor Barva pro polygony
     */
    public PaintDemo2(Color backgroundColor, Color vertexColor, Color circleColor, Color triangleColor, Color polygonColor) {
        super(backgroundColor, vertexColor, circleColor, triangleColor);
        this.polygonColor = polygonColor;
    }
    
    /**
     * Metoda pro pridani polygonu do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni polygon mimo vykreslovaci prostor.
     * 
     * @param polygon Polygon ktery chci vykreslit
     * @return true pokud se polygon vykresli, false nikoliv
     */
    public boolean paintRegularPolygon(GeneralRegularPolygon polygon) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - polygon.getCenter().getX()));
        int y = (int) Math.rint(halfY - polygon.getCenter().getY());
        int r = (int) polygon.getRadius();
        
        if (x-r < 0 || x+r > width || y-r < 0 || y+r > height) {
            return false;
        }
        polygons.add(polygon);
        return true;
    }
    
    protected void paintPolygon(Graphics g, GeneralRegularPolygon polygon) {
        if (polygon instanceof Circle) {
            super.paintCircle(g, (Circle) polygon);
            return;
        }
        
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        g.setColor(polygonColor);
        Polygon p = new Polygon();
        for (int i = 0; i < polygon.getNumEdges(); i++) {
            int x = (int) ((halfX + polygon.getCenter().getX()) - polygon.getRadius() * Math.cos(i * 2 * Math.PI / polygon.getNumEdges()));
            int y = (int) ((halfY - polygon.getCenter().getY()) - polygon.getRadius() * Math.sin(i * 2 * Math.PI / polygon.getNumEdges()));
            p.addPoint(x, y);
        }
        g.drawPolygon(p);
    }

    protected void myPaintAll(Graphics g) {
        super.myPaintAll(g);
        for (GeneralRegularPolygon pg : polygons) {
            paintPolygon(g, pg);
        }
    }
}
