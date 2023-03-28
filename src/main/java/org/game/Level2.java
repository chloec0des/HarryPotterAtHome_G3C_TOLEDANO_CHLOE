package org.game;

import characters.Enemy;
import characters.Wizard;
import items.House;
import items.Potion;
import items.Spell;
import items.Sword;

import java.util.Optional;

public class Level2 extends Level {

    public Level2() {

        super("Level 2", "Chamber of Secrets", new Enemy("Basilisk", 20, 70));
    }


    public void playLevel(Wizard wizard) {
        System.out.println("Welcome back for this new year " + getName() + " in the " + getLocation() + "!");
        System.out.println("You are facing a wild " + getEnemy().getName() + " that has appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Accio", 25, 40);
        Optional<Sword> swordOptional = Optional.empty();
        if (wizard.getHouse() == House.GRYFFINDOR) {
            Sword sword = wizard.getInventory().getItemByType(Sword.class);
            swordOptional = Optional.ofNullable(sword);
        }
        Level.battle(wizard, getEnemy(), spell, swordOptional);
        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            Potion chosenPotion = Potion.choosePotion();
            chosenPotion.use(wizard);
            if (getEnemy().getHealthPoints() <= 0) {
                Level.endingLevel(wizard, getEnemy(), 2);
            }
        }
        swordOptional.ifPresent(s -> wizard.getInventory().removeItem(s));
    }

}
