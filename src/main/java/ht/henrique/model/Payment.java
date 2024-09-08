package ht.henrique.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Payment {
    private String codCharge;
    private BigDecimal payValue;
    private String status;

    public Payment(String codCharge, BigDecimal payValue, String status) {
        this.codCharge = codCharge;
        this.payValue = payValue;
        this.status = status;
    }
}
