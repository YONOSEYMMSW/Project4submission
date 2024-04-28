import java.util.Scanner;


public class Account {
    protected static Scanner scanner = new Scanner(System.in);

    protected int balance;

    protected int getAccountNumber() {
        return accountNumber;
    }



    protected int accountNumber;
    protected static int baseAccountNumber = 1000;



    public int getAccountNumber(int accountNumber) {
        return this.accountNumber;
    }
    public Account(int amountDeposited) {
        this.balance = amountDeposited;
        this.accountNumber = baseAccountNumber++;;
    }

    public void depositAmount() {
        System.out.println("Please enter the amount you want to deposit: ");
        int depositAmountGiven  = Integer.parseInt(scanner.nextLine());
        balance = balance + depositAmountGiven;
        System.out.println("you have deposited: " + depositAmountGiven);
        System.out.println("you have a balance of " + balance);

    }

    public void withdrawAmount() {
        System.out.println(" Please enter the amount you want to withdraw : ");
        int withdrawAmountGiven = Integer.parseInt(scanner.nextLine());
        balance = balance - withdrawAmountGiven;

        if(balance < withdrawAmountGiven){
            System.out.println(" Insufficient funds ");
        } else {

            System.out.println(" you have withdrawn : " + withdrawAmountGiven);
            System.out.println(" you have  " + balance  + " amount left ");
        }

    }





    @Override
    public String toString() {
        return
                '\n' + "AccountNumber:  " + accountNumber + '\n' +
                "balance: " + balance
                ;
    }
}

