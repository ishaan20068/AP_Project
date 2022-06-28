package WillHero;
import java.io.Serializable;

public class Sword extends Weapon implements Serializable {

    Sword() {
        setDamage_value(2);
        setLevel(1);
        setWname("Sword");
    }

}
