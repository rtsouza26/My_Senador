package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "servico")
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column
	protected String NomeServico;
	@Column
	protected String DescricaoServico;
	@Column
	protected String UrlServico;
	
	public String getNomeServico() {
		return NomeServico;
	}
	public void setNomeServico(String nomeServico) {
		NomeServico = nomeServico;
	}
	public String getDescricaoServico() {
		return DescricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) {
		DescricaoServico = descricaoServico;
	}
	public String getUrlServico() {
		return UrlServico;
	}
	public void setUrlServico(String urlServico) {
		UrlServico = urlServico;
	}
	
	

}
