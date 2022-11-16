package vn.funix.ducntfx18862.java.asm03.Test;

import org.junit.Test;
import vn.funix.ducntfx18862.java.asm02.models.Account;
import vn.funix.ducntfx18862.java.asm02.models.Customer;
import vn.funix.ducntfx18862.java.asm03.models.DigitalCustomer;

import static org.junit.Assert.*;

public class DigitalCustomerTest {
    private DigitalCustomer newCustomer;

    // Set up information
    @org.junit.Before
    public void setup(){
        newCustomer = new DigitalCustomer("Lux", "001099123456");
        Account account1 = new Account("123456", 10000000, "Unknown");
        newCustomer.getAccounts().add(account1);

    }

    // Test function check account is existed or not
    @org.junit.Test
    public void isAccountExisted() {
        Account account2 = new Account("123456", 10000000, "Unknown");
        assertTrue(newCustomer.isAccountExisted(account2));
    }

    // Test function find account by number Account
    @Test
    public void getAccountByNumberAccount() {
        Account account3 = new Account("123789", 10000000, "Unknown");
        newCustomer.getAccountsDigital().add(account3);
        assertEquals(account3, newCustomer.getAccountByNumberAccount("123789"));
    }
}