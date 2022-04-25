// Name: Jason Carrillo
// Class: CSIS-1400
// Assignment: BankingApp (Team Project)

import java.util.Scanner;
import java.util.ArrayList;

public class BankingApp {
    public static void main(String arg[]){
        Scanner scnr = new Scanner(System.in);
        double userLoanRequestedAmount;
        boolean hasChecking, hasSavings, quit;
        char choice;
        int i, loanID, userCreditScore;
        loanID = 0;
        hasChecking = hasSavings = quit = false;

        //Accounts array list
        ArrayList<Account> accounts = new ArrayList<Account>();

        // Array for loan class
        Loan[] loans;
        
        //loan array can have up to 6 loans
        loans = new Loan[5];
        
        
        //Welcome Screen
        System.out.println("********************");
        System.out.println("**                **");
        System.out.println("**   Welcome to   **");
        System.out.println("**   CSIS Bank!   **");
        System.out.println("**                **");
        System.out.println("********************\n\n");
        
        
        while(true){
            quit = false;
            menu();
            choice = Character.toLowerCase(scnr.next().charAt(0));
            
            switch(choice){
                // quit application
                case 'h':
                    scnr.close();
                    return;

                // open an account
                case 'a':
                
                    while(!quit){
                        System.out.println("What type of account would you like to open?\nChecking (a)\nSavings (b)\nCancel(q)");
                        char accountChoice = Character.toLowerCase(scnr.next().charAt(0));

                        switch(accountChoice){
                            case 'a':
                                if(hasChecking == true){
                                    System.out.println("You already have a checking account");
                                    quit = true;
                                    break;
                                }

                                Account checking = new Account();
                                checking.setAccountName("Checking");
                                checking.setAccountType(false);
                                checking.setAPR(0.00);

                                System.out.println("How much for your initial deposit?");
                                checking.setBalance(scnr.nextDouble());

                                checking.display();
                                hasChecking = true;
                                accounts.add(checking);
                                quit = true;
                                break;
                                
                                case 'b':
                                if(hasSavings == true){
                                    System.out.println("You already have a checking account");
                                    quit = true;
                                    break;
                                }
                                
                                Account savings = new Account();
                                savings.setAccountName("Checking");
                                savings.setAccountType(false);
                                savings.setAPR(0.60);
                                
                                System.out.println("How much for your initial deposit?");
                                savings.setBalance(scnr.nextDouble());
                                
                                savings.display();
                                hasSavings = true;
                                accounts.add(savings);
                                quit = true;
                                break;
                            case 'q':
                                quit = true;
                                break;
                                
                            default:
                                System.out.println("Try Again");
                        }
                    }
                    break;
                // display accounts and loans
                case 'b':
                    for(i = 0; i < accounts.size();i++ ){
                        accounts.get(i).display();
                    }
                    break;
                
                // Deposit
                case 'c':
                    System.out.println("Choose what account to deposit to.");
                        for(i = 0; i < accounts.size();i++ ){
                            accounts.get(i).display();
                        }
                    break;
                    
                // Withdraw
                case 'd':
                    System.out.println("Choose what account to withdraw from.");

                    for(i = 0; i < accounts.size();i++ ){
                        accounts.get(i).display();
                    }

                    break;
                    
                // Transfer
                case 'e':
                    // checks if user has 2 accounts
                    if(!hasChecking | !hasSavings){
                        System.out.println("\nSORRY! You do not have enough accounts\n");
                        break;
                    }

                    System.out.println("Choose \"from\" account");
                        for(i = 0; i < accounts.size();i++ ){
                            accounts.get(i).display();
                        }
                    System.out.println("Choose \"to\" account");
                    break;
                    
                // apply for loan
                case 'f':
                    if(loans.length == 6){
                        System.out.print("You have the max allowed loans");
                        break;
                    };

                    System.out.print("\nHow much were you looking to apply for? ");
                    userLoanRequestedAmount = scnr.nextDouble();
                    System.out.print("\nWhat is your credit score? ");
                    userCreditScore = scnr.nextInt();

                    if(userCreditScore < 650 & userLoanRequestedAmount > 35000.00){
                        System.out.println("Sorry, your credit score is too low for that amount");
                        break;
                    }

                    System.out.print("Name this loan: ");
                    scnr.nextLine();
                    String userLoanName = scnr.nextLine();

                    while(!quit){
                        System.out.print("\nWhat is your loan type?\n\nStudent Loan (a)\nMortgage (b)\nPersonal Loan (c)\nAuto Loan (d)\n Enter Choice: ");
                        char loanChoice = Character.toLowerCase(scnr.next().charAt(0));

                        switch(loanChoice){
                            // Student Loan
                            case 'a':
                                loans[loanID] = new Loan(userLoanName, 0, 2.75, userLoanRequestedAmount);
                                break;

                            // Mortgage
                            case 'b':
                                System.out.print("Would you like a 15 year or 30 year term?\nEnter Choice: ");
                                int termChoice = scnr.nextInt();

                                // checks if user chose a valid option
                                if(termChoice != 15 || termChoice != 30){
                                    System.out.println("Invalid Choice");
                                    break;
                                }

                                loans[loanID] = new Loan(userLoanName, termChoice, 2.81, userLoanRequestedAmount);
                                break;

                            // Personal Loan
                            case 'c':
                                loans[loanID] = new Loan(userLoanName, 24, 9.34, userLoanRequestedAmount);
                                break;
                            
                            // Auto Loan
                            case 'd':
                                loans[loanID] = new Loan(userLoanName, 48, 4.98, userLoanRequestedAmount);
                                break;

                            default:
                                System.out.print("Invalid option please try again.\n Enter Choice: ");
                                break;

                        }
                    }
                    break;
                
                // frequently asked questions
                case 'g':
                  
                    while(!quit){
                        System.out.println("\nWhat would you like to know?\n"); // added \n
                        Questions questions = new Questions();
                        questions.viewQuestions();
                        char questionChoice = Character.toLowerCase(scnr.next().charAt(0));
                        
                        switch(questionChoice){
                              case 'a':
                                  questions.viewAnswerA();
                                  break;
                              case 'b':
                                  questions.viewAnswerB();
                                  break;
                              case 'c':
                                  questions.viewAnswerC();
                                  break;
                              case 'd':
                                  questions.viewAnswerD();
                                  break;
                              case 'e':
                                  questions.viewAnswerE();
                                  break;
                              case 'f':
                                  quit = true;
                                  break;
                                  
                              default:
                                  System.out.println("Try Again");
                        }
                    }
                    break;
                    
                // default for invalid options
                default:
                    System.out.println("Invalid Response: ");
            }
        }
    }

    public static void menu(){
        System.out.println("What would you like to do?\n");
        System.out.println("a - Create Account");
        System.out.println("b - View Accounts");
        System.out.println("c - Deposit");
        System.out.println("d - Withdraw");
        System.out.println("e - Transfer");
        System.out.println("f - Apply for Loan");
        System.out.println("g - Frequently Asked Questions");
        System.out.println("h - Quit");
    }
    
}

