package com.br.antbridge.severino.resource.mod_geral.usuario.validacao;

import java.util.List;

import javax.persistence.NoResultException;

import com.br.antbridge.core.rest.filters.RestException;
import com.br.antbridge.core.util.enumeration.SimNao;
import com.br.antbridge.severino.entity.mod_geral.usuario.Usuario;
import com.br.antbridge.severino.resource.mod_acesso.acesso.AcessoTipo;
import com.br.antbridge.severino.resource.mod_geral.usuario.UsuarioResource;

public class ValidaDuplicacaoDeRegistros {

	private RestException erroCampoPISJaVinculadoAOutroUsuario = new RestException("Campo P.I.S. Informado já esta vinculado a outro usuário");
	private RestException erroCampoNomeJaVinculadoAOutroUsuario = new RestException("Campo Nome Informado já esta vinculado a outro usuário");
	private RestException erroCampoEmailJaVinculadoAOutroUsuario = new RestException("Campo E-mail Informado já esta vinculado a outro usuário");
	
	public void validar(Usuario usuario) throws Exception {
		
		try (UsuarioResource usuRes = new UsuarioResource()) {
			
			if (!usuario.getAcesso().getTipo().equals(AcessoTipo.ADMIN)) {
				
				Usuario usuPis = usuRes.buscaUsuarioPorPis(usuario.getPis());
				if (usuPis!=null && usuPis.getId()!=usuario.getId()) {
					throw erroCampoPISJaVinculadoAOutroUsuario.addDetalhe(usuPis.getId()+" - "+usuPis.getNome());
				}
				
				List<Usuario> listaUsuarios = usuRes.buscaTotos();
				
				if (listaUsuarios!=null && listaUsuarios.size()>0) {
					
					for (Usuario usuBanco : listaUsuarios) {
						if (usuBanco.getId()!=usuario.getId()) {
							if (usuBanco.getReceber_notificacao().equals(SimNao.SIM) 
									&& usuBanco.getEmail()!=null 
									&& !usuBanco.getEmail().equals("")
									&& usuario.getEmail()!=null
									&& !usuario.getEmail().equals("")) {
								if (usuBanco.getEmail().toUpperCase().equals(usuario.getEmail().toUpperCase())) {
									throw erroCampoEmailJaVinculadoAOutroUsuario.addDetalhe(usuBanco.getId()+" - "+usuBanco.getNome());
								}
							}
							if (usuBanco.getNome().toUpperCase().equals(usuario.getNome().toUpperCase())) {
								throw erroCampoNomeJaVinculadoAOutroUsuario.addDetalhe(usuBanco.getId()+" - "+usuBanco.getNome());
							}
						}
					}
					
				}
				
			}
			
		} catch (NoResultException e) {
		}	
		
	}
}
