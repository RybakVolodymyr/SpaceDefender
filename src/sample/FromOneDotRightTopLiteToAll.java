package sample;

import java.util.ArrayList;

public class FromOneDotRightTopLiteToAll extends FromOneDotRightTop {

    int x = 1280 / 2;
    int y = 50;
    int distanceY = height - y;
    double distTop = 1280/8;
    double distDown = 1280/7;
    boolean for11 = false;


    static void fillArray11(ArrayList<Mobs> list) {
        int i = 1;
        for (Mobs mob : list) {
            if (i == 1) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for1 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
                mob.setFireAbility(true);
            }
            if (i == 2) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for2 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
                mob.setFireAbility(true);
            }
            if (i == 3) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for3 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
                mob.setFireAbility(true);
            }
            if (i == 4) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for4 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
                mob.setFireAbility(true);
            }
            if (i == 5) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for5 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
                mob.setFireAbility(true);
            }
            if (i == 6) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for6 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
                mob.setFireAbility(true);
            }
            if (i == 7) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for7 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
            }
            if (i == 8) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for8 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
            }
            if (i == 9) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for9 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
            }
            if (i == 10) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for10 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
            }
            if (i == 11) {
                FromOneDotRightTopLiteToAll FromOneDotRightTopLiteToAll = new FromOneDotRightTopLiteToAll();
                FromOneDotRightTopLiteToAll.for11 = true;
                mob.setPath(FromOneDotRightTopLiteToAll);
            }
            i++;
        }
    }
    @Override
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
            if (for11) setFor11();
        }
        return currentPoint;
    }

    static boolean goLeft = false;

    @Override
    void setFor1() {
        if(goLeft && currentPoint.getX()>distTop){
            currentPoint.setX(currentPoint.getX() - (firstX - distTop)/100 );
        }
    }

    @Override
    void setFor2() {
        if(goLeft && currentPoint.getX()>distTop*2){
            currentPoint.setX(currentPoint.getX() - (firstX - distTop*2)/100 );
        }
    }

    @Override
    void setFor3() {
        if(goLeft && currentPoint.getX()>distTop*3){
            currentPoint.setX(currentPoint.getX() - (firstX - distTop*3)/100 );
        }

    }

    @Override
    void setFor4() {
        if(goLeft && currentPoint.getX()>distTop*4){
            currentPoint.setX(currentPoint.getX() - (firstX - distTop*4)/100 );
        }
    }

    @Override
    void setFor5() {
        System.out.println("lol");
        if(goLeft && currentPoint.getX()>distTop*5){
            currentPoint.setX(currentPoint.getX() - (firstX - distTop*5)/100 );
        }
    }

    @Override
    void setFor6() {
        if(goLeft && currentPoint.getX()>distTop*6){
            currentPoint.setX(currentPoint.getX() - (firstX - distTop*6)/100 );
        }
    }

    @Override
    void setFor7() {
        if(goLeft && currentPoint.getX()>distDown){
            currentPoint.setX(currentPoint.getX() - (firstX - distDown)/100 );
        }else {
            currentPoint.setY(currentPoint.getY() +1 );
            if (currentPoint.getY() >= 100) goLeft = true;
        }
    }

    @Override
    void setFor8() {
        if(goLeft && currentPoint.getX()>distDown*2){
            currentPoint.setX(currentPoint.getX() - (firstX - distDown*2)/100 );
        }else {
            currentPoint.setY(currentPoint.getY() +1 );
            if (currentPoint.getY() >= 100) goLeft = true;
        }
    }

    @Override
    void setFor9() {
        if(goLeft && currentPoint.getX()>distDown*3){
            currentPoint.setX(currentPoint.getX() - (firstX - distDown*3)/100 );
        }else {
            currentPoint.setY(currentPoint.getY() + 1 );
            if (currentPoint.getY() >= 100) goLeft = true;
        }
    }

    @Override
    void setFor10() {
        if(goLeft && currentPoint.getX()>distDown*4){
            currentPoint.setX(currentPoint.getX() - (firstX - distDown*4)/100 );
        }else {
            currentPoint.setY(currentPoint.getY() + 1 );
            if (currentPoint.getY() >= 100) goLeft = true;
        }
    }

    void setFor11() {
        if(goLeft && currentPoint.getX()>distDown*5){
            currentPoint.setX(currentPoint.getX() - (firstX - distDown*5)/100 );
        }else {
            currentPoint.setY(currentPoint.getY() + 1 );
            if (currentPoint.getY() >= 100) goLeft = true;
        }
    }
}
