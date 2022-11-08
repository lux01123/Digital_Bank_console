package vn.funix.ducntfx18862.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends User {
    private List<Account> accounts;

    public Customer() {
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
        accounts.add(newAccount);
        for (int i = 0; i < this.accounts.size()-1; i++) {
            if (Objects.equals(newAccount.getAccountNumber(), accounts.get(i).getAccountNumber())) {
                System.out.println("Duplicated Account !");
                accounts.remove(newAccount);
            } else {
                accounts.add(newAccount);
                System.out.println("Da them tai khoan moi");
            }
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
//        int count = 0;
        if (isPremium())
            isPre = "Premium";
        else
            isPre = "Normal";
//        System.out.println(string1 + "|" + "\t" + string2 + "\t" +  isPre + "\t" + string3 );
        System.out.printf("%-15s | %-15s | %-10s | %15s\n", getCustomerId(), getName(), isPre, getBalance());
//        System.out.printf("%-15s | % -20s | %-15s | %-20s\n", getCustomerId(), getName(), isPre, getBalance());
        for (int i = 0; i < accounts.size(); i++) {
//            System.out.printf("%-5s | %s\n", count++, accounts.get(i).toString());
            System.out.print(String.valueOf(i+1) + "     ");
            accounts.get(i).toStringUser();
            System.out.println("");
        }
    }

}
