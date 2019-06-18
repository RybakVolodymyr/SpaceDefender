package sample;

import java.io.Serializable;

public class Ship implements Serializable {
    private String url;
    private int firstDamage = 100;
    private int damageUp;
    private int nymberOfDamageUpdate;
    private int nymberOfHpUpdate;
    private int numberOfGuns;
    private int firstHP;
    private boolean firstSuper;
    private boolean secondSuper;
    private boolean thirdSuper;
    private int numberOfCoins;
    private int damage;
    private int lifes;
    private int startLifes;
    private boolean helper;


    public String getUrl() {
        return url;
    }

    public int getLifes() {
        return lifes;
    }

    void refreshLives(){
        lifes = startLifes+nymberOfHpUpdate;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFirstDamage() {
        return firstDamage;
    }

    public void setFirstDamage(int firstDamage) {
        this.firstDamage = firstDamage;
    }

    public int getDamageUp() {
        return damageUp;
    }

    public void setDamageUp(int damageUp) {
        this.damageUp = damageUp;
    }

    public int getNymberOfDamageUpdate() {
        return nymberOfDamageUpdate;
    }

    public void setNymberOfDamageUpdate(int nymberOfDamageUpdate) {
        this.nymberOfDamageUpdate = nymberOfDamageUpdate;
    }

    public int getNymberOfHpUpdate() {
        return nymberOfHpUpdate;
    }

    public void setNymberOfHpUpdate(int nymberOfHpUpdate) {
        this.nymberOfHpUpdate = nymberOfHpUpdate;
    }

    public int getNumberOfGuns() {
        return numberOfGuns;
    }

    public void setNumberOfGuns(int numberOfGuns) {
        this.numberOfGuns = numberOfGuns;
    }

    public int getFirstHP() {
        return firstHP;
    }

    public void setFirstHP(int firstHP) {
        this.firstHP = firstHP;
    }

    public boolean isFirstSuper() {
        return firstSuper;
    }

    public void setFirstSuper(boolean firstSuper) {
        this.firstSuper = firstSuper;
    }

    public boolean isSecondSuper() {
        return secondSuper;
    }

    public void setSecondSuper(boolean secondSuper) {
        this.secondSuper = secondSuper;
    }

    public boolean isThirdSuper() {
        return thirdSuper;
    }

    public void setThirdSuper(boolean thirdSuper) {
        this.thirdSuper = thirdSuper;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public int getDamage() {
        damage = firstDamage + damageUp*nymberOfDamageUpdate;
        return damage;
    }

    public boolean isHelper() {
        return helper;
    }

    public void setHelper(boolean helper) {
        this.helper = helper;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Ship(int numberOfCoins, int damageUp, int nymberOfDamageUpdate, int nymberOfHpUpdate, int numberOfGuns, int firsHP, boolean firstSuper, boolean secondSuper, boolean thirdSuper) {
        refreshURL(numberOfGuns);
        this.damageUp = damageUp;
        this.numberOfCoins = numberOfCoins;
        this.firstHP = firsHP;
        this.nymberOfDamageUpdate = nymberOfDamageUpdate;
        this.nymberOfHpUpdate = nymberOfHpUpdate;
        this.numberOfGuns = numberOfGuns;
        this.firstSuper = firstSuper;
        this.secondSuper = secondSuper;
        this.thirdSuper = thirdSuper;
        this.startLifes = firstHP;
        this.lifes = firstHP+nymberOfHpUpdate;
    }

    public void refreshURL(int numberOfGuns){
        if(numberOfGuns==1)
            this.url = "\\recources\\space ship\\redOne.png";
        if(numberOfGuns==2)
            this.url = "\\recources\\space ship\\redTwo.png";
        if(numberOfGuns==3)
            this.url = "\\recources\\space ship\\redThree.png";
        if(numberOfGuns!=1 && numberOfGuns!=2 && numberOfGuns!=3)
            this.url = "\\recources\\space ship\\redOne.png";
    }
}
