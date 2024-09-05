package ht.henrique.exception;

import ht.henrique.model.error.ErrorTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@ControllerAdvice
public class HandleException {

    @ExceptionHandler({DatabaseException.class})
    public ResponseEntity<ErrorTemplate> handleException(DatabaseException e) {
        return buildResponse(e);
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ErrorTemplate> handleException(ServiceException e) {
        return buildResponse(e);
    }

    private ResponseEntity<ErrorTemplate> buildResponse(BaseException baseException) {
        Date date = new Date();
        ErrorTemplate errorTemplate = ErrorTemplate.builder()
                .errorCode(baseException.getReturnCode().getCode())
                .errorMessage(baseException.getMessage())
                .timeStamp(new Timestamp(date.getTime()).toString())
                .build();
        log.error(errorTemplate.toString());
        return ResponseEntity.status(baseException.getReturnCode().getHttpStatus()).body(errorTemplate);
    }
}
