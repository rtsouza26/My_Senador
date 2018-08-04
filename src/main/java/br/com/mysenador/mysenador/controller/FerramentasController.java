package br.com.mysenador.mysenador.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mysenador.mysenador.analyzer.Analyzer;
import br.com.mysenador.mysenador.extractor.XmlApi;
import br.com.mysenador.mysenador.model.Categorias;
import br.com.mysenador.mysenador.model.CategoriasPorParlamentar;
import br.com.mysenador.mysenador.model.Comissao;
import br.com.mysenador.mysenador.model.ComissaoParticipa;
import br.com.mysenador.mysenador.model.DadosBasicosParlamentar;
import br.com.mysenador.mysenador.model.Exercicio;
import br.com.mysenador.mysenador.model.FiliacaoAtual;
import br.com.mysenador.mysenador.model.IdentificacaoComissao;
import br.com.mysenador.mysenador.model.IdentificacaoMateria;
import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;
import br.com.mysenador.mysenador.model.Mandato;
import br.com.mysenador.mysenador.model.Materia;
import br.com.mysenador.mysenador.model.MateriasAutoria;
import br.com.mysenador.mysenador.model.Parlamentar;
import br.com.mysenador.mysenador.model.ParlamentarDetalhado;
import br.com.mysenador.mysenador.model.Partido;
import br.com.mysenador.mysenador.model.PrimeiraLegislaturaDoMandato;
import br.com.mysenador.mysenador.model.SegundaLegislaturaDoMandato;
import br.com.mysenador.mysenador.model.Senado;
import br.com.mysenador.mysenador.model.Suplente;
import br.com.mysenador.mysenador.model.Titular;
import br.com.mysenador.mysenador.repository.CategoriasPorParlamentarRep;
import br.com.mysenador.mysenador.repository.CategoriasRep;
import br.com.mysenador.mysenador.repository.ComissaoParticipaRep;
import br.com.mysenador.mysenador.repository.ComissaoRep;
import br.com.mysenador.mysenador.repository.DadosBasicosParlamentarRep;
import br.com.mysenador.mysenador.repository.ExercicioRep;
import br.com.mysenador.mysenador.repository.FiliacaoAtualRep;
import br.com.mysenador.mysenador.repository.IdentificacaoComissaoRep;
import br.com.mysenador.mysenador.repository.IdentificacaoMateriaRep;
import br.com.mysenador.mysenador.repository.IdentificacaoParlamentarRep;
import br.com.mysenador.mysenador.repository.MandatoRep;
import br.com.mysenador.mysenador.repository.MateriaRep;
import br.com.mysenador.mysenador.repository.MateriasAutoriaRep;
import br.com.mysenador.mysenador.repository.PartidoRep;
import br.com.mysenador.mysenador.repository.PrimeiraLegislaturaRep;
import br.com.mysenador.mysenador.repository.SegundaLegislaturaRep;
import br.com.mysenador.mysenador.repository.SuplenteRep;
import br.com.mysenador.mysenador.repository.TitularRep;
import br.com.mysenador.mysenador.util.HtmlRequest;

@Controller
public class FerramentasController {

	@Autowired
	protected IdentificacaoParlamentarRep idparlamentarRep;
	@Autowired
	protected DadosBasicosParlamentarRep dadosbasicosRep;
	@Autowired
	protected FiliacaoAtualRep filiacaoRep;
	@Autowired
	protected PartidoRep partidorep;
	@Autowired
	protected MandatoRep mandatorep;
	@Autowired
	protected PrimeiraLegislaturaRep primarep;
	@Autowired
	protected SegundaLegislaturaRep segunrep;
	@Autowired
	protected SuplenteRep suplerep;
	@Autowired
	protected ExercicioRep exercrep;
	@Autowired
	protected TitularRep titurep;
	@Autowired
	protected ComissaoRep comissaorep;
	@Autowired
	protected MateriaRep materiaRep;
	@Autowired
	protected MateriasAutoriaRep materiasrep;
	@Autowired
	protected IdentificacaoMateriaRep idmateriarep;
	@Autowired
	protected CategoriasRep categoriarep;
	@Autowired
	protected CategoriasPorParlamentarRep categoriasParlamentarRep;
	@Autowired
	protected IdentificacaoComissaoRep idcomissaorep;
	@Autowired
	protected ComissaoParticipaRep comissaopartrep;

