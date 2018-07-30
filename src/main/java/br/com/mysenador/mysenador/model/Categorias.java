package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "categorias")
public class Categorias {
	@Id
	protected String Categoria;
	@Column
	protected Integer Numero_PLS;
	@Column
	protected String Checked;
	
	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public Integer getNumero_PLS() {
		return Numero_PLS;
	}

	public void setNumero_PLS(Integer numero_PLS) {
		Numero_PLS = numero_PLS;
	}

	public String getChecked() {
		return Checked;
	}

	public void setChecked(String checked) {
		Checked = checked;
	}
	
	
	
	

}
