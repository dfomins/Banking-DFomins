public class BankAccount {

    public int accountNumber;
    private double balance;

    // Empty constructor
    public BankAccount() {}

    // Constructor with one parameter
    public BankAccount(int cardNumber, double balance) {
        this.accountNumber = cardNumber;
        this.balance = balance;
    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public double withdraw(double amount) {
        if (balance >= amount) {
            return balance -= amount;
        }
        System.out.println("Not enough money!");
        return balance;
    }

    public void printBalance() {
        System.out.println("Your balance: " + balance);
    }

    public double getBalance() { return balance; }

    public void transfer(BankAccount to, double amount) {
        if (balance >= amount) {
            balance -= amount;
            to.balance += amount;
        } else {
            System.out.println("Not enough money to transfer!");
        }
    }

}
