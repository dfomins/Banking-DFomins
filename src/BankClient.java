public class BankClient {

    public static void main(String[] args) {

        BankAccount swed = new BankAccount(153.23);
        BankAccount seb = new BankAccount(34.11);

        swed.printBalance();
        swed.transfer(seb, 31);
        swed.printBalance();

    }

}
