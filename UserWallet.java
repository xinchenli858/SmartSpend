
/**
 * This class tracks total wealth and the user's savings goal.
 */
public class UserWallet 
{
    private double totalBalance;
    private double savingsGoal;
    private double totalIncome;
    
    
    public UserWallet(double savingsGoal) 
    {
        this.savingsGoal = savingsGoal;
        this.totalBalance = 0.0;
        this.totalIncome = 0.0;
    }

    public void addIncome(double amount) 
    {
        this.totalBalance += amount;
        this.totalIncome += amount;
    }
    
    public void deductExpense(double amount) 
    {
        this.totalBalance -= amount;
    }
    
    public double getSavingsProgress() 
    {
        return this.totalBalance;
    }
    
    public double getTotalBalance() 
    {
        return totalBalance;
    }

    public double getSavingsGoal() 
    {
        return savingsGoal;
    }

    public double getTotalIncome() 
    {
        return totalIncome;
    }
}