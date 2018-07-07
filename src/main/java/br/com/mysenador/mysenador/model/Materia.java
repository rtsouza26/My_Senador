package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@OneToOne
	protected IdentificacaoMateria IdentificacaoMateria;
	@Column
	protected String EmentaMateria;
	
	
	public IdentificacaoMateria getIdentificacaoMateria() {
		return IdentificacaoMateria;
	}
	public void setIdentificacaoMateria(IdentificacaoMateria identificacaoMateria) {
		IdentificacaoMateria = identificacaoMateria;
	}
	public String getEmentaMateria() {
		return EmentaMateria;
	}
	public void setEmentaMateria(String ementaMateria) {
		EmentaMateria = ementaMateria;
	}
	
	

}
