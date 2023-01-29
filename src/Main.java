import ATM.ATM;

public class Main {
    public static void main(String[] args) throws InterruptedException {
// loads data and function from ATM
        ATM atm = new ATM();
        atm.loadUsers("Data/UserInfo.txt");
        atm.loadAccounts("Data/OpeningAccountsData.txt");
        atm.interactATM();
    }
}