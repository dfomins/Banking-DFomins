import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Client> clients = new ArrayList<>(2);
        clients.add(new Client("Janis", "Petrovs", "201100-53412"));
        clients.add(new Client("Youriy", "Koudrin", "123456-12345"));

        System.out.println("Users list:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(i + ") " + clients.get(i).getName() + " " + clients.get(i).getSurame());
        }

        System.out.println();
        System.out.print("Select an user: ");
        int selectedClientIndex = sc.nextInt();
        System.out.println();

        if (selectedClientIndex >= 0 && selectedClientIndex < clients.size()) {

            boolean exit = false;
            do {

                Client selectedClient = clients.get(selectedClientIndex);
                System.out.println("Select an option:");
                System.out.println("1) Create an account");

                if (selectedClient.bankAccounts.size() > 0) {
                    System.out.println("2) List of my accounts");
                    System.out.println("3) Select an account to work with");
                }

                System.out.println("0) Exit");

                System.out.println();

                System.out.print("Option: ");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter new account number: ");
                        int accountNumber = sc.nextInt();
                        System.out.print("Money amount: ");
                        double amount = sc.nextDouble();

                        selectedClient.createBankAccount(accountNumber, amount);

                        System.out.println();
                        break;

                    case 2:
                        selectedClient.getListOfBankAccounts();
                        System.out.println();
                        break;

                    case 3:
                        for (int i = 0; i < selectedClient.bankAccounts.size(); i++) {
                            System.out.println(i + ") " + selectedClient.bankAccounts.get(i).accountNumber);
                        }
                        System.out.print("\nSelect: ");
                        int selectedAccountIndex = sc.nextInt();
                        System.out.println();

                        if (selectedAccountIndex >= 0 && selectedAccountIndex < selectedClient.bankAccounts.size()) {

                            BankAccount selectedAccount = selectedClient.bankAccounts.get(selectedAccountIndex);
                            do {
                                System.out.println("1) Print balance");
                                System.out.println("2) Deposit");
                                System.out.println("3) Withdraw");
                                System.out.println("4) Transfer");
                                System.out.println("0) Exit\n");
                                System.out.print("Option: ");
                                option = sc.nextInt();

                                switch (option) {
                                    case 1:
                                        selectedAccount.printBalance();
                                        System.out.println();
                                        break;

                                    case 2:
                                        System.out.print("Enter amount you want to deposit: ");
                                        amount = sc.nextDouble();
                                        selectedAccount.deposit(amount);
                                        System.out.println();
                                        break;

                                    case 3:
                                        System.out.print("Enter amount you want to withdraw: ");
                                        amount = sc.nextDouble();
                                        selectedAccount.withdraw(amount);
                                        break;

                                    case 4:
                                        System.out.println("\nSelect account to which you want to transfer:\n");
                                        selectedClient.getListOfBankAccounts();
                                        System.out.print("\nOption: ");
                                        int accountToTransferIndex = sc.nextInt();

                                        System.out.print("Enter amount you want to transfer: ");
                                        amount = sc.nextDouble();

                                        if (accountToTransferIndex >= 0 && accountToTransferIndex < selectedClient.bankAccounts.size()) {

                                            BankAccount accountToTransfer = selectedClient.bankAccounts.get(accountToTransferIndex);
                                            selectedAccount.transfer(accountToTransfer, amount);

                                        } else {

                                            System.out.println("Incorrect account index!");

                                        }
                                        break;

                                    case 0:
                                        exit = true; break;

                                }

                            } while (!exit);

                        } else {
                            System.out.println("Incorrect account index!");
                        }

                        exit = false;
                        break;

                    case 0:
                        exit = true;break;
                }

            } while (!exit);

        } else {
            System.out.println("Client does not exist!");
        }
    }
}