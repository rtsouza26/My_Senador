package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "exercicio")
public class Exercicio {
	
	@Id
	protected Integer CodigoExercicio;
	@Column
	protected String DataInicio;
	@Column
	protected String DataFim;
	@Column
	protected String SiglaCausaAfastamento;
	@Column
	protected String DescricaoCausaAfastamento;
	@Column
	protected String DataLeitura;
	
	
	public Exercicio() {
		
	}
	
	public Exercicio(Integer codigoExercicio,String dataInicio, String dataFim,
			String siglaCausaAfastamento, String descricaoCausaAfastamento,String DataLeitura) {
		
		this.CodigoExercicio = codigoExercicio;
		this.DataInicio = dataInicio;
		this.DataFim = dataFim;
		this.SiglaCausaAfastamento = siglaCausaAfastamento;
		this.DescricaoCausaAfastamento = descricaoCausaAfastamento;
		this.DataLeitura = DataLeitura;
		
	}
	
	public String getDataLeitura() {
		return DataLeitura;
	}

	public void setDataLeitura(String dataLeitura) {
		DataLeitura = dataLeitura;
	}

	public Integer getCodigoExercicio() {
		return CodigoExercicio;
	}
	public void setCodigoExercicio(Integer codigoExercicio) {
		this.CodigoExercicio = codigoExercicio;
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
	public String getSiglaCausaAfastamento() {
		return SiglaCausaAfastamento;
	}
	public void setSiglaCausaAfastamento(String siglaCausaAfastamento) {
		this.SiglaCausaAfastamento = siglaCausaAfastamento;
	}
	public String getDescricaoCausaAfastamento() {
		return DescricaoCausaAfastamento;
	}
	public void setDescricaoCausaAfastamento(String descricaoCausaAfastamento) {
		this.DescricaoCausaAfastamento = descricaoCausaAfastamento;
	}
	

}
