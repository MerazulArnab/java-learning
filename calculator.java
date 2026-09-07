import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        while (true) { 
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Exit"); 
            System.out.print("Choose: ");

            int choice= input.nextInt();
            if (choice == 6) {
                System.out.println("Calculator closed.");
                break;
            }

            System.out.print("Enter first number: ");
            double num1= input.nextDouble();

            System.out.print("Enter second number: ");
            double num2= input.nextDouble();

            switch (choice){
                case 1: System.out.println("Result: "+ add(num1,num2));
                break;

                case 2: System.out.println("Result: "+ subtract(num1,num2));
                break;

                case 3: System.out.println("Result: "+ multiply(num1,num2));
                break;

                case 4: System.out.println("Result: "+ divide(num1,num2));
                break;

                case 5: System.out.println("Result: "+ power(num1,num2));
                break;

                default:
                System.out.println("Invalid choice");
            }

        }
    }
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }
    
}

