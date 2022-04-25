public class Loan {
   private String loanName;
   private int loanTerm;
   private double loanAmount, APR, totalLoan, monthlyPayment;

   Loan(String name, int term, double apr, double amount){
      this.loanName = name;
      this.loanTerm = term;
      this.APR = apr;
      this.loanAmount = amount;
   }

   public String getLoanName(){
      return loanName;
   }

   public double getAPR(){
      return APR;
   }

   public int getTerm(){
      return loanTerm;
   }

   public double getLoanAmount(){
      return loanAmount;
   }

   public void setMonthlyPayment(){
      this.monthlyPayment = getTotalLoan() / 12;
   }

   public double getMonthlyPayment(){
      return monthlyPayment;
   }
   
   public void setTotalLoan(){
      if(APR == 0){
         this.totalLoan = loanAmount;
      }
      this.totalLoan = loanAmount + (loanAmount * (APR * 100));
   }

   public double getTotalLoan(){
      return totalLoan;
   }

   public void display(){

   }
}
