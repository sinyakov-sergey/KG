package com.company;

import java.awt.*;

public class Ship {
    public Ship(Graphics2D g2) {
        Draw(g2);
    }

    public void Draw(Graphics2D g2){
        g2.setPaint(new Color(139,69,19));
        Polygon polygon = new Polygon();
        polygon.addPoint(700,400);
        polygon.addPoint(1150,400);
        polygon.addPoint(1050,530);
        polygon.addPoint(800,530);
        g2.fill(polygon);

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setSize(240,40);
        rectangle1.setLocation(900,360);
        g2.fill(rectangle1);
        Rectangle rectangle2 = new Rectangle();
        rectangle2.setSize(160,30);
        rectangle2.setLocation(940,330);
        g2.fill(rectangle2);
        g2.fillRect(1010, 310, 20, 30);
        g2.fillRect(800, 370, 20, 30);

        g2.setPaint(new Color(135, 206, 250));
        g2.fillOval(800,445,45,45);
        g2.fillOval(900,445,45,45);
        g2.fillOval(1000,445,45,45);

        g2.setPaint(new Color(255,255,0));
        g2.fillRect(920, 370, 10,20);
        g2.fillRect(950, 370, 10,20);
        g2.fillRect(980, 370, 10,20);
        g2.fillRect(1010, 370, 10,20);
        g2.fillRect(1040, 370, 10,20);
        g2.fillRect(1070, 370, 10,20);
        g2.fillRect(1100, 370, 10,20);

        g2.fillRect(950, 335, 10,20);
        g2.fillRect(980, 335, 10,20);
        g2.fillRect(1010, 335, 10,20);
        g2.fillRect(1040, 335, 10,20);
        g2.fillRect(1070, 335, 10,20);

        g2.setPaint(new Color(255,0,0));
        Polygon sail1 = new Polygon();
        sail1.addPoint(870,100);
        sail1.addPoint(710,370);
        sail1.addPoint(870,370);
        g2.fill(sail1);

        Polygon sail2 = new Polygon();
        sail2.addPoint(1060,100);
        sail2.addPoint(1060,310);
        sail2.addPoint(950,310);
        g2.fill(sail2);
    }

}
