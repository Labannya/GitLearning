package bank;

import bank.DTO.BankAccount;

import java.math.BigDecimal;

/**
 * Created by nissan on 5/27/15.
 */
public class Kiosk implements BankingServices {


    public void deposit(Integer accountNumber, BigDecimal amount) {
        // if account number does not exist, throw a ResourceNotFoundException
    }

    public void withdraw(int accountNumber, BigDecimal amount) {

    }

    public BigDecimal checkBalance(Integer accountNumber) {
        return null;
    }

    public void openAccount(BankAccount newAccount) {

    }

    public void closeAccount(Integer accountNumber) {

    }
}
