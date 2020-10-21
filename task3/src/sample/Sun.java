package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Sun {


    private final int rad;
    private final int x;
    private final int y;
    private final int number;
    private final int leng;
    private float degr;


    public Sun(Group group, int rad, int x, int y, int number, int leng, float degr) {
        this.rad = rad;
        this.x = x;
        this.y = y;
        this.number = number;
        this.leng = leng;
        this.degr = degr;
        Draw(group);
    }

    public int getRad() {
        return rad;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    public int getLeng() {
        return leng;
    }

    public float getDegr() {
        return degr;
    }

    public void Draw(Group group){
        Circle circle = new Circle(group, rad, x, y, 1, Color.YELLOW);//рисуется солнце
        float step = (float) (2 * Math.PI / number);//шаг радиан между лучами
        for (int n = 0; n < number; n++){
            float x2 = (float) (x + leng * Math.cos(degr));
            float y2 = (float) (y - leng * Math.sin(degr));
            Line line = new Line(group, x, x2, y, y2,Color.YELLOW);
            degr = degr + step;
        }//риусуются лучи
    }
}
