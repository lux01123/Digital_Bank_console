package vn.funix.ducntfx18862.java.asm01;

import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class Asm01 {
    private static Scanner scanner = new Scanner(System.in);

    //function create random security number
    public static int Create_Random_Number() {
        Random rand = new Random();
        int ranNum = rand.nextInt(1000);
        return ranNum;
    }

    //function check string is number or not
    public static boolean isNumeric(String strNum) {
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

    public static void main(String[] args) {
        //Creating a dictionary for place
        Dictionary dict1 = new Hashtable();
        //Adding values in the dictionary
        dict1.put("001", "Hà Nội");
        dict1.put("002", "Hà Giang");
        dict1.put("004", "Cao Bằng");
        dict1.put("006", "Bắc Kạn");
        dict1.put("008", "Tuyên Quang");
        dict1.put("010", "Lào Cai");
        dict1.put("011", "Điện Biên");
        dict1.put("012", "Lai Châu");
        dict1.put("014", "Sơn La");
        dict1.put("015", "Yên Bái");
        dict1.put("017", "Hòa Bình");
        dict1.put("019", "Thái Nguyên");
        dict1.put("020", "Lạng Sơn");
        dict1.put("022", "Quảng Ninh");
        dict1.put("024", "Bắc Giang");
        dict1.put("025", "Phú Thọ");
        dict1.put("026", "Vĩnh Phúc");
        dict1.put("027", "Bắc Ninh");
        dict1.put("030", "Hải Dương");
        dict1.put("031", "Hải Phòng");
        dict1.put("033", "Hưng Yên");
        dict1.put("034", "Thái Bình");
        dict1.put("035", "Hà Nam");
        dict1.put("036", "Nam Định");
        dict1.put("037", "Ninh Bình");
        dict1.put("038", "Thanh Hóa");
        dict1.put("040", "Nghệ An");
        dict1.put("042", "Hà Tĩnh");
        dict1.put("044", "Quảng Bình");
        dict1.put("045", "Quảng Trị");
        dict1.put("046", "Thừa Thiên Huế");
        dict1.put("048", "Đà Nẵng");
        dict1.put("049", "Quảng Nam");
        dict1.put("051", "Quảng Ngãi");
        dict1.put("052", "Bình Định");
        dict1.put("054", "Phú Yên");
        dict1.put("056", "Khánh Hòa");
        dict1.put("058", "Ninh Thuận");
        dict1.put("060", "Bình Thuận");
        dict1.put("062", "Kon Tum");
        dict1.put("064", "Gia Lai");
        dict1.put("066", "Đắk Lắk");
        dict1.put("067", "Đắk Nông");
        dict1.put("068", "Lâm Đồng");
        dict1.put("070", "Bình Phước");
        dict1.put("072", "Tây Ninh");
        dict1.put("074", "Bình Dương");
        dict1.put("075", "Đồng Nai");
        dict1.put("077", "Bà Rịa - Vũng Tàu");
        dict1.put("079", "Hồ Chí Minh");
        dict1.put("080", "Long An");
        dict1.put("082", "Tiền Giang");
        dict1.put("083", "Bến Tre");
        dict1.put("084", "Trà Vinh");
        dict1.put("086", "Vĩnh Long");
        dict1.put("087", "Đồng Tháp");
        dict1.put("089", "An Giang");
        dict1.put("091", "Kiên Giang");
        dict1.put("092", "Cần Thơ");
        dict1.put("093", "Hậu Giang");
        dict1.put("094", "Sóc Trăng");
        dict1.put("095", "Bạc Liêu");
        dict1.put("096", "Cà Mau");

        //For program
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| NGAN HANG SO | FX18862@v1.0.0         |");
        System.out.println("+-----------+-----------------+---------+");
        System.out.println("| 1. Nhap CCCD                          |");
        System.out.println("| 0 Thoat                               |");
        System.out.println("+-----------+-----------------+---------+");
        //Loop for main program
        boolean doProgram1 = true;                          // Logic for program can run or stop
        while (doProgram1) {
            int numEnter;
            System.out.println(" ");
            System.out.print("Chuc nang: ");
            numEnter = scanner.nextInt();
            if (numEnter == 1) {
//                System.out.println("You enter 1");
                int numRandom = Create_Random_Number();
                System.out.println("Nhap ma xac thuc: " + numRandom);
                //Loop for check random security number
                boolean doProgram2 = true;                  // Logic for program can run or stop
                while (doProgram2) {
                    int numEnterCheck;
                    numEnterCheck = scanner.nextInt();
                    if (numEnterCheck == numRandom) {
                        //Loop for check string number
                        boolean doProgram3 = true;          // Logic for program can run or stop
                        while (doProgram3) {
                            System.out.print("Vui long nhap so can cuoc cong dan: ");
                            String numCCCD = scanner.next();        // Number user enter for ID
                            // Exit program
                            if (numCCCD.equals("No")) {
                                doProgram3 = false;
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
                            boolean isNumber = isNumeric(numCCCD);

                            //Analysis string number
                            boolean isCity = false;                             //Condition is city or not

                            String s0 = String.valueOf(numCCCD.charAt(0));
                            String s1 = String.valueOf(numCCCD.charAt(1));
                            String s2 = String.valueOf(numCCCD.charAt(2));
                            String s3 = String.valueOf(numCCCD.charAt(3));
                            String s4 = String.valueOf(numCCCD.charAt(4));
                            String s5 = String.valueOf(numCCCD.charAt(5));
                            String s6 = String.valueOf(numCCCD.charAt(6));
                            String s7 = String.valueOf(numCCCD.charAt(7));
                            String s8 = String.valueOf(numCCCD.charAt(8));
                            String s9 = String.valueOf(numCCCD.charAt(9));
                            String s10 = String.valueOf(numCCCD.charAt(10));
                            String s11 = String.valueOf(numCCCD.charAt(11));

                            String numCity = s0 + s1 + s2;
                            String numGender = s3;
                            String numCentury = s4 + s5;
                            String numEnd = s6 + s7 + s8 + s9 + s10 + s11;

                            String BirthYear = null;
                            String Gender = null;
                            if(isNumber) {
                                // Check city
                                if(dict1.get(numCity).equals("null")) {
                                    isCity = false;
                                } else {
                                    isCity = true;
                                }

                                // Choose birth
                                switch (numGender) {
                                    case "0": case "1":
                                        BirthYear = "19" + numCentury;
                                        break;
                                    case "2": case "3":
                                        BirthYear = "20" + numCentury;
                                        break;
                                    case "4": case "5":
                                        BirthYear = "21" + numCentury;
                                        break;
                                    case "6": case "7":
                                        BirthYear = "22" + numCentury;
                                        break;
                                    case "8": case "9":
                                        BirthYear = "23" + numCentury;
                                        break;
                                    default:
                                        break;
                                }
                                // Choose gender
                                switch (numGender) {
                                    case "0": case "2": case "4": case "6": case "8":
                                        Gender = "Nam";
                                        break;
                                    case "1": case "3": case "5": case "7": case "9":
                                        Gender = "Nu";
                                        break;
                                    default:
                                        break;
                                }

                            }

                            //Check all condition of string number
                            boolean validCCCD = isNumber && lengthCCCD && isCity;

                            if (validCCCD) {
//                                System.out.println("Valid number: " + numCCCD);
                                System.out.println("    | 1. Kiem tra noi sinh");
                                System.out.println("    | 2. Kiem tra tuoi, gioi tinh");
                                System.out.println("    | 3. Kiem tra so ngau nhien");
                                System.out.println("    | 0. Thoat");
                                System.out.println("Noi sinh: " + dict1.get(numCity));
                                System.out.println("Gioi tinh " + Gender + " | " + BirthYear);
                                System.out.println("So ngau nhien " + numEnd);

                            } else {
                                System.out.println(" ");
                                System.out.println("So can cuoc cong dan khong hop le");
                                System.out.println("Vui long nhap lai hoac 'No' de thoat");
                            }
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Ma xac thuc khong dung. Vui long thu lai");
                    }
                }
            } else if (numEnter == 0) {
//                System.out.println("You enter 0");
                System.out.println(" ");
                System.out.println("Program is shutting down");
                doProgram1 = false;
            } else {
                System.out.println("Invalid number! Please enter again");
            }
        }
    }
}
