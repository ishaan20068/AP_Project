package WillHero;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Location implements Serializable{
    //private double x_center;
    private int number;
    private Chest chest;
    private Orc orc;
    private transient ImageView coinhere;
    private transient ImageView fallingplatform;
    private boolean has_coin=false;


    private boolean has_platform;
    private boolean has_chest;
    private boolean has_orc;
    private boolean has_falling_platform;
    Location(int loc,boolean has_platform){ //For island
        this.number = loc;
        this.has_platform = has_platform;
    }

    public void setHas_platform(boolean has_platform) {
        this.has_platform = has_platform;
    }

    public void setFallingplatform(ImageView w){
        this.fallingplatform=w;
    }

    public ImageView getFallingplatform(){
        return this.fallingplatform;
    }
    public boolean isHas_falling_platform() {
        return has_falling_platform;
    }

    public void setHas_falling_platform(boolean has_falling_platform) {
        this.has_falling_platform = has_falling_platform;
    }

    public boolean isHas_platform() {
        return has_platform;
    }

    public void setHas_chest(boolean has_chest) {
        this.has_chest = has_chest;
    }

    public void setHas_orc(boolean has_orc) {
        this.has_orc = has_orc;
    }

    public ImageView getCoinhere() {
        return coinhere;
    }

    public void setCoinhere(ImageView coinhere) {
        this.coinhere = coinhere;
    }

    public Orc getOrc() {
        return orc;
    }

    public void setOrc(Orc orc) {
        this.orc = orc;
    }

    public boolean isHas_coin() {
        return has_coin;
    }

    public void setHas_coin(boolean has_coin) {
        this.has_coin = has_coin;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public boolean isHas_chest() {
        return has_chest;
    }

    public int getNumber() {
        return number;
    }

    public boolean isHas_orc() {
        return has_orc;
    }
}
