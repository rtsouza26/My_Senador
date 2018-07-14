package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;



@Entity
@Table(name= "categorias_por_parlamentar")
public class CategoriasPorParlamentar {
	@Id
	protected Integer CodigoParlamentar;
	@OneToOne
	protected Categorias Categoria;
	@Column
	protected Integer Numero_PLS;
	
	
	public Integer getCodigoParlamentar() {
		return CodigoParlamentar;
	}
	public void setCodigoParlamentar(Integer codigoParlamentar) {
		CodigoParlamentar = codigoParlamentar;
	}
	public Categorias getCategoria() {
		return Categoria;
	}
	public void setCategoria(Categorias categoria) {
		Categoria = categoria;
	}
	public Integer getNumero_PLS() {
		return Numero_PLS;
	}
	public void setNumero_PLS(Integer numero_PLS) {
		Numero_PLS = numero_PLS;
	}
	
	

}
