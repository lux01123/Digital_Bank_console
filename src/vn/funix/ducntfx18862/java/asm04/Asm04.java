package vn.funix.ducntfx18862.java.asm04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Asm04 {
    // Define all const
    private static final int SHOW_CUSTOMER_LIST = 1;
    private static final int PUT_CUSTOMER_LIST = 2;
    private static final int ADD_ACCOUNT_ATM = 3;
    private static final int TRANSACT = 4;
    private static final int WITHDRAW = 5;
    private static final int SHOW_HISTORY = 6;



    // Define all function
    private static final Scanner scanner = new Scanner(System.in);

    // Show start screen
    public static void showScreen() {
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| NGÂN HÀNG ĐIỆN TỬ | FX18862@v4.0.0    |");
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| 1. Danh sách khách hàng               |");
        System.out.println("| 2. Nhập danh sách khách hàng          |");
        System.out.println("| 3. Thêm tài khoản ATM                 |");
        System.out.println("| 4. Chuyển tiền                        |");
        System.out.println("| 5. Rút tiền                           |");
        System.out.println("| 6. Tra cứu lịch sử giao dịch          |");
        System.out.println("| 0. Thoát                              |");
        System.out.println("+-----------+-----------------+---------+");
    }

    // Get number of input Enter
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
        showScreen();
        boolean isRunning = true;
        while (isRunning) {
            int numEnter = getNumberEnter();
            switch (numEnter) {
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 4 -> System.out.println();
                case 5 -> System.out.println();
                case 6 -> System.out.println();
                case 0 -> {
                    isRunning = false;
                    System.out.println("Program is shutting down");
                }
                default -> System.out.println("Khong ton tai chuc nang nay");
            }
        }
    }
}
