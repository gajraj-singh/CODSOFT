import java.util.Scanner;

public class ATMInterface {
    private double balance = 1000.0; // initial balance
    private int pin = 1234; // default PIN

    public void startATM() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to CodSoft ATM!");
        System.out.print("Enter your PIN: ");
        int userPin = scanner.nextInt();

        if (userPin == pin) {
            System.out.println("PIN is correct. Please choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash(scanner);
                    break;
                case 3:
                    depositCash(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using CodSoft ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } else {
            System.out.println("Invalid PIN. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private void withdrawCash(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        }
    }

    private void depositCash(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        atm.startATM();
    }
}