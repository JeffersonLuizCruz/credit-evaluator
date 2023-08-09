package com.evaluator.mscreditevaluator.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.evaluator.mscreditevaluator.infra.queue.SolicitacaoEmissaoCartaoPublisher;
import com.evaluator.mscreditevaluator.infra.web.CardFeignClient;
import com.evaluator.mscreditevaluator.infra.web.CustomerFeignClient;
import com.evaluator.mscreditevaluator.model.Card;
import com.evaluator.mscreditevaluator.model.CardApproved;
import com.evaluator.mscreditevaluator.model.CardData;
import com.evaluator.mscreditevaluator.model.CustomerData;
import com.evaluator.mscreditevaluator.model.DadosSolicitacaoEmissaoCartao;
import com.evaluator.mscreditevaluator.model.ProtocoloEmissaoCartao;
import com.evaluator.mscreditevaluator.model.RequestCustomer;
import com.evaluator.mscreditevaluator.model.ResponseValuation;
import com.fasterxml.jackson.core.JsonProcessingException;

import feign.FeignException;

@Service
public class RequestCustomerServiceImpl implements RequestCustomerService {

	@Autowired private CustomerFeignClient customerFeignClient;
	@Autowired private CardFeignClient cardFeignClient;
	@Autowired private SolicitacaoEmissaoCartaoPublisher solicitacaoEmissaoCartaoPublisher;

	@Override
	public RequestCustomer findByRequestCustomer(String cpf) throws Exception {
		try {
			ResponseEntity<CustomerData> responseCustomer = customerFeignClient.findByCustomerCpf(cpf);
			ResponseEntity<List<CardData>> responseCards = cardFeignClient.findByCardCpf(cpf);
			
			return RequestCustomer.builder()
					.customer(responseCustomer.getBody())
					.card(responseCards.getBody())
					.build();
		} catch (FeignException.FeignClientException e) {
			
			if(HttpStatus.NOT_FOUND.value() == e.status()) {
				
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found - Microservice");
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro de comunicação do microsserviço!");
		}
	}

	@Override
	public ResponseValuation approvedValuation(String cpf, Long renda) throws Exception {
		try {
			ResponseEntity<CustomerData> responseCustomer = customerFeignClient.findByCustomerCpf(cpf);
			ResponseEntity<List<Card>> responseIncome = cardFeignClient.findByIncome(renda);
			
			List<Card> cards = responseIncome.getBody();
			
			List<CardApproved> cardApproved = cards.stream().map(card -> {
				Integer age = responseCustomer.getBody().getAge();
				
				BigDecimal basicLimit = card.getBasicLimit();
				BigDecimal basicAge = BigDecimal.valueOf(age);
				
				BigDecimal divide = basicAge.divide(BigDecimal.valueOf(10));
				BigDecimal limitApproved = divide.multiply(basicLimit);
				
				CardApproved approved = new CardApproved();
				approved.setCard(card.getName());
				approved.setFlag(card.getFlagCard());
				approved.setLimitApproved(limitApproved);
				
				return approved;
			}).collect(Collectors.toList());
			
			return new ResponseValuation(cardApproved);
			
		} catch (FeignException.FeignClientException e) {
			
			if(HttpStatus.NOT_FOUND.value() == e.status()) {
				
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found - Microservice");
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro de comunicação do microsserviço!");
		}
	}
	
	@Override
	public ProtocoloEmissaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
		solicitacaoEmissaoCartaoPublisher.solicitarCartao(dados);
		String uuid = UUID.randomUUID().toString();
		
		return new ProtocoloEmissaoCartao(uuid);
	}
}
