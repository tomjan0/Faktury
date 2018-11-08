package mypackage;

import org.junit.Test;

public class CustomerTest {

    @Test(expected = IllegalArgumentException.class)
    public void nipExceptionCheck() {
        new Customer("1111", "ex", "ex", "123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void phoneExceptionCheck() {
        new Customer("1234567890", "ex", "ex", "1234567");
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyExceptionCheck() {
        new Customer("1234567890", "ex", "", "123456789");
    }

    @Test
    public void correctCheck() {
        new Customer("1234567890", "ex", "ex", "123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getInvoiceNegativeId(){
        new Customer("1234567890", "a", "a", "123456789").getInvoice(-12);
    }
}