package br.com.fiap.paymentservice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Payment {

    private int idtransacao;
    private String numerocartao;
    private String validade;
    private BigDecimal valor;
    private String bandeira;

}
