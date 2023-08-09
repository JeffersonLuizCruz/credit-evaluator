package com.evaluator.mscreditevaluator.service;

import com.evaluator.mscreditevaluator.model.DadosSolicitacaoEmissaoCartao;
import com.evaluator.mscreditevaluator.model.ProtocoloEmissaoCartao;
import com.evaluator.mscreditevaluator.model.RequestCustomer;
import com.evaluator.mscreditevaluator.model.ResponseValuation;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RequestCustomerService {

	RequestCustomer findByRequestCustomer(String cpf) throws Exception;
	ResponseValuation approvedValuation(String cpf, Long renda) throws Exception;
	ProtocoloEmissaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException;
}
