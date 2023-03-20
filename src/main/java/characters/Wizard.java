package characters;
// Wizard.java
public class Wizard extends Character {
    private House house;
    private Pet pet;
    private Wand wand;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, House house, Pet pet, Wand wand) {
        super(name);
        this.house = house;
        this.pet = pet;
        this.wand = wand;
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
    }

    // Getters and setters
    // ...

    public void learnSpell(Spell spell) {
        this.knownSpells.add(spell);
    }

    public void addPotion(Potion potion) {
        this.potions.add(potion);
    }
}

