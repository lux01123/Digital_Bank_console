package vn.funix.ducntfx18862.java.asm04;

import vn.funix.ducntfx18862.java.asm04.models.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Asm04 {

    // Default
    private static final String FILE_PATH_DEFAULT = "src/vn/funix/ducntfx18862/java/asm04/";
    private static final DigitalBank activeBank = new DigitalBank("ACTIVEBANK");

    // Define all function
    private static final Scanner scanner = new Scanner(System.in);

    // Enter 1: Show customer in file
    public static void ShowCustomerList(){
        activeBank.showCustomers();
    }

    // Enter 2: Add customer to file
    public static void PullCustomerList() throws IOException, CustomerIdNotValidException {
        scanner.nextLine();
        System.out.println("Nhập đường dẫn đến tệp");
        String filePath = scanner.nextLine();
        String filePathCustomerTXT = FILE_PATH_DEFAULT + filePath;
        activeBank.addCustomer(filePathCustomerTXT);
    }

    // Enter 3: add a new account atm to file
    public static void AddAccountAtm() throws IOException {
        scanner.nextLine();
        System.out.println("Nhập mã số của khách hàng");
        String customerId = scanner.nextLine();
        System.out.print("Nhập mã số tài khoản gồm 6 chữ số: ");
        String numberAccount = scanner.nextLine();
        System.out.print("Nhập số dư tài khoản >= 50.000 d: ");
        String strNumberBalance = scanner.nextLine();
        activeBank.addSavingsAccount(customerId, numberAccount, strNumberBalance);
    }

    // Enter 4: make a transaction
    public static void Transact() throws IOException {
        scanner.nextLine();
        System.out.println("Nhập mã số của khách hàng");
        String customerId = scanner.nextLine();
        activeBank.transferAmount(customerId);
    }

    // Enter 5: withdraw and save to file
    public static void Withdraw() throws IOException {
        scanner.nextLine();
        System.out.println("Nhập mã số của khách hàng: ");
        String customerId = scanner.nextLine();
        activeBank.withdraw(customerId);
    }

    // Enter 6: show transaction of customer in file
    public static void ShowHistory(){
        scanner.nextLine();
        System.out.println("Nhập mã số của khách hàng: ");
        String customerId = scanner.nextLine();
        activeBank.showTransactionsCustomer(customerId);
    }

    // Show start screen
    public static void ShowScreen() {
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
    public static int GetNumberEnter() {
        while (true) {
            System.out.print("Chọn chức năng: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Hãy nhập vao số thứ tự của chức năng !!!");
            }
        }
    }


    public static void main(String[] args) throws IOException, CustomerIdNotValidException {
        //======== Test function print Customer from text file =================
//        String filePath = FILE_PATH_DEFAULT +  "store/customers.txt";
//        List<Customer> customers = TextFileService.readFileT(filePath);
//        for (int i = 0; i < customers.size(); i++){
//            System.out.println(customers.get(i).getCustomerId() + " | "
//                    + customers.get(i).getName());
//        }

//        List<List<String>> customerList = TextFileService.readFile(filePath);
//        for(int i = 0; i < customerList.size(); i++){
//            if(Account.validID(customerList.get(i).get(0))){
//                System.out.println(customerList.get(i));
//            }
//            else {
//                System.out.println("Tai khoan " + customerList.get(i).get(0) + " khong hop le");
//            }
//        }
        //======== Test function of digital bank add and read customer list=========================
//        activeBank.showCustomers();
//        System.out.println("========================================");
//        activeBank.addCustomer(filePath);
//        activeBank.showCustomers();
        //========True program=======================
        ShowScreen();
        boolean isRunning = true;
        while (isRunning) {
            int numEnter = GetNumberEnter();
            switch (numEnter) {
                case 1 -> ShowCustomerList();
                case 2 -> PullCustomerList();
                case 3 -> AddAccountAtm();
                case 4 -> Transact();
                case 5 -> Withdraw();
                case 6 -> ShowHistory();
                case 0 -> {
                    isRunning = false;
                    System.out.println("Program is shutting down");
                }
                default -> System.out.println("Không tồn tại chức năng này");
            }
        }
    }
}
