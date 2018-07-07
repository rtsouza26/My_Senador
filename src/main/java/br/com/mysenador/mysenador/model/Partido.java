package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "partido")
public class Partido {
	@Id
	protected String CodigoPartido;
	@Column
	protected String SiglaPartido;
	@Column
	protected String NomePartido;
	
	
	public String getCodigoPartido() {
		return CodigoPartido;
	}
	public void setCodigoPartido(String codigoPartido) {
		CodigoPartido = codigoPartido;
	}
	public String getSiglaPartido() {
		return SiglaPartido;
	}
	public void setSiglaPartido(String siglaPartido) {
		SiglaPartido = siglaPartido;
	}
	public String getNomePartido() {
		return NomePartido;
	}
	public void setNomePartido(String nomePartido) {
		NomePartido = nomePartido;
	}
	
	

}
