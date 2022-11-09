package vn.funix.ducntfx18862.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.text.NumberFormat;
import java.util.Locale;

public class Customer extends User {
    private List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }

    public Customer(String name, String customerId, List<Account> accounts) {
        super(name, customerId);
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium() {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (accounts.get(i).isPremium()) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account newAccount) {
        boolean duplicatedAcc = false;
        for (int i = 0; i < this.accounts.size(); i++) {
            if (Objects.equals(newAccount.getAccountNumber(), accounts.get(i).getAccountNumber())) {
                duplicatedAcc = true;
            }
        }
        if (!duplicatedAcc) {
            accounts.add(newAccount);
            System.out.println("Da them tai khoan moi");
        } else {
            System.out.println("Tai khoan da dang ky !");
        }
    }

    public double getBalance() {
        double sum = 0;
        for (int i = 0; i < this.accounts.size(); i++) {
            sum += accounts.get(i).getBalance();
        }
        return sum;
    }

    public void displayInformation() {
        String isPre;
        if (isPremium())
            isPre = "Premium";
        else
            isPre = "Normal";
        // Format type number
        NumberFormat currentLocale = NumberFormat.getInstance();
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String str1 = en.format(getBalance());
        System.out.printf("%-15s | %-15s | %-10s | %15sđ\n", getCustomerId(), getName(), isPre, str1);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.print(i + 1 + "     ");
            accounts.get(i).toStringUser();
        }
    }

}
