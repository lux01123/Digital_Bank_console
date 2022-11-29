package vn.funix.ducntfx18862.java.asm03.models;

import vn.funix.ducntfx18862.java.asm02.models.Bank;
import vn.funix.ducntfx18862.java.asm02.models.Customer;

import java.text.NumberFormat;
import java.util.*;

public class DigitalBank extends Bank {

    private final List<Transaction> transactionList;

    public DigitalBank() {
        this.transactionList = new ArrayList<>();
    }

    public List<Customer> getCustomerDigital() {
        return getCustomers();
    }

    // Find customer by number ID
    public Customer getCustomerById(String customerId) {
        for (int i = 0; i < getCustomerDigital().size(); i++) {
            if (Objects.equals(getCustomerDigital().get(i).getCustomerId(), customerId)) {
                return getCustomerDigital().get(i);
            }
        }
        System.out.println("Khach hang chua dang ky D");
        return null;
    }

    // Check is customer existed
    public boolean isCustomerExisted(Customer newCustomer) {
        for (int i = 0; i < getCustomerDigital().size(); i++) {
            if (Objects.equals(getCustomerDigital().get(i).getCustomerId(), newCustomer.getCustomerId())) {
                return true;
            }
        }
        System.out.println("Khach hang chua dang ky D");
        return false;
    }

    // Check is customerId existed
    public boolean validateCustomerId(String canCuocCongDan) {
        for (int i = 0; i < getCustomerDigital().size(); i++) {
            if (Objects.equals(getCustomerDigital().get(i).getCustomerId(), canCuocCongDan)) {
                return true;
            }
        }
        return false;
    }

    // Add new customer
    public void addCustomer(String customerId, String name) {
        boolean isDuplicated = false;
        for (int i = 0; i < getCustomers().size(); i++) {
            if (Objects.equals(getCustomers().get(i).getCustomerId(), customerId)) {
                isDuplicated = true;
                break;
            }
        }
        if (!isDuplicated) {
            Customer newCustomer = new Customer(name, customerId);
            getCustomers().add(newCustomer);
            System.out.println("Da them khach hang moi D");
        } else {
            System.out.println("Khach hang da dang ky D");
        }
    }

    // Find transaction
    public List<Transaction> getTransactionList() {
        return this.transactionList;
    }

    // Withdraw money with parameter: number CustomerId, number of account and amount
    public void withDraw(String customerId, String accountNumber, double amount) {
        boolean isCustomer = false;
        boolean isAccount = false;
        for (int i = 0; i < getCustomers().size(); i++) {
            if (Objects.equals(getCustomers().get(i).getCustomerId(), customerId)) {
                isCustomer = true;
                for (int j = 0; j < getCustomers().get(i).getAccounts().size(); j++) {
                    if (Objects.equals(getCustomers().get(i).getAccounts().get(j).getAccountNumber(), accountNumber)) {
                        // Make string of time
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
                        // Withdraw Saving account
                        if (Objects.equals(getCustomers().get(i).getAccounts().get(j).getAccountType(), "SAVINGS")) {
                            // Use downcast
                            SavingsAccount savingsAccount = (SavingsAccount) getCustomers().get(i).getAccounts().get(j);
                            savingsAccount.withdraw(amount);
                            // Create and replace
//                            String numberWithdraw = getCustomers().get(i).getAccounts().get(j).getAccountNumber();
//                            double balanceWithdraw = getCustomers().get(i).getAccounts().get(j).getBalance();
//                            SavingsAccount accountWithDraw = new SavingsAccount(numberWithdraw, balanceWithdraw);
//                            accountWithDraw.withdraw(amount);
//                            getCustomers().get(i).getAccounts().set(j, accountWithDraw);
                            // Add transaction
                            Transaction newTransactions = new Transaction(customerId, accountNumber, amount, dateDisplay, true);
                            transactionList.add(newTransactions);
                            isAccount = true;

                        }
                        // Withdraw Loan account
                        if (Objects.equals(getCustomers().get(i).getAccounts().get(j).getAccountType(), "LOAN")) {
                            // Use downcast
                            LoanAccount loanAccount = (LoanAccount) getCustomers().get(i).getAccounts().get(j);
                            loanAccount.withdraw(amount);
                            // Create and replace
//                            String numberWithdraw = getCustomers().get(i).getAccounts().get(j).getAccountNumber();
//                            double balanceWithdraw = getCustomers().get(i).getAccounts().get(j).getBalance();
//                            LoanAccount accountWithdraw = new LoanAccount(numberWithdraw, balanceWithdraw);
//                            accountWithdraw.withdraw(amount);
//                            getCustomers().get(i).getAccounts().set(j, accountWithdraw);
                            // Add transaction
                            Transaction newTransactions = new Transaction(customerId, accountNumber, amount, dateDisplay, true);
                            transactionList.add(newTransactions);
                            isAccount = true;
                        }
                    }
                }
            }
        }
        if(!isAccount){
            System.out.println("Tai khoan chua dang ky D");
        }
        if(!isCustomer){
            System.out.println("Khach hang chua dang ky D");
        }
    }

    // Display history transaction
    public void displayHistory(String customerId) {
        System.out.println("+-------------+-----------------------------------+----------------+");
        System.out.println("| LICH SU GIAO DICH                                                |");
        System.out.println("+-------------+-----------------------------------+----------------+");
        getCustomerById(customerId).displayInformation();
        // Display transactions of customer
        for (int i = 0; i < transactionList.size(); i++) {
            if (Objects.equals(getTransactionList().get(i).getId(), customerId)) {
//            NumberFormat currentLocale = NumberFormat.getInstance();
                Locale localeEN = new Locale("en", "EN");
                NumberFormat en = NumberFormat.getInstance(localeEN);
                String amount = "-" + en.format(transactionList.get(i).getAmount());
                System.out.printf("%s    | %s | %15sđ | %s\n", customerId, transactionList.get(i).getAccountNumber(),
                        amount, transactionList.get(i).getTime());
            }
        }
        System.out.println("+-------------+-----------------------------------+----------------+");
    }
}
