package vn.funix.ducntfx18862.java.asm03.Test;

import org.junit.Test;
import vn.funix.ducntfx18862.java.asm02.models.Customer;
import vn.funix.ducntfx18862.java.asm03.models.DigitalBank;
import vn.funix.ducntfx18862.java.asm03.models.DigitalCustomer;

import static org.junit.Assert.*;

public class DigitalBankTest {
    private DigitalBank newBank;
    private Customer newCustomer;

    @org.junit.Before
    public void setup(){
        newBank = new DigitalBank();
        newCustomer = new Customer("Lux", "001099123456");
//        newBank.addCustomer(CUSTOMER_NAME, CUSTOMER_ID);
        newBank.addCustomer(newCustomer);
    }

    @org.junit.Test
    public void getCustomerById() {
        assertEquals(newCustomer, newBank.getCustomerById("001099123456"));
    }

    @org.junit.Test
    public void isCustomerExisted() {
        assertTrue(newBank.isCustomerExisted(newCustomer));
    }

    @org.junit.Test
    public void validateCustomerId() {
        assertTrue(newBank.validateCustomerId("001099123456"));
    }
}