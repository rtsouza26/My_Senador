package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name= "cargoatual")
public class CargoAtual {
	@Id
	protected Integer id;
	@OneToOne
	protected IdentificacaoComissao IdentificacaoComissao;
	@Column
	protected String CodigoCargo;
	@Column
	protected String DescricaoCargo;
	@Column
	protected String DataInicio;
	
	
	public IdentificacaoComissao getIdentificacaoComissao() {
		return IdentificacaoComissao;
	}
	public void setIdentificacaoComissao(IdentificacaoComissao identificacaoComissao) {
		IdentificacaoComissao = identificacaoComissao;
	}
	public String getCodigoCargo() {
		return CodigoCargo;
	}
	public void setCodigoCargo(String codigoCargo) {
		CodigoCargo = codigoCargo;
	}
	public String getDescricaoCargo() {
		return DescricaoCargo;
	}
	public void setDescricaoCargo(String descricaoCargo) {
		DescricaoCargo = descricaoCargo;
	}
	public String getDataInicio() {
		return DataInicio;
	}
	public void setDataInicio(String dataInicio) {
		DataInicio = dataInicio;
	}
	
	

}
