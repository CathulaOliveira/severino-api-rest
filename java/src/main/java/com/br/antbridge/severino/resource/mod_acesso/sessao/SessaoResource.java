package com.br.antbridge.severino.resource.mod_acesso.sessao;

import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_acesso.Sessao;

public class SessaoResource extends ResourceCRUD<Sessao> {

	public SessaoResource() {
	}
	
	public SessaoResource(ResourceCRUD<?> res) {
		super(res);
	}
	
	@Override
	public Class<Sessao> getModelClass() {
		return Sessao.class;
	}
	
	public Sessao buscaPelaToken(String token) {
		
		TypedQuery<Sessao> query = this.getEm().createQuery("select u from Sessao u where u.token = :token", this.getModelClass());
		query.setParameter("token", token);
		Sessao sessao = query.getSingleResult();
		
		return sessao;
		
	}

}
