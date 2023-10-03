package atm_simulator;

/**
 * Demo
 */
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();

        // Generate a 10-digit random number
        long randomNumber = (random.nextLong() % 1000000L) + 10000L;
        if (randomNumber < 0) {
            // Ensure the number is positive and has 10 digits
            randomNumber = -randomNumber;
        }

        // Print the generated number
        System.out.println("Generated 10-digit random number: " + String.format("%010d", randomNumber));
        // System.out.println(randomNumber);
    }
}
