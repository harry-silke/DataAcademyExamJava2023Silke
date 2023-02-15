package Tests;

import ATM.Account;
import ATM.AccountType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AccountTest {
    @Test
    public void testSavingAccounts() {
        Account account = new Account(100, 0, "766", AccountType.SAVING);
        assertTrue(account.getBalance() == 100);
        assertTrue(account.getAccountNumber().equals("766"));
        assertTrue(account.getId() == 0);


        Account account1 = new Account(11100, 1, "12345", AccountType.SAVING);
        assertTrue(account1.getBalance() == 11100);
        assertTrue(account1.getAccountNumber().equals("12345"));
        assertTrue(account1.getId() == 1);

        Account account2 = new Account(0, 2, "56789", AccountType.SAVING);
        assertTrue(account2.getBalance() == 0);
        assertTrue(account2.getAccountNumber().equals("56789"));
        assertTrue(account2.getId() == 2);

        Account account3 = new Account(-100, 3, "09876", AccountType.SAVING);
        assertTrue(account3.getBalance() == -100);
        assertTrue(account3.getAccountNumber().equals("09876"));
        assertTrue(account3.getId() == 3);

        Account account4 = new Account(10000, 4, "76543", AccountType.SAVING);
        assertTrue(account4.getBalance() == 10000);
        assertTrue(account4.getAccountNumber().equals("76543"));
        assertTrue(account4.getId() == 4);
    }
    public void testNegativeBalanceSavings() {
        Account account6 = new Account(-10000, 6, "67890", AccountType.SAVING);
        assertTrue(account6.getBalance() == -10000);
        assertTrue(account6.getAccountNumber().equals("67890"));
        assertTrue(account6.getId() == 6);
    }

    public void testAccountTypeChecking() {
        Account account7 = new Account(3000, 7, "78901", AccountType.CHEQUE);
        assertTrue(account7.getBalance() == 3000);
        assertTrue(account7.getAccountNumber().equals("78901"));
        assertTrue(account7.getId() == 7);
        assertTrue(account7.getAccountType().equals(AccountType.CHEQUE));
    }
    public void testAccountTypeSaving() {
        Account account7 = new Account(2000, 12, "23456543", AccountType.SAVING);
        assertTrue(account7.getBalance() == 2000);
        assertTrue(account7.getAccountNumber().equals("23456543"));
        assertTrue(account7.getId() == 12);
        assertTrue(account7.getAccountType().equals(AccountType.SAVING));
    }

    @Test
    public void testCheckingAccount() {
        Account account = new Account(100, 2, "765434567", AccountType.CHEQUE);
        assertTrue(account.getBalance() == 100);
        assertTrue(account.getAccountNumber().equals("765434567"));
        assertTrue(account.getId() == 2);


        Account account1 = new Account(11100, 3, "545654323", AccountType.CHEQUE);
        assertTrue(account1.getAccountNumber().equals("545654323"));
        assertTrue(account1.getBalance() == 11100);
        assertTrue(account1.getId() == 3);


        Account account2 = new Account(200, 4, "8989", AccountType.CHEQUE);
        assertTrue(account2.getBalance() == 200);
        assertTrue(account2.getAccountNumber().equals("8989"));
        assertTrue(account2.getId() == 4);

        Account account3 = new Account(500, 5, "1234", AccountType.CHEQUE);
        assertTrue(account3.getBalance() == 500);
        assertTrue(account3.getAccountNumber().equals("1234"));
        assertTrue(account3.getId() == 5);
    }
// ahhhh testing
}
