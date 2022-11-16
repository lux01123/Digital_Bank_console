package vn.funix.ducntfx18862.java.asm03.Test;

import org.junit.Test;
import vn.funix.ducntfx18862.java.asm02.models.Account;
import vn.funix.ducntfx18862.java.asm02.models.Customer;

import static org.junit.Assert.*;

public class CustomerTest {
    public Customer customer;
    // Set up info
    @org.junit.Before
    public void setup(){
        customer = new Customer("Lux", "001099123456");
        Account account1 = new Account("123456", 10000000, "Unknown");
        customer.getAccounts().add(account1);
        Account account2 = new Account("123789", 5000000, "Unknown");
        customer.getAccounts().add(account2);
    }

    // Test customer is Premium or not
    @Test
    public void isPremium() {
        assertTrue(customer.isPremium());
    }

    // Test function calculate sum of all balance
    @Test
    public void getBalance() {
        assertEquals(15000000, customer.getBalance(), 0.1);
    }
}