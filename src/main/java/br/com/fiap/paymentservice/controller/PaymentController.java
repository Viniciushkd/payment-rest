package br.com.fiap.paymentservice.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.paymentservice.Payment;
import br.com.fiap.paymentservice.handler.ExceptionReponse;
import br.com.fiap.paymentservice.handler.PaymentNotFoundException;
import br.com.fiap.paymentservice.handler.RestResponseEntityExceptionHandler;

@RestController
@RequestMapping("/payment")

public class PaymentController {

    private List<Payment> payments = new ArrayList<>();

    @GetMapping("/findById/{id}")
    public Payment getPedido(@PathVariable int id) {
        Payment payment = payments.stream().filter(o -> o.getIdtransacao() == id).findAny().orElse(null);
        if(payment == null) {
        	throw new PaymentNotFoundException("id:" + id);
        } else {
        	return payment;
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePedido(@RequestBody Payment payment) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        payments.add(payment);
        try {
            URI uri = new URI("/order/" + payment.getIdtransacao());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            return new RestResponseEntityExceptionHandler().handlePedidoRespondeEntity(new ExceptionReponse(new Date(), e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePedido(@PathVariable int id, @RequestBody Payment payment) {
        Payment orderSelect = payments.stream().filter(o -> o.getIdtransacao() == id).findAny().orElse(null);
        orderSelect.setNumerocartao(payment.getNumerocartao());
        orderSelect.setValidade(payment.getValidade());
        orderSelect.setValor(payment.getValor());
        orderSelect.setBandeira(payment.getBandeira());
        try {
            URI uri = new URI("/update/" + payment.getIdtransacao());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
        	return new RestResponseEntityExceptionHandler().handlePedidoRespondeEntity(new ExceptionReponse(new Date(), e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable int id) {
        Payment orderSelect = payments.stream().filter(o -> o.getIdtransacao() == id).findAny().orElse(null);
        payments.remove(orderSelect);
        try {
            URI uri = new URI("/delete/" + orderSelect.getIdtransacao());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            return new RestResponseEntityExceptionHandler().handlePedidoRespondeEntity(new ExceptionReponse(new Date(), e.getMessage(), HttpStatus.NOT_FOUND));
        }
    }
}