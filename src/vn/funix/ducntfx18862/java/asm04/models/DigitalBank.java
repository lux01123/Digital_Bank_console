package vn.funix.ducntfx18862.java.asm04.models;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.Date;
import java.util.Locale;

import vn.funix.ducntfx18862.java.asm04.models.Account;
import vn.funix.ducntfx18862.java.asm04.models.SavingsAccount;
public class DigitalBank extends Bank{
    public DigitalBank(String name) {
        super(name);
    }

    private static final Scanner scanner = new Scanner(System.in);

    // Show all customer in file Customer.dat and account in file Account.dat
    public void showCustomers(){
        List<Customer> customers = CustomerDao.list();
        if(customers.size() == 0){
            System.out.println("Chưa có khách hàng nào trong danh sách");
            return;
        }
        for(int i = 0; i < customers.size(); i++){
            customers.get(i).displayInformation();
        }
    }

    // Add customer by path
    public void addCustomer(String filePath) throws IOException, CustomerIdNotValidException {
        List<Customer> oldCustomers = CustomerDao.list();
        List<List<String>> readCustomers = TextFileService.readFile(filePath);
        for(int i = 0; i < readCustomers.size(); i++) {
            boolean isNewCustomer = true;
            for (int j = 0; j < oldCustomers.size(); j++) {
                if (Objects.equals(readCustomers.get(i).get(0), oldCustomers.get(j).getCustomerId())) {
                    isNewCustomer = false;
                    System.out.println("Khách hàng " + readCustomers.get(i).get(0) + " đã tồn tại, thêm khách hàng không thành công");
                    break;
                }
            }
            if (isNewCustomer) {
                try {
                    Customer customer = new Customer();
                    customer.setCustomerId(readCustomers.get(i).get(0));
                    customer.setName(readCustomers.get(i).get(1));
                    oldCustomers.add(customer);
                    System.out.println("Đã thêm khách hàng " + customer.getCustomerId() + " vào danh sách khách hàng");
                } catch (CustomerIdNotValidException e) {
                    System.out.println("Mã số id của khách hàng không hợp lệ, thêm khách hàng không thành công");
                }
            }
        }
        CustomerDao.save(oldCustomers);
    }

