package vn.funix.ducntfx18862.java.asm02;
import vn.funix.ducntfx18862.java.asm02.models.Bank;
import vn.funix.ducntfx18862.java.asm02.models.Customer;
import vn.funix.ducntfx18862.java.asm02.models.Account;
import vn.funix.ducntfx18862.java.asm02.models.User;


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
//                    while(!User.validID(customerNumber)){
//                        System.out.println("Nhap so can cuoc cong dan: ");
//                        customerNumber = scanner.nextLine();
//                    }
//                    Customer customerNew = new Customer();
//                    customerNew.setName(customerName);
//                    customerNew.setCustomerId(customerNumber);
//                    bank.addCustomer(customerNew);
//                    System.out.println("Them khach hang moi");
//                    System.out.println(bank.getId());
                    Customer cus1 = new Customer();
                    cus1.setName("Abc");
                    cus1.setCustomerId("001099123456");
                    bank.addCustomer(cus1);
                    for(int i=0;i<bank.getCustomers().size();i++) {
                        System.out.println(bank.getCustomers().get(i).getName());
                        System.out.println(bank.getCustomers().get(i).getCustomerId());
                    }
                } else if (numEnter == 2) {
                    System.out.println("Nhap CCCD khach hang:");
                    String customerNumber = scanner.nextLine();
                    while(!User.validID(customerNumber)){
                        System.out.println("Nhap CCCD khach hang ");
                        customerNumber = scanner.nextLine();
                    }
                    // Check customer existed or not
                    
                    //
                    System.out.println("Nhap ma so STK gom 6 chu so");

                } else if (numEnter == 3) {
                    for(int i=0;i<bank.getCustomers().size();i++) {
                        System.out.println(bank.getCustomers().get(i).getName());
                        System.out.println(bank.getCustomers().get(i).getCustomerId());
                    }
                } else if (numEnter == 4) {
                    Customer cus1 = new Customer();
                    cus1.setName("deg");
                    cus1.setCustomerId("001099456789");
                    bank.addCustomer(cus1);
                    for(int i=0;i<bank.getCustomers().size();i++) {
                        System.out.println(bank.getCustomers().get(i).getName());
                        System.out.println(bank.getCustomers().get(i).getCustomerId());
                    }
                } else if (numEnter == 5) {
                } else if (numEnter == 0) {
                    System.out.println(" ");
                    System.out.println("Program is shutting down");
                    break;
                } else {
                    System.out.println("Invalid number! Please enter again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter again");
            }
        }
    }
}
