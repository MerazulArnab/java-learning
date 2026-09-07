import java.util.Scanner;

public class atm_withdrawal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your balance: ");
        double balance = input.nextDouble();

        System.out.println("Enter your withdrawal:");
        double withdrawalAmount = input.nextDouble();

        if(withdrawalAmount <=0 ){
            System.out.println("Withdrawal amount must be positive.");
        }
        else if( withdrawalAmount> balance){
            System.out.println("Cannot withdraw more than your balance");
        }
        else if (withdrawalAmount%10 !=0){
            System.out.println("Withdrawal amount must be a multiple of 10");
        }
        else {
            balance = balance - withdrawalAmount;
            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance = "+ balance);
        }

    }
}
