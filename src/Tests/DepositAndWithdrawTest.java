package Tests;

import ATM.Account;
import ATM.AccountType;
import org.junit.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class DepositAndWithdrawTest {


        // Test deposit function
        @Test
        public void testDeposit() {
            Account account = new Account(1500, 5, "53565", AccountType.SAVING);
            double depositAmount = 500;
            double expectedBalance = 2000;
            double actualBalance = account.deposit(depositAmount);
            assertEquals(expectedBalance, actualBalance, 0);
        }

        // Test withdraw function with invalid input (insufficient funds)
        @Test
        public void testWithdrawInvalidInputErrorMessage() {
            Account account = new Account(1000, 1, "1234", AccountType.SAVING);
            double withdrawAmount = 1500;
            double expectedBalance = 1000;
            double actualBalance = account.withdraw(withdrawAmount);
            assertEquals(expectedBalance, actualBalance, 0);
            String outContent = ("Error - Wrong Input. Amount entered ($1500.0) is greater than the amount in account ($1000.0)");
            assertEquals("Error - Wrong Input. Amount entered ($" + withdrawAmount + ") is greater than the amount in account ($" + account.getBalance() + ")", outContent.toString().trim());
        }




        // Test withdraw function with valid input
        @Test
        public void testWithdrawValidInput() {
            Account account = new Account(500, 3, "87658432", AccountType.CHEQUE);
            double withdrawAmount = 500;
            double expectedBalance = 0;
            double actualBalance = account.withdraw(withdrawAmount);
            assertEquals(expectedBalance, actualBalance, 0);
        }

        // Test withdraw function with invalid input (insufficient funds)
        @Test
        public void testWithdrawInvalidInput() {
            Account account = new Account(1000, 2, "1234567", AccountType.CHEQUE);
            double withdrawAmount = 1500;
            double expectedBalance = 1000;
            double actualBalance = account.withdraw(withdrawAmount);
            assertEquals(expectedBalance, actualBalance, 0);
        }



    @Test
    public void testCheckBalance() {
        Account account = new Account(100, 1, "87654", AccountType.CHEQUE);
        String outContent = ("This is your account balance: $100.0");
//        System.setOut(new PrintStream(outContent));
        account.checkBalance();
        assertEquals("This is your account balance: $100.0", outContent.toString().trim());
//        System.setOut(originalOut);
    }

    @Test
    public void testHandleWithdrawCheckingValidAmount() {
        Account account = new Account(100, 2, "7654567", AccountType.CHEQUE);
        double withdrawAmount = 50;
        double expectedBalance = 50;
        double actualBalance = account.withdraw(withdrawAmount);
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void testHandleWithdrawCheckingOverdraftLimit() {
        Account account = new Account(100, 2, "7654567", AccountType.CHEQUE);
        double withdrawAmount = 150;
        double expectedBalance = 100;
        double actualBalance = account.withdraw(withdrawAmount);
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void testHandleWithdrawCheckingZeroAmount() {
        Account account = new Account(100, 2, "7654567", AccountType.CHEQUE);
        double withdrawAmount = 0;
        double expectedBalance = 100;
        double actualBalance = account.withdraw(withdrawAmount);
        assertEquals(expectedBalance, actualBalance, 0);
    }




        @Test
        public void testHandleWithdrawSavingsValidAmount() {
            Account account = new Account(100, 0, "7654567", AccountType.SAVING);
            double withdrawAmount = 50;
            double expectedBalance = 50;
            double actualBalance = account.withdraw(withdrawAmount);
            assertEquals(expectedBalance, actualBalance, 0);
        }

        @Test
        public void testHandleWithdrawSavingsOverdraftLimit() {
            Account account = new Account(100, 0, "7654567", AccountType.SAVING);
            double withdrawAmount = 150;
            double expectedBalance = 100;
            double actualBalance = account.withdraw(withdrawAmount);
            assertEquals(expectedBalance, actualBalance, 0);
        }

        @Test
        public void testHandleWithdrawSavingsZeroAmount() {
            Account account = new Account(100, 0, "7654567", AccountType.SAVING);
            double withdrawAmount = 0;
            double expectedBalance = 100;
            double actualBalance = account.withdraw(withdrawAmount);
            assertEquals(expectedBalance, actualBalance, 0);
        }

}