    // Add new savings account for customer
    public void addSavingsAccount(String customerId, String numberAccount, String strBalance) throws IOException {
        List<Customer> customers = CustomerDao.list();
        List<Account> accounts = AccountDao.list();
        List<Transaction> transactions = TransactionDao.list();
        // Check id of customer is exist or not
        boolean isCustomerExits = false;
        for (Customer customer : customers) {
            if (Objects.equals(customer.getCustomerId(), customerId)) {
                isCustomerExits = true;
                break;
            }
        }
        if(isCustomerExits){
            // Check account Number input
            while (true) {
                boolean isAccountExisted = true;
                for (Account account : accounts) {
                    if (Objects.equals(account.getAccountNumber(), numberAccount)) {
                        isAccountExisted = false;
                        break;
                    }
                }
                if (Account.validAccountNumber(numberAccount) && isAccountExisted) {
                    break;
                } else if (!isAccountExisted){
                    System.out.println("Tài khoản đã tồn tại, tác vụ không thành công");
                    System.out.print("Nhập mã số tài khoản gầm 6 chữ số: ");
                    numberAccount = scanner.nextLine();
                }
                else {
                    System.out.println("Không thể nhập ký tự hoặc chuỗi có chiều dải không hợp lệ !!!");
                    System.out.print("Nhập mã số tài khoản gồm 6 chữ số: ");
                    numberAccount = scanner.nextLine();
                }
            }
            // Check account Balance input
            double numberBalance;
            while (true) {
                try {
                    numberBalance = Double.parseDouble(strBalance);
                    if (numberBalance < 50000) {
                        System.out.println("Số dư ban đầu không được nhỏ hơn 50,000 đ");
                        System.out.print("Nhập số dư tài khoản >= 50.000 d: ");
                        strBalance = scanner.nextLine();
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số tiền !!!");
                    System.out.print("Nhập số dư tài khoản >= 50.000 d: ");
                    strBalance = scanner.nextLine();
                }
            }
            // Add account
            Account newAccount = new Account(numberAccount, numberBalance, "SAVINGS", customerId);
            accounts.add(newAccount);
            AccountDao.save(accounts);
            // Get time
            String time = getTimeD();
            // Add transaction
            Transaction newTransaction = new Transaction(customerId, numberAccount, numberBalance, time, true, "DEPOSIT");
            transactions.add(newTransaction);
            TransactionDao.save(transactions);
            System.out.println("Tạo tài khoản thành công");
        } else {
            System.out.println("Không tìm thấy khách hàng " + customerId + " tác vụ không thành công");
        }
    }

    // Show history transaction by id of customer
    public void showTransactionsCustomer(String customerId){
        List<Customer> customers = CustomerDao.list();
        List<Transaction> transactions = TransactionDao.list();
        boolean isCustomer = false;
        // Find customer
        for (Customer customer : customers) {
            if (Objects.equals(customer.getCustomerId(), customerId)) {
                isCustomer = true;
                customer.displayInformation();
            }
        }
        if (!isCustomer) {
            System.out.println("Khách hàng chưa đăng ký !!!");
            return;
        }
        // Show history transaction
        try {
            for (Transaction transaction : transactions) {
                if (Objects.equals(transaction.getId(), customerId)) {
                    // Format type number balance
                    Locale localeEN = new Locale("en", "EN");
                    NumberFormat en = NumberFormat.getInstance(localeEN);
                    String strBalance = en.format(transaction.getAmount());
                    System.out.printf("[GD] %7s | %-10s | %14s đ |  %s"
                            , transaction.getAccountNumber()
                            , transaction.getType()
                            , strBalance
                            , transaction.getTime());
                    System.out.println();
                }
            }
        } catch (Exception e){
            System.out.println("Khách hàng chưa thực hiện giao dịch !!!");
        }
    }


    // Withdraw money
    public void withdraw(String customerId) throws IOException {
        List<Customer> customers = CustomerDao.list();
        List<Account> accounts = AccountDao.list();
        List<Transaction> transactions = TransactionDao.list();
        boolean isCustomer = false;
        for (Customer customer : customers) {
            if (Objects.equals(customer.getCustomerId(), customerId)) {
                isCustomer = true;
                customer.displayInformation();
            }
        }
        if (!isCustomer) {
            System.out.println("Khách hàng chưa đăng ký");
            return;
        }
        String accountNumber;
        String amountStr;
        double amount;
        // Find account number
        boolean isAccount = false;
        boolean tryWithdraw = true;
        while (tryWithdraw) {
            System.out.print("Nhập số tài khoản: ");
            accountNumber = scanner.nextLine();
            for (int k = 0; k < accounts.size(); k++) {
                if (Objects.equals(accounts.get(k).getAccountNumber(), accountNumber)) {
                    isAccount = true;
                    // Enter amount
                    while (true) {
                        try {
                            System.out.print("Nhập số tiềnn rút: ");
                            amountStr = scanner.nextLine();
                            amount = Double.parseDouble(amountStr);
                            break;
                            } catch (NumberFormatException e) {
                            System.out.println("Số tiền nhập vào phải là định dạng số !!!");
                        }
                    }
                    // Withdraw
                    SavingsAccount amountAccount = new SavingsAccount(
                            accounts.get(k).getAccountNumber()
                            , accounts.get(k).getBalance()
                            , "SAVINGS"
                            , customerId);
                    boolean isTransaction = amountAccount.withdraw(amount);
                    // Rewrite balance of account
                    accounts.get(k).setBalance(amountAccount.getBalance());
                    AccountDao.save(accounts);
                    // Add transaction file
                    if(isTransaction) {
                        String time = getTimeD();
                        Transaction newTransaction = new Transaction(
                                customerId
                                , accountNumber
                                , -amount
                                , time
                                , true
                                , "WITHDRAW");
                        transactions.add(newTransaction);
                    }
                    TransactionDao.save(transactions);
                    // end
                    tryWithdraw = false;
                    break;
                }
            } if (!isAccount){
                System.out.println("Tài khoản chưa đăng ký !!!");
            }
        }
    }



    // Transfer money
    public void transferAmount(String customerId) throws IOException {
        List<Customer> customers = CustomerDao.list();
        List<Account> accounts = AccountDao.list();
        List<Transaction> transactions = TransactionDao.list();
        boolean isCustomer = false;
        for (Customer customer : customers) {
            if (Objects.equals(customer.getCustomerId(), customerId)) {
                isCustomer = true;
                customer.displayInformation();
            }
        }
        if (!isCustomer) {
            System.out.println("Khách hàng chưa đăng ký");
            return;
        }
        String accountNumberT = "";
        String accountNumberR = "";
        String amountStr;
        int accountT = -1;
        int accountR = -1;
        double amount;
        boolean loop1 = true;
        while (loop1) {
            System.out.print("Nhập số tài khỏan: ");
            accountNumberT = scanner.nextLine();
            for (int i = 0; i < accounts.size(); i++) {
                if (Objects.equals(accounts.get(i).getAccountNumber(), accountNumberT)) {
                    accountT = i;
                    loop1 = false;
                    break;
                }
            }
            if (loop1) {
                System.out.println("Tài khoản chưa đăng ký");
            }
        }
        boolean loop2 = true;
        while (loop2) {
            System.out.print("Nhập số tài khoản nhận (exit) để thoát: ");
            accountNumberR = scanner.nextLine();
            if (Objects.equals(accountNumberR, "exit")) {
                return;
            }
            for (int i = 0; i < accounts.size(); i++) {
                if (Objects.equals(accounts.get(i).getAccountNumber(), accountNumberR)) {
                    accountR = i;
                    loop2 = false;
                    break;
                }
            }
            if (loop2) {
                System.out.println("Tài khoản chưa đăng ký");
            }
        }
        // Find account of customer receive
        String nameReceive = "";
        for (Customer customer : customers) {
            if (Objects.equals(customer.getCustomerId(), accounts.get(accountR).getCustomerId())) {
                nameReceive = customer.getName();
            }
        }
        System.out.println("Gửi tiền đến số tài khỏan " + accountNumberR
                + " | " + nameReceive);
        // Scan input amount
        while (true) {
            try {
                System.out.print("Nhập số tiền chuyển: ");
                amountStr = scanner.nextLine();
                amount = Double.valueOf(amountStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số tiền nhập vào phải là định dạng số !!!");
            }
        }
        // Make object format tyoe
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String strAmount = en.format(amount);
        while (true) {
            String inputEnterS;
            System.out.print("Xác nhận thực hiện chuyển " + strAmount + "đ từ tài khoản ["
                    + accountNumberT + "] đến tài khoản [" + accountNumberR + "] (Y/N): ");
            inputEnterS = scanner.nextLine();
            String inputEnter = inputEnterS.toLowerCase();
            if (Objects.equals(inputEnter, "n")) {
                System.out.println("Hủy giao dịch");
                break;
            } else if (Objects.equals(inputEnter, "y")){
                System.out.println("Chuyển tiền thành công, biên lai giao dịch");
                SavingsAccount accountTranfer = new SavingsAccount(
                        accounts.get(accountT).getAccountNumber()
                        , accounts.get(accountT).getBalance()
                        , "SAVINGS"
                        , accounts.get(accountT).getCustomerId()
                );
                SavingsAccount accountReceive = new SavingsAccount(
                        accounts.get(accountR).getAccountNumber()
                        , accounts.get(accountR).getBalance()
                        , "SAVINGS"
                        , accounts.get(accountR).getCustomerId()
                );
                boolean isTransaction = accountTranfer.transfer(accountReceive, amount);
                accounts.get(accountT).setBalance(accountTranfer.getBalance());
                accounts.get(accountR).setBalance(accountReceive.getBalance());
                if(isTransaction) {
                    String time = getTimeD();
                    Transaction transactionTran = new Transaction(
                            accountTranfer.getCustomerId()
                            , accountNumberT
                            , -amount
                            , time
                            , true
                            , "TRANSFER"
                    );
                    Transaction transactionRece = new Transaction(
                            accountReceive.getCustomerId()
                            , accountNumberR
                            , amount
                            , time
                            , true
                            , "TRANSFER"
                    );
                    transactions.add(transactionTran);
                    transactions.add(transactionRece);
                }
                // Write and close file
                AccountDao.save(accounts);
                TransactionDao.save(transactions);
                break;
            } else {
                System.out.println("Ký tự nhập vao không hợp lệ. Hãy lựa chọn ký tự Y hoặc N");
            }
        }
    }

    // Check if customer exist
    public boolean isCustomerExisted(String customerId){
        List<Customer> customerList = CustomerDao.list();
        List<Customer> customers = new ArrayList<>();
        customerList.forEach(customer -> {
            if(Objects.equals(customer.getCustomerId(), customerId)){
                customers.add(customer);
            }
        });
        return customers.size() > 0;
    }

    // Get string time of transaction
    public String getTimeD(){
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
        return getDate + "/" + getMonth + "/" + getYear + " " + getHours + ":" + getMinutes + ":" + getSeconds;
    }
}
