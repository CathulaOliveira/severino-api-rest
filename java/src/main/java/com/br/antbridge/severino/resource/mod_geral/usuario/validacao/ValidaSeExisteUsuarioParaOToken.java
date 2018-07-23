package com.br.antbridge.severino.resource.mod_geral.usuario.validacao;

import javax.persistence.NoResultException;

import com.br.antbridge.core.rest.filters.RestException;
import com.br.antbridge.severino.entity.mod_geral.usuario.Usuario;
import com.br.antbridge.severino.resource.mod_geral.usuario.UsuarioResource;

public class ValidaSeExisteUsuarioParaOToken {

	private RestException erroTokenNaoInformado = new RestException("Token não informado");
	private RestException erroUsuarioNaoLocalizado = new RestException("Usuário Não Localizado");

	public Usuario validar(String token) throws Exception {
		
		if (token=="") {
			throw erroTokenNaoInformado;
		}
		
		try (UsuarioResource usuRes = new UsuarioResource()) {
			return usuRes.buscaUsuarioPeloToken(token);
		} catch (NoResultException e) {
			throw erroUsuarioNaoLocalizado.addDetalhe("Token Inválido");
		}	
		
	}
	
}
