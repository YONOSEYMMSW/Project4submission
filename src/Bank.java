import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> bankInfoList = new ArrayList<Customer>();

    public void addCustomer(Customer customer){
        bankInfoList.add(customer);
    }

    public void removeCustomer(Customer customer){
        bankInfoList.remove(customer);
    }

    public Customer getBankDataList(int PIN){
        Customer bankAccountInfo = null;
        for(Customer i : bankInfoList){
            if(i.getPIN(PIN) == (PIN)){
                bankAccountInfo =i;
                break;
            }
        }
        return bankAccountInfo;
    }

    public StringBuilder getAllTheBankInfo(){
        StringBuilder customerStringBuilder = new StringBuilder();

        for(Customer j : bankInfoList){
            customerStringBuilder.append(j.toString());
        }
        return customerStringBuilder;}
}
