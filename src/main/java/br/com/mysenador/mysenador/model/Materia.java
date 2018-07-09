package br.com.mysenador.mysenador.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name= "materia")
public class Materia {
	@Id
	protected Integer id;
	@OneToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	protected IdentificacaoMateria IdentificacaoMateria;
	@Column(columnDefinition="TEXT")
	protected String EmentaMateria;
	@Column
	protected String Categoria;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	
	
	
	

}
