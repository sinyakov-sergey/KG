package com.company;

import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class Sea {

    public Sea(Graphics2D g2) {
        Draw(g2);
    }

    public void Draw(Graphics2D g2){
        Rectangle rectangle = new Rectangle();
        rectangle.setSize(Area.width, Area.height/2);
        rectangle.setLocation(0,Area.height/2);
        g2.setPaint(new Color(30,144,255));
        g2.fill(rectangle);
        BlackLine(g2, 20, 400);
        BlackLine(g2, 40, 550);
        BlackLine(g2, 900, 600);
        BlackLine(g2, 180, 500);
        BlackLine(g2, 500, 550);
        BlackLine(g2, 280, 590);
        BlackLine(g2, 380, 380);
        BlackLine(g2, 600, 410);
        BlackLine(g2, 400, 480);

    }

    public void BlackLine(Graphics2D g2, double x, double y){
        g2.setPaint(new Color(0,0,128));
        BasicStroke basicStroke = new BasicStroke(4);
        g2.setStroke(basicStroke);
        QuadCurve2D quadCurve2D1 = new QuadCurve2D.Double(x, y, x + 25, y + 25, x + 50, y);
        g2.draw(quadCurve2D1);
        QuadCurve2D quadCurve2D2 = new QuadCurve2D.Double(x + 50, y, x + 75, y - 25, x + 100, y);
        g2.draw(quadCurve2D2);
    }
}
