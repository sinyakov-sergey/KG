package sample;


import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Space extends TimerTask {

    private List<Star> stars = new LinkedList<>();
    private long speed = 0;
    private int b = 1;

    public Space(List<Star> stars, long speed, int b) {
        this.stars = stars;
        this.speed = speed;
        this.b = b;
    }

    public Space() {
    }

    public void addToStars(Star star){
        stars.add(star);
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public List<Star> getStars() {
        return stars;
    }

    public long getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        for (Star s : stars) {
            if (b == 1){
                s.setLength(s.getLength() + speed, 1);
                s.setB(1);
            }
            else {
                s.setLength(s.getLength() - speed, 1);
                s.setB(0);
            }
        }
    }
}
