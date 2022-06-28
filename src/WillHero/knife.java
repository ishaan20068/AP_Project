package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class knife extends Weapon implements Serializable {

    private final int range=2;
    private int no;//number of knives
    knife() {
        this.no = 1;
        setWname("Knife");
        setDamage_value(1);
        setLevel(1);
    }

    public int getRange() {
        return range;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
