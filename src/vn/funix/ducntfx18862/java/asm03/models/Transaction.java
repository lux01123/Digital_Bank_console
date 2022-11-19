package vn.funix.ducntfx18862.java.asm03.models;

public class Transaction {
    private final String id;
    private final String accountNumber;
    private final double amount;
    private final String time;
    private final boolean status;

    public Transaction(String id, String accountNumber, double amount, String time, boolean status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.time = time;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public boolean isStatus() {
        return status;
    }
}
