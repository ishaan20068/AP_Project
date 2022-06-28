package WillHero;

import javafx.scene.image.ImageView;

public class Hero extends GameObjects {
    private Helmet helmet;
    private int weapon_flag;
    //private Platform platform;
    private int coins=0;
    private final double jump_height=60.0;
    private double current_y_position;
    private final double length=25.0;

    public int getCoins() {
        return this.coins;
    }

    public void increasecoins(int coins) {
        this.coins += coins;
    }

    Hero(Location loc1,ImageView img1){
        super(loc1,img1);//When beginning the game from scratch...
        this.weapon_flag=0;
    }

    public int getWeapon_flag() {
        return weapon_flag;
    }

    public void setWeapon_flag(int weapon_flag) {
        this.weapon_flag = weapon_flag;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }
}
