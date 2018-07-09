package br.com.mysenador.mysenador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name= "materiasautoria")
public class MateriasAutoria {
	
	@Id
	protected Integer id;
	@OneToMany
	protected List<Materia> materias = new ArrayList<Materia>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	public void add(Materia materia) {
		
		materias.add(materia);
	}
	
	public void clear() {
		materias.clear();
	}
	
	

}
