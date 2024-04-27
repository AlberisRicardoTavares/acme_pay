package br.com.acmepay;

import br.com.acmepay.exception.BalanceToWithdrawException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private List<String> transactions = new ArrayList<>();
    public void createAccount(Account account){
        this.id = account.id;
        this.number = account.number;
        this.agency = account.agency;
        this.balance = account.balance;
        this.customer = account.customer;
        this.cards = account.cards;
        this.createdAt = account.createdAt;
        this.updatedAt = account.updatedAt;
        this.closed = account.closed;
        transactions.add("account created sucessfully" + createdAt);
    }
    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
        transactions.add("transaction received iin the amount of:" + amount);
    }
    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(BigDecimal.ZERO) <= 0){
            throw new BalanceToWithdrawException("error: you have no balance");
        }
        else if (this.balance.subtract(amount).compareTo(BigDecimal.ZERO) < 0){
            throw new BalanceToWithdrawException ("error: insufficient balance");
        }
        this.balance = this.balance.subtract(amount);
        transactions.add("transaction made in the amount of:" + amount);
    }

    public String transfer(Account destinationAccount, BigDecimal amount) throws BalanceToWithdrawException{
        try{
            this.withdraw(amount);
        }catch (BalanceToWithdrawException e){
            System.out.println(e);
        }
        destinationAccount.deposit(amount);
        return "transaction sucessful!";

    }

    public String extract(){
        String text = "Extract";
        for(String transaction : transactions){
            text = text + "\n" + transaction;
        }
        return text;
    }




}
