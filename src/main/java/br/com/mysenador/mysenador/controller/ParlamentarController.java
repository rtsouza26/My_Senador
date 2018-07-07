package br.com.mysenador.mysenador.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mysenador.mysenador.extractor.XmlApi;
import br.com.mysenador.mysenador.model.FiliacaoAtual;
import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;
import br.com.mysenador.mysenador.model.Mandato;
import br.com.mysenador.mysenador.model.Parlamentar;
import br.com.mysenador.mysenador.model.ParlamentarDetalhado;
import br.com.mysenador.mysenador.model.SegundaLegislaturaDoMandato;
import br.com.mysenador.mysenador.model.Senado;
import br.com.mysenador.mysenador.model.Titular;
import br.com.mysenador.mysenador.repository.DadosBasicosParlamentarRep;
import br.com.mysenador.mysenador.repository.ExercicioRep;
import br.com.mysenador.mysenador.repository.FiliacaoAtualRep;
import br.com.mysenador.mysenador.repository.IdentificacaoParlamentarRep;
import br.com.mysenador.mysenador.repository.MandatoRep;
import br.com.mysenador.mysenador.repository.ParlamentarRep;
import br.com.mysenador.mysenador.repository.PrimeiraLegislaturaRep;
import br.com.mysenador.mysenador.repository.SegundaLegislaturaRep;
import br.com.mysenador.mysenador.repository.SuplenteRep;
import br.com.mysenador.mysenador.util.HtmlRequest;

@Controller
public class ParlamentarController {
	
	
	@Autowired
	IdentificacaoParlamentarRep idsalva;
	@Autowired
	DadosBasicosParlamentarRep dadosrep;
	@Autowired
	MandatoRep mandrep;
	@Autowired
	FiliacaoAtualRep filiacaoRep;
	XmlApi xmlapi = new XmlApi();
	PrimeiraLegislaturaRep primrep;
	SegundaLegislaturaRep  segunrep;
	SuplenteRep suplerep;
	ExercicioRep exercrep;
	
	ParlamentarRep parlarep;
	List<Parlamentar> parl = new ArrayList<Parlamentar>();
	Parlamentar parlu;
	Mandato mando;
	SegundaLegislaturaDoMandato segm;
	Senado senado;
	HtmlRequest requesturl = new HtmlRequest();
	List<IdentificacaoParlamentar> identificacao = new ArrayList<IdentificacaoParlamentar>();
	protected ParlamentarDetalhado parldet =new ParlamentarDetalhado();
	
	@RequestMapping("informa")
	public ModelAndView informa(@RequestParam int id) {

		ModelAndView model = new ModelAndView("informa");
		Optional<IdentificacaoParlamentar> info = idsalva.findById(id);
		Optional<Mandato>mandato1 = mandrep.findById(id);
		Optional<FiliacaoAtual>filiacaop = filiacaoRep.findById(id);
		IdentificacaoParlamentar info2 = new IdentificacaoParlamentar();
		Mandato mand = new Mandato();
		FiliacaoAtual filiacao = new FiliacaoAtual();
		filiacao.preenche(filiacao, filiacaop);
		mand.preenche(mand, mandato1);
		Titular titular = new Titular();
		titular.setDescricaoParticipacao("Senador");
		info2 = info2.preenche(info2, info);
		String foto = "senadores/" + info.get().getCodigoParlamentar() + ".png";
		
		
			
		model.addObject("info", info2);
		model.addObject("foto", foto);
		model.addObject("mand", mand);
		model.addObject("filiacao", filiacao);
		
		return model;

	}
	
	@RequestMapping("/api/senators/informa")
	public String informaApi(Model model, @RequestParam int id) {

		Optional<IdentificacaoParlamentar> info = idsalva.findById(id);
		IdentificacaoParlamentar info2 = new IdentificacaoParlamentar();
		info2 = info2.preenche(info2, info);
		String infojson = xmlapi.identToJson(info2);

		model.addAttribute("info", infojson);
		return "informApi";
	}
	
	
	

		
		

}
