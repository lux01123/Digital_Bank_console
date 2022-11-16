package vn.funix.ducntfx18862.java.asm03.Test;

import org.junit.Test;
import vn.funix.ducntfx18862.java.asm02.models.Account;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;
    // Set up information
    @org.junit.Before
    public void setup() {
        account = new Account("123456", 10000000, "Unknown");
    }

    // Test function Account Number is valid or not
    @Test
    public void validAccountNumber() {
        boolean validAccount = Account.validAccountNumber(account.getAccountNumber());
        assertTrue(validAccount);
    }

    // Test function Account is Premium or not
    @Test
    public void isPremium() {
        boolean isPremium = account.isPremium();
        assertTrue(isPremium);
    }
}