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
        System.out.println("Welcome to " + getName() + " at " + getLocation() + "!");
        System.out.println("You are facing " + getEnemy().getName() + " that have appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Accio", 40, 60);
        Level.battle(wizard, super.getEnemy(), spell, Optional.empty());

        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            if (getEnemy().getHealthPoints() <= 0) {
                System.out.println("You successfully cast Accio and retrieved the portkey. You have been transported to the next level!");
                Level5 level5 = new Level5();
                level5.playLevel(wizard);
            } else {
                System.out.println("The spell failed to retrieve the portkey. You need to defeat Voldemort and Peter Pettigrew to proceed.");
            }
        } else {
            System.out.println("You have been defeated. Game over!");
        }
    }

}