package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Potion;
import items.Spell;
import items.Patronus;

import java.util.Optional;

public class Level3 extends Level {

    public Level3() {
        super("Level 3", "Forbidden Forest", new Enemy("Dementor", 30, 100));
    }

    public void playLevel(Wizard wizard) {
        System.out.println("Welcome to " + getLocation() + "!");
        System.out.println("You have entered the " + getLocation() + ", but a Dementor is lurking in the shadows.");

        // Level-specific mechanics here
        Spell spell = new Spell("Expecto Patronum", 40, 30);
        if (wizard.getInventory().getItemByType(Patronus.class) == null) {
            System.out.println("You don't have a Patronus yet. Go back to Level 2 to learn how to cast one.");
        } else {
            System.out.println("You cast Expecto Patronum, and a " + wizard.getInventory().getItemByType(Patronus.class).getName() + " Patronus appears!");
            if (wizard.getHouse().getName().equals("Gryffindor")) {
                System.out.println("As a member of Gryffindor, your Patronus is particularly effective against Dementors.");
                spell.setAccuracy(spell.getAccuracy() * 1.2);
                spell.setDamage(spell.getDamage() * 1.2);
            }
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() <= 0) {
                System.out.println("You have been defeated. Game over!");
                return;
            }
            System.out.println("You successfully cast Expecto Patronum and drove the Dementor away from the Forbidden Forest!");
            Level.endingLevel(wizard, getEnemy(), 3);
        }
    }
}
