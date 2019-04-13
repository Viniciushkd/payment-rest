package br.com.fiap.paymentservice;

import java.math.BigDecimal;

public class Payment {

    private int idtransacao;
    private String numerocartao;
    private String validade;
    private BigDecimal valor;
    private String bandeira;
	public int getIdtransacao() {
		return idtransacao;
	}
	public void setIdtransacao(int idtransacao) {
		this.idtransacao = idtransacao;
	}
	public String getNumerocartao() {
		return numerocartao;
	}
	public void setNumerocartao(String numerocartao) {
		this.numerocartao = numerocartao;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

}
