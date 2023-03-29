package org.game;

import characters.Enemy;
import characters.Wizard;
import items.*;

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
                System.out.println("You have successfully defeated the Basilisk!");
                learnPatronus(wizard);
                Level.endingLevel(wizard, getEnemy(), 2);
            }
        }
        swordOptional.ifPresent(s -> wizard.getInventory().removeItem(s));
    }
    private void learnPatronus(Wizard wizard) {
        System.out.println("Congratulations on defeating the Basilisk! You have unlocked the ability to cast a Patronus.");
        Patronus patronus = new Patronus(Game.readString("Enter to learn your Patronum and finish this second year! Remember, this spell will be useful later... Sooner than you imagine"), 50);
        wizard.getInventory().addItem(patronus);
        System.out.println("You have learned to cast Expecto Patronum, and your Patronus has been added to your inventory.");
    }
}
