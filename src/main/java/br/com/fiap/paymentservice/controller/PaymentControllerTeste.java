package br.com.fiap.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import br.com.fiap.orderservice.Order;
import br.com.fiap.orderservice.controller.MicroservicesExemploController;
import br.com.fiap.orderservice.controller.MockBean;
import br.com.fiap.orderservice.controller.MockMvc;
import br.com.fiap.orderservice.controller.RunWith;
import br.com.fiap.orderservice.controller.SpringRunner;
import br.com.fiap.orderservice.controller.Test;
import br.com.fiap.orderservice.controller.WebMvcTest;

@RunWith(SpringRunner.class)
@WebMvcTest(PaymentController.class)
public class PaymentControllerTeste {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private Order repository;
	
	@Test
	public void notFoundOrder() throws Exception {
		mvc.perform(
                get("/findById/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

	}

}
