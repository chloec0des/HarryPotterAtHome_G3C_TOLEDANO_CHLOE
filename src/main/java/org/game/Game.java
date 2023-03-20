package org.game;
import java.util.Scanner;
import characters.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt, int userChoices){
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                input = -1;
                System.out.println("Please enter an integer!");
            }}while (input<1 || input > userChoices);
        return input;
        }
    //clearing out the console
    public static void clearConsole(){
        for (int i=0; i<100; i++)
            System.out.println();
    }
    //separator with length n
    public static void printSeparator(int n){
    for (int i=0; i<n; i++)
        System.out.print("-");
        System.out.println();
    }
        //print a heading
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    public static void anythingToContinue(){
    System.out.println("\n Enter anything to continue...");
    }


            { // Start the game
                int currentLevel = 1;
                while (currentLevel <= 7) {
                    Level level = levelFactory.createLevel(currentLevel, player);
                    level.play();
                    currentLevel++;
                }

                // Game over
                System.out.println("Congratulations, " + playerName + "! You have completed all levels of the game.");
            }
        }
    private void initGame(Wizard wizard){
        // Initialize game objects
        Wizard player = new Wizard();
        SortingHat sortingHat = new SortingHat();
        LevelFactory levelFactory = new LevelFactory();

        // Prompt player to enter their name
        System.out.print("Welcome to Hogwarts! Please enter your name: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);

        // Sort the player into a house
        House house = sortingHat.sort(player);
        player.setHouse(house);
        System.out.println("Congratulations, " + playerName + "! You have been sorted into " + house + " house.");

    }
    private void levelone(Wizard wizard){
        Enemy enemy1 = new Enemy("Troll", 20,150);

    }
}
