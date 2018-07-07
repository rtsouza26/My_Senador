package br.com.mysenador.mysenador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "dadosbasicosparlamentar")
public class DadosBasicosParlamentar {
	@Id
	protected Integer id;
	@Column
	protected String DataNascimento;
	@Column
	protected String UfNaturalidade;
	@Column
	protected String EnderecoParlamentar;
	@Column
	protected String TelefoneParlamentar;
	@Column
	protected String FaxParlamentar;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getUfNaturalidade() {
		return UfNaturalidade;
	}
	public void setUfNaturalidade(String ufNaturalidade) {
		UfNaturalidade = ufNaturalidade;
	}
	public String getEnderecoParlamentar() {
		return EnderecoParlamentar;
	}
	public void setEnderecoParlamentar(String enderecoParlamentar) {
		EnderecoParlamentar = enderecoParlamentar;
	}
	public String getTelefoneParlamentar() {
		return TelefoneParlamentar;
	}
	public void setTelefoneParlamentar(String telefoneParlamentar) {
		TelefoneParlamentar = telefoneParlamentar;
	}
	public String getFaxParlamentar() {
		return FaxParlamentar;
	}
	public void setFaxParlamentar(String faxParlamentar) {
		FaxParlamentar = faxParlamentar;
	}
	
	
	

}
