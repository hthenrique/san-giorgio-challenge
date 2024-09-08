package ht.henrique.util;

import ht.henrique.model.Payment;
import ht.henrique.model.database.Charge;
import ht.henrique.model.database.Seller;
import ht.henrique.model.request.CreateChargeRequest;
import ht.henrique.model.request.CreateSellerRequest;
import ht.henrique.model.request.PaymentRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    protected PaymentRequest mockPaymentRequest() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCodSeller("123");
        paymentRequest.setPayments(createPaymentList());
        return paymentRequest;
    }

    protected List<Payment> createPaymentList() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("123", new BigDecimal(100), "pending"));
        payments.add(new Payment("123", new BigDecimal(10), "pending"));
        payments.add(new Payment("123", new BigDecimal(200), "pending"));
        payments.add(new Payment("123", new BigDecimal(300), "pending"));
        payments.add(new Payment("1234", new BigDecimal(300), "pending"));
        return payments;
    }

    protected CreateSellerRequest mockCreateSellerRequest() {
        CreateSellerRequest createSellerRequest = new CreateSellerRequest();
        createSellerRequest.setName("Teste");
        createSellerRequest.setCodSeller("123");
        return createSellerRequest;
    }

    protected CreateChargeRequest mockCreateChargeRequest() {
        CreateChargeRequest createChargeRequest = new CreateChargeRequest();
        createChargeRequest.setCodCharge("123");
        createChargeRequest.setValue(new BigDecimal(100));
        return createChargeRequest;
    }

    protected Seller mockSeller() {
        Seller seller = new Seller();
        seller.set_name("Teste");
        seller.set_codSeller("123");
        return seller;
    }

    protected Charge mockCharge() {
        Charge charge = new Charge();
        charge.set_codCharge("123");
        charge.set_value(new BigDecimal(100));
        return charge;
    }

    protected List<Seller> mockSellerList() {
        List<Seller> list = new ArrayList<>();
        list.add(mockSeller());
        list.add(mockSeller());
        list.add(mockSeller());
        list.add(mockSeller());
        list.add(mockSeller());
        return list;
    }

    protected List<Charge> mockChargeList() {
        List<Charge> list = new ArrayList<>();
        list.add(mockCharge());
        list.add(mockCharge());
        list.add(mockCharge());
        list.add(mockCharge());
        list.add(mockCharge());
        return list;
    }
}
