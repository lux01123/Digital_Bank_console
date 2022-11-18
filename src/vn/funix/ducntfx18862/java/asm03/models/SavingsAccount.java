package vn.funix.ducntfx18862.java.asm03.models;

import vn.funix.ducntfx18862.java.asm02.models.Account;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Date;

public class SavingsAccount extends Account implements ReportService, Withdraw {

    private final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    public SavingsAccount(String accountNumber, double balance){
        super(accountNumber, balance, "SAVINGS");
    }

    // Check amount can withdraw or not
    @Override
    public boolean isAccepted(double amount) {
        if((amount >= 50000.0) && (amount % 10000.0 == 0) && (getBalance() - amount >= 50000.0)){
            if(isPremium()){
                return true;
            }
            if(!isPremium() && (amount < SAVINGS_ACCOUNT_MAX_WITHDRAW)){
                return true;
            }
        }
        return false;
    }

    // Withdraw money
    @Override
    public boolean withdraw(double amount) {
        double newBalance = 0.0;
        if(isAccepted(amount)){
            newBalance = getBalance() - amount;
            setBalance(newBalance);
            log(amount);
            return true;
        }
        System.out.println("So tien rut khong kha dung");
        return false;
    }

    // Display bill for withdraw
    @Override
    public void log(double amount) {
        // Make object format tyoe
        NumberFormat currentLocale = NumberFormat.getInstance();
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        // Format type amount and balance
        String strAmount = en.format(amount);
        String strBalance = en.format(getBalance());
        // Make string of date
        Date date1 = new Date();
        String getDate;
        if(date1.getDate() < 10){
            getDate = "0" + date1.getDate();
        } else{
            getDate = String.valueOf(date1.getDate());
        }
        String getMonth;
        if(date1.getMonth() < 10){
            getMonth = "0" + date1.getMonth();
        } else {
            getMonth = String.valueOf(date1.getMonth());
        }
        String getYear;
        getYear = String.valueOf(1900 + date1.getYear());
        String getHours;
        if(date1.getHours() < 10){
            getHours = "0" + date1.getHours();
        } else {
            getHours = String.valueOf(date1.getHours());
        }
        String getMinutes;
        if(date1.getMinutes() < 10) {
            getMinutes = "0" + date1.getMinutes();
        } else {
            getMinutes = String.valueOf(date1.getMinutes());
        }
        String getSeconds;
        if(date1.getSeconds() < 10) {
            getSeconds = "0" + date1.getSeconds();
        } else {
            getSeconds = String.valueOf(date1.getSeconds());
        }
        String dateDisplay =  getDate + "/" + getMonth + "/" + getYear + " " + getHours + ":" + getMinutes + ":" + getSeconds;
        // Display Screen
        System.out.println("+-----------+----------------------+--------+");
        System.out.println("        BIEN LAI GIAO DICH SAVINGS           ");
        System.out.printf("Ngay giao dich: %28s\n" ,dateDisplay);
        System.out.println("ATM ID:                DIGITAL-BANK-ATM 2022");
        System.out.printf("So TK: %37s\n", getAccountNumber());
        System.out.printf("So tien: %34sđ\n" , strAmount);
        System.out.printf("So du: %36sđ\n" , strBalance);
        System.out.println("Phi + Vat:                                0đ\n");
        System.out.println("+-----------+----------------------+--------+");
    }
}
