package Tests;


import ATM.ATM;


import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

class ATMTest {
    @Test
    public void testCreateObjects(){
        ATM atm = new ATM();
        atm.loadUsers("UserInfo.txt");
        atm.loadAccounts("OpeningAccountsData.txt");

        assertTrue(atm.users.get(001).getID()==001);
        assertTrue(atm.users.get("John").getFirstname() == "John");
        assertTrue(atm.users.get("Smith").getLastname() == "Smith");
        assertTrue(atm.users.get("0403715629").getMobileNumber() == "0403715629");

        assertTrue(atm.users.get(002).getID()==002);
        assertTrue(atm.users.get("Leanne").getFirstname() == "Leanne");
        assertTrue(atm.users.get("Smith").getLastname() == "Smith");
        assertTrue(atm.users.get("0403185031").getMobileNumber() == "0403185031");

        assertTrue(atm.users.get(003).getID()==003);
        assertTrue(atm.users.get("Kim").getFirstname() == "Kim");
        assertTrue(atm.users.get("Kash").getLastname() == "Kash");
        assertTrue(atm.users.get("0404993021").getMobileNumber() == "0404993021");


    }


//    public class BankTest {
//        private ATM atm;
//
//        @Before
//        public void setUp() {
//            atm = new ATM();
//        }
//
//        @Test
//        public void testLoadAccounts() throws IOException {
//            // Create a test file with sample data
//            File testFile = new File("test_accounts.txt");
//            testFile.createNewFile();
//            String data = "AccountOwnerID|||AccountNumber|||AccountType|||AccountBalance\n" +
//                    "1|||12345|||Saving|||1000.0\n" +
//                    "2|||67890|||Cheque|||2000.0\n";
//            FileUtils.writeStringToFile(testFile, data, StandardCharsets.UTF_8);
//
//            File testFile = new File("test_Users.txt");
//            testFile.createNewFile();
//            String data = "FirstName|||Surname |||Mobile|||AccountOwnerID" +
//                    "John, Smith, 12345, 1" +
//                    "Bob , Bob, 234567, 2";
//            FileUtils.writeStringToFile(testFile, data, StandardCharsets.UTF_8);
//
//            // Verify that the accounts are loaded correctly
//            atm.loadAccounts("test_accounts.txt");
//            User user1 = atm.getUser(1);
//            User user2 = atm.getUser(2);
//            assertNotNull(user1);
//            assertNotNull(user2);
//            assertEquals(1000.0, user1.getSavingAccount().getBalance(), 0.1);
//            assertEquals("12345", user1.getSavingAccount().getAccountNumber());
//            assertEquals(2000.0, user2.getCheckingAccount().getBalance(), 0.1);
//            assertEquals("67890", user2.getCheckingAccount().getAccountNumber());
//
//            // Clean up the test file
//            testFile.delete();
//        }
//    }



}