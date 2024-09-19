package com.makkajai.salestax;

/**
 * Represents an item in the shopping basket.
 */
public class Item {
    private String name;      // Name of the item
    private double price;     // Base price of the item before tax
    private int quantity;
    private boolean isImported; // Indicates if the item is imported
    private boolean isExempt;   // Indicates if the item is exempt from basic tax

    /**
     * Constructor to initialize the item details.
     * 
     * @param name        Name of the item.
     * @param price       Base price of the item.
     * @param isImported  Indicates if the item is imported.
     * @param isExempt    Indicates if the item is exempt from basic sales tax.
     */
    public Item(String name, double price, int quantity, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    // Getters for the item attributes

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }
}
