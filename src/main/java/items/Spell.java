package items;

public class Spell extends AbstractSpell {
    private int successRate;

    public Spell(String name, int damage, int successRate) {
        super(name, damage);
        this.successRate = successRate;
    }

    // Getters and setters
    // ...

    public boolean cast() {
        // Implement the logic to determine if the spell is successfully cast
    }
}
