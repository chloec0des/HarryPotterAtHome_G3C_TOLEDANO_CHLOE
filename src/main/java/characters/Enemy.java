package characters;

import items.House;
import items.Wand;

public class Enemy {
    private String name;
    private int damage;
    private int HP;

    public Enemy(String name, int damage, int HP) {
        this.name = name;
        this.damage = damage;
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}