package vn.funix.ducntfx18862.java.asm03.models;

import vn.funix.ducntfx18862.java.asm02.models.Account;
import vn.funix.ducntfx18862.java.asm02.models.Customer;

import java.util.List;
import java.util.Objects;

public class DigitalCustomer extends Customer {
    public DigitalCustomer(String name, String customerId){
        super(name, customerId);
    }
    public DigitalCustomer(String name, String customerId, List<Account> accounts){
        super(name, customerId, accounts);
    }
    public List<Account> getAccountsDigital() {
        return getAccounts();
    }

    // With draw money with parameter: number of account and amount
    public void withdraw(String number, Double amount){
        for(int i = 0; i < getAccounts().size(); i++){
            if(Objects.equals(getAccounts().get(i).getAccountNumber(), number)){
                if(Objects.equals(getAccounts().get(i).getAccountType(), "SAVINGS")){
                    String numberWithdraw = getAccounts().get(i).getAccountNumber();
                    double balanceWithdraw = getAccounts().get(i).getBalance();
                    SavingsAccount accountWithDraw = new SavingsAccount(numberWithdraw, balanceWithdraw);
                    accountWithDraw.withdraw(amount);
                    getAccounts().set(i, accountWithDraw);
                    return;

                }
                if(Objects.equals(getAccounts().get(i).getAccountType(), "LOAN")){
                    String numberWithdraw = getAccounts().get(i).getAccountNumber();
                    double balanceWithdraw = getAccounts().get(i).getBalance();
                    LoanAccount accountWithdraw = new LoanAccount(numberWithdraw, balanceWithdraw);
                    accountWithdraw.withdraw(amount);
                    getAccounts().set(i, accountWithdraw);
                    return;
                }
            } else {
                System.out.println("So tai khoan chua dang ky D");
            }
        }
    }

    // Add new account
    public void addAccount(Account account){
        boolean isDuplicated = false;
        for(int i = 0; i < getAccounts().size(); i++){
            if(Objects.equals(getAccounts().get(i).getAccountNumber(), account.getAccountNumber())){
                isDuplicated = true;
            }
        }
        if(isDuplicated){
            System.out.println("So tai khoan da dang ky D ");
        } else if (!isDuplicated ) {
            getAccounts().add(account);
            System.out.println("Da them tai khoan moi D");
        }
    }

    public boolean isAccountExisted (Account newAccount){
        for(int i = 0; i < getAccounts().size(); i++){
            if(getAccounts().get(i).getAccountNumber() == newAccount.getAccountNumber()){
                return true;
            }
        }
        return false;
    }

    public Account getAccountByNumberAccount(String accountNumber){
        for(int i = 0; i < getAccounts().size(); i++){
            if(Objects.equals(getAccounts().get(i).getAccountNumber(), accountNumber)){
                return getAccounts().get(i);
            }
        }
        return null;
    }
}
