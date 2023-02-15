package ATM;


import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ATM {


    //    enum AccountType { CHEQUE, SAVING }
    //map for users and their id
    public Map<Integer, User> users;

    public void ATM() {
        users = new HashMap<Integer, User>();
    }
    public Map<Integer, User> getUsers() {
        return this.users;
    }
    public void interactATM() {

        boolean depositFailed = false;
        boolean withdrawFailed = false;


        boolean active = true;
        User user = null;
        Scanner scanner = new Scanner(System.in);


        while (active) {
            System.out.println("Please Enter you User ID");
            int id;

            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                active = false;
                System.out.println("Wrong Input: Invalid Account Number");
                break;
            }
            user = users.get(id);

            if (user == null){
                active = false;
                System.out.println("Wrong Input: Invalid Account Number");
                interactATM();
            }


// Will re-run the program if the deposit fails
            if (depositFailed == true) {
                user.getFinalNotificationString();
                interactATM();
            }
// Will return to the start of program if the withdrawal fails
            if (withdrawFailed == true) {
                user.getFinalNotificationString();
                interactATM();
            }

            System.out.println("Welcome " + user.getFirstname() + " " + user.getLastname() + "!");


            // asks user what option they want to do
            System.out.println("Select an option: 1) Deposit 2) Withdraw 3) Balance q) Quit"); // q for quit
            String option;
            option = scanner.nextLine();
            try {
                option = scanner.nextLine();
            } catch (InputMismatchException e) {
                active = false;
                user.getFinalNotificationString();
//                make sure this breaks
                break;

            }


// if user doesn't have a checking account
            if (user.getCheckingAccount() == null) {
                if (option.equals("1")) {
                    handleDepositSavings(user);
                    interactATM();

                }
                if (option.equals("2")) {
                    handleWithdrawSavings(user);
                    interactATM();
                }

                if (option.equals("3")) {
                    handleBalanceSavings(user);
                    interactATM();
                }
                else {
                    break;
                }
            }

// if user doesn't have a savings account
            if (user.getSavingsAccount() == null) {
                if (option.equals("1")) {
                    handleDepositChecking(user);
                    interactATM();
                }

                if (option.equals("2")) {
                    handleWithdrawChecking(user);
                    interactATM();

                }

                if (option.equals("3")) {
                    handleBalanceChecking(user);
                    interactATM();
                }

                else {
                    break;
                }
            }


// If user has both accounts
            if (user.hasCheckingAccount(user) && user.hasSavingsAccount(user)) {
                if (option.equals("1")) {
                    try {
                        handleDeposit(user);
                        interactATM();
                    } catch (Exception e) {
                        depositFailed = true;
                    }


                } else if (option.equals("2")) {
                    try {
                        handleWithdraw(user);

                    } catch (Exception e) {
                        withdrawFailed = true;
                    }


                } else if (option.equals("3")) {
                    handleBalance(user);
                    interactATM();;

                } else {
                    active = false;
                    user.getFinalNotificationString();
                    break;
                }


            }


        }

    }



    private void handleWithdrawChecking(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an account: 1) Checking: " + user.getCheckingAccount().getAccountNumber());
        String accountType = scanner.nextLine();
        if (!(accountType.equals("1"))){
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getCheckingAccount().getBalance());
            System.exit(0);
        }

        System.out.println("How much would you like to withdraw?");
        double value = 0;
        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getCheckingAccount().getBalance());
            System.exit(0);
        }

        if (accountType.equals("1")) {
            user.getCheckingAccount().withdraw(value);
            interactATM();
        } else {
            System.out.println("Account Balance:");
            System.out.println("Checking: " + user.getCheckingAccount().getBalance());
            System.exit(0);
        }
    }

    private void handleDepositChecking(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an account: 1) Checking: " + user.getCheckingAccount().getAccountNumber());
        String accountType = scanner.nextLine();
        if (!(accountType.equals("1"))){
                System.out.println("Account balance:");
                System.out.println("Checking: " + user.getCheckingAccount().getBalance());
                System.exit(0);
            }
