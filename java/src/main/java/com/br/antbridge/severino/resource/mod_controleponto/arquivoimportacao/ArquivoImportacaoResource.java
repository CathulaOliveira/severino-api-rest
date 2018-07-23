package com.br.antbridge.severino.resource.mod_controleponto.arquivoimportacao;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_controleponto.ArquivoImportacao;

public class ArquivoImportacaoResource extends ResourceCRUD<ArquivoImportacao> {

	public ArquivoImportacaoResource() {
	}
	
	public ArquivoImportacaoResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<ArquivoImportacao> getModelClass() {
		return ArquivoImportacao.class;
	}
	
}
