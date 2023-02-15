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



}