/**
 * activity 1.
 * @author Don Travo 
 * @ version 18 August 2020 
 * gets bank loan info and returns amount and number of loans.
 */

public class BankLoan {
	/**
      * gets loan amount, name, returns balance. 
      * @param args Command line arguments – not used.
      */
   private static final int MAX_LOAN_AMOUNT = 100000;
   private static int loansCreated = 0;

   
   private String customerName;
   private double balance, interestRate;
   
 /**
      * @param customerNameIn customerNameIn
      * @param interestRateIn interestRateIn
      * increments count
      */
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }
/**
      * gets amount.
      * @param amount amount.
      * @return wasLoanMade 
      */  
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }
/**
      * gets amountPaid.
      * @param amountPaid amountPaid.
      * @return balance. 
      */  
   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
   /**
      * @param getBalance
      * @return balance
      */
   public double getBalance() {
      return balance;
   }
   /**
      * gets interestRate.
      * @param interestRateIn interestRateIn.
      * @return true if interestRate is greater than 0 and less than 1.
      */  
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      * @param getInterestRate
      * @return interestRate
      */
   public double getInterestRate() {
      return interestRate;
   }
   /**
      * calculates interest.
      */
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }
   /**
      * gets amount.
      * @param amount amount.
      * @return true if amount is greater than 0.
      */  
   public static boolean isAmountValid(double amount) {
      return (amount >= 0.0);  
   }
   /**
      * gets laon.
      * @param loan loan.
      * @return true if loan is greater than 0.
      */  
   public static boolean isInDebt(BankLoan loan) { 
      if (loan.getBalance() > 0) {
         return true;
      }
      return false;
   }
   
      
     /**
      * @return loansCreated
      */
   public static int getLoansCreated() {
      return loansCreated;
   }
    /**
      * returns count to zero.
      */
   public static void resetLoansCreated() {
      loansCreated = 0;
   }
      
   /**
      * sends to string output of information.
      * @return Command line arguments .
      */ 
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }

}
