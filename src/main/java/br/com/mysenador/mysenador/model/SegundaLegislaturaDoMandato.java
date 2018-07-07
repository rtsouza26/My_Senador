package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "segunda_legislatura_do_mandato")

public class SegundaLegislaturaDoMandato {
	
	@Id
	protected Integer NumeroLegislatura;
	@Column
	protected String DataInicio;
	@Column
	protected String DataFim;
	
	public SegundaLegislaturaDoMandato() {

	}
	
	public SegundaLegislaturaDoMandato(Integer numeroLegislatura, String dataInicio,
			String dataFim) {
		
		this.NumeroLegislatura = numeroLegislatura;
		this.DataInicio = dataInicio;
		this.DataFim = dataFim;
	}
	
	

	public Integer getNumeroLegislatura() {
		return NumeroLegislatura;
	}
	public void setNumeroLegislatura(Integer numeroLegislatura) {
		this.NumeroLegislatura = numeroLegislatura;
	}
	public String getDataInicio() {
		return DataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.DataInicio = dataInicio;
	}
	public String getDataFim() {
		return DataFim;
	}
	public void setDataFim(String dataFim) {
		this.DataFim = dataFim;
	}

}
