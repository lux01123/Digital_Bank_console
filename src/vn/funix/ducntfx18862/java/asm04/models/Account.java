package vn.funix.ducntfx18862.java.asm04.models;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;

public class Account implements Serializable {
    private String accountNumber;
    private double balance;

    private String customerId;
    private String accountType;
    
    private long serialVersionUID ;

    public Account() {
    }

    public Account(String accountNumber, double balance, String accountType, String customerId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customerId = customerId;
    }

    // Set balance of account
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Get balance of aacount
    public double getBalance() {
        return this.balance;
    }

    // Check account number is valid or not
    public static boolean validAccountNumber(String accountNumber) {
        // Check length
        boolean lengthCondition;
        lengthCondition = accountNumber.length() == 6;
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

    // Set account number
    public void setAccountNumber(String accountNumber) {
        if (validAccountNumber(accountNumber)) {
            this.accountNumber = accountNumber;
        }
    }

    // Get account number
    public String getAccountNumber() {
        return this.accountNumber;
    }

    // Check account is Premium or not
    public boolean isPremium() {
        return this.balance >= 10000000;
    }

    // Print information of account
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
        // Print to screen
        System.out.printf("%s    | %-14s  | %28s??\n", this.accountNumber, typeAccount, str1);
    }

    // Get account Type
    public String getAccountType() {
        return accountType;
    }

    // Set account Type
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // Check id of customer is valid or not
    public static boolean validID(String customerId){
        //Creating a dictionary for place
        Map<String, String> dict1 = new HashMap<String, String>();
        //Adding values in the dictionary
        dict1.put("001", "H?? N???i");
        dict1.put("002", "H?? Giang");
        dict1.put("004", "Cao B???ng");
        dict1.put("006", "B???c K???n");
        dict1.put("008", "Tuy??n Quang");
        dict1.put("010", "L??o Cai");
        dict1.put("011", "??i???n Bi??n");
        dict1.put("012", "Lai Ch??u");
        dict1.put("014", "S??n La");
        dict1.put("015", "Y??n B??i");
        dict1.put("017", "H??a B??nh");
        dict1.put("019", "Th??i Nguy??n");
        dict1.put("020", "L???ng S??n");
        dict1.put("022", "Qu???ng Ninh");
        dict1.put("024", "B???c Giang");
        dict1.put("025", "Ph?? Th???");
        dict1.put("026", "V??nh Ph??c");
        dict1.put("027", "B???c Ninh");
        dict1.put("030", "H???i D????ng");
        dict1.put("031", "H???i Ph??ng");
        dict1.put("033", "H??ng Y??n");
        dict1.put("034", "Th??i B??nh");
        dict1.put("035", "H?? Nam");
        dict1.put("036", "Nam ?????nh");
        dict1.put("037", "Ninh B??nh");
        dict1.put("038", "Thanh H??a");
        dict1.put("040", "Ngh??? An");
        dict1.put("042", "H?? T??nh");
        dict1.put("044", "Qu???ng B??nh");
        dict1.put("045", "Qu???ng Tr???");
        dict1.put("046", "Th???a Thi??n Hu???");
        dict1.put("048", "???? N???ng");
        dict1.put("049", "Qu???ng Nam");
        dict1.put("051", "Qu???ng Ng??i");
        dict1.put("052", "B??nh ?????nh");
        dict1.put("054", "Ph?? Y??n");
        dict1.put("056", "Kh??nh H??a");
        dict1.put("058", "Ninh Thu???n");
        dict1.put("060", "B??nh Thu???n");
        dict1.put("062", "Kon Tum");
        dict1.put("064", "Gia Lai");
        dict1.put("066", "?????k L???k");
        dict1.put("067", "?????k N??ng");
        dict1.put("068", "L??m ?????ng");
        dict1.put("070", "B??nh Ph?????c");
        dict1.put("072", "T??y Ninh");
        dict1.put("074", "B??nh D????ng");
        dict1.put("075", "?????ng Nai");
        dict1.put("077", "B?? R???a - V??ng T??u");
        dict1.put("079", "H??? Ch?? Minh");
        dict1.put("080", "Long An");
        dict1.put("082", "Ti???n Giang");
        dict1.put("083", "B???n Tre");
        dict1.put("084", "Tr?? Vinh");
        dict1.put("086", "V??nh Long");
        dict1.put("087", "?????ng Th??p");
        dict1.put("089", "An Giang");
        dict1.put("091", "Ki??n Giang");
        dict1.put("092", "C???n Th??");
        dict1.put("093", "H???u Giang");
        dict1.put("094", "S??c Tr??ng");
        dict1.put("095", "B???c Li??u");
        dict1.put("096", "C?? Mau");
        //Check length of string
        boolean lengthCondition;
        lengthCondition = customerId.length() == 12;
        //Check string is number
        boolean numCondition;
        if (customerId == null) {
            numCondition = false;
        }
        try {
            double d = Double.parseDouble(customerId);
            numCondition = true;
        } catch (NumberFormatException nfe) {
            numCondition = false;
        }
        // Check city in string
        boolean cityCondition;
        String numCity = String.valueOf(customerId.charAt(0))
                + customerId.charAt(1)
                + customerId.charAt(2);
        cityCondition = !(dict1.get(numCity) == null);
        return lengthCondition && numCondition && cityCondition;
    }

    // Get id of customer
    public String getCustomerId(){
        return this.customerId;
    }

    // Get list transactions of account
    public List<Transaction> getTransactions(){
        List<Transaction> transactionList = TransactionDao.list();
        List<Transaction> accountTransactions = new ArrayList<>();
        transactionList.forEach(transaction -> {
            if(Objects.equals(transaction.getAccountNumber(), accountNumber)){
                accountTransactions.add(transaction);
            }
        });
        return accountTransactions;
    }
}
