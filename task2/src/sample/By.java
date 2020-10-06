package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;


public class By implements PixelsDrawer{

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public By(Group group, int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        Draw(group, color);
    }

    @Override
    public void Draw(Group group, Color color) {
        if (x2 < x1) {
            x1 += x2;
            x2 = x1 - x2;
            x1 -= x2;
            y1 += y2;
            y2 = y1 - y2;
            y1 -= y2;
        }
        int dx = x2 - x1;
        int dy = y2 - y1;
        //Горизонтальные и вертикальные линии не нуждаются в сглаживании
        if (dx == 0 || dy == 0) {
            DDA dda1 = new DDA(group,x1, y1, x2, y2, color);
            return;
        }
        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            DDA dda1 = new DDA(group, x1, y1, x1, y1, color);
            for (int x = x1; x < x2; ++x) {
                DDA dda3 = new DDA(group, x, (int)intery, x, (int)intery, new Color(color.getRed(),
                        color.getBlue(), color.getGreen(), (255 - fractionalPart(intery) * 255) / 255));
                DDA dda4 = new DDA(group, x, (int)intery + 1, x, (int)intery + 1, new Color(color.getRed(),
                        color.getBlue(), color.getGreen(), (fractionalPart(intery) * 255) / 255));
                intery += gradient;
            }
            DDA dda2 = new DDA(group,x2, y2, x2, y2, color);
        }
        else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            DDA dda1 = new DDA(group,x1, y1, x1, y1, color);
            for (int y = y1; y < y2; ++y) {
                DDA dda3 = new DDA(group,(int)interx, y, (int)interx, y, new Color(color.getRed(),
                        color.getBlue(), color.getGreen(), (255 - fractionalPart(interx) * 255) / 255));
                DDA dda4 = new DDA(group,(int)interx + 1, y, (int)interx + 1, y, new Color(color.getRed(),
                        color.getBlue(), color.getGreen(), (fractionalPart(interx) * 255) / 255));
                interx += gradient;
            }
            DDA dda2 = new DDA(group,x2, y2, x2, y2, color);
        }

    }

    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp; //вернёт дробную часть числа
    }
}
