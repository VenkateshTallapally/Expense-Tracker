package service;

import model.Expense;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseService {

    private ArrayList<Expense> expenses = new ArrayList<>();

    // Add Expense
    public void addExpense(int id, String title, double amount,
                           String category, LocalDate date,
                           String description) {

        Expense expense = new Expense(id, title, amount, category, date, description);
        expenses.add(expense);

        System.out.println("Expense added successfully!");
    }

    // View Expenses
    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.printf("%-5s %-15s %-10s %-15s %-12s %-20s%n",
                "ID", "Title", "Amount", "Category", "Date", "Description");

        System.out.println("--------------------------------------------------------------------------");

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // Search Expense
    public void searchExpense(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {
                System.out.println("Expense Found:");
                System.out.println(expense);
                return;
            }
        }

        System.out.println("Expense not found.");
    }

    // Delete Expense
    public void deleteExpense(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {
                expenses.remove(expense);
                System.out.println("Expense deleted successfully.");
                return;
            }
        }

        System.out.println("Expense not found.");
    }

    // Update Expense
    public void updateExpense(int id, String title,
                              double amount,
                              String category,
                              LocalDate date,
                              String description) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                expense.setTitle(title);
                expense.setAmount(amount);
                expense.setCategory(category);
                expense.setDate(date);
                expense.setDescription(description);

                System.out.println("Expense updated successfully.");
                return;
            }
        }

        System.out.println("Expense not found.");
    }

    // Total Expense
    public void totalExpense() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        System.out.println("Total Expense = ₹" + total);
    }

    // Getter (used later for saving/loading)
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    // Setter (used later for loading data)
    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
}