package com.br.antbridge.severino.resource.mod_controleponto.diasemana;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import com.br.antbridge.core.rest.ControllerCRUD;
import com.br.antbridge.severino.entity.mod_controleponto.DiaSemana;

import io.swagger.annotations.Api;

@Api("Dia da Semana")
@Path("/diasemana")
public class DiaSemanaController extends ControllerCRUD<DiaSemana, DiaSemanaResource> {

	@HeaderParam("user-token")
	String userToken;
	
	@HeaderParam("session-token")
	String sessionToken;

	@Override
	public DiaSemanaResource newResource() {
		return new DiaSemanaResource();
	}
	
}
