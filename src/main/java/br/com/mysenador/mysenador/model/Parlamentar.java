package br.com.mysenador.mysenador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name= "parlamentar")
public class Parlamentar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@OneToOne
	protected IdentificacaoParlamentar IdentificacaoParlamentar;
	@OneToOne
	protected DadosBasicosParlamentar DadosBasicosParlamentar;
	@OneToOne
	protected Mandato Mandato;
	@OneToOne
	protected Mandato MandatoAtual;
	@OneToOne
	protected Mandato UlltimoMandato;
	
	@OneToOne
	protected FiliacaoAtual FiliacaoAtual;
	@OneToMany
	protected List<Comissao> MembroAtualComissoes =new ArrayList<Comissao>();
	@OneToMany
	protected List<CargoAtual>CargosAtuais = new ArrayList<CargoAtual>();
	@OneToMany
	protected List<Lideranca> LiderancasAtuais =new ArrayList<Lideranca>();
	@OneToMany
	protected List<Materia> MateriasDeAutoriaTramitando = new ArrayList<Materia>();
	@OneToMany
	protected List<Relatoria> RelatoriasAtuais =new ArrayList<Relatoria>();
	@OneToMany
	protected List<Servico> OutrasInformacoes = new ArrayList<Servico>();
	@Column
	protected String UrlGlossario;
	@OneToOne
	protected MateriasAutoria Autoria = new MateriasAutoria();
	
	public Parlamentar() {
		
	}
	
	

	public Parlamentar(Integer id, br.com.mysenador.mysenador.model.IdentificacaoParlamentar identificacaoParlamentar,
			br.com.mysenador.mysenador.model.DadosBasicosParlamentar dadosBasicosParlamentar,
			br.com.mysenador.mysenador.model.Mandato mandato, br.com.mysenador.mysenador.model.Mandato mandatoAtual,
			br.com.mysenador.mysenador.model.Mandato ulltimoMandato,
			br.com.mysenador.mysenador.model.FiliacaoAtual filiacaoAtual, List<Comissao> membroAtualComissoes,
			List<CargoAtual> cargosAtuais, List<Lideranca> liderancasAtuais, List<Materia> materiasDeAutoriaTramitando,
			List<Relatoria> relatoriasAtuais, List<Servico> outrasInformacoes, String urlGlossario,
			MateriasAutoria autoria) {
		super();
		this.id = id;
		IdentificacaoParlamentar = identificacaoParlamentar;
		DadosBasicosParlamentar = dadosBasicosParlamentar;
		Mandato = mandato;
		MandatoAtual = mandatoAtual;
		UlltimoMandato = ulltimoMandato;
		FiliacaoAtual = filiacaoAtual;
		MembroAtualComissoes = membroAtualComissoes;
		CargosAtuais = cargosAtuais;
		LiderancasAtuais = liderancasAtuais;
		MateriasDeAutoriaTramitando = materiasDeAutoriaTramitando;
		RelatoriasAtuais = relatoriasAtuais;
		OutrasInformacoes = outrasInformacoes;
		UrlGlossario = urlGlossario;
		this.Autoria = autoria;
	}



	public DadosBasicosParlamentar getDadosBasicosParlamentar() {
		return DadosBasicosParlamentar;
	}


	public void setDadosBasicosParlamentar(DadosBasicosParlamentar dadosBasicosParlamentar) {
		DadosBasicosParlamentar = dadosBasicosParlamentar;
	}


	public Mandato getMandatoAtual() {
		return MandatoAtual;
	}


	public void setMandatoAtual(Mandato mandatoAtual) {
		MandatoAtual = mandatoAtual;
	}


	public FiliacaoAtual getFiliacaoAtual() {
		return FiliacaoAtual;
	}


	public void setFiliacaoAtual(FiliacaoAtual filiacaoAtual) {
		FiliacaoAtual = filiacaoAtual;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public IdentificacaoParlamentar getIdentificacaoParlamentar() {
		return IdentificacaoParlamentar;
	}
	public void setIdentificacaoParlamentar(IdentificacaoParlamentar identificacaoParlamentar) {
		this.IdentificacaoParlamentar = identificacaoParlamentar;
	}
	public Mandato getMandato() {
		return MandatoAtual;
	}
	public void setMandato(Mandato mandato) {
		this.MandatoAtual = mandato;
	}
	public String getUrlGlossario() {
		return UrlGlossario;
	}
	public void setUrlGlossario(String urlGlossario) {
		this.UrlGlossario = urlGlossario;
	}


	public List<Comissao> getMembroAtualComissoes() {
		return MembroAtualComissoes;
	}


	public void setMembroAtualComissoes(List<Comissao> membroAtualComissoes) {
		MembroAtualComissoes = membroAtualComissoes;
	}


	public List<CargoAtual> getCargosAtuais() {
		return CargosAtuais;
	}


	public void setCargosAtuais(List<CargoAtual> cargosAtuais) {
		CargosAtuais = cargosAtuais;
	}


	public List<Lideranca> getLiderancasAtuais() {
		return LiderancasAtuais;
	}


	public void setLiderancasAtuais(List<Lideranca> liderancasAtuais) {
		LiderancasAtuais = liderancasAtuais;
	}


	public List<Materia> getMateriasDeAutoriaTramitando() {
		return MateriasDeAutoriaTramitando;
	}


	public void setMateriasDeAutoriaTramitando(List<Materia> materiasDeAutoriaTramitando) {
		MateriasDeAutoriaTramitando = materiasDeAutoriaTramitando;
	}


	public List<Relatoria> getRelatoriasAtuais() {
		return RelatoriasAtuais;
	}


	public void setRelatoriasAtuais(List<Relatoria> relatoriasAtuais) {
		RelatoriasAtuais = relatoriasAtuais;
	}


	public List<Servico> getOutrasInformacoes() {
		return OutrasInformacoes;
	}


	public void setOutrasInformacoes(List<Servico> outrasInformacoes) {
		OutrasInformacoes = outrasInformacoes;
	}

	public Mandato getUlltimoMandato() {
		return UlltimoMandato;
	}

	public void setUlltimoMandato(Mandato ulltimoMandato) {
		UlltimoMandato = ulltimoMandato;
	}



	public MateriasAutoria getAutoria() {
		return Autoria;
	}



	public void setAutoria(MateriasAutoria autoria) {
		this.Autoria = autoria;
	}
	
	
	

}
