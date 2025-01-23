import java.util.Map;
import java.util.HashMap;

public class Client {

    private String name;
    private String surname;
    private String personalCode;
    public Map<Integer, BankAccount> bankAccounts = new HashMap<>();

    public Client(String name, String surname, String personalCode) {
        this.name = name;
        this.surname = surname;
        this.personalCode = personalCode;
    }

    public String getName() {
        return name;
    }

    public String getSurame() {
        return surname;
    }

    public void createBankAccount(int accountNumber, double amount) {
        bankAccounts.put(accountNumber, new BankAccount(accountNumber, amount));
    }

    public void getBankAccountInfo(int accountNumber) {
        bankAccounts.get(accountNumber).printBalance();
    }

}
