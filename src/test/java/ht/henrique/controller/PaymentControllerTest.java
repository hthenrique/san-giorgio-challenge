package ht.henrique.controller;

import ht.henrique.model.request.CreateChargeRequest;
import ht.henrique.model.request.CreateSellerRequest;
import ht.henrique.service.PaymentService;
import ht.henrique.util.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PaymentControllerTest extends BaseTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEndpoints() {
        assertDoesNotThrow(() -> paymentController.payment(mockPaymentRequest()));
        assertDoesNotThrow(() -> paymentController.findSeller());
        assertDoesNotThrow(() -> paymentController.findCharge());
        assertDoesNotThrow(() -> paymentController.createSeller(mockCreateSellerRequest()));
        assertDoesNotThrow(() -> paymentController.createCharge(mockCreateChargeRequest()));
    }


}