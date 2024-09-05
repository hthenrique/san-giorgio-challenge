package ht.henrique.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateChargeRequest {
    private String codCharge;
    private BigDecimal value;
}
