package vn.funix.ducntfx18862.java.asm03.Test;

import vn.funix.ducntfx18862.java.asm03.models.SavingsAccount;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @org.junit.Before
    public void setup(){
        savingsAccount = new SavingsAccount("001099123456", 1000000);
    }

    @org.junit.Test
    public void isAccepted() {
        boolean accepted = savingsAccount.isAccepted(100000);
        assertTrue(accepted);
    }

    @org.junit.Test
    public void withdraw() {
        savingsAccount.withdraw(100000);
        assertEquals(900000, savingsAccount.getBalance(), 0.1);
    }
}