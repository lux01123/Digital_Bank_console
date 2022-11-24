package vn.funix.ducntfx18862.java.asm04.models;

import java.io.IOException;
import java.util.List;

public class AccountDao {
    private final static String FILE_PATH = "store/accounts.dat";

    public static void save(List<Account> customers) throws IOException {
        BinaryFileService.writeFile(FILE_PATH, customers);
    }

    public static List<Account> list() {
        return BinaryFileService.readFile(FILE_PATH);
    }
}
