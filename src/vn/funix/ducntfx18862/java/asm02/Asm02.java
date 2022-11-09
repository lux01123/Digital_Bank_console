package vn.funix.ducntfx18862.java.asm02;

import vn.funix.ducntfx18862.java.asm02.models.*;


import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class Asm02 {

    private static Scanner scanner = new Scanner(System.in);

    private static final Bank bank = new Bank();

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
        while (true) {
            String stringEnter;
            System.out.print("Chuc nang: ");
            stringEnter = scanner.nextLine();
            try {
                int numEnter = Integer.valueOf(stringEnter);
                if (numEnter == 1) {
//                    System.out.println("Nhap ten khach hang: ");
//                    String customerName = scanner.nextLine();
//                    System.out.println("Nhap so can cuoc cong dan: ");
//                    String customerNumber = scanner.nextLine();
//                    // Check number CCCD id valid or not
//                    while (!User.validID(customerNumber)) {
//                        System.out.println("Nhap so can cuoc cong dan: ");
//                        customerNumber = scanner.nextLine();
//                    }
//                    Customer customerNew = new Customer();
//                    customerNew.setName(customerName);
//                    customerNew.setCustomerId(customerNumber);
//                    bank.addCustomer(customerNew);
// -------------------------- For test ---------------------------------------------
                    Customer cus1 = new Customer();
                    cus1.setName("abc");
                    cus1.setCustomerId("001099123456");
                    Account accountNew = new Account();
                    accountNew.setAccountNumber("123456");
                    accountNew.setBalance(50000);
                    cus1.addAccount(accountNew);
                    bank.addCustomer(cus1);
                    Account accountNew2 = new Account();
                    accountNew2.setAccountNumber("234567");
                    accountNew2.setBalance(10000000);
                    cus1.addAccount(accountNew2);

                    Customer cus2 = new Customer();
                    cus2.setName("deg");
                    cus2.setCustomerId("001099456789");
                    Account accountNew21 = new Account();
                    accountNew21.setAccountNumber("345678");
                    accountNew21.setBalance(50000);
                    cus2.addAccount(accountNew21);
                    bank.addCustomer(cus2);
                    Account accountNew22 = new Account();
                    accountNew22.setAccountNumber("123456");
                    accountNew22.setBalance(100000);
                    cus2.addAccount(accountNew22);

                    Customer cus3 = new Customer();
                    cus3.setName("abcd");
                    cus3.setCustomerId("001099123000");
                    Account accountNew31 = new Account();
                    accountNew31.setAccountNumber("123456");
                    accountNew31.setBalance(50000);
                    cus3.addAccount(accountNew31);
                    bank.addCustomer(cus3);
                    Account accountNew32 = new Account();
                    accountNew32.setAccountNumber("234567");
                    accountNew32.setBalance(10000000);
                    cus3.addAccount(accountNew32);
// -----------------------------------------------------------------------------------
                } else if (numEnter == 2) {
                    System.out.println("Nhap CCCD khach hang:");
                    String customerNumber = scanner.nextLine();
                    while (!User.validID(customerNumber)) {
                        System.out.println("Nhap CCCD khach hang ");
                        customerNumber = scanner.nextLine();
                    }
                    // Check customer existed or not
                    if (bank.isCustomerExisted(customerNumber)) {
                        // Check valid number or not
                        System.out.println("Nhap ma so STK gom 6 chu so");
                        String numSTK = scanner.nextLine();
                        while (!Account.validAccountNumber(numSTK)) {
                            System.out.println("Nhap ma so STK gom 6 chu so:");
                            numSTK = scanner.nextLine();
                        }
                        // Check valid balance or not
                        System.out.println("Nhap so du:");
                        double numBalance = scanner.nextDouble();
                        while (numBalance < 50000) {
                            System.out.println("So du phai lon hon 50,000 dong");
                            System.out.println("Nhap so du:");
                            numBalance = scanner.nextDouble();
                        }
                        // Create account
                        Account accountNew = new Account();
                        accountNew.setAccountNumber(numSTK);
                        accountNew.setBalance(numBalance);
//                        System.out.println(accountNew.getAccountNumber());
//                        System.out.println(accountNew.getBalance());
                        bank.addAccount(customerNumber, accountNew);
                    } else {
                        System.out.println("Khach hang chua dang ky");
                    }
                } else if (numEnter == 3) {
                    for (int i = 0; i < bank.getCustomers().size(); i++) {
//---------------------------------For test ------------------------------------
//                        System.out.println(bank.getCustomers().get(i).getName());
//                        System.out.println(bank.getCustomers().get(i).getCustomerId());
//                        System.out.println(bank.getCustomers().get(i).getAccounts().get(0).getBalance());
//-----------------------------------------------------------------------------------
                        bank.getCustomers().get(i).displayInformation();
                    }
                } else if (numEnter == 4) {
                    System.out.println("Nhap so can cuoc cong dan can tim");
                    String findNum = scanner.nextLine();
                    for (int i = 0; i < bank.getCustomers().size(); i++) {
                        if (Objects.equals(findNum, bank.getCustomers().get(i).getCustomerId())) {
                            bank.getCustomers().get(i).displayInformation();
                        }
                    }
                } else if (numEnter == 5) {
                    System.out.println("Nhap ten khach hang can tim");
                    String findName = scanner.nextLine();
                    for (int i = 0; i < bank.getCustomers().size(); i++) {
                        String nameCus = bank.getCustomers().get(i).getName();
                        if (nameCus.contains(findName)) {
                            System.out.println(nameCus);
                        }
                    }
                } else if (numEnter == 0) {
                    System.out.println(" ");
                    System.out.println("Program is shutting down");
                    break;
                } else {
                    System.out.println("Invalid number! Please enter again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid symbol! Please enter again");
            }
        }
    }
}
