package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;
import javax.persistence.Id;



@Entity
@Table(name= "categorias_por_parlamentar")
public class CategoriasPorParlamentar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column
	protected Integer CodigoParlamentar;
	@Column
	protected String Categoria;
	@Column
	protected Integer Numero_PLS;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodigoParlamentar() {
		return CodigoParlamentar;
	}
	public void setCodigoParlamentar(Integer codigoParlamentar) {
		CodigoParlamentar = codigoParlamentar;
	}
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
	
	

}
