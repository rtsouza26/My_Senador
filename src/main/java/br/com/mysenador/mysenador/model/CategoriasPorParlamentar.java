package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name= "categorias_por_parlamentar")
public class CategoriasPorParlamentar {
	
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@ManyToOne
    @JoinColumn(name = "codigo_parlamentar")
	private IdentificacaoParlamentar codigoParlamentar;
	@ManyToOne
    @JoinColumn(name = "categoria")
	private Categorias categoria;
	@Column
	private int numero_pls;
	
	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public IdentificacaoParlamentar getCodigoParlamentar() {
		return codigoParlamentar;
	}
	public void setCodigoParlamentar(IdentificacaoParlamentar codigoParlamentar) {
		this.codigoParlamentar = codigoParlamentar;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public int getNumero_pls() {
		return numero_pls;
	}
	public void setNumero_pls(int numero_pls) {
		this.numero_pls = numero_pls;
	}
	

}
