package br.com.mysenador.mysenador.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.mysenador.mysenador.extractor.XmlApi;
import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;
import br.com.mysenador.mysenador.model.Mandato;
import br.com.mysenador.mysenador.model.Parlamentar;
import br.com.mysenador.mysenador.model.Senado;
import br.com.mysenador.mysenador.model.Titular;
import br.com.mysenador.mysenador.model.User;
import br.com.mysenador.mysenador.repository.IdentificacaoParlamentarRep;
import br.com.mysenador.mysenador.repository.TitularRep;
import br.com.mysenador.mysenador.repository.UserRep;
import br.com.mysenador.mysenador.util.HtmlRequest;

@RestController

public class SenadoController {

	List<IdentificacaoParlamentar> identificacao = new ArrayList<IdentificacaoParlamentar>();
	List<Mandato> mandato = new ArrayList<Mandato>();
	List<Titular> titular = new ArrayList<Titular>();
	List<Parlamentar> parlamentar1 = new ArrayList<Parlamentar>();
	String url = "http://legis.senado.leg.br/dadosabertos/senador/lista/atual";
	HtmlRequest requesturl = new HtmlRequest();
	XmlApi xmlapi = new XmlApi();

	Senado senado;
	@Autowired
	IdentificacaoParlamentarRep idsalva;
	@Autowired
	TitularRep titularrep;
	@Autowired
	UserRep userrep;
	EntityManager entidid;

	IdentificacaoParlamentar id;
	
	//@RequestMapping("/")
	//public String index() {
	//	return "index";
	//}
	@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
	@RequestMapping("/")
	public ModelAndView index1() {

		ModelAndView model = new ModelAndView("db");
		//String xml = requesturl.toString(url);
		//senado = xmlapi.converte(xml);
		//parlamentar1.clear();
		// for(int i = 0;i<81;i++){
		// parlamentar1.add(senado.getParlamentares().get(i));
		// }
		identificacao = null;
		identificacao = (List<IdentificacaoParlamentar>) idsalva.findAll();

		model.addObject("Parl", identificacao);

		return model;

	}

	@RequestMapping(value ="login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String senha) {

		Optional<User> loginteste;
		loginteste = userrep.findById(email);
		System.out.println(senha);
		System.out.println(loginteste.get().getSenha());
		if (loginteste.get().getSenha().equals(senha)) {
			return "/db";
		} else {
			return "index";
		}

	}

	

	@RequestMapping("/api/senators/all")
	public String indexapi(Model model) {

		String xml = requesturl.toString(url);
		senado = xmlapi.converte(xml);
		String desconverte = xmlapi.senadoToJson(senado);

		model.addAttribute("descon", desconverte);

		return "index1";

	}
	
	/*
	 * @GetMapping(path="/all") public @ResponseBody
	 * Iterable<IdentificacaoParlamentar> getAllid() { // This returns a JSON or XML
	 * with the users return idsalva.findAll(); }
	 * 
	 */ 
	

	 /* 
	 * @RequestMapping("/titular/salva") public String addSuplenteall(){ String xml
	 * = ""; String url
	 * ="http://legis.senado.leg.br/dadosabertos/senador/lista/atual"; xml =
	 * requesturl.toString(url); senado = xmlapi.converte(xml);
	 * 
	 * for(int i = 0;i<81;i++){
	 * titular.add(senado.getParlamentares().get(i).getMandato().getTitular());
	 * titularrep.save(titular.get(i)); } return null;
	 * 
	 * }
	 * 
	 * @GetMapping(path="/add") // Map ONLY GET Requests public @ResponseBody String
	 * addNewUser (@RequestParam String name , @RequestParam String email) {
	 * // @ResponseBody means the returned String is the response, not a view name
	 * // @RequestParam means it is a parameter from the GET or POST request
	 * 
	 * User n = new User(); n.setName(name); n.setEmail(email); userrep.save(n);
	 * return "Saved"; }
	 * 
	 * @GetMapping(path="/user/all") public @ResponseBody Iterable<User>
	 * getAllUsers() { // This returns a JSON or XML with the users return
	 * userrep.findAll(); }
	 */
}
