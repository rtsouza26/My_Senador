package br.com.mysenador.mysenador.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name= "categorias")
public class Categorias {
	@Id
	protected String Categoria;
	protected String Checked;
	
	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	
	

}
