import java.util.ArrayList;

public class Client {

    private String name;
    private String surname;
    public ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public Client(String name, String surname, String personalCode) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurame() {
        return surname;
    }

    public void createBankAccount(int accountNumber, double amount) {
        bankAccounts.add(new BankAccount(accountNumber, amount));
    }

    public void getListOfBankAccounts() {
        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println(i + ") " + bankAccounts.get(i).accountNumber);
        }
    }

}
