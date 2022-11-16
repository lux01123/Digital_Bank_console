package vn.funix.ducntfx18862.java.asm03.Test;

import org.junit.Test;
import vn.funix.ducntfx18862.java.asm03.models.LoanAccount;

import static org.junit.Assert.*;

public class LoanAccountTest {
    
    private LoanAccount loanAccount;

    @org.junit.Before
    public void setup(){
        loanAccount = new LoanAccount("001099123456", 1000000);
    }

    @org.junit.Test
    public void isAccepted() {
        boolean accepted = loanAccount.isAccepted(100000);
        assertTrue(accepted);
    }

    @org.junit.Test
    public void withdraw() {
        loanAccount.withdraw(100000);
        assertEquals(895000, loanAccount.getBalance(), 0.1);
    }
}