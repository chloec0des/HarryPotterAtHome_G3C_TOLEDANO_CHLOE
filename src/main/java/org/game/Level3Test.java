package org.game;
import characters.Enemy;
import characters.Wizard;
import items.*;

public class Level3Test {
    public static void main(String[] args) {
        // create a test wizard with a Patronus
        Wizard testWizard = new Wizard(100, "Test Wizard", House.GRYFFINDOR,
                new Wand(Core.DRAGON_HEARTSTRING, 10), Pet.OWL);
        testWizard.getInventory().addItem(new Patronus("Test Patronus", 100));

        // create a test level 3
        Level3 testLevel = new Level3();

        // play the level with the test wizard
        testLevel.playLevel(testWizard);

        // assert that the wizard's health points are greater than 0 after playing the level
        assert testWizard.getHealthPoints() > 0;

        // assert that the wizard's inventory contains the reward
        assert testWizard.getInventory().getItemByType(Reward.class) != null;
    }
}
