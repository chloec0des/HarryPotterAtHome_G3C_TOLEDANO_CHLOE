package org.game;

import characters.Enemy;
import characters.Wizard;
import items.Core;
import items.Potion;
import items.Spell;
import items.Wand;

import java.util.Optional;
import java.util.Random;

public class Level7 extends Level {

    public Level7() {
        super("Level 7", "Hogwarts", new Enemy("Voldemort", 80, 250));
    }
    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome back to " + getLocation() + "!");
        display.printMessage("You have finally reached your last year, where Voldemort awaits you.");

        // Perform level-specific gameplay mechanics here
        Wand voldemortWand = generateVoldemortWand();
        if (voldemortWand.getCore() == wizard.getWand().getCore()) {
            finalBattle(wizard, super.getEnemy());
        } else {
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

    private Wand generateVoldemortWand() {
        Core voldemortCore = Core.PHOENIX_FEATHER;
        Random random = new Random();
        return new Wand(voldemortCore, random.nextInt(25) + 1);
    }


    private void finalBattle(Wizard wizard, Enemy enemy) {
        Core wizardCore = wizard.getWand().getCore();
        Core voldemortCore = generateVoldemortWand().getCore();
        if (wizardCore == voldemortCore) {
            display.printMessage("Your chance of winning against Voldemort is now 50% because you have the same core.");
            Random random = new Random();
            boolean wizardWins = random.nextBoolean();
            Display.anythingToContinue();
            if (wizardWins) {
                display.printMessage("You have defeated Voldemort! Congratulations!");
                Level.endingLevel(wizard, enemy, 7);
            } else {
                display.printMessage("Unfortunately, Voldemort has defeated you. Game over!");
            }
        } else {
            display.printMessage("You face Voldemort in the final battle!");
            Spell spell = new Spell("Expelliarmus", 80, 50);
            Level.battle(wizard, enemy, spell, Optional.empty());
            if (wizard.getHealthPoints() > 0) {
                Level.choiceIncrease(wizard, spell);
                Potion chosenPotion = Potion.choosePotion();
                chosenPotion.use(wizard);
                if (enemy.getHealthPoints() <= 0) {
                    display.printMessage("You have defeated Voldemort! Congratulations!");
                    Level.endingLevel(wizard, enemy, 7);
                }
            } else {
                display.printMessage("Unfortunately, Voldemort has defeated you. Game over!");
            }
        }
    }
}