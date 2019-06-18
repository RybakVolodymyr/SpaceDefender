package sample;

import java.util.ArrayList;

public class FromOneDotAllRectangle extends FromOneDotAll {



    @Override
    void setFor1() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() > dist)
            currentPoint.setX(currentPoint.getX() - 2);
    }

    @Override
    void setFor2() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() > dist * 2)
            currentPoint.setX(currentPoint.getX() - 2);
    }

    @Override
    void setFor3() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() > dist * 3)
            currentPoint.setX(currentPoint.getX() - 2);
    }

    @Override
    void setFor4() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() > dist * 4)
            currentPoint.setX(currentPoint.getX() - 2);
    }

    @Override
    void setFor5() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() > dist * 5)
            currentPoint.setX(currentPoint.getX() - 2);
    }

    @Override
    void setFor6() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
    }

    @Override
    void setFor7() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() < dist * 7)
            currentPoint.setX(currentPoint.getX() + 2);
    }

    @Override
    void setFor8() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() < dist * 8)
            currentPoint.setX(currentPoint.getX() + 2);
    }

    @Override
    void setFor9() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() < dist * 9)
            currentPoint.setX(currentPoint.getX() + 2);
    }

    @Override
    void setFor10() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
        else if (currentPoint.getX() < dist * 10)
            currentPoint.setX(currentPoint.getX() + 2);
    }


    static void fillArray10(ArrayList<Mobs> list) {
        int i = 1;
        for (Mobs mob : list) {
            if (i == 1) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for1 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 2) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for2 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 3) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for3 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 4) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for4 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 5) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for5 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 6) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for6 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 7) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for7 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 8) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for8 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 9) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for9 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            if (i == 10) {
                FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
                FromOneDotAllRectangle.for10 = true;
                mob.setPath(FromOneDotAllRectangle);
                mob.setFireAbility(true);
            }
            i++;
        }
    }

}
