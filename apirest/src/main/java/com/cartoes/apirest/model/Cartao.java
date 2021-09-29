package com.cartoes.apirest.model;

import java.util.Date;

import com.cartoes.apirest.model.enums.TipoEmissor;
import com.cartoes.apirest.model.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cartao;
	private String logo;
	private String dn;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataExpiracao;
	private String codigoOrganizacao;
	private String cartaoAtivo;
	private TipoEmissor tipo;
	private TipoPessoa tipoP;

	public String getcartao() {
		return cartao;
	}
	public void setId(String cartao) {
		this.cartao = cartao;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public String getCodigoOrganizacao() {
		return codigoOrganizacao;
	}
	public void setCodigoOrganizacao(String codigoOrganizacao) {
		this.codigoOrganizacao = codigoOrganizacao;
	}
	public String getCartaoAtivo() {
		return cartaoAtivo;
	}
	public void setCartaoAtivo(String cartaoAtivo) {
		this.cartaoAtivo = cartaoAtivo;
	}
	public TipoEmissor getTipo() {
		return tipo;
	}
	public void setTipo(TipoEmissor tipo) {
		this.tipo = tipo;
	}
	public TipoPessoa getTipoP() {
		return tipoP;
	}
	public void setTipoP(TipoPessoa tipoP) {
		this.tipoP = tipoP;
	}
	public int getId() {
		return id;
	}
	public void intId(int id) {
		this.id = id;
	}



}
	

