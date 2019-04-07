package br.com.fiap.paymentservice.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public final ResponseEntity<?> handlePedidoRespondeEntity(ExceptionReponse apiError){
			ExceptionReponse exceptionReponse = new ExceptionReponse(new Date(), apiError.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(exceptionReponse, exceptionReponse.getStatus());
	}

}
