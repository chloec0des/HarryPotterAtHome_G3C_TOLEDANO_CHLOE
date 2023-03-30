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
        display.printMessage("Welcome to " + getName() + " at " + getLocation() + "!");
        display.printMessage("You are facing a powerful " + getEnemy().getName() + " that has appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Stupefy", 50, 70);
        while (getEnemy().getHealthPoints() > 0) {
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() <= 0) {
                display.printMessage("You have been defeated. Game over!");
                return;
            }
        }

        Level.choiceIncrease(wizard, spell);

        // Add fireworks to inventory
        Inventory inventory = wizard.getInventory();
        inventory.addItem(new Fireworks("Fireworks"));

        display.printMessage("You defeated " + getEnemy().getName() + " and found some fireworks! Let's party! 🎉");

        Level.endingLevel(wizard, getEnemy(), 5);
    }


}
