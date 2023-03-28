package items;

import java.util.Random;

public abstract class AbstractSpell {
    private String name;
    private int damage;
    private int accuracy;

    public AbstractSpell(String name, int damage, int accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAccuracy() {
        return accuracy;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public boolean hasFailed() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber > accuracy;
    }
}
