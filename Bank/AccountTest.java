// imports for our program
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
// import java.io.*; this does all the ios above but good to see the imports

// class
public class AccountTest {
    
    public static void main(String[] args) throws IOException { // this exception will be thrown if there is no file
        
        // create scanner object
        Scanner in = new Scanner(System.in);
        String passwordTest = "";

        //====================================================================
        // TO WRITE TEXT TO A TXT FILE: LEARNING:
        // 1) create a file
        File file1 = new File("out.txt");

        // 2) create a file writer class
        FileWriter fw = new FileWriter(file1);

        // 3) create a print writer class
        // we put the previously created filewriter object in there
        PrintWriter pw = new PrintWriter(fw);

        // pw.write("Line 1"); -- just this there is no new line
        // pw.println("Line 1");
    

        //====================================================================
        // READ A TXT FILE LEARNING
        // File readFile = new File("out.txt");
        // Scanner fileReader = new Scanner(readFile);


        // while(fileReader.hasNextLine()) {
        //     System.out.println(fileReader.nextLine()); // this alone will just read 1 line    
        // }
        
        //====================================================================

        // print out messages to the user for interaction / entering data
        System.out.println("\n\t-- Hello! Please enter your bank information --\n");
        System.out.print("Enter your name: ");
        String name = in.nextLine();

        System.out.print("Enter your age: ");
        int age = in.nextInt();
        in.nextLine(); // prevent error

        System.out.print("Enter your location: ");
        String location = in.nextLine();

        System.out.print("Enter your bank name: ");
        String bankName = in.nextLine();

        System.out.print("Enter your account number: ");
        String accountNumber = in.nextLine();

        System.out.print("Enter your routing number: ");
        String routingNumber = in.nextLine();

        System.out.print("Please create a password: ");
        String password = in.nextLine();

        // create a new account with data entered
        Account Nick = new Account(accountNumber, age, name, location, bankName, routingNumber, password);

        // // for text file
        // pw.println("Name: " + Nick.getName());
        // pw.println("Location: " + Nick.getLocation());
        // pw.println("Age: " + Nick.getAge());
        // pw.println("Bank name: " + Nick.getBankName());
        // pw.println("Account number: " + Nick.getAccountNumber());
        // pw.println("Routing number: " + Nick.getRoutingNumber());
        // pw.println("Password: " + Nick.getPassword());
        // pw.println("\nAmount in account: " + Nick.getAmount());

        // pw.close();

        // Ask user if they would like to alter their balance
        while(true) {
            System.out.println("\nPress 1 for deposit/withdrawal, 2 to change password, and 0 to quit programFIRST: ");
            int control = in.nextInt();
            in.nextLine(); // needed for proper input
            
            // if user enters 
            if(control == 1) {
                // password access point
                System.out.print("Please enter your password: ");
                passwordTest = in.nextLine();
            } else if(control == 0) {
                break;
            }
            
            // while control input is 1
            while(control == 1) {
                // measures to see if the password test entered is equal to the og password
                if(passwordTest.equals(password)) {
                    System.out.println("\n\t-- Password is correct! --");
                    // would like to alter balance or change password
                    System.out.print("\nPress 1 to enter amount change or 0 return to selection: ");
                    int userAnswer = in.nextInt();
                    // if user enters 1
                    if(userAnswer == 1) {
                        // loops as long as the user answer does not equal 0
                        while(userAnswer != 0) {
                            // asks user what they want to do when they enter the program
                            System.out.print("\nPress 1 to deposit, 2 to withdrawal, or 0 to return to selection: ");
                            userAnswer = in.nextInt();
                            if(userAnswer == 1) {
                                // if they choose deposite:
                                System.out.println("\nHow much would you like to deposit? ");
                                double insertAmount = in.nextDouble();
                                in.nextLine();
                                // insert amount into a function that adds money to total
                                Nick.insertMoney(insertAmount);
                                System.out.printf("\nYou deposited $%,.2f%n", insertAmount);
                                System.out.printf("\n\t-- You now have $%,.2f --\n", Nick.getAmount());
                            } else if(userAnswer == 2) {
                                // if they choose withdrawal:
                                System.out.println("\nHow much would you like to withdrawal? ");
                                double extractAmount = in.nextDouble();
                                in.nextLine();
                                // insert amount into a function that removes money from total
                                Nick.extractMoney(extractAmount);
                                System.out.printf("\nYou withdrew $%,.2f%n", extractAmount);
                                System.out.printf("\n\t-- You now have $%,.2f --\n", Nick.getAmount());


                            } else if(userAnswer == 0) {
                                break; // break the program
                            }


                        } 
 
                    } else if(userAnswer == 0) {
                        break; // break the program
                    }
                } else {
                    // continue looping until password is correct
                    while(!passwordTest.equals(password)) {
                        System.out.print("Wrong! Please enter your password: ");
                        passwordTest = in.nextLine();
                        if(passwordTest.equals(password)) {
                            break;
                        }
                    }
                    if(passwordTest.equals(password)) {
                        continue;
                    }
                }
                // asks users again after they quit loop
                System.out.println("\nPress 1 for deposit/withdrawal, 2 to change password, or 0 to quit programSECOND: ");
                control = in.nextInt();
                in.nextLine(); // needed so program doesnt break
                if(control == 0) {
                    break;
                }
            }   

            // if they choose 2 they can change their password
            if(control == 2) {
                System.out.println("\nPress 1 to change your password or 0 to return to selection: ");
                int changePasswordQuestion = in.nextInt();
                in.nextLine();

                if(changePasswordQuestion == 1) {
                    // if they want to change their password they need to comfirm they're identity
                    System.out.print("Please enter old password: ");
                    passwordTest = in.nextLine();  
                }

                // asks password over and over until they get it correct
                while(changePasswordQuestion == 1) {
                    if(passwordTest.equals(password)) {
                        if(changePasswordQuestion == 1) {
                            System.out.print("\nPlease enter new password: ");
                            String newPassword = in.nextLine();
                            if(newPassword.equals(password)) {
                                System.out.println("\n-- New password cannot be old password. Try again. --");
                                continue;
                            } else {
                                System.out.println("\n\t-- Success! --");
                                password = newPassword;
                                break; 
                            }
                        } 
                    } else if(!passwordTest.equals(password)) {
                        while(!passwordTest.equals(password)) {
                            System.out.print("Wrong! Please enter old password: ");
                            passwordTest = in.nextLine();
                        }
                    } else {
                        continue;
                    }
                }
                // System.out.println("\nPress 1 to return to selection and 0 to quit program: ");
                // int restart = in.nextInt();
                // if(restart == 1) {
                //     continue;
                // } else {
                //     break;
                // }
                
            }
            if(control == 0) {
                break;
            }
        }    
        System.out.printf("\n\tThank you for using %s!\n", Nick.getBankName());
    }
}


