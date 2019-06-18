package sample;

import java.util.ArrayList;

public class FromOneDotAllStraight extends FromOneDotAll {

    int x = 1280 / 2;
    int y = 50;
    int distanceY = height - y;

    @Override
    void setFor1() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() - (x - dist) / 50);
        }
    }

    @Override
    void setFor2() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() - (x - dist*2) / 50);
        }
    }

    @Override
    void setFor3() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() - (x - dist*3) / 50);
        }
    }

    @Override
    void setFor4() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() - (x - dist*4) / 50);
        }
    }

    @Override
    void setFor5() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() - (x - dist*5) / 50);
        }
    }

    @Override
    void setFor6() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
        }

    }

    @Override
    void setFor7() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() + (-x + dist*7) / 50);
        }
    }

    @Override
    void setFor8() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() + (-x + dist*8) / 50);
        }
    }

    @Override
    void setFor9() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() + (-x + dist*9) / 50);
        }
    }

    @Override
    void setFor10() {
        if (currentPoint.getY() < 100) {
            currentPoint.setY(currentPoint.getY() + y / 50);
            currentPoint.setX(currentPoint.getX() + (-x + dist*10) / 50);
        }
    }


    static void fillArray10(ArrayList<Mobs> list) {
        int i = 1;
        for (Mobs mob : list) {
            if (i == 1) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for1 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 2) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for2 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 3) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for3 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 4) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for4 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 5) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for5 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 6) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for6 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 7) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for7 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 8) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for8 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 9) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for9 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            if (i == 10) {
                FromOneDotAllStraight FromOneDotAllStraight = new FromOneDotAllStraight();
                FromOneDotAllStraight.for10 = true;
                mob.setPath(FromOneDotAllStraight);
                mob.setFireAbility(true);
            }
            i++;
        }
    }
}
