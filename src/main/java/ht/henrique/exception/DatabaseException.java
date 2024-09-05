package ht.henrique.exception;

import ht.henrique.type.Codes;

public class DatabaseException extends BaseException{
    public DatabaseException(Codes code, String message) {
        super(code, message);
    }
}
