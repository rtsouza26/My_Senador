package br.com.mysenador.mysenador.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mysenador.mysenador.extractor.XmlApi;
import br.com.mysenador.mysenador.model.Comissao;
import br.com.mysenador.mysenador.model.DadosBasicosParlamentar;
import br.com.mysenador.mysenador.model.Exercicio;
import br.com.mysenador.mysenador.model.FiliacaoAtual;
import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;
import br.com.mysenador.mysenador.model.Mandato;
import br.com.mysenador.mysenador.model.Parlamentar;
import br.com.mysenador.mysenador.model.ParlamentarDetalhado;
import br.com.mysenador.mysenador.model.Partido;
import br.com.mysenador.mysenador.model.PrimeiraLegislaturaDoMandato;
import br.com.mysenador.mysenador.model.SegundaLegislaturaDoMandato;
import br.com.mysenador.mysenador.model.Senado;
import br.com.mysenador.mysenador.model.Suplente;
import br.com.mysenador.mysenador.model.Titular;
import br.com.mysenador.mysenador.repository.ComissaoRep;
import br.com.mysenador.mysenador.repository.DadosBasicosParlamentarRep;
import br.com.mysenador.mysenador.repository.ExercicioRep;
import br.com.mysenador.mysenador.repository.FiliacaoAtualRep;
import br.com.mysenador.mysenador.repository.IdentificacaoParlamentarRep;
import br.com.mysenador.mysenador.repository.MandatoRep;
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
	protected ComissaoRep comirep;
	
	protected FiliacaoAtual filiacao =new  FiliacaoAtual();
	protected XmlApi xmlapi = new XmlApi();
	protected List<Parlamentar> parl = new ArrayList<Parlamentar>();
	protected HtmlRequest requesturl = new HtmlRequest();
	protected List<IdentificacaoParlamentar> identificacao = new ArrayList<IdentificacaoParlamentar>();
	protected ParlamentarDetalhado parldet =new ParlamentarDetalhado();
	protected DadosBasicosParlamentar dadosb = new DadosBasicosParlamentar();
	protected Partido partido =new Partido();
	protected Mandato mandato =new Mandato();
	protected PrimeiraLegislaturaDoMandato primeira = new PrimeiraLegislaturaDoMandato();
	protected SegundaLegislaturaDoMandato segunda = new SegundaLegislaturaDoMandato();
	protected List<Suplente> suplentes = new ArrayList<Suplente>();
	protected List<Exercicio> exercicios = new ArrayList<Exercicio>();
	protected Titular titular =new Titular();
	protected List<Comissao> comissao = new ArrayList<Comissao>();
	
	
	//função que salva todos os objetos IdentificacaoParlamentar no banco de dados
	@RequestMapping("/salva")
	public String salvaIdentificacaoParlamentar(){
	 
	  String url ="http://legis.senado.leg.br/dadosabertos/senador/lista/atual"; 
	  String  xml =requesturl.toString(url); 
	  Senado senado = xmlapi.converte(xml); 
	  
	  for(int i = 0;i<82;i++){ 
		  
		  identificacao.add(senado.getParlamentares().get(i).getIdentificacaoParlamentar()); 
		  System.out.printf("Parlamentar numero:%d",i);
		  idparlamentarRep.save(identificacao.get(i)); 
		  
		  }
	  
	  return "teste"; 
	}
	
	
	@RequestMapping("dados")
	public String salvaDadosBasicosParlamantares() {

		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();
		
		for(int i=0;i<identificacao.size();i++) {
			System.out.printf("Salvando dados, partido e filiação do parlamentar: %s cod:%d \n",identificacao.get(i).getNomeParlamentar(),identificacao.get(i).getCodigoParlamentar());
			
			String url ="http://legis.senado.leg.br/dadosabertos/senador/"+identificacao.get(i).getCodigoParlamentar();
			String xml = requesturl.toString(url);
			parldet = xmlapi.parlamentarconverte(xml);
			dadosb = parldet.getParlamentar().getDadosBasicosParlamentar();
			filiacao = parldet.getParlamentar().getFiliacaoAtual();
			partido = filiacao.getPartido();
			dadosb.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
			filiacao.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
			mandato = parldet.getParlamentar().getMandatoAtual();
			primeira = parldet.getParlamentar().getMandatoAtual().getPrimeiraLegislaturaDoMandato();
			segunda = parldet.getParlamentar().getMandatoAtual().getSegundaLegislaturaDoMandato();
			exercicios =parldet.getParlamentar().getMandatoAtual().getExercicios();
			suplentes = parldet.getParlamentar().getMandatoAtual().getSuplentes();
			titular = parldet.getParlamentar().getMandatoAtual().getTitular();
			comissao = parldet.getParlamentar().getMembroAtualComissoes();
			mandato.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
			
			
			dadosbasicosRep.save(dadosb);
			partidorep.save(partido);
			filiacaoRep.save(filiacao);
			primarep.save(primeira);
			segunrep.save(segunda);
			suplerep.saveAll(suplentes);
			comirep.saveAll(comissao);
			exercrep.saveAll(exercicios);
			if(titular!=null) {
				titurep.save(titular);
			}
			mandatorep.save(mandato);
			
			
		}

		return "teste";

	}
	@RequestMapping("foto")
	public String salvaFotoParlamentares() throws IOException {
		
		identificacao = (List<IdentificacaoParlamentar>) idparlamentarRep.findAll();
		
		for (int i=0;i<81;i++) {
			URL url = new URL(identificacao.get(i).getUrlFotoParlamentar());
			BufferedImage image = ImageIO.read(url);
			ImageIO.write(image, "png", new File("C:\\Users\\rtsou\\Desktop\\mysenador\\src\\main\\resources\\static\\senadores\\"
												+identificacao.get(i).getCodigoParlamentar()+".png"));
			System.out.printf("Foto do parlamentar :%s salva com sucesso \n", identificacao.get(i).getNomeParlamentar());
		}
		
		
		return "teste";
	}
	
	
	
}
