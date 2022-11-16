package vn.funix.ducntfx18862.java.asm02.models;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private double balance;

    private String accountType;

    public Account() {
    }

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
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
        String typeAccount = "UNKNOWN";
        if(Objects.equals(getAccountType(), "SAVINGS")){
            typeAccount = "ATM";
        }
        if(Objects.equals(getAccountType(), "LOAN")){
            typeAccount = "CREDIT";
        }
        // Format type number
        NumberFormat currentLocale = NumberFormat.getInstance();
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String str1 = en.format(this.balance);
        System.out.printf("%s    | %-14s  | %28sđ\n", this.accountNumber, typeAccount, str1);
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
