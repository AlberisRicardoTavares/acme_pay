package br.com.acmepay;

import lombok.Getter;

@Getter
public class Bank {

    private String name;
    private Long bankId;

    public boolean compareTo(Bank bank){
        return this.bankId == bank.getBankId();
    }




}
