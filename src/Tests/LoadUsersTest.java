package Tests;

import ATM.ATM;
import ATM.User;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class LoadUsersTest {



        @Test
        public void testLoadUsersValid() {
            ATM atm = new ATM();
            String fileName = "Data/TestData/UserInfoTest.txt";
            boolean result = atm.loadUsers(fileName);
            assertTrue(result);

            // Check if the correct number of uses have been loaded
            assertEquals(atm.users.size(), 3);
            // Check if a specific user has been loaded correctly
            User user = atm.getUsers().get(1);
            assertNotNull(user);
            assertEquals(user.getFirstname(), "Marie");
            assertEquals(user.getLastname(), "Antoinette");
            assertEquals(user.getMobileNumber(), "040202040");
            assertEquals(user.getID(), 1);
        }

    @Test
    public void testLoadUsersWithInvalidData() {
        // Create an instance of the ATM class
        ATM atm = new ATM();

        // Define an invalid file name
        String fileName = "Data/TestData/NonexistentFile.txt";

        // Call the loadUsers method with the invalid file name
        boolean result;
        try {
            result = atm.loadUsers(fileName);
        } catch (Exception e) {
            result = true;
        }

        // Check that the users list is empty
        assertTrue(atm.getUsers().isEmpty());
    }

    }
