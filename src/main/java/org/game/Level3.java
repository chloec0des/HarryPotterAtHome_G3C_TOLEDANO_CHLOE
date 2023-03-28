package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Potion;
import items.Spell;

import java.util.Optional;

public class Level3 extends Level {

    public Level3() {
        super("Level 3", "Forbidden Forest", new Enemy("Acromantula", 40, 100));
    }

    public void playLevel(Wizard wizard) {
        System.out.println("Welcome back for this new year " + getName() + " in the " + getLocation() + "!");
        System.out.println("You have encountered a dangerous " + getEnemy().getName() + " in the Forbidden Forest.");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Expelliarmus", 30, 60);
        Level.battle(wizard, super.getEnemy(), spell, Optional.empty());

        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            Potion chosenPotion = Potion.choosePotion();
            chosenPotion.use(wizard);
            if (getEnemy().getHealthPoints() <= 0) {
                Level.endingLevel(wizard, getEnemy(), 3);
            }
        }
    }
}