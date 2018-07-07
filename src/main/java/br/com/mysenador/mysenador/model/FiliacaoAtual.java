package br.com.mysenador.mysenador.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "filiacaoatual")
public class FiliacaoAtual {
	@Id
	protected Integer id;
	@OneToOne
	protected Partido Partido;
	@Column
	protected String DataFiliacao;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Partido getPartido() {
		return Partido;
	}
	public void setPartido(Partido partido) {
		Partido = partido;
	}
	public String getDataFiliacao() {
		return DataFiliacao;
	}
	public void setDataFiliacao(String dataFiliacao) {
		DataFiliacao = dataFiliacao;
	}
	
	public void preenche(FiliacaoAtual filiacao, Optional<FiliacaoAtual>filiacaop) {
		
		filiacao.setDataFiliacao(filiacaop.get().getDataFiliacao());
		filiacao.setId(filiacaop.get().getId());
		filiacao.setPartido(filiacaop.get().getPartido());
		
	}

}
