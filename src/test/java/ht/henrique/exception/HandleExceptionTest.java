package ht.henrique.exception;

import ht.henrique.type.Codes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class HandleExceptionTest {

    @InjectMocks
    private HandleException handleException;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleException() {
        assertDoesNotThrow(() -> handleException.handleException(new DatabaseException(Codes.INVALID_PARAMETERS, "Test")));
        assertDoesNotThrow(() -> handleException.handleException(new ServiceException(Codes.INVALID_PARAMETERS, "Test")));
    }
}