package ht.henrique.exception;

import ht.henrique.type.Codes;

public class ServiceException extends BaseException {
    public ServiceException(Codes returnCode, String message) {
        super(returnCode, message);
    }
}
