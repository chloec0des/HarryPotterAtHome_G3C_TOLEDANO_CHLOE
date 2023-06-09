package items;

import java.util.ArrayList;

import static org.game.Game.wizard;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    // Add this method to your Inventory class

    public <T> T getItemByType(Class<T> itemType) {
        for (Item item : items) {
            if (itemType.isInstance(item)) {
                return itemType.cast(item);
            }
        }
        return null;
    }
    public int getSize() {
        return items.size();
    }
    public void printInventory() {
        System.out.println("Inventory:");
        for (Item item : getItems()) {
            String itemName = item instanceof Patronus ? "Patronus" : item.getName();
            System.out.println("- " + itemName);
        }
    }
    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }


}
