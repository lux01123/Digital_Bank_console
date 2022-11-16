package vn.funix.ducntfx18862.java.asm02;

import vn.funix.ducntfx18862.java.asm02.models.*;


import java.util.Scanner;
import java.util.*;

public class Asm02 {

    private static Scanner scanner = new Scanner(System.in);

    private static final Bank bank = new Bank();

    // Search number
    public static void searchCustomerByCCCD(String findNum) {
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            if (Objects.equals(findNum, bank.getCustomers().get(i).getCustomerId())) {
                bank.getCustomers().get(i).displayInformation();
            }
        }
    }

    // Search name
    public static void searchCustomerByName(String findName) {
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            String nameCus = bank.getCustomers().get(i).getName();
            if (nameCus.contains(findName)) {
                bank.getCustomers().get(i).displayInformation();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| NGAN HANG SO | FX18862@v2.0.0         |");
        System.out.println("+-----------+-----------------+---------+");
        System.out.println(" 1. Them khach hang                      ");
        System.out.println(" 2. Them tai khoan cho khach hang        ");
        System.out.println(" 3. Hien thi danh sach khach hang        ");
        System.out.println(" 4. Tim theo CCCD                        ");
        System.out.println(" 5. Them theo ten khach hang             ");
        System.out.println(" 0. Thoat                                ");
        System.out.println("+-----------+-----------------+---------+");
        System.out.print("Chuc nang: ");
        while (true) {
            String stringEnter;
            stringEnter = scanner.nextLine();
            try {
                int numEnter = Integer.parseInt(stringEnter);
                if (numEnter == 1) {
                    System.out.println("Nhap ten khach hang: ");
                    String customerName = scanner.nextLine();
                    System.out.println("Nhap so can cuoc cong dan: ");
                    String customerNumber = scanner.nextLine();
                    // Check number CCCD id valid or not
                    while (!User.validID(customerNumber)) {
                        System.out.println("Nhap so can cuoc cong dan: ");
                        customerNumber = scanner.nextLine();
                    }
                    Customer customerNew = new Customer();
                    customerNew.setName(customerName);
                    customerNew.setCustomerId(customerNumber);
                    bank.addCustomer(customerNew);
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 2) {
                    System.out.println("Nhap CCCD khach hang:");
                    String customerNumber = scanner.nextLine();
                    while (!User.validID(customerNumber)) {
                        System.out.println("Nhap CCCD khach hang: ");
                        customerNumber = scanner.nextLine();
                    }
                    // Check customer existed or not
                    if (bank.isCustomerExisted(customerNumber)) {
                        // Check valid number or not
                        System.out.println("Nhap ma STK gom 6 chu so:");
                        String numSTK = scanner.nextLine();
                        while (!Account.validAccountNumber(numSTK)) {
                            System.out.println("Nhap ma STK gom 6 chu so:");
                            numSTK = scanner.nextLine();
                        }
                        // Check valid balance or not
                        System.out.println("Nhap so du:");
                        double numBalance = scanner.nextDouble();
                        while (numBalance < 50000) {
                            System.out.println("So du khong duoc nho hon 50,000 dong");
                            System.out.println("Nhap so du:");
                            numBalance = scanner.nextDouble();
                        }
                        // Create account
                        Account accountNew = new Account();
                        accountNew.setAccountNumber(numSTK);
                        accountNew.setBalance(numBalance);
                        bank.addAccount(customerNumber, accountNew);
                    } else {
                        System.out.println("Khach hang chua dang ky");
                    }
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 3) {
                    for (int i = 0; i < bank.getCustomers().size(); i++) {
                        bank.getCustomers().get(i).displayInformation();
                    }
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 4) {
                    System.out.println("Nhap so can cuoc cong dan can tim:");
                    String findNum = scanner.nextLine();
                    searchCustomerByCCCD(findNum);
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 5) {
                    System.out.println("Nhap ten khach hang can tim:");
                    String findName = scanner.nextLine();
                    searchCustomerByName(findName);
                    System.out.print("Chuc nang: ");
                } else if (numEnter == 0) {
                    System.out.println(" ");
                    System.out.println("Program is shutting down");
                    break;
                } else {
                    System.out.println("Invalid number! Please enter again");
                    System.out.print("Chuc nang: ");
                }
            } catch (NumberFormatException e) {
            }
        }
    }
}
