package br.com.acmepay.domain.models;

import br.com.acmepay.domain.exception.DocumentValidationException;
import br.com.acmepay.domain.exception.EmailValidationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(
        onlyExplicitlyIncluded = true
)

public class Customer {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private List<Account> accounts;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<Customer> customers = new ArrayList<>();

    public void createCustomer(Customer customer) {
        try {
            this.documentValidation(customer.getDocument());
            this.emailValidation(customer.getEmail());
        } catch (DocumentValidationException e) {
            System.out.println(e);
        } catch (EmailValidationException e) {
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

    public List<Customer> listCustomers() {
        return this.customers;

    }

    public void delete(Long id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
            }
        }
    }

    public void update(
            Long id, String name, String email,
            String phone, String document
    ) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                c.setUpdated_at(LocalDateTime.now());
                if (name != null) c.setName(name);
                if (email != null) {
                    try {
                        this.emailValidation(email);
                        c.setEmail(email);
                    }catch (EmailValidationException e) {
                        System.out.println(e);
                    }
                }
                if (phone != null) c.setPhone(phone);

                if (document != null) {
                    try {
                        this.documentValidation(document);
                        c.setDocument(document);
                    } catch (DocumentValidationException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    public Customer getById(Long id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void documentValidation(String document) throws DocumentValidationException {
        for (Customer c : customers) {
            if (c.getDocument().equals(document)) throw new DocumentValidationException("Invalid Document");
        }
    }

    public void emailValidation(String email) throws EmailValidationException {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) throw new EmailValidationException("Invalid email");
        }
    }

}