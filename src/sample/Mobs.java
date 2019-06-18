package sample;

import javafx.scene.image.ImageView;


public class Mobs {

    private int hp = 500;
    private int firstHp = hp;
    private int firstDamage = 1;
    private int damageUpdate;
    private String url = "\\recources\\enemyBlack1.png";
    ImageView image = new ImageView(url);

    FromOneDot path;

    boolean fireAbility = false;

    public boolean isFireAbility() {
        return fireAbility;
    }

    public void setFireAbility(boolean fireAbility) {
        this.fireAbility = fireAbility;
    }

    public Mobs(int damageUpdate) {
        this.damageUpdate = damageUpdate;
    }

    public FromOneDot getPath() {
        return path;
    }

    public void setPath(FromOneDot path) {
        this.path = path;
    }

    boolean minosLife(){
        if(hp-Main.ship.getDamage() >0) {
        hp-=Main.ship.getDamage();
            System.out.println(Main.ship.getDamage()+ "    dddddddddddddddddddddddddddddddddddddddddddddddddddd");
        return true;
        }
        return false;
    }

    public int getFirstHp() {
        return firstHp;
    }

    public void setFirstHp(int firstHp) {
        this.firstHp = firstHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getFirstDamage() {
        return firstDamage;
    }

    public void setFirstDamage(int firstDamage) {
        this.firstDamage = firstDamage;
    }

    public int getDamageUpdate() {
        return damageUpdate;
    }

    public void setDamageUpdate(int damageUpdate) {
        this.damageUpdate = damageUpdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
