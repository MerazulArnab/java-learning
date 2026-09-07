import java.util.ArrayList;
import java.util.Scanner;

public class LoginApp {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>(); //since number of users can grow, so array is suitable for this.

        while(true){
            System.out.println("===== LOGIN SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Change Password");
            System.out.println("4. Exit");

            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();//consumes that leftover Enter ("nextInt()"reads the number but leaves the Enter you pressed behind)

            if(choice==1){
                register(input, users);
            }

            if(choice==2){
                login(input, users);

            }

            if(choice ==3){
                changePassword(input, users);
            }
            if(choice==4){
                break;
            }
        }
    }

    public static void register(Scanner input, ArrayList<User> users){ //We're giving the method access to the Scanner and the list of users that we created in main().
        System.out.print("Enter username: ");
        String username = input.nextLine(); //// actually reads username

        for(int i = 0; i<users.size();i++){
            User user = users.get(i); //Get one User object from the users ArrayList at position i and temporarily store it in a variable called user.

            if(user.getUsername().equals(username)){
                System.out.println("Username already exists.");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();
        if(!isValidPassword(password)){
            return;
        }

        User newUser = new User(username, password);
        users.add(newUser);

        System.out.println("Registration successful.");

        
    }

    public static boolean isValidPassword(String password){
        
        if (password.length()<8){
            System.out.println("Password must contain at least 8 characters.");
            return false;
        }

        boolean hasUppercase = false; 
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

    public static void login(Scanner input, ArrayList<User>users){
        System.out.print("Enter username: ");
        String username = input.nextLine();

        User foundUser = null;

        for(int i=0; i<users.size(); i++){
            User user= users.get(i);

            if(user.getUsername().equals(username)){
                foundUser = user;
                break;
            }
        }
        
        if(foundUser ==null){
            System.out.println("User not found.");
            return;
        }

        if(foundUser.isLocked()){
            System.out.println("Account is locked");
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if(foundUser.getPassword().equals(password)){
            System.out.println("Login successful.");
            foundUser.resetFailedAttempts();
        }

        else{
            System.out.println("Incorrect password.");
            foundUser.increaseFailedAttempts();

            if(foundUser.getFailedAttempts()>=3){
                foundUser.isLocked();
                System.out.println("Account locked after 3 attempts.");

            }
        }
    }

    public static void changePassword(Scanner input, ArrayList<User>users){
        System.out.print("Enter username: ");
        String username = input.nextLine();

        User foundUser = null;
        for(int i=0; i<users.size();i++){
            User user= users.get(i);

            if(user.getUsername().equals(username)){
                foundUser=user;
                break;
            }
        }

        if(foundUser ==null){
            System.out.println("User not found.");
            return;
        }

        if(foundUser.isLocked()){
            System.out.println("Account is locked.");
        }

        System.out.print("Enter your current password: ");
        String currentPassword =input.nextLine();

        if(!foundUser.getPassword().equals(currentPassword)){
            System.out.println("Authentication failed.");
            return;
        }

        System.out.print("Enter your new password: ");
        String newPassword = input.nextLine();

        if(!isValidPassword(newPassword)){
            return;
        }

        foundUser.setPassword(newPassword);
        System.out.println("Password changed successfully.");

    }
        
        
}
