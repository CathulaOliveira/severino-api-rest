package com.br.antbridge.severino.resource.mod_geral.conexao;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import com.br.antbridge.core.rest.ControllerCRUD;
import com.br.antbridge.severino.entity.mod_geral.Conexao;

import io.swagger.annotations.Api;

@Api("Conexão")
@Path("/conexao")
public class ConexaoController extends ControllerCRUD<Conexao, ConexaoResource> {

	@HeaderParam("user-token")
	String userToken;
	
	@HeaderParam("session-token")
	String sessionToken;

	@Override
	public ConexaoResource newResource() {
		return new ConexaoResource();
	}
	
}
