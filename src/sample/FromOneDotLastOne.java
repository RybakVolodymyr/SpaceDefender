package sample;

import java.util.ArrayList;

public class FromOneDotLastOne extends FromOneDotAll {


    @Override
    void setFor1() {
    }

    @Override
    void setFor2() {

    }

    @Override
    void setFor3() {
    }

    @Override
    void setFor4() {

    }

    @Override
    void setFor5() {

    }

    @Override
    void setFor6() {
        if (currentPoint.getY() < height)
            currentPoint.setY(currentPoint.getY() + 2);
    }

    @Override
    void setFor7() {

    }

    @Override
    void setFor8() {

    }

    @Override
    void setFor9() {

    }

    @Override
    void setFor10() {

    }


    static void fillArray1(Mobs mob) {
        FromOneDotAllRectangle FromOneDotAllRectangle = new FromOneDotAllRectangle();
        FromOneDotAllRectangle.for6 = true;
        mob.setPath(FromOneDotAllRectangle);
        mob.setFireAbility(true);

    }
}


