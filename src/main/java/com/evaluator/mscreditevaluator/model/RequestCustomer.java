package com.evaluator.mscreditevaluator.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
public class RequestCustomer implements Serializable{
	private static final long serialVersionUID = -5274806180638754742L;
	
	private CustomerData customer;
	private List<CardData> card;
}
