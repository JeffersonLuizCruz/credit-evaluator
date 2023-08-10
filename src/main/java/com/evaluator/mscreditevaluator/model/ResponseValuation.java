package com.evaluator.mscreditevaluator.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class ResponseValuation implements Serializable{
	private static final long serialVersionUID = 3685968370982694706L;

	private List<CardApproved> cards;
}
