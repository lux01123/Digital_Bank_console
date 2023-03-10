package vn.funix.ducntfx18862.java.asm02.models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String customerId;

    public User() {
    }

    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static boolean validID(String customerId) {
        //Creating a dictionary for place
        Map<String, String> dict1 = new HashMap<String, String>();
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
        //Check length of string
        boolean lengthCondition;
        if (customerId.length() == 12) {
            lengthCondition = true;
        } else {
            lengthCondition = false;
        }
        //Check string is number
        boolean numCondition;
        if (customerId == null) {
            numCondition = false;
        }
        try {
            double d = Double.parseDouble(customerId);
            numCondition = true;
        } catch (NumberFormatException nfe) {
            numCondition = false;
        }
        // Check city in string
        boolean cityCondition;
        String numCity = String.valueOf(customerId.charAt(0))
                + customerId.charAt(1)
                + customerId.charAt(2);
        if (!(dict1.get(numCity) == null)) {
            cityCondition = true;
        } else {
            cityCondition = false;
        }

        boolean validId = lengthCondition && numCondition && cityCondition;
        return validId;
    }

    public void setCustomerId(String customerId) {
        if (validID(customerId)) {
            this.customerId = customerId;
        } else {
            System.out.println("Exception Error");
        }
    }

    public String getCustomerId() {
        return this.customerId;
    }
}
