
/**
* This program is for a microwave calculator that 
* calculates the time needed to heat 3 types of food
* (food: sub, pizza, soup) the time is already set 
* (time: sub = 60 seconds, pizza = 45 seconds, soup = 105 seconds)
* the program asks the user for the item, and then the quantity of it.
* if its 2 items the time is increaded by 50% and if its 3 items the time is increased by 100%
* it will then display the total time needed to heat the food in seconds and minutes.
* @author  MF-ROB
* @version 1.0
* @since   2026-22-09
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class microwave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner declaration

        // User inputs
        System.out.print("This program is to calculate the microwave time");
        System.out.println();
        System.out.print("Options: sub (1) = 60 seconds, pizza (2) = 45 seconds, soup (3) = 105 seconds");
        System.out.println();
        System.out.print("Please enter the item you want to reheat:  ");

        try {
            // variable declarations
            int heating = sc.nextInt();
            int baseTime = 0;
            String itemName = ""; // this is for when the user selects an item

            // User selected item
            if (heating == 1) {
                baseTime = 60;
                itemName = "sub";
            } else if (heating == 2) {
                baseTime = 45;
                itemName = "pizza";
            } else if (heating == 3) {
                baseTime = 105;
                itemName = "soup";
            } else {
                // error code for unexpected input one
                System.out.println("Error: Please enter 1, 2, or 3.");
                sc.close();
                return;
            }

            // Item amount delcaration
            System.out.print("Please enter how many items you wanna reheat:  ");
            int amount = sc.nextInt();

            // the amount of items user wants to reheat
            double totalSeconds;
            if (amount == 1) {
                totalSeconds = baseTime;
            } else if (amount == 2) {
                totalSeconds = baseTime * 1.5;
            } else if (amount == 3) {
                totalSeconds = baseTime * 2.0;
            } else {
                System.out.println("Error: Quantity must be 1, 2, or 3.");
                sc.close();
                return;
            }

            // calculations for the microwave
            long roundedSeconds = Math.round(totalSeconds);
            long minutes = roundedSeconds / 60;
            long seconds = roundedSeconds % 60;

            // Displaying the result for it
            System.out.println();
            System.out.println("Item: " + itemName + " x" + amount);
            System.out.println("Total time: " + roundedSeconds + " seconds (" + minutes + " min " + seconds + " sec)");

        } catch (InputMismatchException e) { // if user inputs letters
            // catch block to handle non-numeric input
            System.out.println("Error: Please enter a valid numeric value.");
        } finally {
            // closes the scanner
            sc.close();
        }
    }
}