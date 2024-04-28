import java.util.HashMap;

public class Customer {
    private String firstName;
    private String lastName;
    private int PIN;
    //ArrayList<Account> customerAccountList = new ArrayList<Account>();
    HashMap< Integer, Account > customerAccountHashMap = new HashMap< Integer , Account>();

    public Customer(String firstName, String lastName, int PIN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;
    }

    public void addAccount(Account account){
        customerAccountHashMap.put(account.getAccountNumber(), account);
    }

    public void removeAccount(Account account){
        customerAccountHashMap.remove(account.getAccountNumber(),account);
    }

    public Account getAccountData( int accountNumber){
        Account customerAccountInfo = null;

        if( customerAccountHashMap.containsKey(accountNumber)) {
            customerAccountInfo =  customerAccountHashMap.get(accountNumber);


        }

        return customerAccountInfo;
    }




    public StringBuilder getAllTheAccounts() {
        StringBuilder customerStringBuilder = new StringBuilder();
        for (customerAccountHashMap.forEach((PIN, Account) -> {
            customerStringBuilder.append(Account.toString());
        }); ; )
            return customerStringBuilder;
    }




    public int getPIN(int PIN) {
        return this.PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    @Override
    public String toString() {
        return
                '\n' + "Customer name: " + firstName + ' ' + lastName + '\n' +
                        "PIN: " + PIN
                ;
    }
}
