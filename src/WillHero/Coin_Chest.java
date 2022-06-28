package WillHero;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Coin_Chest extends Chest implements Serializable {
    private final int numCoins=10;
    Coin_Chest(Location loc, ImageView coinChestimg){
        super(loc,coinChestimg);
        this.setType("Coin");
    }

    public int getNumCoins() {
        return numCoins;
    }
}
