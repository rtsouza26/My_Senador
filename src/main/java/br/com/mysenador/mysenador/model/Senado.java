package br.com.mysenador.mysenador.model;

import java.util.ArrayList;
import java.util.List;

public class Senado {
	
	protected Metadados Metadados;
	protected List<Parlamentar>Parlamentares = new ArrayList<Parlamentar>();
	
	public List<Parlamentar> getParlamentares() {
		return Parlamentares;
	}

	public void setParlamentares(List<Parlamentar> parlamentares) {
		Parlamentares = parlamentares;
	}

	public Metadados getMetadados() {
		return Metadados;
	}

	public void setMetadados(Metadados metadados) {
		Metadados = metadados;
	}

}
