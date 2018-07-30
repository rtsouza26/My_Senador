package br.com.mysenador.mysenador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name= "categorias_por_parlamentar")
public class CategoriasPorParlamentar {
	
;
	@Id
	protected Integer CodigoParlamentar;
	@OneToMany
	protected List<Categorias> Categorias = new ArrayList<Categorias>();

	
	
	
	public Integer getCodigoParlamentar() {
		return CodigoParlamentar;
	}
	public void setCodigoParlamentar(Integer codigoParlamentar) {
		CodigoParlamentar = codigoParlamentar;
	}
	
	public List<Categorias> getCategorias() {
		return Categorias;
	}
	public void setCategorias(List<Categorias> categorias) {
		Categorias = categorias;
	}
	
	public void add(Categorias categoria) {
		Categorias.add(categoria);
	}
	
	

}
