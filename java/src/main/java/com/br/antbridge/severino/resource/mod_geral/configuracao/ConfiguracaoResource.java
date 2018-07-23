package com.br.antbridge.severino.resource.mod_geral.configuracao;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_geral.Configuracao;

public class ConfiguracaoResource extends ResourceCRUD<Configuracao> {
	
	public ConfiguracaoResource() {
	}
	
	@Override
	public Class<Configuracao> getModelClass() {
		return Configuracao.class;
	}
	
}