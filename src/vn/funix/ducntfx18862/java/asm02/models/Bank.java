package vn.funix.ducntfx18862.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return this.id;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void addCustomer(Customer newCustomer) {
        boolean duplicatedCus = false;
        for (int i = 0; i < this.customers.size(); i++) {
            if (Objects.equals(newCustomer.getCustomerId(), customers.get(i).getCustomerId())) {
                duplicatedCus = true;
            }
        }
        if (!duplicatedCus) {
            customers.add(newCustomer);
            System.out.println("Da them khach hang moi");
        } else {
            System.out.println("Khach hang da dang ky !");
        }
    }

    public void addAccount(String customerId, Account account) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (Objects.equals(customerId, customers.get(i).getCustomerId())) {
                customers.get(i).addAccount(account);
            }
        }
    }

    public boolean isCustomerExisted(String customerId) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (Objects.equals(customerId, customers.get(i).getCustomerId())) {
                return true;
            }
        }
        return false;
    }


}
