package com.br.antbridge.severino.resource.mod_geral.usuario.empresa;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import com.br.antbridge.core.rest.ControllerCRUD;
import com.br.antbridge.severino.entity.mod_geral.usuario.Empresa;

import io.swagger.annotations.Api;

@Api("Empresa")
@Path("/empresa")
public class EmpresaController extends ControllerCRUD<Empresa, EmpresaResource> {

	@HeaderParam("user-token")
	String userToken;
	
	@HeaderParam("session-token")
	String sessionToken;

	@Override
	public EmpresaResource newResource() {
		return new EmpresaResource();
	}
	
}
