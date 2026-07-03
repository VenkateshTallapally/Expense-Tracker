package main;

import model.Expense;
import service.ExpenseService;
import util.FileManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        String fileName = "src/expenses.csv";

        // Load existing expenses
        ArrayList<Expense> expenses = FileManager.loadExpenses(fileName);
        service.setExpenses(expenses);

        int choice;

        do {
            System.out.println("\n========== Expense Tracker ==========");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Total Expense");
            System.out.println("7. Save Expenses");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    service.addExpense(
                            id,
                            title,
                            amount,
                            category,
                            LocalDate.now(),
                            description
                    );
                    break;

                case 2:
                    service.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter Expense ID: ");
                    service.searchExpense(sc.nextInt());
                    break;

                case 4:

                    System.out.print("Enter Expense ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter New Description: ");
                    String newDescription = sc.nextLine();

                    service.updateExpense(
                            updateId,
                            newTitle,
                            newAmount,
                            newCategory,
                            LocalDate.now(),
                            newDescription
                    );

                    break;

                case 5:
                    System.out.print("Enter Expense ID: ");
                    service.deleteExpense(sc.nextInt());
                    break;

                case 6:
                    service.totalExpense();
                    break;

                case 7:
                    FileManager.saveExpenses(service.getExpenses(), fileName);
                    break;

                case 8:
                    FileManager.saveExpenses(service.getExpenses(), fileName);
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}