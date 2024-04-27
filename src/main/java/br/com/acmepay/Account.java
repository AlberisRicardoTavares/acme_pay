package br.com.acmepay;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Account {
    @Getter
    private Bank bank;
    private Long id;
    private int number;
    private int agency;
    @Getter @Setter
    private BigDecimal balance;
    private Customer customer;
    private List<Card> cards;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private boolean closed;

    public Account createAccount(){
        return this;
    }


}
