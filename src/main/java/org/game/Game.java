package org.game;
import java.util.Scanner;
import characters.*;

import items .*;
public class Game {
    static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //clearing out the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //separator with length n
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //print a heading
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\n Enter anything to continue...");
    }


    public class Game {
        private Wizard player;

        public Game() {
        }

        public void init() {
            initWizard();
            // Initialize other game objects here
        }

        public void play() {
            // Implement the game logic and levels here
        }

        private void initWizard() {
            // Initialize the player's Wizard object
        }
    }
}