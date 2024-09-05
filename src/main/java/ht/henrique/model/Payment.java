package ht.henrique.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {
    private String codCharge;
    private BigDecimal payValue;
    private String status;
}
