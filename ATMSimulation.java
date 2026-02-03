import java.util.Scanner;

class ATM {

    private int[] userIds = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110 , 2102};
    private int[] pins = {1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999, 0000 , 1212};
    private double[] balances = {5000, 10000, 7500, 12000, 3000, 15000, 2000, 8000, 6000, 4000, 25000};

    private int currentUserIndex = -1;

    void start() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int enteredId = sc.nextInt();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        for (int i = 0; i < userIds.length; i++) {
            if (userIds[i] == enteredId && pins[i] == enteredPin) {
                currentUserIndex = i;
                break;
            }
        }

        if (currentUserIndex == -1) {
            System.out.println("Invalid User ID or PIN");
            return;
        }

        int choice;
        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: Rs." + balances[currentUserIndex]);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balances[currentUserIndex] += deposit;
                        System.out.println("Updated Balance: Rs." + balances[currentUserIndex]);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw > 0 && withdraw <= balances[currentUserIndex]) {
                        balances[currentUserIndex] -= withdraw;
                        System.out.println("Updated Balance: Rs." + balances[currentUserIndex]);
                    } else {
                        System.out.println("Insufficient balance");
                    }
                    break;

                case 4:
                    System.out.println("Exit Successful");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        new ATM().start();
    }
}
