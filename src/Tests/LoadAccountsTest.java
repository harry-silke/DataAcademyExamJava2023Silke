package Tests;

import ATM.ATM;
import org.junit.Test;
import ATM.User;
import ATM.Account;
import ATM.AccountType;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LoadAccountsTest {


    @Test
    public void testLoadAccounts() {
        ATM atm = new ATM();
        atm.users = new HashMap<>();
        User user1 = new User("Marie", "Antoinette", "040202040", 1);
        User user2 = new User("Mary", "Poppins", "0412345774", 2);
        User user3 = new User("Mary", "Queen Of Scots", "0412345774", 3);
        atm.users.put(1, user1);
        atm.users.put(2, user2);
        atm.users.put(3, user3);


        String fileName = "Data/TestData/OpeningAccountsDataTest.txt";
        boolean result = atm.loadAccounts(fileName);
        assertTrue(result);



        // Check if the correct number of accounts have been loaded
        assertEquals(atm.getNumberOfAccounts(), 5);


        // Check if a specific account has been loaded correctly
        Account checkingAccount = user1.getCheckingAccount();
        assertNotNull(checkingAccount);
        assertEquals(checkingAccount.getAccountNumber(), "345654");
        assertEquals(checkingAccount.getAccountType(), AccountType.CHEQUE);
        assertEquals(checkingAccount.getBalance(), 1000.0, 0.01);

        // Check if another specific account has been loaded correctly
        Account savingAccount2 = user2.getSavingsAccount();
        assertNotNull(savingAccount2);
        assertEquals(savingAccount2.getAccountNumber(), "987654");
        assertEquals(savingAccount2.getAccountType(), AccountType.SAVING);
        assertEquals(savingAccount2.getBalance(), 13456.0, 0.01);
    }
}
