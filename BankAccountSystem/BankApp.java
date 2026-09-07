
public class BankApp {
    public static void main(String[]args){
        BankAccount arnab= new BankAccount("1001", "Arnab", 1000);

        BankAccount john= new BankAccount("1002", "john", 500);
        
        arnab.deposit(200);
        System.out.println("Arnab's  balance: $"+ arnab.getBalance());
        System.out.println();

        arnab.withdraw(100);
        System.out.println("Arnab's  balance: $"+ arnab.getBalance());
        System.out.println();

        arnab.transfer(john, 200);
        System.out.println("John's balance: $"+john.getBalance());

        System.out.println();
        arnab.displayAccount();
        arnab.displayTransactions();
        System.out.println();

        john.displayAccount();
        john.displayTransactions();
    }
}