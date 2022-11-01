package vn.funix.ducntfx18862.java.asm01;

import java.util.Scanner;
import java.util.Random;
public class Asm01 {
    private static Scanner scanner = new Scanner(System.in);

    public static void Print_Enter_Again() {
        System.out.println("Invalid number! Please enter again");
    }

    public static int Create_Random_Number() {
        Random rand = new Random();
        int ranNum = rand.nextInt(1000);
        return ranNum;
    }

    public static void main (String[] args) {
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| NGAN HANG SO | FX18862@v1.0.0         |");
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| 1. Nhap CCCD                          |");
        System.out.println("| 0 Thoat                               |");
        System.out.println("+-----------+-----------------+---------+");
        while(true){
            int numEnter;
            System.out.print("Chuc nang: ");
            numEnter = scanner.nextInt();
            if (numEnter == 1) {
                System.out.println("You enter 1");
                System.out.println(Create_Random_Number());
            } else if (numEnter == 0) {
                System.out.println("You enter 0");
                System.out.println("Program is shutting down");
                break;
            } else {
                Print_Enter_Again();
            }
        }
    }
}
