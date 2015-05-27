package bank;

import bank.DTO.BankAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by nissan on 5/27/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class KioskTest {

    public static final String CUSTOMER_1_FIRST_NAME = "Steve";
    public static final String CUSTOMER_1_LAST_NAME = "Jobbs";
    public static final int CUSTOMER_1_ACC_NUMBER = 123;
    public static final BigDecimal CUSTOMER_1_INITIAL_BALANCE = new BigDecimal(50.00);
    public static final BigDecimal CUSTOMER_1_DEPOSIT_AMOUNT = new BigDecimal(20.00);
    public static final int NON_EXISTENT_BANK_ACCOUNT_NO = 4545543;
    public static final BigDecimal CUSTOMER_1_WITHDRAWAL = new BigDecimal(30.00);
    private Kiosk kiosk;

    @Before
    public void setup(){
        kiosk = new Kiosk();
    }

    /**
     * Deposit related tests
     */

    /**
     * Deposit £20 into account with £50. Assert new total is £70
     */
    @Test
    public void testDepositIntoExistingBankAccount(){
        BankAccount steveBankAccount = createBankAccount();
        kiosk.openAccount(steveBankAccount);
        kiosk.deposit(CUSTOMER_1_ACC_NUMBER, CUSTOMER_1_DEPOSIT_AMOUNT);

        BigDecimal newBalance = kiosk.checkBalance(CUSTOMER_1_ACC_NUMBER);
        BigDecimal expectedNewBalance = CUSTOMER_1_INITIAL_BALANCE.add(CUSTOMER_1_DEPOSIT_AMOUNT);
        assertEquals(expectedNewBalance, newBalance);
    }

    /**
     *
     */
    @Test(expected = ResourceNotFoundException.class)
    public void testDepositIntoNonExistingBankAccount() {
        kiosk.deposit(NON_EXISTENT_BANK_ACCOUNT_NO, CUSTOMER_1_DEPOSIT_AMOUNT);
    }

    /**
     * Withdraw related tests
     */
    @Test
    public void testWithdrawFromExistingBankAccount(){
        BankAccount steveBankAccount = createBankAccount();
        kiosk.openAccount(steveBankAccount);
        kiosk.withdraw(CUSTOMER_1_ACC_NUMBER, CUSTOMER_1_WITHDRAWAL);

        BigDecimal newBalance = kiosk.checkBalance(CUSTOMER_1_ACC_NUMBER);
        BigDecimal expectedNewBalance = CUSTOMER_1_INITIAL_BALANCE.subtract(CUSTOMER_1_WITHDRAWAL);
        assertEquals(expectedNewBalance, newBalance);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testWithdrawFromNonExistingBankAccount() {
        kiosk.withdraw(NON_EXISTENT_BANK_ACCOUNT_NO, CUSTOMER_1_WITHDRAWAL);
    }

    @Test
    public void testWithdrawFromNonExistingBankAccountExceedsFundsAvailable() {

    }

    /**
     * Check balance related tests
     */
    @Test
    public void testCheckBalanceFromExistingAccount(){

    }

    @Test
    public void testCheckBalanceFromNonExistingAccount(){

    }

    /**
     * Test Helpers
     */
    public BankAccount createBankAccount(){
        return new BankAccount(CUSTOMER_1_FIRST_NAME, CUSTOMER_1_LAST_NAME, CUSTOMER_1_ACC_NUMBER, CUSTOMER_1_INITIAL_BALANCE);
    }
}
