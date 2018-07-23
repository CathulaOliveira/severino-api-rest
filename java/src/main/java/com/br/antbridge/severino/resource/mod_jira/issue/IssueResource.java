package com.br.antbridge.severino.resource.mod_jira.issue;

import java.util.List;

import javax.persistence.TypedQuery;

import com.br.antbridge.core.resource.ResourceCRUD;
import com.br.antbridge.severino.entity.mod_controleponto.Ponto;
import com.br.antbridge.severino.entity.mod_jira.Issue;

public class IssueResource extends ResourceCRUD<Issue> {
	
	public IssueResource() {
	}
	
	@Override
	public Class<Issue> getModelClass() {
		return Issue.class;
	}
	
	public List<Issue> buscaIssuesPorPonto(Ponto ponto) throws Exception {
		
		TypedQuery<Issue> queryIssue = this.getEm().createQuery("select d from Issue d where d.ponto = :ponto", Issue.class);
		queryIssue.setParameter("ponto", ponto);	
		
		return queryIssue.getResultList();
		
	}
	
}