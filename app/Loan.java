public class Loan {
   private String loanType;
   private double interestRate;
   private double loanAmount;
   
   public void viewLoans() {
      System.out.println("(a) Personal Loan");
      System.out.println("(b) Auto Loan");
      System.out.println("(c) Student Loan");
      System.out.println("(d) Mortgage Loan");
      System.out.println("(e) Quit");
   }
   
   public void setLoanType (String loanType) {
      this.setLoanType = loanType
   }
   
   public String getLoanType() {
      return loanType;
   }
   
   public void setInterestRate (double interestRate) {
      this.setInterestRate = interestRate
   }
   
   public double getInterestRate() {
      return interestRate;
   }
   
   public void setLoanAmount (double loanAmount) {
      this.setLoanAmount = loanAmount
   }
   
   public double getLoanAmount() {
      return loanAmount;
   }
}
