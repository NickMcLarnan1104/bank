import java.util.Scanner;

public class AccountTest {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
   

        System.out.print("Enter your name: ");
        String name = in.nextLine();

        System.out.print("Enter your age: ");
        int age = in.nextInt();
        in.nextLine();

        System.out.print("Enter your location: ");
        String location = in.nextLine();

        System.out.print("Enter your bank name: ");
        String bankName = in.nextLine();

        System.out.print("Enter your account number: ");
        String accountNumber = in.nextLine();

        System.out.print("Enter your routing number: ");
        String routingNumber = in.nextLine();

        System.out.print("Please create a new password: ");
        String password = in.nextLine();

        Account Nick = new Account(accountNumber, age, name, location, bankName, routingNumber, password);

        System.out.println("\nWould you like to alter your balance? (1 for yes 0 for no)");
        int control = in.nextInt();
        in.nextLine();

        System.out.print("Please enter your password: ");
        String passwordTest = in.next();

        while(!passwordTest.equals(password)) {
            System.out.print("Please enter your password: ");
            passwordTest = in.next();
    
            if (passwordTest.equals(password)) {
                System.out.printf("\nYou have gained access to %s's account!\n", Nick.getName());
                // would like to alter balance
                while(control == 1) {
                    System.out.print("\nPress 1 to insert, 2 to extract, and 0 to cancel: ");
                    int userAnswer = in.nextInt();
                    in.nextLine();
                    if(userAnswer == 1) {
                      System.out.println("\nHow much would you like to insert? ");
                      double insertAmount = in.nextInt();
                      in.nextLine();
                      Nick.insertMoney(insertAmount);
                      System.out.println("Now you have $" + Nick.getAmount());

                    } else if(userAnswer == 2) {
                     System.out.println("\nHow much would you like to extract? ");
                     double extractAmount = in.nextInt();
                     in.nextLine();
                     Nick.extractMoney(extractAmount);
                     System.out.println("You now have $" + Nick.getAmount());
            } else if(userAnswer == 0) {
                break;
            }
                
            } 
            } else {
                System.out.println("Incorrect password. Try again.");
                continue;
            }   
        }
        if(control == 0) {
            System.out.println("Would you like to change your password? 1 for yes 2 for no: ");
            int changePasswordQuestion = in.nextInt();

            if(changePasswordQuestion == 1) {
                System.out.print("Please enter new password: ");
                String newPassword = in.nextLine();
                Nick.changePassword(newPassword);
            }

        }
        

    }



}
