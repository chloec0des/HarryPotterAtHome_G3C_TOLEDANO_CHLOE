package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Spell;
import items.Patronus;

import java.util.Optional;

public class Level3 extends Level {

    public Level3() {

        super("Level 3", "Forbidden Forest", new Enemy("Dementor", 30, 100));
    }

    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome to " + getLocation() + "!");
        display.printMessage("You have entered the " + getLocation() + ", but a Dementor is lurking in the shadows.");

        // Level-specific mechanics here
        Spell spell = new Spell("Expecto Patronum", 40, 30);
        if (wizard.getInventory().getItemByType(Patronus.class) == null) {
            display.printMessage("You don't have a Patronus yet. Go back to Level 2 to learn how to cast one.");
            Level2 level2 = new Level2();
            level2.playLevel(wizard);
        } else {
            display.printMessage("You cast Expecto Patronum, and a " + wizard.getInventory().getItemByType(Patronus.class).getName() + " Patronus appears!");
            if (wizard.getHouse().getName().equals("Gryffindor")) {
                display.printMessage("As a member of Gryffindor, your Patronus is particularly effective against Dementors.");
                spell.setAccuracy(spell.getAccuracy() * 1.2);
                spell.setDamage(spell.getDamage() * 1.2);
            }
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() <= 0) {
                display.printMessage("You have been defeated. Game over!");
                return;
            }
            display.printMessage("You successfully cast Expecto Patronum and drove the Dementor away from the Forbidden Forest!");
            Level.endingLevel(wizard, getEnemy(), 3);
        }
    }
}
