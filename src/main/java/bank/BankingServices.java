package bank;

import bank.DTO.BankAccount;

import java.math.BigDecimal;

/**
 * Created by nissan on 5/27/15.
 */
public interface BankingServices {
    void deposit(Integer accountNumber, BigDecimal amount);
    void withdraw(int accountNUmber, BigDecimal amount);
    BigDecimal checkBalance(Integer accountNumber);
    void openAccount(BankAccount newAccount);
    void closeAccount(Integer accountNumber);
}
