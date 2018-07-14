package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "identificacaocomissao")
public class IdentificacaoComissao {
	@Id
	protected Integer CodigoComissao;
	@Column
	protected String SiglaComissao;
	@Column
	protected String NomeComissao;
	@Column
	protected String SiglaCasaComissao;
	@Column
	protected String NomeCasaComissao;
	
	
	
	public Integer getCodigoComissao() {
		return CodigoComissao;
	}
	public void setCodigoComissao(Integer codigoComissao) {
		CodigoComissao = codigoComissao;
	}
	public String getSiglaComissao() {
		return SiglaComissao;
	}
	public void setSiglaComissao(String siglaComissao) {
		SiglaComissao = siglaComissao;
	}
	public String getNomeComissao() {
		return NomeComissao;
	}
	public void setNomeComissao(String nomeComissao) {
		NomeComissao = nomeComissao;
	}
	public String getSiglaCasaComissao() {
		return SiglaCasaComissao;
	}
	public void setSiglaCasaComissao(String siglaCasaComissao) {
		SiglaCasaComissao = siglaCasaComissao;
	}
	public String getNomeCasaComissao() {
		return NomeCasaComissao;
	}
	public void setNomeCasaComissao(String nomeCasaComissao) {
		NomeCasaComissao = nomeCasaComissao;
	}
	
	
	
	

}
