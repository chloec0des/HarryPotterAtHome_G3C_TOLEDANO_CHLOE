package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Fireworks;
import items.Inventory;
import items.Potion;
import items.Spell;

import java.util.Optional;

public class Level5 extends Level {

    public Level5() {
        super("Level 5", "The Hogwarts Examination Room", new Enemy("Dolores Umbridge", 40, 150));
    }

    public void playLevel(Wizard wizard) {
        System.out.println("Welcome to " + getName() + " at " + getLocation() + "!");
        System.out.println("You are facing a powerful " + getEnemy().getName() + " that has appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Stupefy", 50, 40);
        while (getEnemy().getHealthPoints() > 0) {
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() <= 0) {
                System.out.println("You have been defeated. Game over!");
                return;
            }
        }

        Level.choiceIncrease(wizard, spell);
        Potion chosenPotion = Potion.choosePotion();
        chosenPotion.use(wizard);

        // Check if fireworks are in inventory
        Inventory inventory = wizard.getInventory();
        boolean hasFireworks = inventory.getItemByType(Fireworks.class) != null;
        while (!hasFireworks) {
            System.out.println("You defeated " + getEnemy().getName() + " but she has hidden the fireworks!");
            Game.anythingToContinue();
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() <= 0) {
                System.out.println("You have been defeated. Game over!");
                return;
            }
            hasFireworks = inventory.getItemByType(Fireworks.class) != null;
        }
// If fireworks are in inventory, start the party
        if (inventory.getItemByType(Fireworks.class) != null) {
            inventory.removeItem(new Fireworks("Fireworks"));
            System.out.println("You found the fireworks! Let the party begin!");
            Level.endingLevel(wizard, getEnemy(), 5);
        } else {
            System.out.println("You defeated " + getEnemy().getName() + " but she has hidden the fireworks!");
            Game.anythingToContinue();
        }

    }

}
