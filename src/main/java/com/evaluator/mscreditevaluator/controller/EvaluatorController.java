package com.evaluator.mscreditevaluator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluators")
public class EvaluatorController {
	
	@GetMapping
	String status() {
		return "Hello World";
	}

}
