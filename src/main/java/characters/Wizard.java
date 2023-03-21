package characters;

import items.House;
import items.Pet;
import items.Spell;
import items.Wand;
import items.Potion;



// Wizard.java
import java.util.Random;

public class Wizard extends Character {
    private House house;
    private Wand wand;
    private Pet pet;
    private int maxHealthPoints;
    private int HP;

    public Wizard(int HP, String name, House house, Wand wand, Pet pet) {
        super(name,40, 100);
        this.HP = HP;
        this.house = house;
        this.wand = wand;
        this.pet = pet;
        this.maxHealthPoints = 100;
    }
    public void wizardTakeDamage(int damage) {
        this.HP -= damage;
        System.out.println("The wizard took " + damage + " points of damage.");
        System.out.println("The wizard's remaining HP is " + this.HP + ".");
    }

    public void attackEnemy(Enemy enemy, Spell spell) {
        Random random = new Random();
        double accuracy = spell.getAccuracy();

        // Adjust accuracy based on the wizard's house
        switch (house.getName()) {
            case "Slytherin":
                accuracy *= 1.10;
                break;
            case "Gryffindor":
                accuracy *= 1.05;
                break;
            case "Hufflepuff":
                accuracy *= 1.00;
                break;
            case "Ravenclaw":
                accuracy *= 0.95;
                break;
        }

        if (random.nextDouble() * 100 <= accuracy) {
            enemy.takeDamage(spell.getDamage());
            System.out.println("You cast " + spell.getName() + " and dealt " + spell.getDamage() + " damage to " + enemy.getUsername() + ".");
        } else {
            System.out.println("You missed the spell!");
        }
    }
    public void heal(int healAmount) {
        setHealthPoints(Math.min(getHealthPoints() + healAmount, maxHealthPoints));
    }
    public void takeDamage(int damage) {
        setHealthPoints(Math.max(getHealthPoints() - damage, 0));
    }

    public void defend(Enemy enemy) {
        takeDamage(enemy.getDamage());
        System.out.println("You took " + enemy.getDamage() + " damage from " + enemy.getUsername() + ".");
    }

    public void usePotion(Potion potion) {
        int healAmount = potion.getHealAmount();
        setHealthPoints(Math.min(getHealthPoints() + healAmount, maxHealthPoints));
        System.out.println("You used a healing potion and regained " + healAmount + " HP. Your current HP is " + getHealthPoints() + ".");
    }
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
