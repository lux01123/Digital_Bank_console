package vn.funix.ducntfx18862.java.asm03.models;

import vn.funix.ducntfx18862.java.asm02.models.Account;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class LoanAccount extends Account implements ReportService, Withdraw {
    private final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    public LoanAccount(String accountNumber, double balance) {
        super(accountNumber, balance, "LOAN");
    }

    // Check amount can withdraw or not
    @Override
    public boolean isAccepted(double amount) {
        if (amount < LOAN_ACCOUNT_MAX_BALANCE && (getBalance() - amount >= 50000) && amount > 0) {
            return true;
        }
        return false;
    }

    // Withdraw money
    @Override
    public boolean withdraw(double amount) {
        double newBalance = 0.0;
        if (isAccepted(amount)) {
            if (isPremium()) {
                newBalance = getBalance() - amount - (amount * LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE);
                setBalance(newBalance);
                log(amount);
                return true;
            }
            if (!isPremium()) {
                newBalance = getBalance() - amount - (amount * LOAN_ACCOUNT_WITHDRAW_FEE);
                setBalance(newBalance);
                log(amount);
                return true;
            }
        }
        System.out.println("So tien rut khong kha dung");
        return false;
    }

    // Display bill for withdraw
    @Override
    public void log(double amount) {
        // Make object format
        NumberFormat currentLocale = NumberFormat.getInstance();
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        // Format type amount and balance
        String strAmount = en.format(amount);
        String strBalance = en.format(getBalance());
        // Make string of date
        Date date1 = new Date();
        String getDate;
        if (date1.getDate() < 10) {
            getDate = "0" + date1.getDate();
        } else {
            getDate = String.valueOf(date1.getDate());
        }
        String getMonth;
        if (date1.getMonth() < 10) {
            getMonth = "0" + date1.getMonth();
        } else {
            getMonth = String.valueOf(date1.getMonth());
        }
        String getYear;
        getYear = String.valueOf(1900 + date1.getYear());
        String getHours;
        if (date1.getHours() < 10) {
            getHours = "0" + date1.getHours();
        } else {
            getHours = String.valueOf(date1.getHours());
        }
        String getMinutes;
        if (date1.getMinutes() < 10) {
            getMinutes = "0" + date1.getMinutes();
        } else {
            getMinutes = String.valueOf(date1.getMinutes());
        }
        String getSeconds;
        if (date1.getSeconds() < 10) {
            getSeconds = "0" + date1.getSeconds();
        } else {
            getSeconds = String.valueOf(date1.getSeconds());
        }
        String dateDisplay = getDate + "/" + getMonth + "/" + getYear + " " + getHours + ":" + getMinutes + ":" + getSeconds;
        // Make string of VAT
        String strVat = null;
        strVat = String.valueOf(en.format(amount * LOAN_ACCOUNT_WITHDRAW_FEE));
        if ((getBalance() + amount + amount * LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE) >= 10000000) {
            strVat = String.valueOf(en.format(amount * LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE));
        }
        // Display Screen
        System.out.println("+-----------+----------------------+--------+");
        System.out.println("        BIEN LAI GIAO DICH LOAN              ");
        System.out.printf("Ngay giao dich: %28s\n", dateDisplay);
        System.out.println("ATM ID:                DIGITAL-BANK-ATM 2022");
        System.out.printf("So TK: %37s\n", getAccountNumber());
        System.out.printf("So tien: %34sđ\n", strAmount);
        System.out.printf("So du: %36sđ\n", strBalance);
        System.out.printf("Phi + Vat: %32sđ\n", strVat);
        System.out.println("+-----------+----------------------+--------+");
    }

}
