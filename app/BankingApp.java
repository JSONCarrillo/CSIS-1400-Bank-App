// Name: Jason Carrillo
// Class: CSIS-1400
// Assignment: BankingApp (Team Project)

import java.util.Scanner;
import java.util.ArrayList;

public class BankingApp {
    public static void main(String arg[]){
        Scanner scnr = new Scanner(System.in);
        double userLoanRequestedAmount;
        boolean hasChecking, hasSavings, hasLoan1, hasLoan2, hasLoan3, hasLoan4, quit;
        char choice;
        int i, openLoans, userCreditScore;
        openLoans = 0;
        hasChecking = hasSavings = quit = hasLoan1 = hasLoan2 = hasLoan3 = hasLoan4 = false;

        //Accounts array list
        ArrayList<Account> accounts = new ArrayList<Account>();

        // Array for loan class
        Loan[] loans;
        
        //loan array can have up to 4 loans
        loans = new Loan[4];
        
        
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
                case 'g':
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
                                    System.out.println("You already have a Savings account");
                                    quit = true;
                                    break;
                                }
                                
                                Account savings = new Account();
                                savings.setAccountName("Savings");
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
                    for(i = 0; i < loans.length; i++){
                        if(loans[i] != null){
                            loans[i].display();
                        }
                    }
                    break;
                
                // Deposit
                case 'c':
                    if(hasChecking == true || hasSavings == true){
                        System.out.println("Choose what account to deposit to.");

                        for(i = 0; i < accounts.size();i++ ){
                            System.out.printf("\nChoice (%d)", i);
                            accounts.get(i).display();
                            System.out.println();
                        }

                        System.out.print("\nChoose account: ");
                        int accountChoice = scnr.nextInt();

                        System.out.print("\nHow much to deposit?: ");
                        accounts.get(accountChoice).setBalance(accounts.get(accountChoice).getBalance() + scnr.nextDouble());
                        accounts.get(accountChoice).display();
                        break;
                    }

                    System.out.println("ERROR: no accounts!");

                    break;
                    
                // Withdraw
                case 'd':
                    if(hasChecking == true || hasSavings == true){
                        System.out.println("Choose what account to withdraw from.");

                        for(i = 0; i < accounts.size();i++ ){
                            System.out.printf("\nChoice (%d)", i);
                            accounts.get(i).display();
                            System.out.println();
                        }

                        System.out.print("\nChoose account: ");
                        int accountChoice = scnr.nextInt();

                        System.out.print("\nHow much to withdraw?: ");
                        accounts.get(accountChoice).setBalance(accounts.get(accountChoice).getBalance() - scnr.nextDouble());
                        accounts.get(accountChoice).display();
                        break;
                    }

                    System.out.println("ERROR: no accounts!");

                    break;
                    
                // apply for loan
                case 'e':
                    if(loans.length == 6){
                        System.out.print("You have the max allowed loans");
                        break;
                    };

                    System.out.print("\nHow much were you looking to apply for? ");
                    userLoanRequestedAmount = scnr.nextDouble();
                    System.out.print("\nWhat is your credit score? ");
                    userCreditScore = scnr.nextInt();

                    if(userCreditScore < 650 && userLoanRequestedAmount > 35000.00){
                        System.out.println("Sorry, your credit score is too low for that amount");
                        break;
                    }

                    System.out.print("Name this loan: ");
                    scnr.nextLine();
                    String userLoanName = scnr.nextLine();

                    while(!quit){
                        System.out.print("\nWhat is your loan type?\n\nStudent Loan (a)\nMortgage (b)\nPersonal Loan (c)\nAuto Loan (d)\nEnter Choice: ");
                        char loanChoice = Character.toLowerCase(scnr.next().charAt(0));

                        switch(loanChoice){
                            // Student Loan
                            case 'a':
                                if(hasLoan1){
                                    System.out.println("You already have a Student Loan!");
                                    break;
                                }
                                loans[0] = new Loan(userLoanName, 120, 2.75, userLoanRequestedAmount);
                                loans[0].setTotalLoan();
                                loans[0].setMonthlyPayment();
                                loans[0].display();

                                openLoans++;
                                hasLoan1 = true;
                                quit = true;
                                break;

                            // Mortgage
                            case 'b':
                                if(hasLoan2){
                                    System.out.println("You already have a Mortgage");
                                    break;
                                }
                                System.out.print("Would you like a 15 year or 30 year term?\nEnter Choice: ");
                                int termChoice = scnr.nextInt();

                                // checks if user chose a valid option
                                if(termChoice == 15 || termChoice == 30){
                                    loans[1] = new Loan(userLoanName, (termChoice * 12), 2.81, userLoanRequestedAmount);
                                    loans[1].setTotalLoan();
                                    loans[1].setMonthlyPayment();
                                    loans[1].display();
    
                                    openLoans++;
                                    hasLoan2 = true;
                                    quit = true;
                                    break;
                                }
                                
                                System.out.println(termChoice == 30);
                                System.out.println("\nInvalid Choice");
                                break;

                            // Personal Loan
                            case 'c':
                                if(hasLoan3){
                                    System.out.println("You already have a Student Loan!");
                                    break;
                                }
                                loans[2] = new Loan(userLoanName, 24, 9.34, userLoanRequestedAmount);
                                loans[2].setTotalLoan();
                                loans[2].setMonthlyPayment();
                                loans[2].display();

                                openLoans++;
                                hasLoan3 = true;
                                quit = true;
                                break;
                            
                            // Auto Loan
                            case 'd':
                                if(hasLoan4){
                                    System.out.println("You already have a Student Loan!");
                                    break;
                                }
                                loans[3] = new Loan(userLoanName, 48, 4.98, userLoanRequestedAmount);
                                loans[3].setTotalLoan();
                                loans[3].setMonthlyPayment();
                                loans[3].display();

                                openLoans++;
                                hasLoan4 = true;
                                quit = true;
                                break;

                            default:
                                System.out.print("Invalid option please try again.\n Enter Choice: ");
                                break;

                        }
                    }
                    break;
                
                // frequently asked questions
                case 'f':
                  
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
        System.out.println("e - Apply for Loan");
        System.out.println("f - Frequently Asked Questions");
        System.out.println("g - Quit");
    }
    
}