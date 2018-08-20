package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "titular")
public class Titular {
	
	@Id
	protected Integer CodigoParlamentar;
	@Column
	protected String DescricaoParticipacao;
	@Column
	protected String NomeParlamentar;
	
	public Titular() {
		
	}
	
	public Titular(String descricaoParticipacao, Integer codigoParlamentar, String nomeParlamentar) {
		
		this.DescricaoParticipacao = descricaoParticipacao;
		this.CodigoParlamentar = codigoParlamentar;
		this.NomeParlamentar = nomeParlamentar;
	}
	
	public String getDescricaoParticipacao() {
		return DescricaoParticipacao;
	}
	public void setDescricaoParticipacao(String descricaoParticipacao) {
		this.DescricaoParticipacao = descricaoParticipacao;
	}
	public Integer getCodigoParlamentar() {
		return CodigoParlamentar;
	}
	public void setCodigoParlamentar(Integer codigoParlamentar) {
		this.CodigoParlamentar = codigoParlamentar;
	}
	public String getNomeParlamentar() {
		return NomeParlamentar;
	}
	public void setNomeParlamentar(String nomeParlamentar) {
		this.NomeParlamentar = nomeParlamentar;
	}

}
