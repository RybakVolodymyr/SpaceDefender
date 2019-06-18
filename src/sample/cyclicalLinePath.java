package sample;

public class cyclicalLinePath {
    Point currentPoint;
    Point startPoint;
    Point finishPoint;
    double step;
    boolean right = true;

    public cyclicalLinePath(Point startPoint, Point finishPoint, double step) {
        this.startPoint = startPoint;
        this.currentPoint = new Point(startPoint.getX(), startPoint.getY());
        this.finishPoint = finishPoint;
        this.step = step;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(Point finishPoint) {
        this.finishPoint = finishPoint;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    Point getNextPoint(){
        System.out.println(currentPoint.getX() +"    <    "+ startPoint.getX());
        if(currentPoint.getX() < startPoint.getX()) right = true;
        System.out.println(currentPoint.getX() +"    >    "+ finishPoint.getX());
        if(currentPoint.getX() > finishPoint.getX()) right = false;
        System.out.println(right);
        if(right) currentPoint.setX(currentPoint.getX()+step);
        else currentPoint.setX(currentPoint.getX()-step);
        System.out.println(currentPoint.getX());
        return currentPoint;
    }
}
