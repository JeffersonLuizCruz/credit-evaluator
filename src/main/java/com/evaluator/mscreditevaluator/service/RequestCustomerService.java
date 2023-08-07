package com.evaluator.mscreditevaluator.service;

import com.evaluator.mscreditevaluator.model.RequestCustomer;
import com.evaluator.mscreditevaluator.model.ResponseValuation;

public interface RequestCustomerService {

	RequestCustomer findByRequestCustomer(String cpf) throws Exception;
	ResponseValuation approvedValuation(String cpf, Long renda) throws Exception;
}
