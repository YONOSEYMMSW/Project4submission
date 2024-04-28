public class BusinessAccount extends Account {
    public BusinessAccount(int amountDeposited) {
        super(amountDeposited);
    }

    public String BusinessEmail(){
        System.out.println("What is your business email? ");
        String BusinessEmail = scanner.nextLine();
        return BusinessEmail;
    }
    public String BusinessName(){
        System.out.println("What is your business name? ");
        String BusinessName = scanner.nextLine();
        return BusinessName;
    }

    @Override
    public String toString() {
        return

                '\n' + super.toString() +
                '\n' + "Business email : " + BusinessEmail() +
                '\n' + "Business name : " + BusinessName()
                ;
    }


}
