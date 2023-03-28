package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Potion;
import items.Spell;

import java.util.Optional;

public class Level7 extends Level {

    public Level7() {
        super("Level 7", "Hogwarts", new Enemy("Voldemort", 80, 250));
    }
    public void playLevel(Wizard wizard) {
        System.out.println("Welcome back to " + getLocation() + "!");
        System.out.println("You have finally reached your last year, where Voldemort awaits you.");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Expelliarmus", 80, 50);
        Level.battle(wizard, super.getEnemy(), spell, Optional.empty());

        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            Potion chosenPotion = Potion.choosePotion();
            chosenPotion.use(wizard);
            if (getEnemy().getHealthPoints() <= 0) {
                Level.endingLevel(wizard, getEnemy(), 7);
            }
        }
    }
}
