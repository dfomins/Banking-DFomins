public class BankAccount {

    private double balance;

    // Empty constructor
    public BankAccount() {}

    // Constructor with one parameter
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public void printBalance() {
        System.out.println("Your balance: " + balance);
    }

    public void transfer(BankAccount to, double amount) {
        if (balance >= amount) {
            balance -= amount;
            to.balance += amount;
        } else {
            System.out.println("Not enough money to transfer!");
        }
    }

}
