package WillHero;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Chest extends GameObjects implements Serializable {
    private final double height = 25;
    private Location location;
    private String type;
    Chest(Location loc, ImageView imgChest){
        super(loc,imgChest);
//        this.location = loc;
//        this.imgChest = imgChest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }


}
