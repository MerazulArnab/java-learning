public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String transactionHistory="";

    public BankAccount(String accountNumber, String accountHolder, double balance){
        
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        
    }
    public void deposit(double amount){
        if (amount<0){
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance = balance + amount;

        transactionHistory +="Deposited: $"+ amount +"\n";
        System.out.println("Deposit successful.");
    }
    public double getBalance(){ //method
        return balance;
    }

    public void withdraw(double amount){
        if (amount <=0){
            System.out.println("Withdrawal amount must be positi");
            return;
        }
        
        if(amount>balance){
            System.out.println("Insufficient balance.");
            return;
        }

        balance = balance - amount; 

        transactionHistory +="Withdrew: $" + amount + "\n";

        System.out.println("Withdrawal successful."); 
    }

    public void transfer(BankAccount receiver, double amount){
        if(amount<0){
            System.out.println("Transfer amount must be positive.");
            return;
        }

        if(amount>balance){
            System.out.println("Insufficient amount.");
            return;
        }
        balance = balance - amount;
        receiver.balance = receiver.balance + amount;

        transactionHistory +="Transferred to " + receiver.accountHolder +": $" +amount + "\n";

        receiver.transactionHistory += "Receive from " + accountHolder +": $"+amount +"\n";
        System.out.println(accountHolder +" -> "+ receiver.accountHolder+ ": $"+amount);
    }
    
    public void displayAccount(){

        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Account Holder: "+ accountHolder);
        System.out.println("Balance: $"+ balance);
    }

    public void displayTransactions(){
        System.out.println("Transaction History: ");

        if (transactionHistory.isEmpty()){
            System.out.println("No Transaction history.");
        }
        else{
            System.out.println(transactionHistory);
        }
    }

}

