package com.makkajai.salestax;

/**
 * Handles formatting and printing the receipt.
 * Separates I/O logic from the core business logic.
 */
public class ReceiptFormatter {

    /**
     * Prints the formatted receipt details to the console.
     * 
     * @param receipt The receipt object containing items and their details.
     */
    public static void printReceipt(Receipt receipt) {
        // Loop through each item in the receipt and print details
        for (Item item : receipt.getItems()) {
            double itemTax = TaxCalculator.calculateTax(item); // Calculate tax for each item
            double itemPriceWithTax = item.getPrice() + itemTax; // Get price with tax
            System.out.println(item.getQuantity() + " " + item.getName() + ": " + String.format("%.2f", itemPriceWithTax)); // Print item and price
        }

        // Print total sales tax and total price
        System.out.printf("Sales Taxes: %.2f%n", receipt.getTotalSalesTax());
        System.out.printf("Total: %.2f%n", receipt.getTotalPrice());
    }
}

