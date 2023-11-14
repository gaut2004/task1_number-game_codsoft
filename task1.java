
import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int numberOfRounds = 0;
        int totalWins = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxAttempts + " attempts per round.");
        System.out.println("Let's begin!");

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (numberOfRounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalWins++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber);
            }

            numberOfRounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAnotherRound = scanner.next().toLowerCase();
            if (!playAnotherRound.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + numberOfRounds);
        System.out.println("Total wins: " + totalWins);

        scanner.close();
    }
}
