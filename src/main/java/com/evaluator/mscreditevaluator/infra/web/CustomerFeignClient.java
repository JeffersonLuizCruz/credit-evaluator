package com.evaluator.mscreditevaluator.infra.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evaluator.mscreditevaluator.model.CustomerData;

@FeignClient(value = "mscustomers", path = "/customers")
public interface CustomerFeignClient {

	@GetMapping(params = "cpf")
	public ResponseEntity<CustomerData> findByCustomerCpf(@RequestParam("cpf") String cpf);
}
