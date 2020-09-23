package com.company;

import java.awt.*;

public class Area {
    public static int width;
    public static int height;

    public Area(Graphics2D g2, int width, int height){
        Area.width = width;
        Area.height = height;
        draw(g2);
    }

    public void draw(Graphics2D g2){
        Background background = new Background(g2);
        Sea sea = new Sea(g2);
        Ship ship = new Ship(g2);
    }
}
