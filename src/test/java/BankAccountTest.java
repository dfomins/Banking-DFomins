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
    
}