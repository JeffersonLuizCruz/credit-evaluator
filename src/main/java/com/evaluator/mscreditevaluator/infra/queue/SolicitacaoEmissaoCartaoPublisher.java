package com.evaluator.mscreditevaluator.infra.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evaluator.mscreditevaluator.model.DadosSolicitacaoEmissaoCartao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SolicitacaoEmissaoCartaoPublisher {

	@Autowired private RabbitTemplate rabbitTemplate;
	@Autowired private Queue queueEmissaoCartoes;
	
	public void solicitarCartao(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
		String json = convertJson(dados);
		
		rabbitTemplate.convertAndSend(queueEmissaoCartoes.getName(), json);
	}
	
	private String convertJson(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dados);
		
		return json;
	}
}
