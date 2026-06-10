# SmartSpend
A Java-based personal finance tracking system that helps users manage income, expenses, and custom budgets with real-time financial reports and spending alerts.

Unlike simple expense trackers, SmartSpend simulates a real financial system by allowing users to create custom budget categories, monitor spending behavior in real time, and receive automatic financial status alerts.

---

## Key Features

### Income & Expense Tracking
- Record income and expenses in real time
- Automatically update total balance after each transaction

### Custom Budget Categories
- Users can create personalized spending categories (e.g., Food, Entertainment, Shopping)
- Each category has its own budget limit and tracking system

### Smart Spending Alerts
- NORMAL: Spending is within budget
- NEAR LIMIT: Approaching budget limit
- DEPLETED: Budget exceeded

### Financial Report System
- Generates a full summary report including:
  - Category-wise spending
  - Remaining budget
  - Total income and expenses
  - Overall savings progress

---

## Project Structure (OOP Design)

This project is built using object-oriented programming principles with four main classes:

### 1. FinanceController
Controls the entire program flow, handles user input, and connects all components.

### 2. UserWallet
Tracks total balance, income, and savings goal.

### 3. BudgetCategory
Manages individual spending categories and budget limits.

### 4. Transaction
Represents each financial record (income or expense).

---

## How It Works

1. User sets a monthly savings goal
2. User creates custom budget categories
3. User selects actions from the main menu:
   - Add income
   - Log expenses
   - View financial report
4. System updates balances and displays real-time alerts
