package ht.henrique.service;

import ht.henrique.exception.DatabaseException;
import ht.henrique.exception.ServiceException;
import ht.henrique.model.request.CreateChargeRequest;
import ht.henrique.model.request.CreateSellerRequest;
import ht.henrique.model.request.PaymentRequest;
import ht.henrique.model.response.ServiceResponse;

public interface PaymentService {
    ServiceResponse payment(PaymentRequest paymentRequest) throws DatabaseException, ServiceException;
    ServiceResponse findSellers() throws DatabaseException;
    ServiceResponse findCharges() throws DatabaseException;
    ServiceResponse createSeller(CreateSellerRequest createSellerRequest) throws DatabaseException, ServiceException;
    ServiceResponse createCharge(CreateChargeRequest createChargeRequest) throws ServiceException, DatabaseException;
}
