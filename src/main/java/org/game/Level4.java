package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Spell;

import java.util.Optional;

public class Level4 extends Level {

    public Level4() {
        super("Level 4", "Little Hangleton Cemetery", new Enemy("Voldemort and Peter Pettigrew", 30, 80));
    }

    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome to " + getName() + " at " + getLocation() + "!");
        display.printMessage("You are facing " + getEnemy().getName() + " that have appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Accio", 100, 60);
        Level.battle(wizard, super.getEnemy(), spell, Optional.empty());

        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            if (getEnemy().getHealthPoints() <= 0) {
                display.printMessage("You successfully cast Accio and retrieved. You have been transported to the next level!");
                Level5 level5 = new Level5();
                level5.playLevel(wizard);
            } else {
                display.printMessage("The spell failed to retrieve. You need to defeat Voldemort and Peter Pettigrew to proceed.");
            }
        } else {
            display.printMessage("You have been defeated. Game over!");
        }
    }

}