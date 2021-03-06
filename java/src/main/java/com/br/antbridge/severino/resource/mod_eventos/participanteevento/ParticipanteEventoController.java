package com.br.antbridge.severino.resource.mod_eventos.participanteevento;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

import com.br.antbridge.core.rest.ControllerCRUD;
import com.br.antbridge.severino.entity.mod_eventos.ParticipanteEvento;

import io.swagger.annotations.Api;

@Api("Participante do Evento")
@Path("/participanteevento")
public class ParticipanteEventoController extends ControllerCRUD<ParticipanteEvento, ParticipanteEventoResource> {

	@HeaderParam("user-token")
	String userToken;
	
	@HeaderParam("session-token")
	String sessionToken;

	@Override
	public ParticipanteEventoResource newResource() {
		return new ParticipanteEventoResource();
	}
	
}
