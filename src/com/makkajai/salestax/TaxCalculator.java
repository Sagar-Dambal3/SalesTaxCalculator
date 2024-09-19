package com.makkajai.salestax;

/**
 * Utility class that calculates the tax for a given item.
 */
public class TaxCalculator {

    /**
     * Calculates the total tax (basic + import) for a given item.
     * 
     * @param item The item for which tax is to be calculated.
     * @return The total tax applicable for the item.
     */
    public static double calculateTax(Item item) {
        double tax = 0;

        // Apply basic sales tax if the item is not exempt
        if (!item.isExempt()) {
            tax += roundUpToNearestFiveCents(item.getPrice() * 0.10);
        }

        // Apply import duty if the item is imported
        if (item.isImported()) {
            tax += roundUpToNearestFiveCents(item.getPrice() * 0.05);
        }

        return tax;
    }

    /**
     * Rounds up the tax amount to the nearest 0.05.
     * 
     * @param amount The raw tax amount.
     * @return The tax amount rounded up to the nearest 0.05.
     */
    private static double roundUpToNearestFiveCents(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
