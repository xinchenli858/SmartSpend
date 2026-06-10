import java.util.Scanner;
import java.util.ArrayList;
/**
 * Main Controller Class for the SmartSpend Application.
 */
public class FinanceController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Welcome to SmartSpend ===");
        
        // 1. Get the user's total monthly savings goal
        System.out.print("Enter your monthly savings goal ($): ");
        double goal = scanner.nextDouble();
        UserWallet wallet = new UserWallet(goal);
        
        ArrayList<Transaction> history = new ArrayList<>();
        ArrayList<BudgetCategory> categories = new ArrayList<>();
        
        // 2. Category Setup
        System.out.print("How many budget categories do you want to create for this month? ");
        int numCategories = scanner.nextInt();
        
        for (int i = 0; i < numCategories; i++) {
            System.out.println("Setting up Category #" + (i + 1) + ":");
            System.out.print("Enter category name (e.g., Food, Furniture): ");
            String catName = scanner.next();
            
            System.out.print("Enter budget limit for " + catName + " ($): ");
            double catLimit = scanner.nextDouble();
            
            categories.add(new BudgetCategory(catName, catLimit));
        }
        System.out.println();
        System.out.println("Successfully set up all categories!");
        
        // 3. Menu
        boolean running = true;
        double totalExpensesCounter = 0.0;
        
        while (running) {
            System.out.println("--- MAIN MENU ---");
            System.out.println("1. Add Income / Savings");
            System.out.println("2. Log an Expense");
            System.out.println("3. Generate Master Financial Table");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                // Add Income
                System.out.print("Enter income amount ($): ");
                double amount = scanner.nextDouble();
                wallet.addIncome(amount);
                history.add(new Transaction(amount, "Income", true));
                System.out.println("Success! Income added.");
                
            } else if (choice == 2) {
                // Log Expense
                if (categories.isEmpty()) {
                    System.out.println("No categories available!");
                    continue;
                }
                
                System.out.println("Choose Category:");
                for (int i = 0; i < categories.size(); i++) {
                    System.out.println((i + 1) + ". " + categories.get(i).getName());
                }
                System.out.print("Category selection: ");
                int catChoice = scanner.nextInt() - 1;
                
                if (catChoice >= 0 && catChoice < categories.size()) {
                    BudgetCategory selectedCat = categories.get(catChoice);
                    System.out.print("Enter expense amount ($): ");
                    double amount = scanner.nextDouble();
                    
                    wallet.deductExpense(amount);
                    selectedCat.spend(amount);
                    totalExpensesCounter += amount;
                    history.add(new Transaction(amount, selectedCat.getName(), false));
                    
                    System.out.println("Expense logged successfully!");
                    System.out.println("Status Alert: [" + selectedCat.getStatusAlert() + "]");
                } else {
                    System.out.println("Invalid category selection!");
                }
                
            } else if (choice == 3) {
                // Generate Master Financial Table
                System.out.println();
                System.out.println("=======================================================================");
                System.out.println("                       MASTER FINANCIAL REPORT                         ");
                System.out.println("=======================================================================");
                System.out.printf("%-15s %-12s %-12s %-15s %-10s\n", "Category", "Budget", "Spent", "Remaining", "Status");
                System.out.println("-----------------------------------------------------------------------");
                
                for (int i = 0; i < categories.size(); i++) 
                {
                    BudgetCategory cat = categories.get(i);
                    System.out.printf("%-15s $%-11.2f $%-11.2f $%-14.2f %-10s\n", cat.getName(), cat.getAllocatedBudget(), cat.getMoneySpent(), cat.getRemainingBalance(), cat.getStatusAlert());
                }
                
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("                      TOTAL SAVINGS & WEALTH PROGRESS                  ");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Total Money Earned (Income):  $" + wallet.getTotalIncome());
                System.out.println("Total Money Spent (Expenses): $" + totalExpensesCounter);
                System.out.println("Current Net Wealth (Balance): $" + wallet.getTotalBalance());
                System.out.println("Your Target Savings Goal:     $" + wallet.getSavingsGoal());
                System.out.println("-----------------------------------------------------------------------");
                
                if (wallet.getTotalBalance() >= wallet.getSavingsGoal()) {
                    double surplus = wallet.getTotalBalance() - wallet.getSavingsGoal();
                    System.out.println("Goal Status: [ GOAL ACHIEVED! You have $" + surplus + " extra ]");
                } else {
                    double shortBy = wallet.getSavingsGoal() - wallet.getTotalBalance();
                    System.out.println("Goal Status: [ PROGRESSING - You need $" + shortBy + " more ]");
                }
                System.out.println("=======================================================================");
                
            } else if (choice == 4) {
                System.out.println("Thank you for using SmartSpend. Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}