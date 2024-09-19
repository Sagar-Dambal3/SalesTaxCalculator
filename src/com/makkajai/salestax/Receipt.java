package com.makkajai.salestax;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a receipt for a shopping basket.
 * It holds a list of items, and calculates the total sales tax and total price.
 */
public class Receipt {
    private List<Item> items;   // List of items in the receipt
    private double totalSalesTax; // Total sales tax for all items
    private double totalPrice;    // Total price for all items including tax

    /**
     * Initializes a new empty receipt.
     */
    public Receipt() {
        this.items = new ArrayList<>();
        this.totalSalesTax = 0;
        this.totalPrice = 0;
    }

    /**
     * Adds an item to the receipt, updates total sales tax and total price.
     * 
     * @param item The item to be added to the receipt.
     */
    public void addItem(Item item) {
        double itemTax = TaxCalculator.calculateTax(item); // Calculate the tax for the item
        double itemPriceWithTax = item.getPrice() + itemTax; // Calculate price with tax

        this.items.add(item); // Add the item to the list
        this.totalSalesTax += itemTax; // Update total sales tax
        this.totalPrice += itemPriceWithTax; // Update total price
    }

    // Getters for total sales tax, total price, and the list of items

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }
}

