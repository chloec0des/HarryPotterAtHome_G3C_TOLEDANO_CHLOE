package org.game;
import java.util.Random;
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

    private Wizard wizard;

    public void init() {
        clearConsole();
        printSeparator(30);
        printHeading("Harry Potter at Home - by Chloé Toledano");
        initWizard();
        play(wizard);
        firstLevel(wizard);
        secondLevel(wizard);
        thirdLevel(wizard);
        fourthLevel(wizard);
        fifthLevel(wizard);
        sixthLevel(wizard);
        seventhLevel(wizard);
    }

    public void play(Wizard wizard) {
        int currentLevel = 1;
        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println("Level " + currentLevel);
            // Call the appropriate level method based on the currentLevel.
            switch (currentLevel) {
                case 1:
                    firstLevel(wizard);
                    break;
                case 2:
                    secondLevel(wizard);
                    break;
                case 3:
                    thirdLevel(wizard);
                    break;
                case 4:
                    fourthLevel(wizard);
                    break;
                case 5:
                    fifthLevel(wizard);
                    break;
                case 6:
                    sixthLevel(wizard);
                    break;
                case 7:
                    seventhLevel(wizard);
                    break;
                default:
                    System.out.println("Congratulations! You have completed all the levels!");
                    isPlaying = false;
                    break;
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
        String name =scanner.nextLine();
        House house = SortingHat.randomHouse();
        Core[] cores = Core.values();
        int randomCoreIndex = new Random().nextInt(cores.length);
        Core randomCore = cores[randomCoreIndex];
        int randomSize = new Random().nextInt(15) + 5;
        Wand wand = new Wand(randomCore, randomSize);
        Pet[] pets = Pet.values();
        int randomPetIndex = new Random().nextInt(pets.length);
        Pet randomPet = pets[randomPetIndex];
        this.wizard = new Wizard(100, name, house, wand, randomPet);
        System.out.println("Welcome, " + wizard.getName() + "! Let's begin your adventure.");
        anythingToContinue();
    }

    private void battle(Wizard wizard, Enemy enemy, Spell spell) {
        System.out.println("A wild " + enemy.getName() + " has appeared!");

        while (wizard.getHealthPoints() > 0 && enemy.getHealthPoints() > 0) {
            System.out.println("Your health: " + wizard.getHealthPoints() + " | Enemy health: " + enemy.getHealthPoints());
            System.out.println("Choose an action:");
            System.out.println("1. Attack with " + spell.getName());
            System.out.println("2. Use a healing potion");

            int choice = readInt("Enter your choice (1-2): ", 2);

            switch (choice) {
                case 1:
                    // Wizard attacks enemy
                    enemy.takeDamage(spell.getDamage());
                    System.out.println("You dealt " + spell.getDamage() + " damage to the " + enemy.getName() + ".");
                    break;
                case 2:
                    // Wizard uses a healing potion
                    int healingAmount = 50;
                    wizard.heal(healingAmount);
                    System.out.println("You healed for " + healingAmount + " health points.");
                    break;
            }

            // Check if the enemy is defeated
            if (enemy.getHealthPoints() <= 0) {
                System.out.println("You have defeated the " + enemy.getName() + "!");
                break;
            }

            // Enemy attacks the wizard
            wizard.takeDamage(enemy.getDamage());
            System.out.println("The " + enemy.getName() + " dealt " + enemy.getDamage() + " damage to you.");
        }
    }


    private void firstLevel(Wizard wizard) {
        // Level 1 logic
        Enemy enemy = new Enemy("Troll", 15, 50);
        Spell spell = new Spell("Wingardium Leviosa", 25, 90);
        battle(wizard, enemy, spell);
    }

    private void secondLevel(Wizard wizard) {
        // Chamber of secrets - Basilic
        Enemy enemy2 = new Enemy("Basilic", 20, 50);
        Spell spell = new Spell("Accio", 25, 90);
        battle(wizard, enemy2, spell);
    }

    private void thirdLevel(Wizard wizard) {
        // Lac dans la Forêt Interdite - Détraqueurs
        Enemy enemy = new Enemy("Dementor", 25, 60);
        Spell spell = new Spell("Expecto Patronum", 35, 85);
        Potion potion = new Potion(40);
        battle(wizard, enemy, spell);
    }

    private void fourthLevel(Wizard wizard) {
        // Cimetière de Little Hangleton - Voldemort et Peter Pettigrow
        Enemy enemy = new Enemy("Voldemort and Peter Pettigrow", 30, 80);
        Spell spell = new Spell("Expelliarmus", 40, 80);
        Potion potion = new Potion(40);
        battle(wizard, enemy, spell);
    }

    private void sixthLevel(Wizard wizard) {
        // Tour d'astronomie - Mangemorts
        Enemy enemy = new Enemy("Death Eaters", 35, 100);
        Spell spell = new Spell("Stupefy", 45, 75);
        Potion potion = new Potion(40);
        battle(wizard, enemy, spell);
    }

    private void seventhLevel(Wizard wizard) {
        // Poudlard - Voldemort et Bellatrix Lestrange
        Enemy enemy = new Enemy("Voldemort and Bellatrix Lestrange", 40, 120);
        Spell spell = new Spell("Expelliarmus", 50, 70);
        Potion potion = new Potion(40);
        battle(wizard, enemy, spell);
    }


    private void fifthLevel(Wizard wizard) {
        Enemy enemy = new Enemy("Dolores Umbridge", 40, 500);
        Spell spell = new Spell("SpellName", 50, 12);
        Potion potion = new Potion(40);
        choiceIncrease(wizard, spell);
        Potion chosenPotion = Potion.choosePotion();
        chosenPotion.use(wizard);
        System.out.println("\nIt's time for the Universal Certificate of Elementary Witchcraft In" + enemy.getUsername());
        universalCertificateOfElementaryWitchcraft(wizard, enemy);
        choiceAttackLevel5(enemy.getDamage(), wizard, enemy, spell);
        endingLevelFive(wizard, enemy, 5);
    }

    private void choiceIncrease(Wizard wizard, Spell spell) {
        System.out.println("Choose a spell attribute to increase:");
        System.out.println("1. Increase spell damage by 10");
        System.out.println("2. Increase spell accuracy by 5%");

        int choice = readInt("Enter your choice (1-2): ", 2);

        switch (choice) {
            case 1:
                spell.setDamage(spell.getDamage() + 10);
                System.out.println("Spell damage increased to " + spell.getDamage() + ".");
                break;
            case 2:
                int newAccuracy = Math.min(spell.getAccuracy() + 5, 100);
                spell.setAccuracy(newAccuracy);
                System.out.println("Spell accuracy increased to " + newAccuracy + "%.");
                break;
        }
    }

    private void choosePotion(Wizard wizard, Enemy enemy, Spell spell) {
        Potion potion = Potion.choosePotion();
        potion.use(wizard);
        System.out.println("You used a " + (potion.getHealAmount() == 25 ? "small" : "large") + " healing potion and regained " + potion.getHealAmount() + " HP. Your current HP is " + wizard.getHealthPoints() + ".");
    }

    private void universalCertificateOfElementaryWitchcraft(Wizard wizard, Enemy enemy) {
        // Implement universalCertificateOfElementaryWitchcraft logic
    }

    private void choiceAttackLevel5(int enemyDamage, Wizard wizard, Enemy enemy, Spell spell) {
        // Implement choiceAttackLevel5 logic
    }

    private void endingLevelFive(Wizard wizard, Enemy enemy, int levelId) {
        // Implement endingLevelFive logic
    }

    // Add other methods as needed
}