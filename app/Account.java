public class Account{
    private String accountName;
    private double accountBalance, apr;
    private boolean isSavings;

    // setters
    public void setAccountName(String name){
        this.accountName = name;
    }

    public void setAccountType(boolean savings){
        this.isSavings = savings;
    }

    public void setBalance(double amount){
        this.accountBalance = Math.round(amount * 100.0) / 100.0;
    }

    public void setAPR(double rate){
        this.apr = Math.round(rate * 100.0) / 100.0;
    }

    // getters
    public String getAccountName(){
        return accountName;
    }
    public boolean getAccountType(){
        return isSavings;
    }
    public double getBalance(){
        return accountBalance;
    }
    public double getAPR(){
        return apr;
    }

    public void display(){
        System.out.printf("Account: %s\nAPR: %.2f percent \nCurrent Balance: %.2f\n\n", accountName, apr, accountBalance);
     }
}
