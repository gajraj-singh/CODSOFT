import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int score = 0;
        int rounds = 0;

        while (true) {
            int numberToGuess = rand.nextInt(100) + 1;
            int numberOfTries = 0;
            boolean won = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have 6 attempts to guess it.");

            while (numberOfTries < 6) {
                System.out.print("Enter your guess: ");
                int guess = input.nextInt();
                numberOfTries++;

                if (guess > numberToGuess) {
                    System.out.println("Your guess is too high!");
                } else if (guess < numberToGuess) {
                    System.out.println("Your guess is too low!");
                } else {
                    System.out.println("You win!");
                    System.out.println("The number was " + numberToGuess);
                    System.out.println("It took you " + numberOfTries + " tries.");
                    won = true;
                    break;
                }
            }

            if (!won) {
                System.out.println("You didn't guess the number. It was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = input.next();

            if (response.equalsIgnoreCase("y")) {
                rounds++;
                if (won) {
                    score++;
                }
            } else {
                break;
            }
        }

        System.out.println("You played " + rounds + " rounds.");
        System.out.println("Your score is " + score);
    }
}