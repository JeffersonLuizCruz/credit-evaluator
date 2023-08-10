package com.evaluator.mscreditevaluator.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Card implements Serializable{
	private static final long serialVersionUID = 7405650412029633278L;
	
	private Long id;
	private String name;
	private String flagCard;
	private BigDecimal income;
	private BigDecimal basicLimit;
}
