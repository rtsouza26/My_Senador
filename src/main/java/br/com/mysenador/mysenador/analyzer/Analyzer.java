package br.com.mysenador.mysenador.analyzer;

public class Analyzer {

	public boolean analisar(String conteudo, String parametro ) {
		
		return conteudo.contentEquals(parametro);
	}
}
