package br.com.mysenador.mysenador.analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

	

	public boolean analisar(String conteudo, String parametro) {
		boolean teste = false;
		if (parametro.equals("saúde")) {
			String regex = "(remédios)|(vacinação)|(hospital)|(hospitais)|(médicos)|(médico)|(pacientes)|(paciente)|(advertência)|(teste)(\\s)(do)(\\s)(olhinho)|(medicamentos)|(normas)(\\s)(básicas)(\\s)(sobre)(\\s)(alimentos)|(idoso)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("previdência")) {
			String regex = "(aposentadoria)|(aposentados)|(previdência)|(previdência)(\\s)(social)|(aposentadorias)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("trabalhista")) {
			String regex = "(escravo)|(CLT)|(trabalho)|(trabalhista)|(empregado)|(empregador)|(fgts)|(trabalhadores)|(greve)|(licença)&(gestante)|(servidora)(\\s)(gestante)|(seguro)(\\s)(de)(\\s)(vida)|(fundo)(\\s)(de)(\\s)(garantia)|(PASEP)|(adicional)(\\s)(de)(\\s)(risco)(\\s)(de)(\\s)(vida)|(aviso)(\\s)(prévio)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("educação")) {
			String regex = "(ensino)|(educação)|(estudante)|(FIES)|(universidade)|(universidades)|(escola)|(escolas)|(alfabetizados)|(alfabetização)|(estudantil)|(educacional)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("cultura")) {
			String regex = "(cultura)|(arte)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		
		} else if (parametro.equals("segurança")) {
			String regex = "(criminosa)|(segurança)|(código)(\\s)(Penal)|(exame)(\\s)(criminológico)|(penal)|(proteção)(\\s)(às)(\\s)(vítimas)|(estatuto)(\\s)(do)(\\s)(desarmamento)|(pornografia)(\\s)(infatil)|(funpen)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("ambiental")) {
			String regex = "(ambiental)|(renováveis)|(floresta)|(recursos)(\\s)(hídricos)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("mobilidade")) {
			String regex = "(código)(\\s)(de)(\\s)(trânsito)(\\s)(brasileiro)|(motorista)(\\s)(profissional)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("eleições")) {
			String regex = "(eleições)|(campanha)(\\s)(eleitoral)|(campanhas)(\\s)(eleitorais)|(candidatos)|(partidárias)|(partidos)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("economia")) {
			String regex = "(economia)|(empresas)(\\s)(públicas)|(sociedade)(\\s)(empresária)|"
					+ "(instituições)(\\s)(monetárias)|(abertura)(\\s)(e)(\\s)(fechamento)(\\s)(de)(\\s)(empresas)|"
					+ "(empreendedorismo)|(imposto)|(impostos)|(Imposto)(\\\\s)(de)(\\\\s)(Renda)|(IOF)|(tributário)|"
					+ "(fiscal)|(tributos)(\\\\s)(federais)|(tarifas)|(tributos)|(reforma)(\\s)(agrária)|(produção)|(royalts)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
		} else if (parametro.equals("cidadania")) {
			String regex = "(saneamento)(\\s)(básico)|(municípios)|(estatísticas)(\\s)(oficiais)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
			
		} else if (parametro.equals("tecnologia")) {
			String regex = "(tecnologia)|(ciências)";
			Pattern expres = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher procura = expres.matcher(conteudo);
			while (procura.find()) {
				teste = true;
			}
			
		}
		return teste;
	}
}
