package com.jt.spring.rest.client.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.spring.rest.client.dto.Payment;
import com.jt.spring.rest.client.dto.Request;
import com.jt.spring.rest.client.dto.Response;

@Service
public class RestServiceLocator {
	@Autowired
	private RestTemplate template;

	HttpHeaders headers = null;

	@PostConstruct
	public void init() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	}

	public Response payNow(Request<Payment> request) throws Exception {
		String url = "http://localhost:9090/Spring-rest-curd/PaymentService/pay";
		ObjectMapper mapper = new ObjectMapper();
		Response response = null;
		String result = "";
		String requestJson = mapper.writeValueAsString(request);
		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		result = template.postForObject(url, entity, String.class);
		response = mapper.readValue(result, Response.class);
		return response;
	}

	public Response getTransaction(String vendor) {
		String url = "http://localhost:9090/Spring-rest-curd/PaymentService/transaction/" + vendor;
		Response response = template.getForObject(url, Response.class);
		return response;
	}

}
