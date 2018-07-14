package br.com.mysenador.mysenador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comissaoparticipa")
public class ComissaoParticipa {

	@Id
	protected Integer id;
	@OneToMany
	protected List<Comissao> comissoes = new ArrayList<Comissao>();
	@Column
	protected Integer Numero_Comissoes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Comissao> getComissoes() {
		return comissoes;
	}
	public void setComissoes(List<Comissao> comissoes) {
		this.comissoes = comissoes;
	}
	public Integer getNumero_Comissoes() {
		return Numero_Comissoes;
	}
	public void setNumero_Comissoes(Integer numero_Comissoes) {
		Numero_Comissoes = numero_Comissoes;
	}
	
	public void add(Comissao comissao) {
		
		comissoes.add(comissao);
	}
	
	
	
	
	
	
}
