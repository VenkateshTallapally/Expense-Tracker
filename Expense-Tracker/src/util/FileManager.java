package util;

import model.Expense;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {

    // Save expenses to CSV file
    public static void saveExpenses(ArrayList<Expense> expenses, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Expense expense : expenses) {

                writer.write(
                        expense.getId() + "," +
                        expense.getTitle() + "," +
                        expense.getAmount() + "," +
                        expense.getCategory() + "," +
                        expense.getDate() + "," +
                        expense.getDescription()
                );

                writer.newLine();
            }

            System.out.println("Expenses saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    // Load expenses from CSV file
    public static ArrayList<Expense> loadExpenses(String fileName) {

        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(fileName);

        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Expense expense = new Expense(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3],
                        LocalDate.parse(data[4]),
                        data[5]
                );

                expenses.add(expense);
            }

        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }

        return expenses;
    }
}