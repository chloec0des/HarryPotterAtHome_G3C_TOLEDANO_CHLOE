package items;
import org.game.Game;
import characters.*;
public class Potion {
    private int healAmount;

    public Potion(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public void use(Wizard wizard) {
        wizard.heal(healAmount);
    }

    public static Potion choosePotion() {
        System.out.println("Choose a potion to use:");
        System.out.println("1. Small healing potion (heals 25 HP)");
        System.out.println("2. Large healing potion (heals 50 HP)");

        int choice = Game.readInt("Enter your choice (1-2): ", 2);
        Potion potion;

        switch (choice) {
            case 1:
                potion = new Potion(25);
                break;
            case 2:
                potion = new Potion(50);
                break;
            default:
                throw new IllegalStateException("Invalid potion choice.");
        }

        return potion;
    }
}
