package com.br.antbridge.severino.resource.mod_eventos.participanteevento;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_eventos.Evento;
import com.br.antbridge.severino.entity.mod_eventos.ParticipanteEvento;
import com.br.antbridge.severino.entity.mod_geral.usuario.Usuario;

public class ParticipanteEventoResource extends ResourceCRUD<ParticipanteEvento> {
	
	public ParticipanteEventoResource() {
	}
	
	@Override
	public Class<ParticipanteEvento> getModelClass() {
		return ParticipanteEvento.class;
	}
	
	public ParticipanteEvento buscaParticipantePorEventoEUsuario(Evento evento, Usuario usuario) throws Exception {
		
		TypedQuery<ParticipanteEvento> queryParticipanteEvento = this.getEm().createQuery("select d from ParticipanteEvento d where d.usuario = :usuario and d.evento = :evento", ParticipanteEvento.class);
		queryParticipanteEvento.setParameter("usuario", usuario);	
		
		ParticipanteEvento participante = new ParticipanteEvento();
		
		try {
			participante = queryParticipanteEvento.getSingleResult();
		} catch (NoResultException e) {
			participante = null;
		}
		
		return participante;
		
	}
		
}