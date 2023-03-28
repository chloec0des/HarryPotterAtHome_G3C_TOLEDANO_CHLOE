package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Potion;
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
        Spell spell = new Spell("Expelliarmus", 40, 60);
        Level.battle(wizard, super.getEnemy(), spell, Optional.empty());

        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            if (getEnemy().getHealthPoints() <= 0) {
                Level.endingLevel(wizard, getEnemy(), 4);
            }
        }
    }
}
