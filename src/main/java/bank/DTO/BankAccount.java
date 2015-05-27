package bank.DTO;

import java.math.BigDecimal;

/**
 * Created by nissan on 5/27/15.
 */
public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountNumber;
    private BigDecimal accountBalance;

    public BankAccount(String firstName, String lastName, int accountNumber, BigDecimal accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public BankAccount() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
