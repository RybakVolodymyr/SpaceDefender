package sample;

import java.util.ArrayList;

public class Path {
    Point currentPoint;
    ArrayList<Point> points = new ArrayList<>();

    public Path(ArrayList<Point> points) {
        this.points = points;
    }

    Point getNextPoint(){
        return null;
    }

}
