package br.com.mysenador.mysenador.analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

	Pattern expres = Pattern.compile(".Saúde.",Pattern.CASE_INSENSITIVE);
	
	public boolean analisar(String conteudo, String parametro ) {
		boolean teste = false;
		if(parametro.equals("saúde")) {
			String regex = "(remédios)|(vacinação)|(hospital)|(hospitais)|(médicos)|(médico)|(pacientes)|(paciente)|(advertência)|(teste)(\\s)(do)(\\s)(olhinho)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("previdência")){
			String regex = "(aposentadoria)|(aposentados)|(previdência)|(previdência)(\\s)(social)|(aposentadorias)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("imposto")){
			String regex = "(imposto)|(impostos)|(Imposto)(\\s)(de)(\\s)(Renda)|(IOF)|(tributário)|(fiscal)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("trabalhista")){
			String regex = "(escravo)|(CLT)|(trabalho)|(trabalhista)|(empregado)|(empregador)|(fgts)|(trabalhadores)|(greve)|(licença)&(gestante)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("educação")){
			String regex = "(ensino)|(educação)|(estudante)|(FIES)|(universidade)|(universidades)|(escola)|(escolas)|(alfabetizados)|(alfabetização)|(estudantil)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("cultura")){
			String regex = "(cultura)|(arte)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("idoso")){
			String regex = "(idoso)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("segurança")){
			String regex = "(criminosa)|(segurança)|(código)(\\s)(Penal)|(exame)(\\s)(criminológico)|(penal)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("ambiental")){
			String regex = "(ambiental)|(renováveis)|(floresta)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("transito")){
			String regex = "(código)(\\s)(de)(\\s)(trânsito)(\\s)(brasileiro)";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}else if(parametro.equals("eleições")){
			String regex = "eleições";
			Pattern expres = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while(procura.find()) {
				System.out.println("mach encontrado na posição: "+ procura.start() +conteudo.substring(procura.start(), procura.end()));
				teste = true;
			}
		}
		return teste;
	}
}
