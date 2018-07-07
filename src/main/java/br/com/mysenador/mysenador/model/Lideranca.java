package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "lideranca")
public class Lideranca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@OneToOne
	protected Partido Partido;
	@Column
	protected String SiglaCasaLideranca;
	@Column
	protected String NomeCasaLideranca;
	@Column
	protected String DescricaoTipoLideranca;
	@Column
	protected String DataDesignacao;
	@OneToOne
	protected Bloco Bloco;
	
	
	
	public String getSiglaCasaLideranca() {
		return SiglaCasaLideranca;
	}
	public void setSiglaCasaLideranca(String siglaCasaLideranca) {
		SiglaCasaLideranca = siglaCasaLideranca;
	}
	public String getNomeCasaLideranca() {
		return NomeCasaLideranca;
	}
	public void setNomeCasaLideranca(String nomeCasaLideranca) {
		NomeCasaLideranca = nomeCasaLideranca;
	}
	public String getDescricaoTipoLideranca() {
		return DescricaoTipoLideranca;
	}
	public void setDescricaoTipoLideranca(String descricaoTipoLideranca) {
		DescricaoTipoLideranca = descricaoTipoLideranca;
	}
	public String getDataDesignacao() {
		return DataDesignacao;
	}
	public void setDataDesignacao(String dataDesignacao) {
		DataDesignacao = dataDesignacao;
	}
	public Bloco getBloco() {
		return Bloco;
	}
	public void setBloco(Bloco bloco) {
		Bloco = bloco;
	}
	
	

}
