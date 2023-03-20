package characters;

package game.characters;

public abstract class Character {

    private String name;
    private int damage;
    private int HP;

    public Character(String name, int damage, int HP) {
        this.name = name;
        this.damage = damage;
        this.HP = HP;
    }

    public abstract void attack(Character opponent);

    public void receiveDamage(int damage) {
        this.HP -= damage;
        if (this.HP < 0) {
            this.HP = 0;
        }
        System.out.println(getName() + " received " + damage + " points of damage.");
        if (this.HP == 0) {
            System.out.println(getName() + " is defeated!");
        }
    }

    public boolean isDefeated() {
        return this.HP == 0;
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