//                    scanner.nextLine();

        System.out.println("How much would you like to deposit?");

        double value = 0;
        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Account balance:");
            System.out.println("Checking: " + user.getCheckingAccount().getBalance());
        }


        if (accountType.equals("1")) {
            user.getCheckingAccount().deposit(value);

        } else {
            System.out.println("Account Balance:");
            System.out.println("Checking: " + user.getCheckingAccount().getBalance());


        }
    }

    public void handleWithdraw(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an account: 1) Checking: " + user.getCheckingAccount().getAccountNumber() + " 2) Savings: " + user.getSavingsAccount().getAccountNumber());
        String accountType = scanner.nextLine();

        if (!(accountType.equals("1")))
            if (!(accountType.equals("2"))) {
                user.getFinalNotificationString();
                System.exit(0);
            }

        System.out.println("How much would you like to withdraw?");

        double value = 0;
        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            user.getFinalNotificationString();
            System.exit(0);
        }

        if (accountType.equals("1")) {
            user.getCheckingAccount().withdraw(value);


        } else if (accountType.equals("2")) {
            user.getSavingsAccount().withdraw(value);

        } else {
            user.getFinalNotificationString();
            System.exit(0);

        }
    }

    public void handleBalance(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an account: 1) Checking: " + user.getCheckingAccount().getAccountNumber() + " 2) Savings: " + user.getSavingsAccount().getAccountNumber());
        String accountType = scanner.nextLine();


        if (accountType.equals("1")) {
            user.getCheckingAccount().checkBalance();
        }

        if (accountType.equals("2")) {
            user.getSavingsAccount().checkBalance();
        } else {
            user.getFinalNotificationString();
            System.exit(0);
        }
    }

    private void handleDeposit(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an account: 1) Checking: " + user.getCheckingAccount().getAccountNumber() + " 2) Savings: " + user.getSavingsAccount().getAccountNumber());

        String accountType = scanner.nextLine();
        if (!(accountType.equals("1")) && !(accountType.equals("2"))){
            user.getFinalNotificationString();
            System.exit(0);
        }
//                    scanner.nextLine();

        System.out.println("How much would you like to deposit?");
        double value = 0;
        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            user.getFinalNotificationString();
            System.exit(0);
        }

//        double value = scanner.nextDouble();

        if (accountType.equals("1")) {
            user.getCheckingAccount().deposit(value);

        } else if (accountType.equals("2")) {
            user.getSavingsAccount().deposit(value);

        } else {
            user.getFinalNotificationString();
            System.exit(0);

        }
    }

    private void handleBalanceChecking(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an account: 1) Checking: " + user.getCheckingAccount().getAccountNumber());
        String accountType = scanner.nextLine();


        if (accountType.equals("1")) {
            user.getCheckingAccount().checkBalance();
        } else {
            System.out.println("Account Balance:");
            System.out.println("Checking: " + user.getCheckingAccount().getBalance());
            System.exit(0);

        }
    }

    private void handleDepositSavings(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an Account: 1) Savings: " + user.getSavingsAccount().getAccountNumber());
        String accountType = scanner.nextLine();
        if (!(accountType.equals("1"))){
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());
            System.exit(0);
        }

        System.out.println("How much would you like to deposit?");
        double value = 0;
        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());
        }

        if (accountType.equals("1")) {
            user.getSavingsAccount().deposit(value);
        } else {
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());


        }
    }

    private void handleBalanceSavings(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an account: 1) Savings: " + user.getSavingsAccount().getAccountNumber());
        String accountType = scanner.nextLine();
        if (!(accountType.equals("1"))){
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());
            System.exit(0);
        }

//                    scanner.nextLine();

        if (accountType.equals("1")) {
            user.getSavingsAccount().checkBalance();
        } else {
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());
            System.exit(0);
        }

    }

    private void handleWithdrawSavings(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an account: 1) Savings: " + user.getSavingsAccount().getAccountNumber());
        String accountType = scanner.nextLine();
        if (!(accountType.equals("1"))){
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());
            System.exit(0);
        }

        System.out.println("How much would you like to withdraw?");
        double value = 0;
        try {
            value = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());
            interactATM();
        }

        if (accountType.equals("1")) {
            user.getSavingsAccount().withdraw(value);

        } else {
            System.out.println("Account balance:");
            System.out.println("Savings: " + user.getSavingsAccount().getBalance());
            System.exit(0);

        }
    }

    List accounts = new ArrayList<>();
    public boolean loadAccounts(String fileName) {

        //loads accounts from files

        Path current = Paths.get(".");


        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {

                // use three pipes as separator

                String[] values = line.split("\\|\\|\\|");
//                System.out.println(values[0]);
                if (!values[0].equals("AccountOwnerID")) {
                    accounts.add(1);
                    int id = Integer.parseInt(values[0]);
                    String accountNumber = values[1];
                    String accountType = values[2];
                    double accountBalance = Double.parseDouble(values[3]);
                    User currentUser = users.get(id);
//                What accountType
                    if (accountType.equals("Saving")) {
                        currentUser.createAccount(AccountType.SAVING, accountBalance, id, accountNumber);
                    } else if (accountType.equals("Cheque")) {
                        currentUser.createAccount(AccountType.CHEQUE, accountBalance, id, accountNumber);
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean loadUsers(String fileName) {
        this.users = new HashMap<>();
        // loads users from files
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] values = line.split(",");
                int id = 0;
                if (!values[3].equals("AccountOwnerID")) {
                    id = Integer.parseInt(values[3]);
                    User user = new User(values[0], values[1], values[2], id);
                    users.put(id, user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

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

    public int getNumberOfAccounts() {
        return accounts.size();
    }


}











