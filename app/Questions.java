public class Questions {
  
   public void viewQuestions() {
      System.out.println("(a) How do I create an account?");
      System.out.println("(b) How do I view created accounts?");
      System.out.println("(c) How do I deposit, withdraw, or transfer funds?");
      System.out.println("(d) Are there any fees I should know about?");
      System.out.println("(e) How do you apply for a loan?");
      System.out.println("(f) Quit");
   }
   
   public void viewAnswerA() {
      System.out.println("Type 'a' into the main menu and follow the instructions to enter in name, type, and deposit amount.");
   }
   
   public void viewAnswerB() {
      System.out.println("Type 'b' into the main menu to view accounts.");
   }

   public void viewAnswerC() {
      System.out.println("Type 'c' for deposit, 'd' for withdraw, or 'e' for transfer in the main menu. Follow the instructions given.");
   }

   public void viewAnswerD() {
      System.out.println("Currently, our bank offers no fees.");
   }

   public void viewAnswerE() {
      System.out.println("To apply for a loan, type 'f' into the main menu and follow the given instructions to enter your credit score, choose loan type, and choose loan amount.");
   }     
}
