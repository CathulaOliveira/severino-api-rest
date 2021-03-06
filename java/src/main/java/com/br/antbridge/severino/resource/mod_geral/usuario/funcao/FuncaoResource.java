package com.br.antbridge.severino.resource.mod_geral.usuario.funcao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_geral.usuario.Funcao;

public class FuncaoResource extends ResourceCRUD<Funcao> {
	
	public FuncaoResource() {
	}
	
	@Override
	public Class<Funcao> getModelClass() {
		return Funcao.class;
	}
	
	public Funcao buscaPorNome(String nomeFuncao) throws Exception {
		
		TypedQuery<Funcao> queryFuncao = this.getEm().createQuery("select d from Funcao d where d.nome = :nomeFuncao", Funcao.class);
		queryFuncao.setParameter("nomeFuncao", nomeFuncao);	
		
		Funcao funcao = new Funcao();
		
		try {
			funcao = queryFuncao.getSingleResult();
		} catch (NoResultException e) {
			funcao = null;
		}
		
		return funcao;
		
	}
}