	protected FiliacaoAtual filiacao = new FiliacaoAtual();
	protected XmlApi xmlapi = new XmlApi();
	protected List<Parlamentar> parl = new ArrayList<Parlamentar>();
	protected HtmlRequest requesturl = new HtmlRequest();
	protected List<IdentificacaoParlamentar> identificacao = new ArrayList<IdentificacaoParlamentar>();
	protected ParlamentarDetalhado parldet = new ParlamentarDetalhado();
	protected DadosBasicosParlamentar dadosb = new DadosBasicosParlamentar();
	protected Partido partido = new Partido();
	protected Mandato mandato = new Mandato();
	protected PrimeiraLegislaturaDoMandato primeira = new PrimeiraLegislaturaDoMandato();
	protected SegundaLegislaturaDoMandato segunda = new SegundaLegislaturaDoMandato();
	protected List<Suplente> suplentes = new ArrayList<Suplente>();
	protected List<Exercicio> exercicios = new ArrayList<Exercicio>();
	protected List<Materia> materias = new ArrayList<Materia>();
	protected List<IdentificacaoMateria> idmateria = new ArrayList<IdentificacaoMateria>();
	protected List<IdentificacaoComissao> idcomissao = new ArrayList<IdentificacaoComissao>();
	protected Titular titular = new Titular();
	protected List<Comissao> comissao = new ArrayList<Comissao>();
	protected MateriasAutoria autoria = new MateriasAutoria();
	protected ComissaoParticipa comissaopart = new ComissaoParticipa();
	protected Analyzer analisador = new Analyzer();
	protected Categorias categorias = new Categorias();
	protected CategoriasPorParlamentar categoriaParlamentar = new CategoriasPorParlamentar();
	protected int id = 0;
	
	//////contadores de categorias 
	Map<String, Integer> categoriesMap = new HashMap<String, Integer>();
	/*
	protected short ambiental = 0;
	protected short cultura = 0;
	protected short educação = 0;
	protected short eleições = 0;
	protected short idoso = 0;
	protected short imposto = 0;
	protected short previdência = 0;
	protected short saúde = 0;
	protected short segurança = 0;
	protected short trabalhista = 0;
	protected short transito = 0;
	*/
	//////contadores de categorias
	
	@RequestMapping("ferramenta")
	public ModelAndView ferramenta() {

		ModelAndView model = new ModelAndView("charts");

		return model;
	}

	// função que salva todos os objetos IdentificacaoParlamentar no banco de dados
	@RequestMapping(value = "salva", method = RequestMethod.POST)
	public ModelAndView salvaIdentificacaoParlamentar() {

		String url = "http://legis.senado.leg.br/dadosabertos/senador/lista/atual";
		String xml = requesturl.toString(url);
		Senado senado = xmlapi.converte(xml);
		ModelAndView model = new ModelAndView("charts");
		boolean teste = false;
		int i = 0;
		for (i = 0; i < senado.getParlamentares().size(); i++) {

			identificacao.add(senado.getParlamentares().get(i).getIdentificacaoParlamentar());
			System.out.printf("Parlamentar numero:%d", i);

		}
		idparlamentarRep.saveAll(identificacao);
		if (idparlamentarRep.count() == (long) i) {
			teste = true;
		}
		model.addObject("teste", teste);

		return model;

	}

