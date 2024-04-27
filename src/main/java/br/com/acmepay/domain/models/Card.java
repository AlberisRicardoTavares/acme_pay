package br.com.acmepay.domain.models;

import java.math.BigDecimal;

public class Card {
    private long id;
    private String flag;
    private BigDecimal cardLimit;
    private Account cardAccount;
}
