package characters;
import org.game.*;
public class Enemy extends Character {
    public Enemy(String username, int damage, int healthPoints) {
        super(username, damage, healthPoints);
        setDamage(damage);
    }
    public String getUsername() {
        return this.getName();
    }
    public void attack(Wizard wizard) {
        int damage = 5;
        System.out.println("The enemy attacked the wizard for " + damage + " points of damage.");
        wizard.wizardTakeDamage(damage);
    }

    public void takeDamage(int damage) {
        setHealthPoints(getHealthPoints() - damage);
        if (getHealthPoints() < 0) {
            setHealthPoints(0);
        }

    }
}