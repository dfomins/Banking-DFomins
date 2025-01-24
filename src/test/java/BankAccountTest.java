import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @ParameterizedTest
    @DisplayName("Check if balance is correct after deposit")
    @CsvSource({
            "2362,62.63,938.68",
            "3893,805.39,639.28",
            "7172,542.54,102.31",
            "8348,875.4,904.9",
            "3330,951.58,54.6",
            "3900,652.92,535.98",
            "4474,59.18,826.04",
            "9652,548.76,250.79",
            "6795,115.62,337.6",
            "4508,467.33,77.42",
            "2130,351.27,633.35",
            "7618,794.2,308.21",
            "2982,876.88,865.47",
            "5970,542.18,490.71",
            "3074,439.27,577.0",
            "7906,43.07,26.33",
            "7140,937.78,140.97",
            "1307,802.92,742.33",
            "2771,896.47,967.72",
            "7097,319.31,941.87"
    })

    void deposit(int accountNumber, double initialBalance, double amount) {
        BankAccount testAccount = new BankAccount(accountNumber, initialBalance);
        assertEquals(initialBalance + amount, testAccount.deposit(amount));
    }

    @ParameterizedTest
    @DisplayName("Check if balance is correct after withdraw")
    @CsvSource({
            "2362,62.63,938.68",
            "3893,805.39,639.28",
            "7172,542.54,102.31",
            "8348,875.4,904.9",
            "3330,951.58,54.6",
            "3900,652.92,535.98",
            "4474,59.18,826.04",
            "9652,548.76,250.79",
            "6795,115.62,337.6",
            "4508,467.33,77.42",
            "2130,351.27,633.35",
            "7618,794.2,308.21",
            "2982,876.88,865.47",
            "5970,542.18,490.71",
            "3074,439.27,577.0",
            "7906,43.07,26.33",
            "7140,937.78,140.97",
            "1307,802.92,742.33",
            "2771,896.47,967.72",
            "7097,319.31,941.87"
    })

    void withdraw(int accountNumber, double initialBalance, double amount) {
        BankAccount testAccount = new BankAccount(accountNumber, initialBalance);
        Object expected = (initialBalance - amount > 0)
            ? initialBalance - amount
            : initialBalance;

        assertEquals(expected, testAccount.withdraw(amount));
    }

    @ParameterizedTest
    @DisplayName("Check if balance is correct after withdraw")
    @CsvSource({
            "2362,4563,62.63,45.22,98.68",
            "3893,1767,805.39,56,69.28",
            "7172,6849,542.54,67.22,10.31",
            "8348,6932,875.4,10.22,90.9",
            "3330,7849,951.58,67.21,54.6"
    })

    void transfer(int fromAccountNumber, int toAccountNumber, double initialBalanceFrom, double initialBalanceTo, double amount) {

        // The account from which we're transferring the money
        BankAccount from = new BankAccount(fromAccountNumber, initialBalanceFrom);

        // Account which receives money
        BankAccount to = new BankAccount(toAccountNumber, initialBalanceTo);

        // Expected value that transferring account gets
        Object expectedTo = (initialBalanceFrom - amount > 0)
                ? initialBalanceFrom - amount
                : initialBalanceFrom;

        // Expected value that receiving account gets
        // If transferring account has not enough money, then receiving accounts balance stays the same
        Object expectedFrom = (initialBalanceFrom - amount > 0)
                ? initialBalanceTo + amount
                : initialBalanceTo;

        assertAll(() -> assertEquals(expectedTo, from.transfer(to, amount)),
                () -> assertEquals(expectedFrom, to.getBalance()));
    }
}