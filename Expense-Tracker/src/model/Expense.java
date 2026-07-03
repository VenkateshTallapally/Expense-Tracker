package model;

import java.time.LocalDate;

public class Expense {
    private int id;
    private String title;
    private double amount;
    private String category;
    private LocalDate date;
    private String description;

    // Constructor
    public Expense(int id, String title, double amount, String category,
                   LocalDate date, String description) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "%-5d %-15s %-10.2f %-15s %-12s %-20s",
                id, title, amount, category, date, description
        );
    }
}