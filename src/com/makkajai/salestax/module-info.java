module SalesTaxCalculator {
	exports test.java.com.makkajai.salestax;

	requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;

    exports com.makkajai.salestax; 
    opens com.makkajai.salestax to org.junit.platform.commons;
}