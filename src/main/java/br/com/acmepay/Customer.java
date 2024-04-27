package br.com.acmepay;

import br.com.acmepay.exception.DocumentValidationException;
import br.com.acmepay.exception.EmailValidationException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<Account> accounts;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<Customer> customers = new ArrayList<>();

    public void createCustomer(Customer customer){
        try {
            this.documentValidation(customer.getDocument());
            this.emailValidation(customer.getEmail());
        }catch (DocumentValidationException e){
            System.out.println(e);
        }catch (EmailValidationException e){
            System.out.println(e);
        }

        this.id = customer.id;
        this.name = customer.name;
        this.email = customer.email;
        this.phone = customer.phone;
        this.document = customer.document;
        this.accounts = customer.accounts;
        this.created_at = customer.created_at;
        this.updated_at = customer.updated_at;
        this.customers.add(this);
    }
    public listCustomers(){

    }

    public void delete(int id){
        for (Customer c : customers){
            if (c.getId() == id){
                customers.remove(c);
            }
        }
    }
    //verificar validações
    public void update(int id, Customer customer){
        for (Customer c : customers){
            if (c.getId() == id){

                c.setUpdated_at(LocalDateTime.now());
                c.setEmail(customer.getEmail());
                c.setAccounts(customer.getAccounts());
                c.setName(customer.getName());
                c.setDocument(customer.getDocument());
                c.setPhone(customer.getPhone());
            }
        }
    }
    public Customer getById(int id){
        for (Customer c: customers){
            if (c.getId() == id){
                return c;
            }
        }
    }

    public void documentValidation(String document) throws DocumentValidationException {
        for (Customer c: customers) {
            if (c.getDocument().equals(document)) throw new DocumentValidationException("Invalid Document");
        }
    }
    public void emailValidation(String email) throws EmailValidationException{
        for (Customer c: customers) {
            if (c.getEmail().equals(email)) throw new EmailValidationException("Invalid email");
        }
    }

}