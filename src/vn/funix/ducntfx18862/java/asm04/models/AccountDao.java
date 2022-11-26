package vn.funix.ducntfx18862.java.asm04.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private final static String FILE_PATH = "src/vn/funix/ducntfx18862/java/asm04/store/accounts.dat";

    public static void save(List<Account> accounts) throws IOException {
        BinaryFileService.writeFile(FILE_PATH, accounts);
    }

    public static List<Account> list() {
        return BinaryFileService.readFile(FILE_PATH);
    }

    public static void update(Account editAccount) throws IOException {
        boolean isNew = true;
        List<Account> accounts = new ArrayList<>();
        for(int i = 0; i < list().size(); i++){
            if(accounts.get(i).getAccountNumber().equals(editAccount.getAccountNumber())){
                isNew = false;
                break;
            }
        }
        if (isNew){
            accounts.add(editAccount);
        }
        save(accounts);
    }
}
