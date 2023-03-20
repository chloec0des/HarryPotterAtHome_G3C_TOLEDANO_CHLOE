package items;

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

}

