
package com.br.antbridge.severino.entity.mod_geral.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.br.antbridge.core.util.enumeration.SimNao;
import com.br.antbridge.severino.entity.mod_acesso.Acesso;
import com.br.antbridge.severino.entity.mod_geral.endereco.Endereco;
import com.br.antbridge.severino.resource.mod_geral.usuario.CnhCategoria;
import com.br.antbridge.severino.resource.mod_geral.usuario.EstadoCivil;
import com.br.antbridge.severino.resource.mod_geral.usuario.Sexo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Usuario", description="Usuário")
@Table(
		indexes = { 
				@Index(name = "usuario_pis_idx", columnList = "pis")
		})
@Getter @Setter
@Entity
public class Usuario {
	
	@Id
	@ApiModelProperty("Código")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=200)
	@NotNull
	@ApiModelProperty("Nome")
	private String nome;
	
	@Column(length=200)
	@ApiModelProperty("E-mail")
	private String email;
	
	@Column(length=200)
	@ApiModelProperty("Usuário Jira")
	private String usuario_jira;
	
	@Column
	@ApiModelProperty("Data Admissão")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate data_admissao;
	
	@Column
	@ApiModelProperty("Data Nascimento")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate data_nascimento;
	
	@Column(length=15)
	@ApiModelProperty("Sexo")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(length=20)
	@ApiModelProperty("Estado Civil")
	@Enumerated(EnumType.STRING)
	private EstadoCivil estado_civil;
	
	@Column(length=100)
	@ApiModelProperty("Naturalidade")
	private String naturalidade;

	@Column
	@ApiModelProperty("Data Emissão RG")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate data_emissao_rg;

	@Column
	@ApiModelProperty("Data Validade CNH")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate data_validade_cnh;
	
	@Column(length=50)
	@ApiModelProperty("CNH")
	private String cnh;
	
	@Column(length=3)
	@ApiModelProperty("CNH Categoria")
	@Enumerated(EnumType.STRING)
	private CnhCategoria cnh_categoria;
	
	@Column(length=2)
	@ApiModelProperty("Emissão RG UF")
	private String emissao_rg_uf;
	
	@Column(length=150)
	@ApiModelProperty("Nome Completo")
	private String nome_completo;
	
	@Column(length=150)
	@ApiModelProperty("Nome Mãe")
	private String nome_mae;
	
	@Column(length=150)
	@ApiModelProperty("Nome Pai")
	private String nome_pai;
	
	@Column(length=300)
	@ApiModelProperty("Nome Pai")
	private String observacao;
	
	@Column(length=70)
	@ApiModelProperty("Carteira de Trabalho")
	private String carteira_de_trabalho;
	
	@Column(length=70)
	@ApiModelProperty("Carteira de Trabalho Série")
	private String carteira_de_trabalho_serie;
	
	@Column(length=2)
	@ApiModelProperty("Carteira de trabalho Estado")
	private String carteira_de_trabalho_estado;
	
	@Column(length=70)
	@ApiModelProperty("Título de Eleitor")
	private String titulo_de_eleitor;
	
	@Column(length=10)
	@ApiModelProperty("Título de Eleitor")
	private String titulo_de_eleitor_zona;
	
	@Column(length=15)
	@ApiModelProperty("Título de Eleitor")
	private String titulo_de_eleitor_secao;
	
	@Column(length=20)
	@ApiModelProperty("Título de Eleitor")
	private String titulo_de_eleitor_numero;
	
	@Column(length=80)
	@ApiModelProperty("Título de Eleitor")
	private String titulo_de_eleitor_serie;
	
	@Column(length=26)
	@ApiModelProperty("P.I.S.")
	private Long pis;
	
	@Column(length=11)
	@ApiModelProperty("C.P.F.")
	private String cpf;
	
	@Column(length=20)
	@ApiModelProperty("R.G.")
	private String rg;

	@Column(length=11)
	@ApiModelProperty("Telefône")
	private String telefone;
	
	@Column(length=11)
	@ApiModelProperty("Celular")
	private String celular;
	
	@Column(length=3)
	@ApiModelProperty("Receber Notificação")
	@Enumerated(EnumType.STRING)
	private SimNao receber_notificacao = SimNao.NAO;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="acessoId", foreignKey=@ForeignKey(name="fk_usuario_acesso"))
	private Acesso acesso;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="departamentoId", foreignKey=@ForeignKey(name="fk_usuario_departamento"))
	private Departamento departamento;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="funcaoId", foreignKey=@ForeignKey(name="fk_usuario_funcao"))
	private Funcao funcao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="empresaId", foreignKey=@ForeignKey(name="fk_usuario_empresa"))
	private Empresa empresa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="enderecoId", foreignKey=@ForeignKey(name="fk_usuario_endereco"))
	private Endereco endereco;
	
}
