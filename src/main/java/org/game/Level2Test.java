package org.game;

import characters.Wizard;
import items.*;

import java.util.List;

public class Level2Test {
    public static void main(String[] args) {
        // Create a new Level2 object
        Level2 level2 = new Level2();

        // Create a new Wizard object
        Wand wand = new Wand(Core.DRAGON_HEARTSTRING, 10);
        Wizard wizard = new Wizard(100, "Harry Potter", House.GRYFFINDOR, wand, Pet.OWL);

        // Call the playLevel method with the wizard object
        level2.playLevel(wizard);

        // Assert that the wizard's inventory contains the expected items after completing the level
        Inventory inventory = wizard.getInventory();
        List<Item> items = inventory.getItems();
        assert items.size() == 2;
        assert items.get(0) instanceof Patronus;
        assert items.get(1) instanceof Reward;
    }
}
