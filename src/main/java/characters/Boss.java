package characters;

public class Boss extends Enemy {
    public Boss(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attack(Character target) {
        // Implement the boss's attack logic here
    }
}
