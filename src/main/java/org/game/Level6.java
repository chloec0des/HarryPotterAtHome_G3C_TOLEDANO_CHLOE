package org.game;
import characters.Enemy;
import characters.Wizard;
import items.Potion;
import items.Spell;

import java.util.Optional;

public class Level6 extends Level {

    public Level6() {
        super("Level 6", "Astronomy Tower", new Enemy("Dark Wizard", 60, 150));
    }

    public void playLevel(Wizard wizard) {
        System.out.println("Welcome to " + getLocation() + "!");
        System.out.println("You have entered the " + getLocation() + ", but a Dark Wizard has appeared and is attacking you.");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Sectumsempra", 30, 50);
        if (wizard.getHouse().getName().equals("Slytherin")) {
            System.out.println("As a member of Slytherin, you have the option to ally with the Death Eaters. ");
            String allyChoice = Game.readString("Will you ally with them? (y/n)");
            if (allyChoice.equalsIgnoreCase("y")) {
                super.setEnemy(new Enemy("Death Eater", 70, 200));
                System.out.println("You have allied with the Death Eaters.");
            }
            if (allyChoice.equalsIgnoreCase("y")) {
                System.out.println("You have chosen not to ally with the Death Eaters.");
                Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            }
        }
        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            Potion chosenPotion = Potion.choosePotion();
            chosenPotion.use(wizard);
            if (getEnemy().getHealthPoints() <= 0) {
                Level.endingLevel(wizard, getEnemy(), 6);
            }
        }
    }
}
