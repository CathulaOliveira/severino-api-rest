package com.br.antbridge.severino.resource.mod_controleponto.importacao;

import com.br.antbridge.severino.entity.mod_geral.usuario.Departamento;
import com.br.antbridge.severino.entity.mod_geral.usuario.Empresa;
import com.br.antbridge.severino.entity.mod_geral.usuario.Funcao;
import com.br.antbridge.severino.entity.mod_geral.usuario.Usuario;
import com.br.antbridge.severino.resource.mod_geral.usuario.departamento.DepartamentoResource;
import com.br.antbridge.severino.resource.mod_geral.usuario.empresa.EmpresaResource;
import com.br.antbridge.severino.resource.mod_geral.usuario.funcao.FuncaoResource;

public class ProcessaDependenciasUsuario {

	public Usuario buscaOuCriaDependenciaUsuario(Usuario usuario) throws Exception {
		
		//Empresa verfica se encontra cadastrada no banco caso não encontre cria
		Empresa empresa = new Empresa();
		try (EmpresaResource empresaRes = new EmpresaResource()) {
			empresa = empresaRes.buscaPorRazaoSocial(usuario.getEmpresa().getRazao_social());
			
			if (empresa==null) {
				empresa = empresaRes.incluir(usuario.getEmpresa());
			}
			
			usuario.setEmpresa(empresa);
		}
		
		//Função verifica se encontra cadastrada banco caso não encontre cria
		Funcao funcao = new Funcao();
		try (FuncaoResource funcaoRes = new FuncaoResource()) {
			funcao = funcaoRes.buscaPorNome(usuario.getFuncao().getNome());
			
			if (funcao==null) {
				funcao = funcaoRes.incluir(usuario.getFuncao());
			}
			
			usuario.setFuncao(funcao);
		}
		
		//Departamento verifica se encontra cadastrada banco caso não encontre cria
		Departamento departamento = new Departamento();
		try (DepartamentoResource departamentoRes = new DepartamentoResource()) {
			departamento = departamentoRes.buscaPorNome(usuario.getDepartamento().getNome());
			
			if (departamento==null) {
				departamento = departamentoRes.incluir(usuario.getDepartamento());
			}
			
			usuario.setDepartamento(departamento);
		}
		
		return usuario;
	}
	
}
