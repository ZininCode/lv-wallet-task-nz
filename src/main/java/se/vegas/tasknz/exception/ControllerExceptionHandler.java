package se.vegas.tasknz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import se.vegas.tasknz.dto.WalletExceptionResponse;


import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Handle exception to give a response which will be presented in JSON when exception is thrown.
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<WalletExceptionResponse> gameNotFoundException(WalletNotFoundException ex, WebRequest request) {
        WalletExceptionResponse response = WalletExceptionResponse
                .builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .walletId(ex.getWalletId())
                .path(request.getDescription(false))
                .descriptionMessage(ex.getDescriptionMessage())
                .build();
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    public ResponseEntity<WalletExceptionResponse> notEnoughMoneyException(NotEnoughCreditException ex, WebRequest request) {
        WalletExceptionResponse response = WalletExceptionResponse
                .builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .walletId(ex.getWalletId())
                .path(request.getDescription(false))
                .descriptionMessage(ex.getDescriptionMessage())
                .build();
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    public ResponseEntity<WalletExceptionResponse> transactionIdAlreadyExistException(TransactionIdRedundantException ex, WebRequest request) {
        WalletExceptionResponse response = WalletExceptionResponse
                .builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .walletId(ex.getWalletId())
                .path(request.getDescription(false))
                .descriptionMessage(ex.getDescriptionMessage())
                .build();
        return new ResponseEntity<>(response, NOT_FOUND);
    }
}
