package WillHero;

import javafx.scene.image.ImageView;

public class Weapon_Chest extends Chest{

    private final Weapon w;
    Weapon_Chest(Location loc, ImageView weaponChestImg,Weapon w1){
        super(loc,weaponChestImg);
        this.w = w1;
        this.setType("Weapon");
    }

    public Weapon getWeapon() {
        return this.w;
    }

}
