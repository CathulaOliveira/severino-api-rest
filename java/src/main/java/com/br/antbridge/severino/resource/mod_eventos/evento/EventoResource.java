package com.br.antbridge.severino.resource.mod_eventos.evento;

import javax.persistence.NoResultException;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_eventos.Evento;
import com.br.antbridge.severino.entity.mod_eventos.ParticipanteEvento;
import com.br.antbridge.severino.entity.mod_geral.usuario.Usuario;
import com.br.antbridge.severino.resource.mod_eventos.evento.validacao.ValidaParticipacaoEvento;
import com.br.antbridge.severino.resource.mod_eventos.participanteevento.ParticipanteEventoResource;
import com.br.antbridge.severino.resource.mod_geral.usuario.UsuarioResource;

public class EventoResource extends ResourceCRUD<Evento> {
	
	public EventoResource() {
	}
	
	@Override
	public Class<Evento> getModelClass() {
		return Evento.class;
	}

	public void participar(String userToken, Long idevento) throws Exception {
		
		new ValidaParticipacaoEvento().validar(userToken, idevento);
		
		Evento evento = this.busca(idevento);
		
		try (UsuarioResource usuRes = new UsuarioResource()) {
			
			Usuario usuario = usuRes.buscaUsuarioPeloToken(userToken);
			
			try (ParticipanteEventoResource eveParRes = new ParticipanteEventoResource()) {
				ParticipanteEvento parEve = new ParticipanteEvento();
				
				parEve.setEvento(evento);
				parEve.setUsuario(usuario);
				
				eveParRes.incluir(parEve);
				
			}catch (NoResultException e) {
			}
			
		} catch (NoResultException e) {
		}
		
		evento.setConfirmados(evento.getConfirmados()+1);
		
		this.alterar(evento);
		
	}
	
	
		
}