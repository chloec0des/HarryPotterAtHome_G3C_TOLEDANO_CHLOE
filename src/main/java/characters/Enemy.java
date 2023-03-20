package characters;

public class Enemy extends AbstractEnemy {
    public Enemy(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attack(Character target) {
        // Implement the enemy's attack logic here
    }
}
