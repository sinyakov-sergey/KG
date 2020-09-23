package com.company;

import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame {
    public Paint(){
        super("Sea");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Window());
        setBounds(0,0,1200, 650);
        setVisible(true);
    }

    class Window extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            Area area = new Area(g2,1200, 650);
        }
    }
}

