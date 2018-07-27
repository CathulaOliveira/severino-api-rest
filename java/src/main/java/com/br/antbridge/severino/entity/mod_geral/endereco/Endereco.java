package com.br.antbridge.severino.entity.mod_geral.endereco;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Endereco", description="Endereço")
@Table
@Getter @Setter
@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("Código")
	private Long id;
	
	@Column
	@ApiModelProperty("Latitude")
	private BigDecimal latitude;

	@Column
	@ApiModelProperty("Longitude")
	private BigDecimal longitude;
	
	@Column(length=8)
	@ApiModelProperty("C.E.P.")
	private String cep;
	
	@Column(length=150)
	@ApiModelProperty("Rua")
	private String rua;
	
	@Column(length=8)
	@ApiModelProperty("Número")
	private String numero;
	
	@Column(length=150)
	@ApiModelProperty("Bairro")
	private String bairro;

	@Column(length=200)
	@ApiModelProperty("Complemento")
	private String complemento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="municipioId", foreignKey=@ForeignKey(name="fk_endereco_municipio"))
	private Municipio municipio;
			
}
