package com.evaluator.mscreditevaluator.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DadosSolicitacaoEmissaoCartao {

	private Long idCard;
	private String cpf;
	private String address;
	private BigDecimal basicLimit;
}
