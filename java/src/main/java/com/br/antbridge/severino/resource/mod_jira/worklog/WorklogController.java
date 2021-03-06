package com.br.antbridge.severino.resource.mod_jira.worklog;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Worklog Jira")
@Path("/jira/worklog")
public class WorklogController {
	
	//Lista o issue de um período especifíco
	@GET
	@Path("/listar/worklog/{usuario}/{data}")
	@ApiOperation(value = "Listar Worklog por Usuário e Data")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Worklog> listaWorklog(@PathParam("usuario") Long usuarioid, @PathParam("data") String data) throws Exception {
		try (WorklogResource pres = new WorklogResource()) {
			return pres.listarWorklogJira(usuarioid,data);	
		} catch (Exception e) {
			throw e;
		}
	}
}
