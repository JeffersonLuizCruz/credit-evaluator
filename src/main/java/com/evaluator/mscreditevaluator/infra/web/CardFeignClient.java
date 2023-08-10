package com.evaluator.mscreditevaluator.infra.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evaluator.mscreditevaluator.model.Card;
import com.evaluator.mscreditevaluator.model.CardData;

@FeignClient(value = "mscards", path = "/cards")
public interface CardFeignClient {

	@GetMapping(params = "cpf")
	ResponseEntity<List<CardData>> findByCardCpf(@RequestParam("cpf") String cpf);
	
	@GetMapping(params = "renda")
	ResponseEntity<List<Card>> findByIncome(@RequestParam("renda") Long renda);
}
