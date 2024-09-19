package com.makkajai.salestax;

/**
 * The main entry point for the Sales Tax Calculator application.
 * It demonstrates how to use the core classes to calculate taxes and print receipts.
 */
public class Main {
    public static void main(String[] args) {
        // Example Input 1
        Receipt receipt1 = new Receipt();
        receipt1.addItem(new Item("book", 12.49, 1, false, true)); // Exempt item (book)
        receipt1.addItem(new Item("music CD", 14.99, 1, false, false)); // Taxable item (music CD)
        receipt1.addItem(new Item("chocolate bar", 0.85, 1, false, true)); // Exempt item (chocolate)

        System.out.println("Output 1:");
        ReceiptFormatter.printReceipt(receipt1); // Print the receipt

        // Example Input 2
        Receipt receipt2 = new Receipt();
        receipt2.addItem(new Item("imported box of chocolates", 10.00, 1, true, true)); // Exempt and imported item
        receipt2.addItem(new Item("imported bottle of perfume", 47.50, 1, true, false)); // Imported and taxable item

        System.out.println("\nOutput 2:");
        ReceiptFormatter.printReceipt(receipt2);

        // Example Input 3
        Receipt receipt3 = new Receipt();
        receipt3.addItem(new Item("imported bottle of perfume", 27.99, 1, true, false)); // Imported and taxable item
        receipt3.addItem(new Item("bottle of perfume", 18.99, 1, false, false)); // Taxable item
        receipt3.addItem(new Item("packet of headache pills", 9.75, 1, false, true)); // Exempt item (medicine)
        receipt3.addItem(new Item("box of imported chocolates", 11.25, 1, true, true)); // Exempt and imported item

        System.out.println("\nOutput 3:");
        ReceiptFormatter.printReceipt(receipt3); // Print the receipt
    }
}
