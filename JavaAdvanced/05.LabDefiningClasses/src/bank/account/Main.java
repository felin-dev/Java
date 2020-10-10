package bank.account;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] tasks = input.split("\\s+");
            String command = tasks[0];
            switch (command) {
                case "Create": {
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    bankAccount.print();

                    break;
                }

                case "Deposit": {
                    int id = Integer.parseInt(tasks[1]);

                    if (bankAccountExists(bankAccounts, id)) {
                        double amount = Double.parseDouble(tasks[2]);
                        bankAccounts.get(id).deposit(amount);
                        DecimalFormat df = new DecimalFormat("#######.##");
                        System.out.printf("Deposited %s to ID%d%n", df.format(amount), id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                }
                case "SetInterest": {
                    double interest = Double.parseDouble(tasks[1]);
                    BankAccount.setInterestRate(interest);

                    break;
                }
                case "GetInterest": {
                    int id = Integer.parseInt(tasks[1]);

                    if (bankAccountExists(bankAccounts, id)) {
                        int years = Integer.parseInt(tasks[2]);
                        System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
                }
                default:
                    throw new IllegalArgumentException("Invalid input!");
            }

            input = sc.nextLine();
        }
    }

    private static boolean bankAccountExists(Map<Integer, BankAccount> bankAccounts, int id) {
        return bankAccounts.containsKey(id);
    }
}