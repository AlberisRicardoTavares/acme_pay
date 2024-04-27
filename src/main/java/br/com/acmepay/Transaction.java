package br.com.acmepay;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
public class Transaction {

    private UUID transactionId;
    private BigDecimal transactionValue;
    private int destinationAccount;
    private int originAccount;
    private LocalDate transactionDate;
}