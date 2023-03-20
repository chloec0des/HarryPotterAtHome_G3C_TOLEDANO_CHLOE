package characters;
// Wizard.java
public class Wizard extends Character {
    private House house;
    private Wand wand;
    private Pet pet;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, int damage, int healthPoints, House house, Wand wand, Pet pet) {
        super(name, damage, healthPoints);
        this.house = house;
        this.wand = wand;
        this.pet = pet;
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
    }

    // Add getters and setters for house, wand, pet, knownSpells, and potions
}
