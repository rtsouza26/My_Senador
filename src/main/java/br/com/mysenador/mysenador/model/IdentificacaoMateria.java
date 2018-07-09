package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "identificacaomateria")
public class IdentificacaoMateria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column
	protected Integer CodigoMateria;
	@Column
	protected String SiglaCasaIdentificacaoMateria;
	@Column
	protected String NomeCasaIdentificacaoMateria;
	@Column
	protected String SiglaSubtipoMateria;
	@Column
	protected String DescricaoSubtipoMateria;
	@Column
	protected String NumeroMateria;
	@Column
	protected String AnoMateria;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodigoMateria() {
		return CodigoMateria;
	}
	public void setCodigoMateria(Integer codigoMateria) {
		CodigoMateria = codigoMateria;
	}
	public String getSiglaCasaIdentificacaoMateria() {
		return SiglaCasaIdentificacaoMateria;
	}
	public void setSiglaCasaIdentificacaoMateria(String siglaCasaIdentificacaoMateria) {
		SiglaCasaIdentificacaoMateria = siglaCasaIdentificacaoMateria;
	}
	public String getNomeCasaIdentificacaoMateria() {
		return NomeCasaIdentificacaoMateria;
	}
	public void setNomeCasaIdentificacaoMateria(String nomeCasaIdentificacaoMateria) {
		NomeCasaIdentificacaoMateria = nomeCasaIdentificacaoMateria;
	}
	public String getSiglaSubtipoMateria() {
		return SiglaSubtipoMateria;
	}
	public void setSiglaSubtipoMateria(String siglaSubtipoMateria) {
		SiglaSubtipoMateria = siglaSubtipoMateria;
	}
	public String getDescricaoSubtipoMateria() {
		return DescricaoSubtipoMateria;
	}
	public void setDescricaoSubtipoMateria(String descricaoSubtipoMateria) {
		DescricaoSubtipoMateria = descricaoSubtipoMateria;
	}
	public String getNumeroMateria() {
		return NumeroMateria;
	}
	public void setNumeroMateria(String numeroMateria) {
		NumeroMateria = numeroMateria;
	}
	public String getAnoMateria() {
		return AnoMateria;
	}
	public void setAnoMateria(String anoMateria) {
		AnoMateria = anoMateria;
	}
	
	
	

}
