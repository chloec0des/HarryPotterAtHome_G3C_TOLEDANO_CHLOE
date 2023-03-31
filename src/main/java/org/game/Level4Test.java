package org.game;

import characters.Enemy;
import characters.Wizard;
import items.*;

public class Level4Test {
    public static void main(String[] args) {
        Level4 level4 = new Level4();
        Wizard wizard = new Wizard(100, "Harry Potter", House.GRYFFINDOR, new Wand(Core.PHOENIX_FEATHER, 10), Pet.OWL);

        // Check if the level's name and location are correct
        assert level4.getName().equals("Level 4");
        assert level4.getLocation().equals("Little Hangleton Cemetery");

        // Check if the enemy's name, health points, and damage are correct
        Enemy enemy = level4.getEnemy();
        assert enemy.getName().equals("Voldemort and Peter Pettigrew");
        assert enemy.getHealthPoints() == 30;
        assert enemy.getDamage() == 80;

        // Play the level and check if the reward is added to the inventory
        level4.playLevel(wizard);
        Inventory inventory = wizard.getInventory();
        assert inventory.hasItem("a Howler card");

        // Check if the wizard's health points have increased after choosing to increase the spell's power
        int initialHP = wizard.getHealthPoints();
        Level.choiceIncrease(wizard, new Spell("Accio", 100, 60));
        assert wizard.getHealthPoints() > initialHP;
    }
}
