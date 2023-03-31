package org.game;

import java.io.ByteArrayInputStream;

public class GameTest {
    public static void main(String[] args) {
        // Test the readInt method
        int userChoices = 3;
        String prompt = "Enter a number between 1 and " + userChoices + ": ";
        int input = 2; // the user enters 2
        ByteArrayInputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);
        int result = Game.readInt(prompt, userChoices);
        if (result != input) {
            System.out.println("readInt test failed!");
        }

        // Test the init method
        Game game = new Game();
        game.init();
        // Check if wizard is initialized
        if (game.wizard == null) {
            System.out.println("initWizard test failed!");
        }
        // Check if the wizard has a valid house, wand, and pet
        if (game.wizard.getHouse() == null || game.wizard.getWand() == null || game.wizard.getPet() == null) {
            System.out.println("initWizard test failed!");
        }
    }
}
