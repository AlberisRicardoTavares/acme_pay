package br.com.acmepay.domain.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Account account = new Account();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();

        List<Customer> customers = new ArrayList<>();
        Set<Customer> customerSet = new HashSet<>();

        customer1.setId(123L);
        customer1.setEmail("123@123");
        customers.add(customer1);
        customerSet.add(customer1);

        customer2.setId(123L);
        customer2.setEmail("123@123");
        //customers.add(customer2);

        customer3.setId(123L);
        customer3.setEmail("321@321");
        //customers.add(customer3);
        //customerSet.add(customer3);

        customer4.setId(321L);
        customer4.setEmail("123@123");
        customers.add(customer4);


        System.out.println(customer1.equals(customer2));
        System.out.println(customer1.equals(customer3));
        System.out.println(customer1.equals(customer4));

        System.out.println(customers.contains(customer2));
        System.out.println(customerSet.contains(customer4));

    }
}
