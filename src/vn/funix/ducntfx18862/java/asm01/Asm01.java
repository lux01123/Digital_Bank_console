//Version: Java 8 - JDK 18.0.2
package vn.funix.ducntfx18862.java.asm01;

import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class Asm01 {
    private static Scanner scanner = new Scanner(System.in);

    // Create string security EASY

    public static String CreateNumber() {
        Random rand = new Random();
        int ranNum1 = rand.nextInt(900);
        int ranNum = ranNum1 + 100;
        String securityString = String.valueOf(ranNum);
        return securityString;
    }


    // Create string security number ADVANTAGE
    public static String CreateStringNumber() {
        String securityString = null;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        char c1 = alphabet.charAt(r.nextInt(alphabet.length()));
        char c2 = alphabet.charAt(r.nextInt(alphabet.length()));
        char c3 = alphabet.charAt(r.nextInt(alphabet.length()));
        char c4 = alphabet.charAt(r.nextInt(alphabet.length()));
        char c5 = alphabet.charAt(r.nextInt(alphabet.length()));
        char c6 = alphabet.charAt(r.nextInt(alphabet.length()));
        securityString = String.valueOf(c1) + c2 + c3 + c4 + c5 + c6;
        return securityString;
    }

    //function check string is number or not
    public static boolean IsNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Function print basic screen
    public static void PrintScreen() {
        System.out.println("    | 1. Kiem tra noi sinh");
        System.out.println("    | 2. Kiem tra tuoi, gioi tinh");
        System.out.println("    | 3. Kiem tra so ngau nhien");
        System.out.println("    | 0. Thoat");
        System.out.print("Chuc nang:  ");
    }

    public static void main(String[] args) {
        //Creating a dictionary for place
        Map<String, String> dict1 = new HashMap<String, String>();
        //Adding values in the dictionary
        dict1.put("001", "H?? N???i");
        dict1.put("002", "H?? Giang");
        dict1.put("004", "Cao B???ng");
        dict1.put("006", "B???c K???n");
        dict1.put("008", "Tuy??n Quang");
        dict1.put("010", "L??o Cai");
        dict1.put("011", "??i???n Bi??n");
        dict1.put("012", "Lai Ch??u");
        dict1.put("014", "S??n La");
        dict1.put("015", "Y??n B??i");
        dict1.put("017", "H??a B??nh");
        dict1.put("019", "Th??i Nguy??n");
        dict1.put("020", "L???ng S??n");
        dict1.put("022", "Qu???ng Ninh");
        dict1.put("024", "B???c Giang");
        dict1.put("025", "Ph?? Th???");
        dict1.put("026", "V??nh Ph??c");
        dict1.put("027", "B???c Ninh");
        dict1.put("030", "H???i D????ng");
        dict1.put("031", "H???i Ph??ng");
        dict1.put("033", "H??ng Y??n");
        dict1.put("034", "Th??i B??nh");
        dict1.put("035", "H?? Nam");
        dict1.put("036", "Nam ?????nh");
        dict1.put("037", "Ninh B??nh");
        dict1.put("038", "Thanh H??a");
        dict1.put("040", "Ngh??? An");
        dict1.put("042", "H?? T??nh");
        dict1.put("044", "Qu???ng B??nh");
        dict1.put("045", "Qu???ng Tr???");
        dict1.put("046", "Th???a Thi??n Hu???");
        dict1.put("048", "???? N???ng");
        dict1.put("049", "Qu???ng Nam");
        dict1.put("051", "Qu???ng Ng??i");
        dict1.put("052", "B??nh ?????nh");
        dict1.put("054", "Ph?? Y??n");
        dict1.put("056", "Kh??nh H??a");
        dict1.put("058", "Ninh Thu???n");
        dict1.put("060", "B??nh Thu???n");
        dict1.put("062", "Kon Tum");
        dict1.put("064", "Gia Lai");
        dict1.put("066", "?????k L???k");
        dict1.put("067", "?????k N??ng");
        dict1.put("068", "L??m ?????ng");
        dict1.put("070", "B??nh Ph?????c");
        dict1.put("072", "T??y Ninh");
        dict1.put("074", "B??nh D????ng");
        dict1.put("075", "?????ng Nai");
        dict1.put("077", "B?? R???a - V??ng T??u");
        dict1.put("079", "H??? Ch?? Minh");
        dict1.put("080", "Long An");
        dict1.put("082", "Ti???n Giang");
        dict1.put("083", "B???n Tre");
        dict1.put("084", "Tr?? Vinh");
        dict1.put("086", "V??nh Long");
        dict1.put("087", "?????ng Th??p");
        dict1.put("089", "An Giang");
        dict1.put("091", "Ki??n Giang");
        dict1.put("092", "C???n Th??");
        dict1.put("093", "H???u Giang");
        dict1.put("094", "S??c Tr??ng");
        dict1.put("095", "B???c Li??u");
        dict1.put("096", "C?? Mau");
        //For program
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| NGAN HANG SO | FX18862@v1.0.0         |");
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| 1. Nhap CCCD                          |");
        System.out.println("| 0. Thoat                              |");
        System.out.println("+-----------+-----------------+---------+");
        //Loop for main program
        while (true) {
            String stringEnter;                 // Create a string input then use Try-Catch convert to number ADVANTAGE
            System.out.println(" ");
            System.out.print("Chuc nang: ");
            stringEnter = scanner.nextLine();
            try {
                int numEnter = Integer.valueOf(stringEnter);
                if (numEnter == 1) {
                    String numRandom;
                    while (true) {

                        System.out.println("An 1 chon ma xac thuc de hoac 2 chon ma xac thuc kho: ");
                        String stringEntermode = scanner.nextLine();
                        try {
                            int numEnterMode = Integer.valueOf(stringEntermode);
                            if (numEnterMode == 1) {
                                numRandom = CreateNumber();
                                break;
                            } else if (numEnterMode == 2) {
                                numRandom = CreateStringNumber();
                                break;
                            }
                        } catch (NumberFormatException e) {
                        }
                    }
                    System.out.println("Nhap ma xac thuc: " + numRandom);
                    //Loop for check random security number
                    boolean doProgram2 = true;                                      // Logic for program can run or stop
                    while (doProgram2) {
                        String numEnterCheck;
                        numEnterCheck = scanner.nextLine();
                        if (Objects.equals(numEnterCheck, numRandom)) {
                            //Loop for check string number
                            boolean doProgram3 = true;                              // Logic for program can run or stop
                            System.out.print("Vui long nhap so can cuoc cong dan: ");
                            while (doProgram3) {
                                String numCCCD = scanner.next();                    // Number user enter for ID
                                // Exit program
                                if (numCCCD.equals("No")) {
                                    doProgram2 = false;
                                    break;
                                }
                                //Check length of string
                                boolean lengthCCCD;
                                if (numCCCD.length() == 12) {
                                    lengthCCCD = true;
                                } else {
                                    lengthCCCD = false;
                                }
                                //Check string is a number ?
                                boolean isNumber = IsNumeric(numCCCD);
                                //Analysis string number
                                // Variable for check
                                String numCity = "";
                                String numGender = "";
                                String numCentury = "";
                                String numEnd = "";
                                // Variable for print to screen
                                String BirthYear = "";
                                String Gender = "";
                                //Check city number
                                if (isNumber && lengthCCCD) {
                                    //Set value for variable to check
                                    numCity = String.valueOf(numCCCD.charAt(0))
                                            + numCCCD.charAt(1)
                                            + numCCCD.charAt(2);
                                    numGender = String.valueOf(numCCCD.charAt(3));
                                    numCentury = String.valueOf(numCCCD.charAt(4))
                                            + numCCCD.charAt(5);
                                    numEnd = String.valueOf(numCCCD.charAt(6))
                                            + numCCCD.charAt(7)
                                            + numCCCD.charAt(8)
                                            + numCCCD.charAt(9)
                                            + numCCCD.charAt(10)
                                            + numCCCD.charAt(11);
                                    // Check city
                                    if (!(dict1.get(numCity) == null)) {
                                        // Choose birth
                                        switch (numGender) {
                                            case "0", "1" -> BirthYear = "19" + numCentury;
                                            case "2", "3" -> BirthYear = "20" + numCentury;
                                            case "4", "5" -> BirthYear = "21" + numCentury;
                                            case "6", "7" -> BirthYear = "22" + numCentury;
                                            case "8", "9" -> BirthYear = "23" + numCentury;
                                            default -> {
                                            }
                                        }
                                        // Choose gender
                                        switch (numGender) {
                                            case "0", "2", "4", "6", "8" -> Gender = "Nam";
                                            case "1", "3", "5", "7", "9" -> Gender = "Nu";
                                            default -> {
                                            }
                                        }
                                    }
                                }
                                //Check all condition of string number
                                if (isNumber && lengthCCCD && (!(dict1.get(numCity) == null))) {
                                    while (true) {
                                        String stringCheckFunc = scanner.nextLine();
                                        try {
                                            int numCheckFunc = Integer.valueOf(stringCheckFunc);
                                            if (numCheckFunc == 0) {
                                                System.out.println("Thoat chuong trinh kiem tra");
                                                doProgram3 = false;
                                                doProgram2 = false;
                                                break;
                                            } else if (numCheckFunc == 1) {
                                                System.out.println("Noi sinh: " + dict1.get(numCity));
                                                PrintScreen();
                                            } else if (numCheckFunc == 2) {
                                                System.out.println("Gioi tinh: " + Gender + " | " + BirthYear);
                                                PrintScreen();
                                            } else if (numCheckFunc == 3) {
                                                System.out.println("So ngau nhien: " + numEnd);
                                                PrintScreen();
                                            } else {
                                                System.out.println("");
                                                PrintScreen();
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("");
                                            PrintScreen();
                                        }
                                    }
                                } else {
                                    System.out.println(" ");
                                    System.out.println("So can cuoc cong dan khong hop le");
                                    System.out.print("Vui long nhap lai hoac 'No' de thoat: ");
                                }
                            }
                        } else {
                            System.out.println(" ");
                            System.out.println("Ma xac thuc khong dung. Vui long thu lai.");
                            System.out.print("Nhap ma xac thuc: ");
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
                System.out.println("Invalid number! Please enter again");
            }
        }
    }
}