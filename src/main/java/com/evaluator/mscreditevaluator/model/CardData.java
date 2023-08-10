package com.evaluator.mscreditevaluator.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CardData implements Serializable{
	private static final long serialVersionUID = -7837763724557606842L;

	private String name;
	private String flag;
	private BigDecimal limitApproved;
}
