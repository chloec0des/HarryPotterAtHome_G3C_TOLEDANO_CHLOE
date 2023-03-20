package characters;

package game.characters;

public abstract class AbstractEnemy extends Character {

    public AbstractEnemy(String name, int damage, int HP) {
        super(name, damage, HP);
    }

    public abstract void speak();

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " attacks " + opponent.getName() + "!");
        opponent.receiveDamage(this.getDamage());
    }
}

