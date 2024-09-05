package ht.henrique.exception;

import ht.henrique.type.Codes;
import lombok.Getter;

@Getter
public class BaseException extends Exception {
    private final Codes returnCode;
    private final String message;
    public BaseException(Codes returnCode, String message) {
        super(message);
        this.returnCode = returnCode;
        this.message = message;
    }
}
