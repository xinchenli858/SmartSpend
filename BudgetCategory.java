
/**
 * This class manages the budget, spending, and alerts for a specific category.
 */
public class BudgetCategory
{
    private String name;
    private double allocatedBudget;
    private double moneySpent;

    public BudgetCategory(String name, double allocatedBudget) 
    {
        this.name = name;
        this.allocatedBudget = allocatedBudget;
        this.moneySpent = 0.0;
    }

    public void spend(double amount) 
    {
        this.moneySpent += amount;
    }
    
    public double getRemainingBalance() 
    {
        return this.allocatedBudget - this.moneySpent;
    }
    
    public String getStatusAlert() 
    {
        if (allocatedBudget == 0) 
        {
            return "No Limit";
        }
        
        double remaining = getRemainingBalance();
        
        if (remaining <= 0) 
        {
            return "!! DEPLETED !!";
        } else if (remaining <= (allocatedBudget * 0.2)) 
        {
            return "!! NEAR LIMIT !!";
        } else 
        {
            return "NORMAL";
        }
    }
    
    public String getName() 
    {
        return name;
    }

    public double getAllocatedBudget() 
    {
        return allocatedBudget;
    }

    public double getMoneySpent() 
    {
        return moneySpent;
    }
}