package ht.henrique.service.impl;

import ht.henrique.exception.DatabaseException;
import ht.henrique.exception.ServiceException;
import ht.henrique.model.database.Charge;
import ht.henrique.model.database.Seller;
import ht.henrique.model.request.CreateChargeRequest;
import ht.henrique.model.request.CreateSellerRequest;
import ht.henrique.model.request.PaymentRequest;
import ht.henrique.model.response.ChargesResponse;
import ht.henrique.model.response.SellersResponse;
import ht.henrique.model.response.ServiceResponse;
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
    public ServiceResponse createCharge(CreateChargeRequest createChargeRequest) throws ServiceException, DatabaseException {
        if (findByCodCharge(createChargeRequest.getCodCharge()) != null) {
            throw new ServiceException(Codes.INVALID_PARAMETERS, "Charge already exists");
        }
        saveCharge(createChargeRequest);
        log.info(String.format("Created charge: %s with success", createChargeRequest.getCodCharge()));
        return new ServiceResponse("201", "Created");
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

    private void saveCharge(CreateChargeRequest createChargeRequest) throws DatabaseException {
        try {
            Charge charge = new Charge();
            charge.set_codCharge(createChargeRequest.getCodCharge());
            charge.set_value(createChargeRequest.getValue());
            chargeRepository.save(charge);
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

    private Charge findByCodCharge(String codCharge) throws DatabaseException {
        try {
            return chargeRepository.findBy_codCharge(codCharge);
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
