package Tests;

import ATM.Account;
import ATM.AccountType;
import ATM.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateTests {
    @Test
    public void testLoadAccounts(){

        User user1 = new User("Harry", "Ocean", "1234543", 1);
        User user2 = new User("Kangaroo", "Basket", "3456543", 2);
        User user3 = new User("Pillow", "Couch", "5456543", 3);

        //create new accounts
        Account savingAccount = user1.createAccount(AccountType.SAVING, 100, 1, "2345");
        Account checkingAccount = user2.createAccount(AccountType.CHEQUE, 112233, 2, "23456");
        Account savingAccount2 = user3.createAccount(AccountType.SAVING, 12, 3, "12345245");

        System.out.println(savingAccount.getId());
        //assert the account details
        assertNotNull(savingAccount);
        assertEquals(100, savingAccount.getBalance(), 0.1);
        assertEquals(1, savingAccount.getId());
        assertEquals("2345", savingAccount.getAccountNumber());
        assertEquals(AccountType.SAVING, savingAccount.getAccountType());

        assertNotNull(checkingAccount);
        assertEquals(112233, checkingAccount.getBalance(), 0.1);
        assertEquals(2, checkingAccount.getId());
        assertEquals("23456", checkingAccount.getAccountNumber());
        assertEquals(AccountType.CHEQUE, checkingAccount.getAccountType());

        assertNotNull(savingAccount2);
        assertEquals(12, savingAccount2.getBalance(), 0.1);
        assertEquals(3, savingAccount2.getId());
        assertEquals("12345245", savingAccount2.getAccountNumber());
        assertEquals(AccountType.SAVING, savingAccount2.getAccountType());
    }


    public void testLoadUsers() {
        User user1 = new User("Whale", "Painting", "8765876", 1);
        User user2 = new User("Fireplace", "Basket", "3456543", 2);
        User user3 = new User("Penguin", "Pillow", "5456543", 3);


        assertNotNull(user1);
        assertEquals("Whale", user1.getFirstname());
        assertEquals("Painting", user1.getLastname());
        assertEquals("8765876", user1.getMobileNumber());
        assertEquals(1, user1.getID());

         assertNotNull(user2);
        assertEquals("Fireplace", user2.getFirstname());
        assertEquals("Basket", user2.getLastname());
        assertEquals("3456543", user1.getMobileNumber());
        assertEquals(2, user1.getID());

        assertNotNull(user3);
        assertEquals("Penguin", user2.getFirstname());
        assertEquals("Pillow", user2.getLastname());
        assertEquals("5456543", user1.getMobileNumber());
        assertEquals(3, user1.getID());

    }


}
