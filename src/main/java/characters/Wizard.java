package characters;

package game.characters;

        import game.items.Pet;
        import game.items.Potion;
        import game.items.Spell;
        import game.items.Wand;
        import game.items.House;
        import java.util.List;

public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, int health, int strength, int defense, int agility, Pet pet, Wand wand, House house, List<Spell> knownSpells, List<Potion> potions) {
        super(name, health, strength, defense, agility);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.strength - opponent.getDefense();
        if (opponent instanceof Enemy) {
            Enemy enemy = (Enemy) opponent;
            if (this.wand.getCore() == Core.DRAGON_HEARTSTRING && enemy.getHouse() != null && this.house.equals(enemy.getHouse())) {
                // Wizard has a wand with a dragon heartstring core and is attacking an enemy from the same house
                System.out.println("Expelliarmus! You lose your wand, " + enemy.getName() + "!");
                enemy.setWand(null);
            }
        }
        if (this.agility >= opponent.getAgility()) {
            opponent.takeDamage(damage);
            System.out.println(this.name + " attacks " + opponent.getName() + " for " + damage + " damage!");
        } else {
            System.out.println(opponent.getName() + " dodges " + this.name + "'s attack!");
        }
    }

    public void defend() {
        // defend method implementation
    }

    public Pet getPet() {
        return pet;
    }

    public Wand getWand() {
        return wand;
    }

    public House getHouse() {
        return house;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public List<Potion> getPotions() {
        return potions;
    }
}
