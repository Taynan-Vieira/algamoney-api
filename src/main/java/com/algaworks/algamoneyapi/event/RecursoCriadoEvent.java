package com.algaworks.algamoneyapi.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class RecursoCriadoEvent extends ApplicationEvent implements Serializable {

	private static final long serialVersionUID = 5653395358249305882L;

	@Getter
	private HttpServletResponse response;
	@Getter
	private Long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

}