	// metodo que salva todos os objetos dadosdetalhados,filiação,partido,mandato e
	// materias no banco de dados
	@RequestMapping(value = "dados_completos", method = RequestMethod.POST)
	public ModelAndView salvaDadosBasicosParlamantares() {
		ModelAndView model = new ModelAndView("charts");
		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();

		for (int i = 0; i < identificacao.size(); i++) {
			System.out.printf("Salvando dados, partido e filiação do parlamentar: %s cod:%d \n",
					identificacao.get(i).getNomeParlamentar(), identificacao.get(i).getCodigoParlamentar());

			String url = "http://legis.senado.leg.br/dadosabertos/senador/"
					+ identificacao.get(i).getCodigoParlamentar();
			String xml = requesturl.toString(url);
			parldet = xmlapi.parlamentarconverte(xml);

			dadosb = parldet.getParlamentar().getDadosBasicosParlamentar();

			filiacao = parldet.getParlamentar().getFiliacaoAtual();
			partido = filiacao.getPartido();

			dadosb.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
			filiacao.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
			if (parldet.getParlamentar().getMandatoAtual() != null) {
				mandato = parldet.getParlamentar().getMandatoAtual();
			} else {
				mandato = parldet.getParlamentar().getUlltimoMandato();
			}
			primeira = parldet.getParlamentar().getMandatoAtual().getPrimeiraLegislaturaDoMandato();
			segunda = parldet.getParlamentar().getMandatoAtual().getSegundaLegislaturaDoMandato();
			exercicios = parldet.getParlamentar().getMandatoAtual().getExercicios();
			suplentes = parldet.getParlamentar().getMandatoAtual().getSuplentes();
			titular = parldet.getParlamentar().getMandatoAtual().getTitular();
			mandato.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());

			dadosbasicosRep.save(dadosb);
			partidorep.save(partido);
			filiacaoRep.save(filiacao);
			primarep.save(primeira);
			segunrep.save(segunda);
			suplerep.saveAll(suplentes);
			exercrep.saveAll(exercicios);
			if (titular != null) {
				titurep.save(titular);
			}
			mandatorep.save(mandato);

			if (parldet.getParlamentar().getMembroAtualComissoes() != null) {
				comissao = parldet.getParlamentar().getMembroAtualComissoes();
				for (int t = 0; t < comissao.size(); t++) {
					comissao.get(t).setId(comissao.get(t).getIdentificacaoComissao().getCodigoComissao());
					idcomissao.add(comissao.get(t).getIdentificacaoComissao());
				}
				comissaopart.setNumero_Comissoes(comissao.size());
				comissaopart.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
				for (int w = 0; w < comissao.size(); w++) {
					comissaopart.add(comissao.get(w));
				}

				// idcomissaorep.saveAll(idcomissao);
				// comissaorep.saveAll(comissao);
				// comissaopartrep.save(comissaopart);
			}

	/*		if (parldet.getParlamentar().getMateriasDeAutoriaTramitando() != null) {

				autoria.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
				for (int j = 0; j < parldet.getParlamentar().getMateriasDeAutoriaTramitando().size(); j++) {
					if (parldet.getParlamentar().getMateriasDeAutoriaTramitando().get(j).getIdentificacaoMateria()
							.getSiglaSubtipoMateria().equalsIgnoreCase("PLS")) {
						materias.add(parldet.getParlamentar().getMateriasDeAutoriaTramitando().get(j));
					}
				}
				autoria.setNumero_PLS(materias.size());
				for (int n = 0; n < materias.size(); n++) {
					idmateria.add(materias.get(n).getIdentificacaoMateria());
				}
				for (int k = 0; k < materias.size(); k++) {
					materias.get(k).setId(materias.get(k).getIdentificacaoMateria().getCodigoMateria());
					autoria.add(materias.get(k));
					System.out.println(materias.get(k).getId());
				}

				idmateriarep.saveAll(idmateria);
				materiaRep.saveAll(materias);
				materiasrep.save(autoria);

			}

			idmateria.clear();
			materias.clear();
			idmateria.clear();
			autoria.clear();
			idcomissao.clear();
			comissao.clear();
*/
		}

