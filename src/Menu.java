import java.util.Scanner;


public class Menu {
    Bank customerBankInfo = new Bank();
    static Scanner scanner = new Scanner(System.in);

    public void displayMenu() {


            System.out.println();
            while (true) {
                System.out.println("********MENU********");
                System.out.println();
                System.out.println(" Please make a selection: ");
                System.out.println(" 1) Access Account ");
                System.out.println(" 2) Open a New Account ");
                System.out.println(" 3) Close All Account ");
                System.out.println(" 4) Exit ");
                System.out.println(">>>>");
                int answer = Integer.parseInt(scanner.nextLine());


                if (answer == 1) {
                    accessBankinfo();

                } else if (answer == 2) {
                    createBankinfo();

                } else if (answer == 3) {
                    deleteAllBankinfo();

                } else if (answer == 4) {
                    System.out.println("Thank you for using BSU BanK");
                    System.out.println("Goodbye Existing ");

                    break;


                } else {
                    System.out.println("Input is invalid, try again...");
                }
            }

    }


    private void accessBankinfo() {
        System.out.println("please enter a PIN: ");
        int PinAnswer = Integer.parseInt(scanner.nextLine());
        Customer customerInfoAccess = customerBankInfo.getBankDataList(PinAnswer);

        if (customerInfoAccess == null) {
            System.out.println(" PIN IS NOT VALID ");
            return;
        }


        System.out.println(customerInfoAccess.getAllTheAccounts());
        System.out.println();
        System.out.println(" Please enter the account number you would like to access: ");
        int userAccountNumber = Integer.parseInt(scanner.nextLine());
        Account customerAccount = customerInfoAccess.getAccountData(userAccountNumber);

        if (customerAccount == null) {
            System.out.println(" ACCOUNT NUMBER INVALID ");
            return;
        }

        while (true) {
            System.out.println("********MENU********");
            System.out.println();
            System.out.println("Please make a selection ");
            System.out.println(" 1) Make a deposit ");
            System.out.println(" 2) Make a withdrawal ");
            System.out.println(" 3) See account balance ");
            System.out.println(" 4) Close Account ");
            System.out.println(" 5) Exit ");
            System.out.println(">>>>");
            int subMenuAnswer = Integer.parseInt(scanner.nextLine());

            if (subMenuAnswer == 1) {
                customerAccount.depositAmount();



            } else if (subMenuAnswer == 2) {
                customerAccount.withdrawAmount();

            } else if (subMenuAnswer == 3) {
                System.out.println();
                System.out.println("Account " + customerAccount.getAccountNumber() +" balance " + customerAccount.toString());

            } else if (subMenuAnswer == 4) {
                customerInfoAccess.removeAccount(customerAccount);
                System.out.println("Account number " + customerAccount.getAccountNumber() +" closed ");

            } else if (subMenuAnswer == 5) {
                return;

            } else {
                System.out.println("Input is invalid, try again");
            }


        }

    }

    private Customer createNewCustomer() {
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter PIN:");
        int pinNumber = Integer.parseInt(scanner.nextLine());

        Customer newCustomer = new Customer(firstName, lastName, pinNumber);
        customerBankInfo.addCustomer(newCustomer);

        System.out.println("New customer added: ");
        System.out.println(newCustomer.toString());
        return newCustomer;
    }

    private void createBankinfo(){
        System.out.println("Are you a new customer? Yes/No ");
        String newCustomerReply = scanner.nextLine();
        System.out.println("Is this a personal account or a business account ");
        String typeOfAccount = scanner.nextLine();
        Account newsAccount;






        if (newCustomerReply.equalsIgnoreCase("yes")) {
            Customer newCustomer = createNewCustomer();
            System.out.println();
            System.out.println("Please enter the amount you want to deposit: ");
            int firstDepositAmount = Integer.parseInt(scanner.nextLine());
            if (typeOfAccount.equalsIgnoreCase("Personal")) {
                newsAccount = new PersonalAccount(firstDepositAmount);
                newCustomer.addAccount(newsAccount);
                System.out.println("New personal account created: " + newsAccount.getAccountNumber());
                System.out.println(newsAccount);
            } else if (typeOfAccount.equalsIgnoreCase("Business")) {
               newsAccount = new BusinessAccount(firstDepositAmount);
                System.out.println("New business account created: " + newsAccount.getAccountNumber());
                System.out.println(newsAccount);
            } else {
                System.out.println("Invalid account type. Returning to the main menu.");
                return;
            }

        } else if (newCustomerReply.equalsIgnoreCase("no")) {
            System.out.println("Please enter your PIN: ");
            int pinAnswer2 = Integer.parseInt(scanner.nextLine());
            Customer existingCustomer = customerBankInfo.getBankDataList(pinAnswer2);


            if (existingCustomer == null) {
                System.out.println("PIN is not valid. Returning to the Main Menu.");

            } else {
                System.out.println("Please enter deposit amount");
                int secondDepositAmount = Integer.parseInt(scanner.nextLine());
                if (typeOfAccount.equalsIgnoreCase("Personal")) {
                    Account newAccount2 = new PersonalAccount(secondDepositAmount);
                    existingCustomer.addAccount(newAccount2);
                    System.out.println("New personal account created: " + newAccount2.getAccountNumber());
                    System.out.println(newAccount2);
                } else if (typeOfAccount.equalsIgnoreCase("Business")) {
                    Account newAccount2 = new BusinessAccount(secondDepositAmount);
                    existingCustomer.addAccount(newAccount2);
                    System.out.println("New business account created: " + newAccount2.getAccountNumber());
                    System.out.println(newAccount2);
                } else {
                    System.out.println("Invalid account type. Returning to the main menu.");
                    return;
                }
            }

        } else {
            System.out.println("Invalid response. Returning to the Main Menu.");


        }
        System.out.println();




    }



    private void deleteAllBankinfo() {
        System.out.println("Please enter your PIN: ");
        int pin = Integer.parseInt(scanner.nextLine());
        Customer customerToRemove = customerBankInfo.getBankDataList(pin);

        if (customerToRemove == null) {
            System.out.println("PIN is not valid. Returning to the Main Menu.");
            return;
        }

        customerBankInfo.removeCustomer(customerToRemove);
        System.out.println("Customer has been removed from the bank registry.");
    }


}


