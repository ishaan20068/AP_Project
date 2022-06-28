package WillHero;

import java.io.Serializable;

public class Helmet implements Serializable{
    private final String name="Normal Helmet";
    private Weapon sword;
    private Weapon knife;
    Helmet(){

    }
    public Weapon getSword() {
        return sword;
    }
    public void setSword(Weapon sword) {
        this.sword = sword;
    }
    public Weapon getKnife() {
        return knife;
    }
    public void setKnife(Weapon knife) {
        this.knife = knife;
    }
}
