package ht.henrique.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateChargeRequest {
    private String codCharge;
    private BigDecimal value;
}
