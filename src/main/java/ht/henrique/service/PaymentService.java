package ht.henrique.service;

import ht.henrique.exception.DatabaseException;
import ht.henrique.exception.ServiceException;
import ht.henrique.model.CreateChargeRequest;
import ht.henrique.model.CreateSellerRequest;
import ht.henrique.model.PaymentRequest;
import ht.henrique.model.ServiceResponse;

public interface PaymentService {
    ServiceResponse payment(PaymentRequest paymentRequest);
    ServiceResponse findSellers() throws DatabaseException;
    ServiceResponse findCharges() throws DatabaseException;
    ServiceResponse createSeller(CreateSellerRequest createSellerRequest) throws DatabaseException, ServiceException;
    ServiceResponse createCharge(CreateChargeRequest createChargeRequest);
}
