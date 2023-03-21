package items;
import characters.*;
import java.util.Random;

public class SortingHat {
    public static House randomHouse() {
        House[] houses = House.values();
        int randomIndex = new Random().nextInt(houses.length);
        House chosenHouse = houses[randomIndex];
        System.out.println("The Sorting Hat is choosing your house...");
        System.out.println("Hmm, interesting. Very interesting.");
        System.out.println("I think I know just the place for you!");
        System.out.println("Congratulations, " + "you are now a member of " + chosenHouse.getName() + "!");
        return chosenHouse;
    }
}

