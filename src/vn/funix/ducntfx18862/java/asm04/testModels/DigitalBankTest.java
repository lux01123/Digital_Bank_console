package vn.funix.ducntfx18862.java.asm04.testModels;

import org.junit.Test;
import vn.funix.ducntfx18862.java.asm04.models.Customer;
import vn.funix.ducntfx18862.java.asm04.models.DigitalBank;

import static org.junit.Assert.*;

public class DigitalBankTest {
    private DigitalBank digitalBank;
    @org.junit.Before
    public void setup(){
        digitalBank = new DigitalBank("GINKOU");
    }
    @Test
    public void isCustomerExisted() {
        assertFalse(digitalBank.isCustomerExisted("001099123456"));
    }
}