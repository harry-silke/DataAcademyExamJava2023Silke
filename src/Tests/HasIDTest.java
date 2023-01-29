package Tests;

import ATM.User;
import ATM.ATM.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HasIDTest {
    public boolean hasID(Map<Integer, User> users, int userID) {
        try{
            users.isEmpty();
        }
        catch (Exception e){
            return false;
        }
        if (!users.containsKey(userID)  ) {
            return false;
        }
        return true;
    }

    @Test
    public void testHasIDValidUserID() {
        Map<Integer, User> users = new HashMap<>();

        int userID = 12345;
        User user = new User("John", "Doe", "04328384848", 12345);
        users.put(userID, user);
        boolean result = hasID(users, userID);
        assertTrue(result);
    }


    @Test
    public void testHasIDInvalidUserID() {
        Map<Integer, User> users = new HashMap<>();

        int userID = 12345;
        User user = new User("John", "Doe", "04328384848", 12345);
        users.put(userID, user);
        int invalidUserID = 56789;
        boolean result = hasID(users, invalidUserID);
        assertFalse(result);
    }

    @Test
    public void testHasIDEmptyUsers() {
        Map<Integer, User> users = new HashMap<>();
        int userID = 12345;
        boolean result = hasID(users, userID);
        assertFalse(result);
    }

    @Test
    public void testHasIDNullUsers() {
        Map<Integer, User> users = null;
        int userID = 12345;
        boolean result = hasID(users, userID);
        assertFalse(result);
    }


}
