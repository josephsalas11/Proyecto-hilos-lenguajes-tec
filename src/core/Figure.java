package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Figure {

    private static final int size = 10;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private int drawingWidth;
    private int drawingHeight;
    private Color objectColor;

    public Figure(int drawingWidth, int drawingHeight) {
        this.drawingWidth = drawingWidth - 100;
        this.drawingHeight = drawingHeight;

        x = (Math.random() * drawingWidth + size) + drawingWidth / 2;
        y = Math.random() * drawingWidth + size;
        dx = 200; //(int)Math.round(Math.random());
        dy = 200;//(int)Math.round(Math.random());

        this.drawingWidth = drawingWidth;
        this.objectColor = generateRandomColor();
    }

    //Agregar a función que modifica la trayectoria de cada hilo dependiendo de una función aleatoria
    public void move() {
        int lowerLimit = 0;
        int upperLimit = drawingHeight - size;

        //x += dx;
        //if (x < lowerLimit) {
        ///  dx *= -1;     
        //} else if (x > upperLimit) {
        //dx *= -1;
        //}
        if (y <= upperLimit) {
            y += 1;
            if ((int) y == upperLimit) {
                System.out.println("Entro");
                y = upperLimit;
                while (y > 0) {
                    System.out.println("Entro 2");
                    y -= 1;
                }
            }
        }
        //Devuelve la figura al inicio y repite el trayecto
        /*
        if (y >= upperLimit){
        	System.out.print("Entra");
        	for (int xTemp = 0; xTemp < upperLimit; xTemp++){
        		y -= 1;
        	}
        }
         */

 /*
        if (y < lowerLimit) {
            dy *= -1;
        } else if (y > upperLimit) {
            dy *= -1;
        }
         */
    }

    public void moveUpward() {

        int upperLimit = drawingHeight - size;

        if (y <= drawingHeight) {
            y -= 1;
        }
    }

    //Dibuja un Cuadrado
    public void draw(Graphics g) {
        g.setColor(this.objectColor);
        g.fillRect((int) x, (int) y, size, size);

    }

    //Dibuja un circulo
    public void drawCircle(Graphics g) {
        g.drawOval((int) x, (int) y, size, size);
        g.setColor(this.objectColor);
        g.fillOval((int) x, (int) y, size + 1, size + 1);
    }

    //Funcion que crea un triangulo
    public void drawTriangle(Graphics g) {
        int[] xp = {(int) x, (int) x + 5, (int) x - 5};
        int[] yp = {(int) y, (int) y + 5, (int) y + 5};
        int n = 3;
        Polygon p = new Polygon(xp, yp, n);
        g.drawPolygon(p);
        g.setColor(this.objectColor);
        g.fillPolygon(p);
    }

    //Funcion que genera la barrera que impide el paso
    public void drawBarrier(Graphics g) {
        g.setColor(this.objectColor);
        g.fillRect(300, 100, 600, 10);
    }

    private Color generateRandomColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        Color c = new Color(R, G, B);
        return c;
    }
}
