package com.overlay.controller.exceptionghandler;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ApiError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String msg;
	private LocalDateTime date;
}