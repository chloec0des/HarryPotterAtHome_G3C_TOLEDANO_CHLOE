package org.game;

import characters.Enemy;
import characters.Wizard;

import items.Inventory;
import items.Reward;
import items.Spell;

import java.util.Optional;

public class Level1 extends Level {

    public Level1() {

        super("Hogwarts School of Witchcraft and Wizardry", "The dungeon toilets",  new Enemy("Troll", 20, 50));
    }

    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome to " + Game.wizard.getName() + " at " + getLocation() + "!");
        display.printMessage("You are facing a wild " + super.getEnemy().getName() + " that has appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Wingardium Leviosa", 25, 60);
        battle(wizard, super.getEnemy(), spell, Optional.empty());
        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            if (getEnemy().getHealthPoints() <= 0) {
                Level.endingLevel(wizard, getEnemy(), 1);
                display.anythingToContinue();
                Reward reward = new Reward(" a golden snitch");
                wizard.getInventory().addItem(reward);
                display.printMessage("You have received " + reward.getReward() + " as a reward.");
                Inventory inventory = wizard.getInventory();
                inventory.printInventory();
                display.anythingToContinue();
            }
        }

    }
}
