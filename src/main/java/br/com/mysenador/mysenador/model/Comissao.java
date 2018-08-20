package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "comissao")
public class Comissao {
	
	@Id
	protected Integer id;
	@OneToOne
	protected IdentificacaoComissao IdentificacaoComissao;
	@Column
	protected String DescricaoParticipacao;
	@Column
	protected String DataInicio;
	@Column
	protected String DataFim;
	
	
	public Comissao() {
		
	}
	
	
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDataFim() {
		return DataFim;
	}



	public void setDataFim(String dataFim) {
		DataFim = dataFim;
	}



	public IdentificacaoComissao getIdentificacaoComissao() {
		return IdentificacaoComissao;
	}
	public void setIdentificacaoComissao(IdentificacaoComissao identificacaoComissao) {
		IdentificacaoComissao = identificacaoComissao;
	}
	public String getDescricaoParticipacao() {
		return DescricaoParticipacao;
	}
	public void setDescricaoParticipacao(String descricaoParticipacao) {
		DescricaoParticipacao = descricaoParticipacao;
	}
	public String getDataInicio() {
		return DataInicio;
	}
	public void setDataInicio(String dataInicio) {
		DataInicio = dataInicio;
	}
	
	

}
