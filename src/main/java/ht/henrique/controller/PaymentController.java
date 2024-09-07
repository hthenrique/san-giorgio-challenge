package ht.henrique.controller;

import ht.henrique.exception.DatabaseException;
import ht.henrique.exception.ServiceException;
import ht.henrique.model.request.CreateChargeRequest;
import ht.henrique.model.request.CreateSellerRequest;
import ht.henrique.model.request.PaymentRequest;
import ht.henrique.model.response.ServiceResponse;
import ht.henrique.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<ServiceResponse> payment(@RequestBody PaymentRequest paymentRequest) throws DatabaseException {
        return ResponseEntity.ok(paymentService.payment(paymentRequest));
    }

    @GetMapping("/find/sellers")
    public ResponseEntity<ServiceResponse> findSeller() throws DatabaseException {
        return ResponseEntity.ok(paymentService.findSellers());
    }

    @GetMapping("/find/charges")
    public ResponseEntity<ServiceResponse> findCharge() throws DatabaseException {
        return ResponseEntity.ok(paymentService.findCharges());
    }

    @PostMapping("/create/seller")
    public ResponseEntity<ServiceResponse> createSeller(@RequestBody CreateSellerRequest createSellerRequest) throws DatabaseException, ServiceException {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createSeller(createSellerRequest));
    }

    @PostMapping("/create/charge")
    public ResponseEntity<ServiceResponse> createCharge(@RequestBody CreateChargeRequest createChargeRequest) throws ServiceException, DatabaseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createCharge(createChargeRequest));
    }
}
