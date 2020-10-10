package bank.account;

public class BankAccount {
    private static int currentId = 0;
    private final static double DEFAULT_INTEREST = 0.02;

    private final int id;
    private double balance;
    private static double interestRate;

    public BankAccount() {
        this.id = ++currentId;
        interestRate = DEFAULT_INTEREST;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public int getId() {
        return id;
    }

    public double getInterest(int years) {
        return this.balance * years * interestRate;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("Account ID%d created", this.id);
    }
}