package com.evaluator.mscreditevaluator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evaluator.mscreditevaluator.model.RequestCustomer;
import com.evaluator.mscreditevaluator.model.ResponseValuation;
import com.evaluator.mscreditevaluator.model.ValuationData;
import com.evaluator.mscreditevaluator.service.RequestCustomerService;
import com.evaluator.mscreditevaluator.service.exception.ErrorMicroserviceException;

@RestController
@RequestMapping("/evaluators")
public class EvaluatorController {
	
	@Autowired private RequestCustomerService requestCustomerService;
	
	@GetMapping(value = "/customer", params = "cpf")
	public ResponseEntity<RequestCustomer> requestApprovedCustomer(@RequestParam("cpf") String cpf){
		RequestCustomer response;
		try {
			response = requestCustomerService.findByRequestCustomer(cpf);
		} catch (Exception e) {
			throw new ErrorMicroserviceException("Erro de comunicação do microsserviço!");
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseValuation> approvedValuation(@RequestBody ValuationData valuationData) {
		{
			ResponseValuation response;
			try {
				response = requestCustomerService.approvedValuation(valuationData.getCpf(), valuationData.getIncome());
			} catch (Exception e) {
				throw new ErrorMicroserviceException("Erro de comunicação do microsserviço!");
			}
			return ResponseEntity.ok(response);
		}
	}
	
	@GetMapping
	String status() {
		return "Hello World";
	}

}
