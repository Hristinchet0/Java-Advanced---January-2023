package P03BankAccount;

public class BankAccount {
    /* Create class BankAccount.
    The class should have private fields for:
    •	Id: int (Starts from 1 and increments for every new account)
    •	Balance: double
    •	Interest rate: double (Shared for all accounts. Default value: 0.02)
    The class should also have public methods for:
    •	setInterestRate(double interest): void (static)
    •	getInterest(int Years): double
    •	deposit(double amount): void
    */
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    private static int accountsCount = 0;
    private int id;
    private double balance;

    public BankAccount() {
        accountsCount++;

        this.id = accountsCount;
        this.balance = 0;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public int getId() {
        return this.id;
    }
}
