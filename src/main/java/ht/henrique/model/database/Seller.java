package ht.henrique.model.database;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long _id;

    @Column(name = "name", nullable = false)
    private String _name;

    @NonNull
    @Column(name = "cod_seller", nullable = false)
    private String _codSeller;
}
