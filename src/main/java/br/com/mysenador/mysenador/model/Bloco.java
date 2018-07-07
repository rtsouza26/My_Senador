package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "bloco")
public class Bloco {
	
	@Id
	protected String CodigoBloco;
	@Column
	protected String SiglaBloco;
	@Column
	protected String NomeBloco;
	@Column
	protected String ApelidoBloco;
	
	
	public String getCodigoBloco() {
		return CodigoBloco;
	}
	public void setCodigoBloco(String codigoBloco) {
		CodigoBloco = codigoBloco;
	}
	public String getSiglaBloco() {
		return SiglaBloco;
	}
	public void setSiglaBloco(String siglaBloco) {
		SiglaBloco = siglaBloco;
	}
	public String getNomeBloco() {
		return NomeBloco;
	}
	public void setNomeBloco(String nomeBloco) {
		NomeBloco = nomeBloco;
	}
	public String getApelidoBloco() {
		return ApelidoBloco;
	}
	public void setApelidoBloco(String apelidoBloco) {
		ApelidoBloco = apelidoBloco;
	}
	
	
}
