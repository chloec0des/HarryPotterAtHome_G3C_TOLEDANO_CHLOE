package org.game;

import characters.Wizard;
import items.Core;
import items.House;
import items.Pet;
import items.Wand;

public class Level1Test {

    public static void main(String[] args) {
        Level1Test test = new Level1Test();
        test.testPlayLevel();
    }

    public void testPlayLevel() {
        Wizard wizard = new Wizard(100, "Harry Potter", House.GRYFFINDOR, new Wand(Core.PHOENIX_FEATHER, 5), Pet.CAT);
        Level1 level = new Level1();
        level.playLevel(wizard);

        // Assertions
        assert wizard.getHealthPoints() == 75 : "Wizard should have lost 25 health points during the battle";
        assert wizard.getInventory().getSize() == 1 : "Wizard should have received one reward";
    }
    }
