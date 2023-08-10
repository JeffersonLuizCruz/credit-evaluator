package com.evaluator.mscreditevaluator.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ValuationData implements Serializable{
	private static final long serialVersionUID = -847966524241540121L;

	private String cpf;
	private Long income;
}
