package org.game;

import characters.Wizard;
import items.*;

import java.util.Random;
import java.util.Scanner;

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
        System.out.println("\nPress any key to continue...");
        scanner.nextLine();
    }

    public static Wizard wizard;

    public void init() {
        clearConsole();
        printSeparator(30);
        printHeading("Harry Potter at Home - by Chloé Toledano");
        initWizard();
        play(wizard);
    }

    public void play(Wizard wizard) {
        int currentLevel = 1;
        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println("Level " + currentLevel);
            // Call the appropriate level method based on the currentLevel.
            switch (currentLevel) {
                case 1 -> {
                    Level1 level1 = new Level1();
                    level1.playLevel(wizard);
                }
                case 2 -> {
                    Level2 level2 = new Level2();
                    level2.playLevel(wizard);
                }
                case 3 -> {
                    Level3 level3 = new Level3();
                    level3.playLevel(wizard);
                }
                case 4 -> {
                    Level4 level4 = new Level4();
                    level4.playLevel(wizard);
                }
                case 5 -> {
                    Level5 level5 = new Level5();
                    level5.playLevel(wizard);
                }
                case 6 -> {
                    Level6 level6 = new Level6();
                    level6.playLevel(wizard);
                }
                case 7 -> {
                    Level7 level7 = new Level7();
                    level7.playLevel(wizard);
                }
                default -> {
                    System.out.println("Congratulations! You have completed all the levels!");
                    isPlaying = false;
                }
            }

            // Check if the wizard is still alive.
            if (wizard.getHealthPoints() <= 0) {
                System.out.println("Game Over! Your wizard has died.");
                isPlaying = false;
            } else {
                currentLevel++;
            }
        }
    }

    private void initWizard() {

        // Initialize the wizard with default values
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        anythingToContinue();

        // Let the user know that their house, wand, and pet will be chosen for them
        System.out.println("Initializing wizard... Your house, wand will now be chosen for you. You can chose your pet!");
        House house = SortingHat.randomHouse();
        System.out.println("The Sorting Hat has placed you in " + house + " house!");
        anythingToContinue();

        Core[] cores = Core.values();
        int randomCoreIndex = new Random().nextInt(cores.length);
        Core randomCore = cores[randomCoreIndex];
        int randomSize = new Random().nextInt(15) + 5;
        Wand wand = new Wand(randomCore, randomSize);
        System.out.println("You have received a " + randomSize + " inch wand with a " + randomCore + " core.");
        anythingToContinue();

        System.out.println("Choose your pet:");
        Pet[] pets = Pet.values();
        for (int i = 0; i < pets.length; i++) {
            System.out.println((i + 1) + ". " + pets[i]);
        }
        int petChoice = readInt("Enter the number corresponding to your desired pet (1-" + pets.length + "): ", pets.length);
        Pet chosenPet = pets[petChoice - 1];
        System.out.println("You have chosen a " + chosenPet + " as your pet.");
        anythingToContinue();

        wizard = new Wizard(100, name, house, wand, chosenPet);
        System.out.println("Welcome, " + wizard.getName() + "! Let's begin your adventure.");
        anythingToContinue();
    }
    public static String readString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }


}