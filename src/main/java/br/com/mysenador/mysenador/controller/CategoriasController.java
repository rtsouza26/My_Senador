package br.com.mysenador.mysenador.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mysenador.mysenador.model.Categorias;
import br.com.mysenador.mysenador.repository.CategoriasRep;


@RestController
public class CategoriasController {

	@Autowired
	protected CategoriasRep categoriarep;
	protected Categorias categorias = new Categorias();
	List<Categorias> cat = new ArrayList<Categorias>();
	
	@RequestMapping("categoria")
	public String categorias(@RequestParam String categoria) {

		categorias.setCategoria(categoria);
		categoriarep.save(categorias);

		return "index1";
	}
	
	@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080"})
	@RequestMapping("/api/categories/all")
	public String todascategorias() throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<>();
		 cat = (List<Categorias>) categoriarep.findAll();
		
		    map.put("categories", cat);
			
			return mapper.writeValueAsString(map);
	}
}
