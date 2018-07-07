package br.com.mysenador.mysenador.model;

import br.com.mysenador.mysenador.extractor.XmlApi;
import br.com.mysenador.mysenador.repository.DadosBasicosParlamentarRep;
import br.com.mysenador.mysenador.util.HtmlRequest;

public class main {
	static DadosBasicosParlamentarRep dadosrep;
	
	public static void main(String[] args) {
		
		
		ParlamentarDetalhado parldet;
		XmlApi xmlapi = new XmlApi();
		String url ="http://legis.senado.leg.br/dadosabertos/senador/3830";
		String xml;
		HtmlRequest requesturl = new HtmlRequest();
		xml = requesturl.toString(url);
		
		
		
		
		
		parldet = xmlapi.parlamentarconverte(xml);		
		DadosBasicosParlamentar dadosb = new DadosBasicosParlamentar();
		dadosb.setId(parldet.getParlamentar().getIdentificacaoParlamentar().getCodigoParlamentar());
		dadosb.setDataNascimento(parldet.getParlamentar().getDadosBasicosParlamentar().getDataNascimento());
		dadosb.setEnderecoParlamentar(parldet.getParlamentar().getDadosBasicosParlamentar().getEnderecoParlamentar());
		dadosb.setFaxParlamentar(parldet.getParlamentar().getDadosBasicosParlamentar().getFaxParlamentar());
		dadosb.setTelefoneParlamentar(parldet.getParlamentar().getDadosBasicosParlamentar().getTelefoneParlamentar());
		dadosb.setUfNaturalidade(parldet.getParlamentar().getDadosBasicosParlamentar().getUfNaturalidade());
		System.out.println(dadosb.getEnderecoParlamentar());
		
		
		dadosrep.save(dadosb);
		
	}

}
