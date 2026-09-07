import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Enter your password: ");
        String password = input.nextLine();
        boolean valid = isValidPassword(password);
        System.out.println("Valid password: "+ valid);
    }


    public static boolean isValidPassword(String password){

        if (password.length()<8){
            System.out.println("Password must contain at least 8 characters.");
            return false;
        }

        boolean hasUppercase = false; //This are called flags.Initially we haven't inspected anything, so everything is false.
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        boolean hasSpace = false;

        for (int i =0; i<password.length() ; i++){
            char c = password.charAt(i);

            if (Character.isUpperCase(c)){ //while the loop goes through every character, once it finds an uppercase this "if" gets applied here
                hasUppercase = true;
            }
            if (Character.isLowerCase(c)){
                hasLowercase = true;
            }
            if (Character.isDigit(c)){
                hasNumber = true;
            }
            if(!Character.isWhitespace(c)){
                hasSpace = true;
            }
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)){
                hasSpecial = true;
            }


        }

        if (!hasUppercase){
            System.out.println("Password must contain at least one uppercase letter");
            return false;
        }
        if (!hasLowercase){
            System.out.println("Paswword must contain at least one number");
            return false;
        }
        if (!hasNumber){
            System.out.println("Password must contain at least one number.");
            return false;
        }
        if (!hasSpecial) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }   

        if (!hasSpace) {
            System.out.println("Password cannot contain spaces.");
            return false;
        }

        return true;

    }
}