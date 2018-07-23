package com.br.antbridge.severino.resource.mod_geral.configuracao;

import javax.ws.rs.Path;

import com.br.antbridge.core.rest.ControllerCRUD;
import com.br.antbridge.severino.entity.mod_geral.Configuracao;

import io.swagger.annotations.Api;

@Api("Configuração")
@Path("/configuracao")
public class ConfiguracaoController extends ControllerCRUD<Configuracao, ConfiguracaoResource> {

	@Override
	public ConfiguracaoResource newResource() {
		return new ConfiguracaoResource();
	}
	
}
