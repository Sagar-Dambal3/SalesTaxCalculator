package test.java.com.makkajai.salestax;

import org.junit.jupiter.api.Test;

import com.makkajai.salestax.Item;
import com.makkajai.salestax.TaxCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the TaxCalculator class.
 */
public class TaxCalculatorTest {

    @Test
    public void testBasicTax() {
        // Test basic tax calculation for a taxable item
        Item item = new Item("music CD", 14.99, 1, false, false);
        double tax = TaxCalculator.calculateTax(item);
        assertEquals(1.50, tax, 0.01);
    }

    @Test
    public void testNoTaxOnExemptedItem() {
        // Test no tax for an exempted item
        Item item = new Item("book", 12.49, 1, false, true);
        double tax = TaxCalculator.calculateTax(item);
        assertEquals(0.00, tax, 0.01);
    }

    @Test
    public void testImportTax() {
        // Test import tax calculation for an imported item
        Item item = new Item("imported bottle of perfume", 47.50, 1, true, false);
        double tax = TaxCalculator.calculateTax(item);
        assertEquals(7.15, tax, 0.01);
    }
}

