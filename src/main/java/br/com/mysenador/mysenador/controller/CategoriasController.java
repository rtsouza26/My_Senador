package br.com.mysenador.mysenador.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mysenador.mysenador.model.Categorias;
import br.com.mysenador.mysenador.repository.CategoriasRep;


@RestController

public class CategoriasController {

	@Autowired
	protected CategoriasRep categoriarep;
	protected Categorias categorias = new Categorias();
	List<Categorias> cat = new ArrayList<Categorias>();
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping("categoria")
	public String categorias(@RequestParam String categoria) {

		categorias.setCategoria(categoria);
		categoriarep.save(categorias);

		return "index1";
	}
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping("/api/categories/all")
	public String todascategorias() throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<>();
		cat = (List<Categorias>) categoriarep.findAll();
		
		map.put("categories", cat);
			
		return mapper.writeValueAsString(map);
	}
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping(value = "api/categories/calculate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void calcularCategorias(@RequestBody String categories) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		cat = mapper.readValue(categories, new TypeReference<List<Categorias>>(){});
		for(int i =0;i<cat.size();i++) {
			System.out.println(cat.get(i).getCategoria());
		}
		
		

	}
}
