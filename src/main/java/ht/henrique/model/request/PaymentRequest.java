package ht.henrique.model.request;

import ht.henrique.model.Payment;
import lombok.Data;

import java.util.List;

@Data
public class PaymentRequest {
    private String codSeller;
    private List<Payment> payments;
}
