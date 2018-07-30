package br.com.mysenador.mysenador.extractor;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import com.thoughtworks.xstream.security.AnyTypePermission;

import br.com.mysenador.mysenador.model.CargoAtual;
import br.com.mysenador.mysenador.model.Comissao;
import br.com.mysenador.mysenador.model.DadosBasicosParlamentar;
import br.com.mysenador.mysenador.model.Exercicio;
import br.com.mysenador.mysenador.model.FiliacaoAtual;
import br.com.mysenador.mysenador.model.IdentificacaoComissao;
import br.com.mysenador.mysenador.model.IdentificacaoParlamentar;
import br.com.mysenador.mysenador.model.Lideranca;
import br.com.mysenador.mysenador.model.Mandato;
import br.com.mysenador.mysenador.model.Materia;
import br.com.mysenador.mysenador.model.MateriasAutoria;
import br.com.mysenador.mysenador.model.Parlamentar;
import br.com.mysenador.mysenador.model.ParlamentarDetalhado;
import br.com.mysenador.mysenador.model.Partido;
import br.com.mysenador.mysenador.model.PrimeiraLegislaturaDoMandato;
import br.com.mysenador.mysenador.model.Relatoria;
import br.com.mysenador.mysenador.model.SegundaLegislaturaDoMandato;
import br.com.mysenador.mysenador.model.Senado;
import br.com.mysenador.mysenador.model.Servico;
import br.com.mysenador.mysenador.model.Suplente;
import br.com.mysenador.mysenador.model.Titular;

public class XmlApi {
	
	public Senado converte(String xml) {
		
		
			XStream arquivo = new XStream();
			XStream.setupDefaultSecurity(arquivo);
			arquivo.addPermission(AnyTypePermission.ANY);
			arquivo.autodetectAnnotations(true);
			arquivo.alias("ListaParlamentarEmExercicio",Senado.class);
			arquivo.alias("Parlamentar", Parlamentar.class);
			arquivo.alias("IdentificacaoParlamentar", IdentificacaoParlamentar.class);
			arquivo.alias("Titular", Titular.class);
			arquivo.alias("Mandato", Mandato.class);
			arquivo.alias("PrimeiraLegislaturaDoMandato", PrimeiraLegislaturaDoMandato.class);
			arquivo.alias("SegundaLegislaturaDoMandato", SegundaLegislaturaDoMandato.class);
			arquivo.alias("Suplente", Suplente.class);
			arquivo.alias("Exercicio",Exercicio.class);
		
		 
			System.out.println("Conversão realizada com sucesso");
			return (Senado)arquivo.fromXML(xml);
		}
	
	public ParlamentarDetalhado parlamentarconverte(String xml) {
		
		XStream arquivo = new XStream();
		XStream.setupDefaultSecurity(arquivo);
		arquivo.addPermission(AnyTypePermission.ANY);
		
		arquivo.alias("DetalheParlamentar",ParlamentarDetalhado.class);
		arquivo.alias("Parlamentar",Parlamentar.class);
		arquivo.alias("IdentificacaoParlamentar",IdentificacaoParlamentar.class);
		arquivo.alias("DadosBasicosParlamentar",DadosBasicosParlamentar.class);
		arquivo.alias("MandatoAtual",Mandato.class);
		arquivo.alias("UltimoMandato",Mandato.class);
		arquivo.alias("Comissao",Comissao.class);
		arquivo.alias("FiliacaoAtual",FiliacaoAtual.class);
		arquivo.alias("Lideranca",Lideranca.class);
		arquivo.alias("Partido",Partido.class);
		arquivo.alias("CargoAtual",CargoAtual.class);
		arquivo.alias("Materia",Materia.class);
		arquivo.alias("Suplente",Suplente.class);
		arquivo.alias("Relatoria",Relatoria.class);
		arquivo.alias("Exercicio",Exercicio.class);
		arquivo.alias("Servico",Servico.class);
		arquivo.alias("IdentificacaoComissao",IdentificacaoComissao.class);
		arquivo.alias("RelatoriasAtuais",Relatoria.class);
		System.out.println("\n******************Conversão de Parlamentar realizada com sucesso***********************************\n");
		return (ParlamentarDetalhado)arquivo.fromXML(xml);
	}


	public String desconverte(Senado senado){
	
	
		XStream arquivo = new XStream();
		XStream.setupDefaultSecurity(arquivo);
		arquivo.autodetectAnnotations(true);
		return arquivo.toXML(senado) ;
	
	}
	
	public String senadoToJson(Senado senado){
		
		 XStream arquivo = new XStream(new JettisonMappedXmlDriver() {
	     public HierarchicalStreamWriter createWriter(Writer writer) {
	           return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
	            }
	        });
		 arquivo.autodetectAnnotations(true);
       return arquivo.toXML(senado) ;
	}
	
	public String identToJson(IdentificacaoParlamentar ident) {
		 XStream arquivo = new XStream(new JettisonMappedXmlDriver() {
		     public HierarchicalStreamWriter createWriter(Writer writer) {
		           return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
		            }
		        });
		 arquivo.autodetectAnnotations(true);
		 return arquivo.toXML(ident);
	}
	
	

}
