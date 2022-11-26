package vn.funix.ducntfx18862.java.asm04.models;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFileService {
    private static final String COMMA_DELIMITER = ",";

    public TextFileService(){}

    public static List<Customer> readFileT(String fileName){
        List<Customer> objects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(COMMA_DELIMITER);
                Customer customer = new Customer(arr[0], arr[1]);
                objects.add(customer);
            }
        } catch (IOException e){
            System.out.println("Tệp không tồn tại");
        }
        return objects;
    }

    public static List<List<String>> readFile(String fileName){
        List<List<String>> objects = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(COMMA_DELIMITER);
                objects.add(Arrays.asList(arr));
            }
        } catch (IOException e){
            System.out.println("Tệp không tồn tại");
        }
        return objects;
    }
}
