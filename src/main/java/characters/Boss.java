package characters;

import items.House;
import items.Wand;

public class Boss extends AbstractEnemy {
    private String name;
    private int maxHealth;
    private int health;
    private int strength;
    private Spell spell;

    public Boss(String name, int maxHealth, int strength, Spell spell) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.strength = strength;
        this.spell = spell;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    public Spell getSpell() {
        return spell;
    }

    @Override
    public void attack(Character character) {
        int damage = this.getStrength() + this.getSpell().getPower() - character.getDefense();
        if (damage > 0) {
            character.takeDamage(damage);
        }
    }
}
