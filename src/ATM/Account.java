package ATM;


public class Account {

    //Declare variables that are a part of users accounts
    private int id;
    //    private String name;
    private double balance;
    //    private double checkingBalance;
    private String mobileNumber;
    private String accountNumber;
//    private String checkingAccountNumber;

    private AccountType accountType;

//    // constructor function to initialise a new account
    public Account(double balance, int id, String accountNumber, AccountType type){
        this.balance = balance;
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = type;
    }

    // returns balance of account
    public double getBalance() {
        return balance;
    }
    // function that returns the id from the account
    public int getId() {
        return (int) id;
    }
    // function that retrieves the account number
    public String getAccountNumber() {
        return accountNumber;
    }
    // function that retrieves the mobile number
    public String getMobileNumber(){
        return mobileNumber;
    }

    public AccountType getAccountType(){
        return accountType;
    }

    //    function that enables you to change the balance
    public void setBalance(double balance){
        this.balance = balance;
    }
    // function that enables you to change or declare the account number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
// function that enables you to change or declare the id

    public void setId(int id) {
        this.id = id;
    }


    // Handle deposit. Update balance and print new account balance.

    public double deposit(double value){
        this.balance = this.balance + value;
        System.out.println("This is your new account balance " + this.balance);
        return this.balance;
    }
    // Handle withdrawal. Check if enough money, if so exit. If not, continue to withdraw.
    public double withdraw(double value){
        if (value > this.balance){
            System.out.println("Error - Wrong Input. Amount entered ($" + value + ") is greater than the amount in account ($" + this.balance + ")");
            return this.balance;
        }
        else {
            this.balance = this.balance - value;
            System.out.println("This is your new account balance " + this.balance);
        }
        return this.balance;
    }
    // check balance function
    public void checkBalance(){
        System.out.println("This is your account balance: " + this.balance);
    }
}
