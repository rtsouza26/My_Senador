package br.com.mysenador.mysenador.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
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
	protected CategoriasPorParlamentarRep catparlrep;
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
	protected CategoriasPorParlamentar catparl = new CategoriasPorParlamentar();
	protected int id = 0;

	// função que salva todos os objetos IdentificacaoParlamentar no banco de dados
	@RequestMapping("/salva")
	public String salvaIdentificacaoParlamentar() {

		String url = "http://legis.senado.leg.br/dadosabertos/senador/lista/atual";
		String xml = requesturl.toString(url);
		Senado senado = xmlapi.converte(xml);

		for (int i = 0; i < senado.getParlamentares().size(); i++) {

			identificacao.add(senado.getParlamentares().get(i).getIdentificacaoParlamentar());
			System.out.printf("Parlamentar numero:%d", i);
			idparlamentarRep.save(identificacao.get(i));

		}

		return "teste";
	}

	// metodo que salva todos os objetos dadosdetalhados,filiação,partido,mandato e
	// materias no banco de dados
	@RequestMapping("dados")
	public String salvaDadosBasicosParlamantares() {

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

			if (parldet.getParlamentar().getMateriasDeAutoriaTramitando() != null) {

				autoria.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
				for (int j = 0; j < parldet.getParlamentar().getMateriasDeAutoriaTramitando().size(); j++) {
					if (parldet.getParlamentar().getMateriasDeAutoriaTramitando().get(j).getIdentificacaoMateria()
							.getSiglaSubtipoMateria().equals("PLS")) {
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

		}

		return "teste";

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
				int pls = 0;
				for (int j = 0; j < categorias.size(); j++) {
					// System.out.println(categorias.size());
					if (autoria.getMaterias() != null) {
						for (int n = 0; n < autoria.getMaterias().size(); n++) {
							// System.out.println(materiasop.get().getNumero_PLS());
							// System.out.println(materiasop.get().getMaterias().get(n).getId());
							if (analisador.analisar(autoria.getMaterias().get(n).getEmentaMateria(),
									categorias.get(j).getCategoria())) {
								System.out.println("\n");
								System.out.printf("Categoria %s emcontrada na materia cod: %d \n",
										categorias.get(j).getCategoria(), autoria.getMaterias().get(n).getId());
								System.out.println("\n");
								autoria.getMaterias().get(n).setCategoria(categorias.get(j).getCategoria());
								materiaRep.save(autoria.getMaterias().get(n));
								System.out.println(pls);
							}
						}

					}
				}
			}
		}
		return "index1";
	}

	@RequestMapping("categoria")
	public String categorias(@RequestParam String categoria) {

		categorias.setCategoria(categoria);
		categoriarep.save(categorias);

		return "index1";
	}

	public String parlamentar_categoria(@RequestParam int id) {

		return "index1";
	}
}
