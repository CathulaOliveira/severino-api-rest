package com.br.antbridge.severino.resource.mod_geral.recuperacaodesenha;

import java.util.Random;

import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.br.antbridge.core.email.Email;
import com.br.antbridge.core.rest.filters.RestException;
import com.br.antbridge.core.util.validacao.ValidaEmail;
import com.br.antbridge.severino.entity.mod_geral.Configuracao;
import com.br.antbridge.severino.entity.mod_geral.usuario.Usuario;
import com.br.antbridge.severino.resource.mod_geral.configuracao.ConfiguracaoResource;
import com.br.antbridge.severino.resource.mod_geral.usuario.UsuarioResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Recuperação de Senha")
@Path("/recuperacaodesenha")
public class RecuperacaoDeSenhaController {

	private RestException campoObrigatorio = new RestException("Campo Obrigatório");
	private RestException campoInvalido = new RestException("Campo Inválido");
	private RestException erroEmailNaoLocalizado = new RestException("E-mail informado não existe na base!");
	
	@GET
	@Path("/verifica/{email}")
	@ApiOperation(value = "Verifica Email de Recuperação de Senha")
	@Produces(MediaType.APPLICATION_JSON)
	public void verificaExistenciaDeEmail(@PathParam("email") String email) throws Exception {
		
		if (email==null || email.equals("")) {
			throw campoObrigatorio.addDetalhe("E-mail");
		} else if (!new ValidaEmail().validaEmail(email)){
			throw campoInvalido.addDetalhe("E-mail");
		}
		
		Usuario usuario = new Usuario();
		try (UsuarioResource usuRes = new UsuarioResource()) {
			try {
				usuario = usuRes.buscaUsuarioPorEmail(email);
				if (usuario==null) {
					throw erroEmailNaoLocalizado;
				}
			} catch (NoResultException e) {
				throw erroEmailNaoLocalizado;
			}
			
		}
		
	}

	@PUT
	@Path("/recuperar/{email}")
	@ApiOperation(value = "Verifica Email de Recuperação de Senha")
	@Produces(MediaType.APPLICATION_JSON)
	public void envioPorEmailNovaSenha(@PathParam("email") String email) throws Exception {
		
		this.verificaExistenciaDeEmail(email);
		try (UsuarioResource usuRes = new UsuarioResource()) {
			Usuario usuario = usuRes.buscaUsuarioPorEmail(email);
			
			String senhaNova = this.geracaoDeSenhaRandomica();
			usuario.getAcesso().setSenha(senhaNova);
			
			usuRes.alterar(usuario);
			
			Configuracao configuracao = new Configuracao();
			try(ConfiguracaoResource conRes = new ConfiguracaoResource()) {
				configuracao = conRes.busca(1);
			}
			
			String tituloEmail = "SEVERINO - Recuperação de senha";
			String mensagem = 
				"<h2>Olá, "+usuario.getNome()+"</h2>"+
			    "<br>"+
				"<table border=\"0\" width=\"100%\" >\n" + 
				"<tr>\n" + 
				"<td>Nome de Acesso: "+usuario.getAcesso().getNomeacesso()+"</td>\n" + 
				"</tr>\n" +  
				"<tr>\n" + 
				"<td>Nova senha: "+senhaNova+"</td>\n" + 
				"</tr>\n" +
				"</table>";
			
			//Envia e-mail para o usuário
			new Email().sendEmail(
						configuracao.getEmail_notificacao(), 
						configuracao.getEmail_senha(), 
						configuracao.getEmail_smtp_port(), 
						configuracao.getEmail_host(),
						tituloEmail, mensagem, usuario.getEmail());
			
		} catch (NoResultException e) {
			throw erroEmailNaoLocalizado;
		}
			
	}

	private String geracaoDeSenhaRandomica() {
		
		int numeroCaracteres = 6;
		Random rand = new Random();
		char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		String senha = "";
		
		StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < numeroCaracteres; i++) {
	        int ch = rand.nextInt (letras.length);
	        sb.append (letras [ch]);
	    }    
		
	    senha = sb.toString();
		
		return senha;
		
	}
	
}