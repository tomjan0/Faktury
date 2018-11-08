package mypackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceTest {
    private Invoice invoice;

    @Before
    public void setUp() throws Exception {
        invoice = new Invoice(new Customer("1234567890", "aa", "bb", "123456789"), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addEntry() {
        invoice.addEntry(new Article(12,"aa",12), 0);
    }

    @Test
    public void show() {
        assertNotNull(invoice.getEntryList());
    }
}