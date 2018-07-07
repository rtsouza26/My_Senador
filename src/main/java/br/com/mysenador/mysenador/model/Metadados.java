package br.com.mysenador.mysenador.model;

public class Metadados {
	
	protected String Versao;
	protected Integer VersaoServico;
	protected String DescricaoDataSet;
	protected String DataVersaoServico;
	
	
	
	public Metadados(String versao, Integer versaoServico, String descricaoDataSet) {
		super();
		Versao = versao;
		VersaoServico = versaoServico;
		DescricaoDataSet = descricaoDataSet;
	}


	public String getVersao() {
		return Versao;
	}


	public void setVersao(String versao) {
		Versao = versao;
	}


	public Integer getVersaoServico() {
		return VersaoServico;
	}


	public void setVersaoServico(Integer versaoServico) {
		VersaoServico = versaoServico;
	}


	public String getDescricaoDataSet() {
		return DescricaoDataSet;
	}


	public void setDescricaoDataSet(String descricaoDataSet) {
		DescricaoDataSet = descricaoDataSet;
	}
}
