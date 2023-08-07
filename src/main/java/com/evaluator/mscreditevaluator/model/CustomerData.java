package com.evaluator.mscreditevaluator.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CustomerData implements Serializable{
	private static final long serialVersionUID = -7778264348645388056L;

	private Long id;
	private String name;
	private Integer age;
}