		return model;

	}
	@RequestMapping("salva_materias")
	public String salva_materias() {
		
		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();
		
		System.out.printf("Salvando dados, partido e filiação do parlamentar: %s cod:%d \n",
				identificacao.get(3).getNomeParlamentar(), identificacao.get(3).getCodigoParlamentar());

		String url = "http://legis.senado.leg.br/dadosabertos/senador/"
				+ identificacao.get(3).getCodigoParlamentar();
		String xml = requesturl.toString(url);
		parldet = xmlapi.parlamentarconverte(xml);

	
		if (parldet.getParlamentar().getMateriasDeAutoriaTramitando() != null) {
			
			autoria.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
			for (int j = 0; j < parldet.getParlamentar().getMateriasDeAutoriaTramitando().size(); j++) {
				if (parldet.getParlamentar().getMateriasDeAutoriaTramitando().get(j).getIdentificacaoMateria()
						.getSiglaSubtipoMateria().equalsIgnoreCase("PLS")||parldet.getParlamentar().getMateriasDeAutoriaTramitando().get(j).getIdentificacaoMateria()
						.getSiglaSubtipoMateria().equalsIgnoreCase("PEC")) {
					materias.add(parldet.getParlamentar().getMateriasDeAutoriaTramitando().get(j));
				}
			}
			autoria.setNumero_PLS(materias.size());
			for (int n = 0; n < materias.size(); n++) {
				idmateria.add(materias.get(n).getIdentificacaoMateria());
				materias.get(n).setId(materias.get(n).getIdentificacaoMateria().getCodigoMateria());
				autoria.add(materias.get(n));
				System.out.println(materias.get(n).getId());
			}
			idmateriarep.saveAll(idmateria);
			materiaRep.saveAll(materias);
			materiasrep.save(autoria);
			
			materias.clear();
			idmateria.clear();
			autoria.clear();
		}
		return "charts";
	}

	@RequestMapping("foto")
	public String salvaFotoParlamentares() throws IOException {

		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();

		for (int i = 0; i < 81; i++) {
			URL url = new URL(identificacao.get(i).getUrlFotoParlamentar());
			BufferedImage image = ImageIO.read(url);
			ImageIO.write(image, "png",
					new File("C:\\Users\\rtsou\\Desktop\\mysenador\\src\\main\\resources\\static\\senadores\\"
							+ identificacao.get(i).getCodigoParlamentar() + ".png"));
			System.out.printf("Foto do parlamentar :%s salva com sucesso \n",
					identificacao.get(i).getNomeParlamentar());
		}

		return "teste";
	}

	@RequestMapping("pls")
	public String analiza_pls() {
		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();
		List<Categorias> categorias = (List<Categorias>) categoriarep.findAll();

		for (int i = 0; i < identificacao.size(); i++) {
			System.out.println("\n");
			System.out.printf("Processando pls do parlamentar: %s cod:%d \n", identificacao.get(i).getNomeParlamentar(),
					identificacao.get(i).getCodigoParlamentar());
			System.out.println("\n");
		
			Optional<MateriasAutoria> materiasop = materiasrep.findById(identificacao.get(i).getCodigoParlamentar());
			if (materiasop.isPresent()) {
				autoria.preenche(autoria, materiasop);
				
				for (int j = 0; j < categorias.size(); j++) {
					
					if (autoria.getMaterias() != null) {
						categoriaParlamentar = new CategoriasPorParlamentar();
						
						categoriesMap.put("ambiental", 0);
						categoriesMap.put("cultura", 0);
						categoriesMap.put("educação", 0);
						categoriesMap.put("eleições", 0);
						categoriesMap.put("idoso", 0);
						categoriesMap.put("imposto", 0);
						categoriesMap.put("previdência", 0);
						categoriesMap.put("saúde", 0);
						categoriesMap.put("segurança", 0);
						categoriesMap.put("trabalhista", 0);
						categoriesMap.put("transito", 0);
						
						for (int n = 0; n < autoria.getMaterias().size(); n++) {

							if (analisador.analisar(autoria.getMaterias().get(n).getEmentaMateria(),
									categorias.get(j).getCategoria())) {
								autoria.getMaterias().get(n).setCategoria(categorias.get(j).getCategoria());
								materiaRep.save(autoria.getMaterias().get(n));
								
								//incrementa a categoria
								categoriesMap.put(categorias.get(j).getCategoria(), categoriesMap.get(categorias.get(j).getCategoria()) + 1);
							}
						}
						categoriaParlamentar.setCategoria(categorias.get(j));
						categoriaParlamentar.setCodigoParlamentar(identificacao.get(i));
						categoriaParlamentar.setNumero_pls(categoriesMap.get(categorias.get(j).getCategoria()));
						
						categoriasParlamentarRep.save(categoriaParlamentar);
						
						categoriaParlamentar = null;
					}
				}
			}
		}
		return "index1";
	}

	@RequestMapping("separa")
	public String parlamentar_categoria() throws InterruptedException {
		
		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();
		List<Categorias> categorias = (List<Categorias>) categoriarep.findAll();
		autoria.clear();
		int PLS =0;
		
		System.out.println("\n");
		System.out.printf("Processando pls do parlamentar: %s cod:%d \n", identificacao.get(3).getNomeParlamentar(),
				identificacao.get(3).getCodigoParlamentar());
		System.out.println("\n");
		Map<String,Integer>map = new HashMap<String,Integer>();
		Optional<MateriasAutoria> materiasop = materiasrep.findById(identificacao.get(3).getCodigoParlamentar());
		if (materiasop.isPresent()) {
			autoria.preenche(autoria, materiasop);
			categoriaParlamentar.setCodigoParlamentar(identificacao.get(3));
			for (int j = 0; j < categorias.size(); j++) {
				for (int n = 0; n < autoria.getMaterias().size(); n++) {
					
					if(autoria.getMaterias().get(n).getCategoria() != null) {
						if(autoria.getMaterias().get(n).getCategoria().equals(categorias.get(j).getCategoria())) {
							PLS++;
						}
					}
				}
				categorias.get(j).setNumero_PLS(PLS);
				System.out.println(categorias.get(j).getCategoria());
				System.out.println(categorias.get(j).getNumero_PLS());
				//if(categorias.get(j).getNumero_PLS() != null) {
//					Categorias cat = new Categorias();
//					cat.setCategoria(categorias.get(j).getCategoria());
//					cat.setNumero_PLS(categorias.get(j).getNumero_PLS());
//					categoriaParlamentar.add(cat);
				//}
				
				map.put(categorias.get(j).getCategoria(),PLS);
				System.out.println("\n");
				System.out.printf("Foram encontradas %d pls's da categoria: %s\n",PLS,
						categorias.get(j));
				System.out.println("\n");
				categoriasParlamentarRep.save(categoriaParlamentar);
				Thread.sleep(1000);
				PLS =0;
			}
			
		}
		
		System.out.println("\n");
		System.out.printf("Total de pls's = %d",materiasop.get().getMaterias().size());
		System.out.println("\n");
		System.out.println(map);
			return "index1";
	}
	

	@RequestMapping("teste")
	public String teste() {
		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();
		List<Categorias> categorias = (List<Categorias>) categoriarep.findAll();

		for (int i = 0; i < identificacao.size(); i++) {
			System.out.println("\n");
			System.out.printf("Processando pls do parlamentar: %s cod:%d \n", identificacao.get(i).getNomeParlamentar(),
					identificacao.get(i).getCodigoParlamentar());
			System.out.println("\n");

			Optional<MateriasAutoria> materiasop = materiasrep.findById(identificacao.get(i).getCodigoParlamentar());
			if (materiasop.isPresent()) {
				autoria.preenche(autoria, materiasop);
				for (int j = 0; j < categorias.size(); j++) {
					System.out.println(categorias.get(j).getCategoria());
					if (autoria.getMaterias() != null) {
						for (int n = 0; n < autoria.getMaterias().size(); n++) {
							// System.out.println(materiasop.get().getNumero_PLS());
							// System.out.println(materiasop.get().getMaterias().get(n).getId());
							if (analisador.analisar(autoria.getMaterias().get(n).getEmentaMateria(),
									categorias.get(j).getCategoria())) {
								System.out.println("\n");
								System.out.printf("Categoria %s encontrada na materia cod: %d \n",
										categorias.get(j).getCategoria(), autoria.getMaterias().get(n).getId());
								System.out.println("\n");
								autoria.getMaterias().get(n).setCategoria(categorias.get(j).getCategoria());
								materiaRep.save(autoria.getMaterias().get(n));
								
								categoriaParlamentar.setCodigoParlamentar(identificacao.get(i));
								categoriaParlamentar.setCategoria(categorias.get(j));
								

							}
						}

					}
				}
			}
		}
		return "teste";

	}
}
