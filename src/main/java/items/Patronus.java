package items;
public class Patronus extends Item {
    private int strength;

    public Patronus(String name, int strength) {
        super(name);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void use() {
        System.out.println("Expecto Patronum!");
        System.out.println("Your " + getName() + " Patronus has appeared and repelled the Dementors.");
    }
}