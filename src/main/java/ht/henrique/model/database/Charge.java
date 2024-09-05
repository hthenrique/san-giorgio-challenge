package ht.henrique.model.database;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cod_charge")
    private String _codCharge;

    @Column(name = "value")
    private BigDecimal _value;
}
