package vn.funix.ducntfx18862.java.asm03;

import vn.funix.ducntfx18862.java.asm02.models.Account;
import vn.funix.ducntfx18862.java.asm03.models.DigitalBank;
import vn.funix.ducntfx18862.java.asm03.models.LoanAccount;
import vn.funix.ducntfx18862.java.asm03.models.SavingsAccount;

import java.util.Scanner;

public class Asm03 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001099123456";
    private static final  String CUSTOMER_NAME = "LUX";

    public static void main(String[] args){

        activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);

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
        System.out.print("Chuc nang: ");
        while (true) {
            String stringEnter;
            stringEnter = scanner.nextLine();
            try {
                int numEnter = Integer.parseInt(stringEnter);
                if (numEnter == 1) {
                    // Display all information about customer
                    activeBank.getCustomerById(CUSTOMER_ID).displayInformation();
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 2) {
                    // Add new ATM account
                    System.out.println("Nhap ma so tai khoan gom 6 chu so:");
                    String numberAccount = scanner.nextLine();
                    System.out.println("Nhap so du:");
                    double numberBalance = scanner.nextDouble();
                    SavingsAccount newAccount = new SavingsAccount(numberAccount, numberBalance);
                    if(numberBalance >= 50000 && Account.validAccountNumber(numberAccount) ) {
                        activeBank.getCustomerById(CUSTOMER_ID).addAccount(newAccount);
                    }
                    if(numberBalance < 50000) {
                        System.out.println("So du ban dau khong duoc nho hon 50,000 đ");
                    } if (!Account.validAccountNumber(numberAccount)){
                        System.out.println("Ma so tai khoan khong hop le");
                    }
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 3) {
                    // Add new Credit account
                    System.out.println("Nhap ma so tai khoan gom 6 chu so:");
                    String numberAccount = scanner.nextLine();
                    System.out.println("Nhap so du:");
                    double numberBalance = scanner.nextDouble();
                    LoanAccount newAccount = new LoanAccount(numberAccount, numberBalance);
                    if(numberBalance >= 50000 && Account.validAccountNumber(numberAccount)) {
                        activeBank.getCustomerById(CUSTOMER_ID).addAccount(newAccount);
                    }
                    if(numberBalance < 50000) {
                        System.out.println("So du ban dau khong duoc nho hon 50,000 đ");
                    } if (!Account.validAccountNumber(numberAccount)){
                        System.out.println("Ma so tai khoan khong hop le");
                    }
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 4) {
                    // Withdraw money
                    System.out.println("Nhap tai khoan can rut tien:");
                    String numberAccount = scanner.nextLine();
                    System.out.println("Nhap so tien can rut:");
                    double numberAmount= scanner.nextDouble();
                    activeBank.withDraw(CUSTOMER_ID, numberAccount, numberAmount);
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 5) {
                    activeBank.displayHistory(CUSTOMER_ID);
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 0) {
                    // Log out
                    System.out.println("Program is shutting down");
                    break;
                } else {
                    // Enter number again
                    System.out.println("Invalid number! Please enter again");
                    System.out.print("Chuc nang: ");
                }
            } catch (NumberFormatException ignored){
                System.out.println("Please enter again");
            }
        }
    }
}
