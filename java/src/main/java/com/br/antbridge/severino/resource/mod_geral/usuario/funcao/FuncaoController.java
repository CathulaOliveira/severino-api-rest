package com.br.antbridge.severino.resource.mod_geral.usuario.funcao;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import com.br.antbridge.core.rest.ControllerCRUD;
import com.br.antbridge.severino.entity.mod_geral.usuario.Funcao;

import io.swagger.annotations.Api;

@Api("Função")
@Path("/funcao")
public class FuncaoController extends ControllerCRUD<Funcao, FuncaoResource> {

	@HeaderParam("user-token")
	String userToken;
	
	@HeaderParam("session-token")
	String sessionToken;
	
	@Override
	public FuncaoResource newResource() {
		return new FuncaoResource();
	}
	
}
