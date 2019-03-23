package br.com.fiap.paymentservice.controller;

import br.com.fiap.paymentservice.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private List<Payment> payments = new ArrayList<>();

    @GetMapping("/findById/{id}")
    public Payment getPedido(@PathVariable int id) {
        return payments.stream().filter(o -> o.getIdtransacao() == id).findAny().orElse(null);
    }

    @PostMapping("/save")
    public ResponseEntity<Payment> savePedido(@RequestBody Payment payment) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        payments.add(payment);
        try {
            URI uri = new URI("/order/" + payment.getIdtransacao());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePedido(@PathVariable int id, @RequestBody Payment payment) {
        Payment orderSelect = payments.stream().filter(o -> o.getIdtransacao() == id).findAny().orElse(null);
        orderSelect.setNumerocartao(payment.getNumerocartao());
        orderSelect.setValidade(payment.getValidade());
        orderSelect.setValor(payment.getValor());
        orderSelect.setBandeira(payment.getBandeira());
        try {
            URI uri = new URI("/update/" + payment.getIdtransacao());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(orderSelect, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePedido(@PathVariable int id) {
        Payment orderSelect = payments.stream().filter(o -> o.getIdtransacao() == id).findAny().orElse(null);
        payments.remove(orderSelect);
        try {
            URI uri = new URI("/delete/" + orderSelect.getIdtransacao());
            return new ResponseEntity(uri, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(orderSelect, HttpStatus.OK);
    }
}