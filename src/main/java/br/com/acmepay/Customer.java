package br.com.acmepay;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class Customer {

    private String customerDocument;
    private List<Account> customerAccounts;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
}