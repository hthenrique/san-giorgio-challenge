package ht.henrique.service.impl;

import ht.henrique.exception.DatabaseException;
import ht.henrique.exception.ServiceException;
import ht.henrique.model.*;
import ht.henrique.model.database.Charge;
import ht.henrique.model.database.Seller;
import ht.henrique.repository.ChargeRepository;
import ht.henrique.repository.SellerRepository;
import ht.henrique.service.PaymentService;
import ht.henrique.type.Codes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private ChargeRepository chargeRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public ServiceResponse payment(PaymentRequest paymentRequest) {
        return null;
    }

    @Override
    public ServiceResponse findSellers() throws DatabaseException {
        List<Seller> list = findAllSellers();
        return new ServiceResponse("200", "OK", new SellersResponse(list));
    }

    @Override
    public ServiceResponse findCharges() throws DatabaseException {
        List<Charge> list = findAllCharges();
        return new ServiceResponse("200", "OK", new ChargesResponse(list));
    }

    @Override
    public ServiceResponse createSeller(CreateSellerRequest createSellerRequest) throws DatabaseException, ServiceException {
        if (findByCodSeller(createSellerRequest.getCodSeller()) != null) {
            throw new ServiceException(Codes.INVALID_PARAMETERS, "Seller already exists");
        }
        saveSeller(createSellerRequest);
        log.info(String.format("Created seller: %s with success", createSellerRequest.getName()));
        return new ServiceResponse("201", "Created");
    }

    @Override
    public ServiceResponse createCharge(CreateChargeRequest createChargeRequest) {
        return null;
    }

    private void saveSeller(CreateSellerRequest createSellerRequest) throws DatabaseException {
        try {
            Seller seller = new Seller();
            seller.set_name(createSellerRequest.getName());
            seller.set_codSeller(createSellerRequest.getCodSeller());
            sellerRepository.save(seller);
        }catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            throw new DatabaseException(Codes.INVALID_PARAMETERS, e.getLocalizedMessage());
        }
    }

    private Seller findByCodSeller(String codSeller) throws DatabaseException {
        try {
            return sellerRepository.findBy_codSeller(codSeller);
        }catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            throw new DatabaseException(Codes.INVALID_PARAMETERS, e.getLocalizedMessage());
        }
    }

    private List<Seller> findAllSellers() throws DatabaseException {
        try {
            return sellerRepository.findAll();
        }catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            throw new DatabaseException(Codes.INVALID_PARAMETERS, e.getLocalizedMessage());
        }
    }

    private List<Charge> findAllCharges() throws DatabaseException {
        try {
            return chargeRepository.findAll();
        }catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            throw new DatabaseException(Codes.INVALID_PARAMETERS, e.getLocalizedMessage());
        }
    }
}
