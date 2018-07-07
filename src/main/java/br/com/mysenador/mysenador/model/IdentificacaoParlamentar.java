package br.com.mysenador.mysenador.model;

import java.util.Optional;

import javax.persistence.*;
@Entity

public class IdentificacaoParlamentar {
	
	@Id
	protected Integer CodigoParlamentar;
	@Column
	protected String NomeParlamentar;
	@Column
	protected String NomeCompletoParlamentar;
	@Column
	protected String SexoParlamentar;
	@Column
	protected String FormaTratamento;
	@Column
	protected String UrlFotoParlamentar;
	@Column
	protected String UrlPaginaParlamentar;
	@Column
	protected String EmailParlamentar;
	@Column
	protected String SiglaPartidoParlamentar;
	@Column
	protected String UfParlamentar;
	
	
	public IdentificacaoParlamentar() {
		
	}
	
	
	public IdentificacaoParlamentar(Integer codigoParlamentar, String nomeParlamentar, String nomeCompletoParlamentar,
			String sexoParlamentar, String formaTratamento, String urlFotoParlamentar, String urlPaginaParlamentar,
			String emailParlamentar, String siglaPartidoParlamentar, String ufParlamentar) {
		
		this.CodigoParlamentar = codigoParlamentar;
		this.NomeParlamentar = nomeParlamentar;
		this.NomeCompletoParlamentar = nomeCompletoParlamentar;
		this.SexoParlamentar = sexoParlamentar;
		this.FormaTratamento = formaTratamento;
		this.UrlFotoParlamentar = urlFotoParlamentar;
		this.UrlPaginaParlamentar = urlPaginaParlamentar;
		this.EmailParlamentar = emailParlamentar;
		this.SiglaPartidoParlamentar = siglaPartidoParlamentar;
		this.UfParlamentar = ufParlamentar;
	}
	


	public Integer getCodigoParlamentar() {
		return CodigoParlamentar;
	}
	public void setCodigoParlamentar(Integer codigoParlamentar) {
		this.CodigoParlamentar = codigoParlamentar;
	}
	public String getNomeParlamentar() {
		return NomeParlamentar;
	}
	public void setNomeParlamentar(String nomeParlamentar) {
		this.NomeParlamentar = nomeParlamentar;
	}
	public String getNomeCompletoParlamentar() {
		return NomeCompletoParlamentar;
	}
	public void setNomeCompletoParlamentar(String nomeCompletoParlamentar) {
		this.NomeCompletoParlamentar = nomeCompletoParlamentar;
	}
	public String getSexoParlamentar() {
		return SexoParlamentar;
	}
	public void setSexoParlamentar(String sexoParlamentar) {
		this.SexoParlamentar = sexoParlamentar;
	}
	public String getFormaTratamento() {
		return FormaTratamento;
	}
	public void setFormaTratamento(String formaTratamento) {
		this.FormaTratamento = formaTratamento;
	}
	public String getUrlFotoParlamentar() {
		return UrlFotoParlamentar;
	}
	public void setUrlFotoParlamentar(String urlFotoParlamentar) {
		this.UrlFotoParlamentar = urlFotoParlamentar;
	}
	public String getUrlPaginaParlamentar() {
		return UrlPaginaParlamentar;
	}
	public void setUrlPaginaParlamentar(String urlPaginaParlamentar) {
		this.UrlPaginaParlamentar = urlPaginaParlamentar;
	}
	public String getEmailParlamentar() {
		return EmailParlamentar;
	}
	public void setEmailParlamentar(String emailParlamentar) {
		this.EmailParlamentar = emailParlamentar;
	}
	public String getSiglaPartidoParlamentar() {
		return SiglaPartidoParlamentar;
	}
	public void setSiglaPartidoParlamentar(String siglaPartidoParlamentar) {
		this.SiglaPartidoParlamentar = siglaPartidoParlamentar;
	}
	public String getUfParlamentar() {
		return UfParlamentar;
	}
	public void setUfParlamentar(String ufParlamentar) {
		this.UfParlamentar = ufParlamentar;
	}
	public IdentificacaoParlamentar preenche(IdentificacaoParlamentar info2,Optional<IdentificacaoParlamentar> info) {
		info2.setCodigoParlamentar(info.get().getCodigoParlamentar());
		info2.setEmailParlamentar(info.get().getEmailParlamentar());
		info2.setFormaTratamento(info.get().getFormaTratamento());
		info2.setNomeCompletoParlamentar(info.get().getNomeCompletoParlamentar());
		info2.setNomeParlamentar(info.get().getNomeParlamentar());
		info2.setSexoParlamentar(info.get().getSexoParlamentar());
		info2.setSiglaPartidoParlamentar(info.get().getSiglaPartidoParlamentar());
		info2.setUfParlamentar(info.get().getUfParlamentar());
		info2.setUrlFotoParlamentar(info.get().getUrlFotoParlamentar());
		info2.setUrlPaginaParlamentar(info.get().getUrlPaginaParlamentar());
		return info2;
	}

}
