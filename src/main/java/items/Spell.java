package items;

public class Spell {
    private String name;
    private int damage;
    private int precision;

    public Spell(String name, int damage, int precision) {
        this.name = name;
        this.damage = damage;
        this.precision = precision;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrecision() {
        return precision;
    }
}