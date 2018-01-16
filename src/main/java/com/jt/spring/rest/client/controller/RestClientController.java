package com.jt.spring.rest.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.spring.rest.client.dto.Payment;
import com.jt.spring.rest.client.dto.Request;
import com.jt.spring.rest.client.dto.Response;
import com.jt.spring.rest.client.service.RestServiceLocator;

@RestController
@RequestMapping("/client")
public class RestClientController {
	@Autowired
	private RestServiceLocator locator;

	@PostMapping("/paying")
	public Response payment(@RequestBody Request<Payment> request) throws Exception {
		return locator.payNow(request);
	}

	@GetMapping("/getTransactionByVendor/{vendor}")
	public Response getTransaction(@PathVariable String vendor) {
		return locator.getTransaction(vendor);
	}

}
