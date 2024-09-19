package com.makkajai.salestax;

import java.util.Scanner;

/**
 * Main class to run the Sales Tax Calculator application.
 * Takes input from the user, processes the receipt, and prints the output.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Input scanner

        Receipt receipt = new Receipt(); // New receipt instance

        System.out.println("Enter the items (type 'done' to finish):");

        while (true) {
            System.out.print("Enter item description (e.g. '1 book at 12.49'): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break; // End input on 'done'
            }

            // Parse the input line to extract item details
            String[] parts = input.split(" at ");
            if (parts.length != 2) {
                System.out.println("Invalid input format. Please try again.");
                continue;
            }

            // Extracting quantity, name, and price
            String itemDescription = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());
            String[] descriptionParts = itemDescription.split(" ", 2);
            int quantity = Integer.parseInt(descriptionParts[0]);
            String name = descriptionParts[1];

            // Check if the item is imported
            boolean isImported = name.contains("imported");

            // Check if the item is tax-exempt (books, food, or medical products)
            boolean isExempt = isExemptItem(name);

            // Create a new Item and add it to the receipt
            Item item = new Item(name, price, quantity, isImported, isExempt);
            receipt.addItem(item);
        }

        // Print the formatted receipt
        ReceiptFormatter.printReceipt(receipt);

        scanner.close();
    }

    /**
     * Determines if an item is exempt from basic sales tax.
     * 
     * @param itemName The name of the item.
     * @return true if the item is exempt, false otherwise.
     */
    private static boolean isExemptItem(String itemName) {
        String[] exemptItems = { "book", "chocolate", "pills" };
        for (String exempt : exemptItems) {
            if (itemName.contains(exempt)) {
                return true; // The item is exempt
            }
        }
        return false;
    }
}
