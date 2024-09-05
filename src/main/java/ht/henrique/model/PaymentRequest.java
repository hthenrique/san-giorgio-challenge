package ht.henrique.model;

import lombok.Data;

import java.util.List;

@Data
public class PaymentRequest {
    private String codSeller;
    private List<Payment> payments;
}
