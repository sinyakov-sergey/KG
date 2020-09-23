package com.company;

import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class Background{
    public Background(Graphics2D g2) {
        Draw(g2);
    }

    public void Draw(Graphics2D g2){
        Rectangle rectangle = new Rectangle();
        rectangle.setSize(Area.width, Area.height/2);
        rectangle.setLocation(0,0);
        g2.setPaint(new Color(255,140,0));
        g2.fill(rectangle);
        //sun
        g2.setPaint(new Color(255,69,0));
        g2.fillOval(20,200,300,300);
        //birds
        Bird(g2, 120, 150);
        Bird(g2, 160, 100);
        Bird(g2, 200, 50);
        Bird(g2, 240, 100);
        Bird(g2, 280, 150);
    }

    public void Bird(Graphics2D g2, double x, double y){
        g2.setPaint(new Color(0,0,0));
        BasicStroke basicStroke = new BasicStroke(3);
        g2.setStroke(basicStroke);
        QuadCurve2D quadCurve2D1 = new QuadCurve2D.Double(x, y, x + 5, y - 25, x + 20, y + 22);
        g2.draw(quadCurve2D1);
        QuadCurve2D quadCurve2D2 = new QuadCurve2D.Double( x + 20, y + 22, x + 30, y - 25, x + 40, y);
        g2.draw(quadCurve2D2);
    }
}
