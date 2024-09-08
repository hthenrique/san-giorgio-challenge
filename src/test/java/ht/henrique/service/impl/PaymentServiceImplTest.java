package ht.henrique.service.impl;

import ht.henrique.exception.DatabaseException;
import ht.henrique.exception.ServiceException;
import ht.henrique.repository.ChargeRepository;
import ht.henrique.repository.PaymentQueueRepository;
import ht.henrique.repository.SellerRepository;
import ht.henrique.util.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.InvalidClassException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class PaymentServiceImplTest extends BaseTest {
    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private PaymentQueueRepository paymentQueueRepository;
    @Mock
    private ChargeRepository chargeRepository;
    @Mock
    private SellerRepository sellerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPayment() {
        when(sellerRepository.findBy_codSeller(Mockito.any())).thenReturn(mockSeller());
        when(chargeRepository.findBy_codCharge(Mockito.any())).thenReturn(mockCharge());
        assertDoesNotThrow(() -> paymentService.payment(mockPaymentRequest()));
        when(chargeRepository.findBy_codCharge(Mockito.any())).thenReturn(null);
        assertDoesNotThrow(() -> paymentService.payment(mockPaymentRequest()));
    }

    @Test
    void savePaymentQueueException() {
        when(sellerRepository.findBy_codSeller(Mockito.any())).thenReturn(mockSeller());
        when(chargeRepository.findBy_codCharge(Mockito.any())).thenReturn(mockCharge());
        when(paymentQueueRepository.save(Mockito.any())).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(DatabaseException.class, () -> paymentService.payment(mockPaymentRequest()));
    }

    @Test
    void testPaymentException(){
        when(sellerRepository.findBy_codSeller(Mockito.any())).thenReturn(null);
        assertThrows(ServiceException.class, () -> paymentService.payment(mockPaymentRequest()));
    }

    @Test
    void testFindSellers() {
        when(sellerRepository.findAll()).thenReturn(mockSellerList());
        assertDoesNotThrow(() -> paymentService.findSellers());
    }

    @Test
    void testFindSellersException() {
        when(sellerRepository.findAll()).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(DatabaseException.class, () -> paymentService.findSellers());
    }

    @Test
    void testFindCharges() {
        when(chargeRepository.findAll()).thenReturn(mockChargeList());
        assertDoesNotThrow(() -> paymentService.findCharges());
    }

    @Test
    void testFindChargesException() {
        when(chargeRepository.findAll()).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(DatabaseException.class, () -> paymentService.findCharges());
    }

    @Test
    void testCreateSeller() {
        assertDoesNotThrow(() -> paymentService.createSeller(mockCreateSellerRequest()));
    }

    @Test
    void testCreateSellerException() {
        when(sellerRepository.save(Mockito.any())).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(DatabaseException.class, () -> paymentService.createSeller(mockCreateSellerRequest()));
    }

    @Test
    void testFindBy_codSellerException() {
        when(sellerRepository.findBy_codSeller(Mockito.any())).thenReturn(mockSeller());
        assertThrows(ServiceException.class, () -> paymentService.createSeller(mockCreateSellerRequest()));
        when(sellerRepository.findBy_codSeller(Mockito.any())).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(DatabaseException.class, () -> paymentService.createSeller(mockCreateSellerRequest()));
    }

    @Test
    void testCreateCharge() {
        when(chargeRepository.findBy_codCharge(Mockito.any())).thenReturn(null);
        assertDoesNotThrow(() -> paymentService.createCharge(mockCreateChargeRequest()));
    }

    @Test
    void testCreateChargeException() {
        when(chargeRepository.save(Mockito.any())).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(DatabaseException.class, () -> paymentService.createCharge(mockCreateChargeRequest()));
    }

    @Test
    void testFindBy_codChargeException() {
        when(chargeRepository.findBy_codCharge(Mockito.any())).thenReturn(mockCharge());
        assertThrows(ServiceException.class, () -> paymentService.createCharge(mockCreateChargeRequest()));
        when(chargeRepository.findBy_codCharge(Mockito.any())).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(DatabaseException.class, () -> paymentService.createCharge(mockCreateChargeRequest()));
    }
}