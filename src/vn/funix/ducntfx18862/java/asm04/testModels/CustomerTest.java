package vn.funix.ducntfx18862.java.asm04.testModels;

import org.junit.Test;
import vn.funix.ducntfx18862.java.asm04.models.Account;
import vn.funix.ducntfx18862.java.asm04.models.Customer;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer newCustomer;

    @org.junit.Before
    public void setup(){
        newCustomer = new Customer("Lux", "001097123456");
    }
    @Test
    public void isAccountExisted() {
        Account account2 = new Account("123456", 10000000, "Unknown", "001099123456");
        assertTrue(newCustomer.isAccountExisted(account2));
    }
    @Test
    public void isPremium() {
        assertFalse(newCustomer.isPremium());
    }
}