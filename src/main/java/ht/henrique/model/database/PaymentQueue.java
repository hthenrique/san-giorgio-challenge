package ht.henrique.model.database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class PaymentQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codSeller;
    private String codCharge;
    private BigDecimal payValue;
    private String status;

    private LocalDateTime dateCreate;

    public PaymentQueue(String codSeller, String codCharge, BigDecimal payValue, String status) {
        this.codSeller = codSeller;
        this.codCharge = codCharge;
        this.payValue = payValue;
        this.status = status;
        this.dateCreate = LocalDateTime.now();
    }
}
