package sample;

public abstract class FromOneDot {
    Point currentPoint ;
    boolean goDown = true;
    boolean for1 = false;
    boolean for2 = false;
    boolean for3 = false;
    boolean for4 = false;
    boolean for5 = false;
    boolean for6 = false;
    boolean for7 = false;
    boolean for8 = false;
    boolean for9 = false;
    boolean for10 = false;

    public FromOneDot() {

    }

    Point getNextPoint() {
        if (goDown) {
            currentPoint.setY(currentPoint.getY() + 2);
            if (currentPoint.getY() > 50) goDown = false;
        } else {
            if (for1) setFor1();
            if (for2) setFor2();
            if (for3) setFor3();
            if (for4) setFor4();
            if (for5) setFor5();
            if (for6) setFor6();
            if (for7) setFor7();
            if (for8) setFor8();
            if (for9) setFor9();
            if (for10) setFor10();
        }
        return currentPoint;
    }

    abstract void setFor1();

    abstract void setFor2();

    abstract void setFor3();

    abstract void setFor4();

    abstract void setFor5();

    abstract void setFor6();

    abstract void setFor7();

    abstract void setFor8();

    abstract void setFor9();

    abstract void setFor10();



}
