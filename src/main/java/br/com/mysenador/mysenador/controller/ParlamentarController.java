package br.com.mysenador.mysenador.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mysenador.mysenador.extractor.XmlApi;
import br.com.mysenador.mysenador.model.FiliacaoAtual;
import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;
import br.com.mysenador.mysenador.model.Mandato;
import br.com.mysenador.mysenador.model.MateriasAutoria;
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
import br.com.mysenador.mysenador.repository.MateriasAutoriaRep;
import br.com.mysenador.mysenador.repository.ParlamentarRep;
import br.com.mysenador.mysenador.repository.PrimeiraLegislaturaRep;
import br.com.mysenador.mysenador.repository.SegundaLegislaturaRep;
import br.com.mysenador.mysenador.repository.SuplenteRep;
import br.com.mysenador.mysenador.util.HtmlRequest;

@RestController
public class ParlamentarController {
	
	@Autowired
	protected IdentificacaoParlamentarRep idsalva;
	@Autowired
	protected DadosBasicosParlamentarRep dadosrep;
	@Autowired
	protected MandatoRep mandrep;
	@Autowired
	protected FiliacaoAtualRep filiacaoRep;
	@Autowired
	protected MateriasAutoriaRep autoriarep;
	protected XmlApi xmlapi = new XmlApi();
	protected PrimeiraLegislaturaRep primrep;
	protected SegundaLegislaturaRep  segunrep;
	protected SuplenteRep suplerep;
	protected ExercicioRep exercrep;
	protected MateriasAutoria materias = new MateriasAutoria();
	
	ParlamentarRep parlarep;
	List<Parlamentar> parl = new ArrayList<Parlamentar>();
	Parlamentar parlu;
	Mandato mando;
	SegundaLegislaturaDoMandato segm;
	Senado senado;
	
	HtmlRequest requesturl = new HtmlRequest();
	List<IdentificacaoParlamentar> identificacao = new ArrayList<IdentificacaoParlamentar>();
	protected ParlamentarDetalhado parldet =new ParlamentarDetalhado();
	
	@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
	@RequestMapping("informa")
	public ModelAndView informa(@RequestParam int id) {

		ModelAndView model = new ModelAndView("informa");
		Optional<IdentificacaoParlamentar> info = idsalva.findById(id);
		Optional<Mandato>mandato1 = mandrep.findById(id);
		Optional<FiliacaoAtual>filiacaop = filiacaoRep.findById(id);
		Optional<MateriasAutoria>materiasop = autoriarep.findById(id);
	    IdentificacaoParlamentar info2 = new IdentificacaoParlamentar();
		Mandato mand = new Mandato();
		FiliacaoAtual filiacao = new FiliacaoAtual();
		filiacao.preenche(filiacao, filiacaop);
		mand.preenche(mand, mandato1);
		System.out.println(materiasop.get().getId());
		System.out.println(materiasop.get().getMaterias().get(0).getEmentaMateria());
		System.out.println(materiasop.get().getMaterias().size());
		Titular titular = new Titular();
		int numero =materiasop.get().getMaterias().size();
		titular.setDescricaoParticipacao("Senador");
		info2 = info2.preenche(info2, info);
		materias.preenche(materias, materiasop);
		String foto = "senadores/" + info.get().getCodigoParlamentar() + ".png";
			
		model.addObject("info", info2);
		model.addObject("foto", foto);
		model.addObject("mand", mand);
		model.addObject("filiacao", filiacao);
		model.addObject("numero", numero);
		model.addObject("materias", materias);
		
		return model;
	}
	
	@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
	@RequestMapping("/api/senators/informa")
	public String informaApi(Model model, @RequestParam int id) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<>();

		Optional<IdentificacaoParlamentar> info = idsalva.findById(id);
		IdentificacaoParlamentar info2 = new IdentificacaoParlamentar();
		info2 = info2.preenche(info2, info);
		map.put("senator", info2);
		return mapper.writeValueAsString(map);
	}

}
