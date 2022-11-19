package vn.funix.ducntfx18862.java.asm03;

import vn.funix.ducntfx18862.java.asm02.models.Account;
import vn.funix.ducntfx18862.java.asm03.models.DigitalBank;
import vn.funix.ducntfx18862.java.asm03.models.LoanAccount;
import vn.funix.ducntfx18862.java.asm03.models.SavingsAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Asm03 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001099123456";
    private static final String CUSTOMER_NAME = "LUX";

    // Show information of customer
    public static void showInformation() {
        activeBank.getCustomerById(CUSTOMER_ID).displayInformation();
    }

    // Add ATM account
    public static void addATM() {
        // Check account Number Enter
        String numberAccount;
        scanner.nextLine();
        System.out.println("Nhap ma so tai khoan gom 6 chu so:");
        while (true) {
            numberAccount = scanner.nextLine();
            if (Account.validAccountNumber(numberAccount)) {
                break;
            } else {
                System.out.println("Khong the nhap ky tu hoac chuoi co chieu dai khong hop le !!!");
                System.out.println("Nhap ma so tai khoan gom 6 chu so:");
            }
        }
        // Check account Balance Enter
        double numberBalance;
        while (true) {
            System.out.println("Nhap so du:");
            String strNumberBalance = scanner.nextLine();
            try {
                numberBalance = Double.parseDouble(strNumberBalance);
                if (numberBalance < 50000) {
                    System.out.println("So du ban dau khong duoc nho hon 50,000 đ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so tien !!!");
            }
        }
        // Add account
        SavingsAccount newAccount = new SavingsAccount(numberAccount, numberBalance);
        if (numberBalance >= 50000 && Account.validAccountNumber(numberAccount)) {
            activeBank.getCustomerById(CUSTOMER_ID).addAccount(newAccount);
        }
    }

    // Add credit account
    public static void addCredit() {
        // Check account Number Enter
        String numberAccount;
        scanner.nextLine();
        System.out.println("Nhap ma so tai khoan gom 6 chu so:");
        while (true) {
            numberAccount = scanner.nextLine();
            if (Account.validAccountNumber(numberAccount)) {
                break;
            } else {
                System.out.println("Khong the nhap ky tu hoac chuoi co chieu dai khong hop le !!!");
                System.out.println("Nhap ma so tai khoan gom 6 chu so:");
            }
        }
        // Check account Balance Enter
        double numberBalance;
        while (true) {
            System.out.println("Nhap so du:");
            String strNumberBalance = scanner.nextLine();
            try {
                numberBalance = Double.parseDouble(strNumberBalance);
                if (numberBalance < 50000) {
                    System.out.println("So du ban dau khong duoc nho hon 50,000 đ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so tien !!!");
            }
        }
        // Add account
        LoanAccount newAccount = new LoanAccount(numberAccount, numberBalance);
        if (numberBalance >= 50000 && Account.validAccountNumber(numberAccount)) {
            activeBank.getCustomerById(CUSTOMER_ID).addAccount(newAccount);
        }
    }

    public static void withdraw(){
        // Check number account
        String numberAccount;
        scanner.nextLine();
        System.out.println("Nhap tai khoan rut tien:");
        while (true){
            numberAccount = scanner.nextLine();
            if (Account.validAccountNumber(numberAccount)) {
                break;
            } else {
                System.out.println("Khong the nhap ky tu hoac chuoi co chieu dai khong hop le !!!");
                System.out.println("Nhap tai khoan rut tien:");
            }
        }

        // Check number amount
        double numberAmount;
        while (true) {
            System.out.println("Nhap so tien can rut:");
            String strNumberBalance = scanner.nextLine();
            try {
                numberAmount = Double.parseDouble(strNumberBalance);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so tien can rut");
            }
        }
        activeBank.withDraw(CUSTOMER_ID, numberAccount, numberAmount);
    }

    // Show history transactions
    public static void showHistoryTransactions() {
        activeBank.displayHistory(CUSTOMER_ID);
    }

    // Show first screen
    public static void showScreen() {
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| NGAN HANG SO | FX18862@v3.0.0         |");
        System.out.println("+-----------+-----------------+---------+");
        System.out.println(" 1. Thong tin khach hang                 ");
        System.out.println(" 2. Them tai khoan ATM                   ");
        System.out.println(" 3. Them tai khoan tin dung              ");
        System.out.println(" 4. Rut tien                             ");
        System.out.println(" 5. Lich su giao dich                    ");
        System.out.println(" 0. Thoat                                ");
        System.out.println("+-----------+-----------------+---------+");
    }

    // Get number of Function
    public static int getNumberEnter() {
        while (true) {
            System.out.print("Chuc nang: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Hay nhap vao so thu tu cua chuc nang !");
            }
        }
    }

    public static void main(String[] args) {
        activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        showScreen();
        boolean isRunning = true;
        while (isRunning) {
            int numEnter = getNumberEnter();
            switch (numEnter) {
                case 1 -> showInformation();
                case 2 -> addATM();
                case 3 -> addCredit();
                case 4 -> withdraw();
                case 5 -> showHistoryTransactions();
                case 0 -> {
                    isRunning = false;
                    System.out.println("Program is shutting down");
                }
                default -> System.out.println("Khong ton tai chuc nang nay");
            }
        }
    }
}
