public class PersonalAccount extends Account {
    public PersonalAccount(int amountDeposited) {
        super(amountDeposited);
    }


    public int creditScore(){
        System.out.println("What is your credit score? ");

        return Integer.parseInt(scanner.nextLine());
    }
    public String SSN (){
        System.out.println("What is your Social Security Number? ");

        return scanner.nextLine();
    }


    @Override
    public String toString() {
        return
                '\n' + super.toString() +

                '\n' + "CreditScore: " + creditScore() +
                        '\n' + "Social security number " +SSN()
                ;
    }
}

