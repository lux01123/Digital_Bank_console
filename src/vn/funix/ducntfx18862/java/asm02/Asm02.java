package vn.funix.ducntfx18862.java.asm02;

import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class Asm02 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| NGAN HANG SO | FX18862@v1.0.0         |");
        System.out.println("+-----------+-----------------+---------+");
        System.out.println(" 1. Them khach hang                      ");
        System.out.println(" 2. Them tai khoan cho khach hang        ");
        System.out.println(" 3. Hien thi danh sach khach hang        ");
        System.out.println(" 4. Tim theo CCCD                        ");
        System.out.println(" 5. Them theo ten khach hang             ");
        System.out.println(" 0. Thoat                                ");
        System.out.println("+-----------+-----------------+---------+");
        while (true) {
            String stringEnter;                 // Create a string input then use Try-Catch convert to number ADVANTAGE
            System.out.println(" ");
            System.out.print("Chuc nang: ");
            stringEnter = scanner.nextLine();
            try {
                int numEnter = Integer.valueOf(stringEnter);
                if (numEnter == 1) {
                } else if (numEnter == 2) {
                } else if (numEnter == 3) {
                } else if (numEnter == 4) {
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
