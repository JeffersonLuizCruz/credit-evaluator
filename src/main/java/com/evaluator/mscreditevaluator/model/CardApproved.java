package com.evaluator.mscreditevaluator.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CardApproved implements Serializable{
	private static final long serialVersionUID = 2885895110007486212L;

	private String card;
	private String flag;
	private BigDecimal limitApproved;
}
