package vn.funix.ducntfx18862.java.asm02.models;

public class Account {
    private String accountNumber;
    private double balance;

    public Account() {
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public static boolean validAccountNumber(String accountNumber) {
        // Check length
        boolean lengthCondition;
        if (accountNumber.length() == 6) {
            lengthCondition = true;
        } else {
            lengthCondition = false;
        }
        // Check is number
        boolean numCondition;
        try {
            double d = Double.parseDouble(accountNumber);
            numCondition = true;
        } catch (NumberFormatException nfe) {
            numCondition = false;
        }
        return lengthCondition && numCondition;
    }

    public void setAccountNumber(String accountNumber) {
        if (validAccountNumber(accountNumber)) {
            this.accountNumber = accountNumber;
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public boolean isPremium() {
        if (this.balance >= 10000000) {
            return true;
        }
        return false;
    }

    public void toStringUser() {
        String s1 = String.valueOf(this.balance);
        System.out.printf("%s    | %46s", this.accountNumber, s1);
    }

}
